package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.dtos.UserDto;
import com.kat.recruitapp.entities.BalanceEntity;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.mappers.BalanceMapper;
import com.kat.recruitapp.mappers.UserMapper;
import com.kat.recruitapp.repositories.BalanceRepository;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.BalanceService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    private final UserRepository userRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository, UserRepository userRepository) {
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BalanceDto save(BalanceDto balance) {
        BalanceEntity balanceEntity = balanceRepository.save(BalanceMapper.mapToEntity(balance));
        return BalanceMapper.mapToDto(balanceEntity);
    }

    @Override
    public BalanceDto update(UUID id, BalanceDto balanceDto) {
        Optional<BalanceEntity> optionalBalance = balanceRepository.findById(id);
        if(optionalBalance.isPresent()){
            BalanceEntity balanceEntity = optionalBalance.get();
            balanceEntity.setAmount(balanceDto.getAmount());
            BalanceEntity savedBalanceEntity = balanceRepository.save(balanceEntity);
            return BalanceMapper.mapToDto(savedBalanceEntity);
        }
        return null;
    }

    @Override
    public BalanceDto getBalanceByUsername(UserDto userDto) {
        String username = userDto.getUsername();
        Optional<UserEntity> userOptional = Optional.of(userRepository.findUserEntityByUsername(username).get());
        return userOptional.map(userEntity -> BalanceMapper.mapToDto(balanceRepository.findBalanceEntityByUserEntity(userEntity))).orElse(null);
    }
}
