package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.UserCredentialsDto;
import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.entities.UserCredentials;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.exceptions.NotFoundException;
import com.kat.recruitapp.exceptions.ExistException;
import com.kat.recruitapp.mappers.UserCredentialsMapper;
import com.kat.recruitapp.mappers.UserMapper;
import com.kat.recruitapp.repositories.BalanceRepository;
import com.kat.recruitapp.repositories.UserCredentialsRepository;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.UserCredentialsService;
import com.kat.recruitapp.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;
    private final UserCredentialsRepository userCredentialsRepository;

    private final UserCredentialsService userCredentialsService;

    public UserServiceImpl(UserRepository userRepository, BalanceRepository balanceRepository, UserCredentialsRepository userCredentialsRepository, UserCredentialsService userCredentialsService) {
        this.userRepository = userRepository;
        this.balanceRepository = balanceRepository;
        this.userCredentialsRepository = userCredentialsRepository;
        this.userCredentialsService = userCredentialsService;
    }

    @Override
    public Optional<UserDto> getUserById(UUID Id) {
        return Optional.empty();
    }

    @Override
    public UserDto saveUser(UserCredentialsDto user) {
        uniqueUserValidation(user);
        UserEntity userEntity = UserMapper.mapFromUserCredentialDto(user);
        userRepository.save(userEntity);

        UserCredentials userCredentials = UserCredentialsMapper.mapToEntity(user, userRepository);
        userCredentials.setUserEntityId(userEntity.getId());
        userCredentialsRepository.save(userCredentials);

        return UserMapper.mapToDto(userEntity);
    }

    @Override
    public UserDto getUserDetailsByUsername(String username) {
        UserEntity userEntityByUsername = userRepository.getUserEntityByUsername(username).orElseThrow(() -> new NotFoundException("User not found"));
        return UserMapper.mapToDto(userEntityByUsername);
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    private void uniqueUserValidation(UserCredentialsDto user) {
        if (validateCredential(user) || validateUser(user)) {
            throw new ExistException("User exists");
        }
    }

    private boolean validateCredential(UserCredentialsDto userCredentialsDto) {
        return userCredentialsService.userCredentialsExistsByUsername(userCredentialsDto.getUsername());
    }

    private boolean validateUser(UserCredentialsDto userCredentialsDto) {
        return userRepository.existsUserEntityByUsernameOrEmailOrPhoneNumber(userCredentialsDto.getUsername(), userCredentialsDto.getEmail(), userCredentialsDto.getPhoneNumber());
    }
}
