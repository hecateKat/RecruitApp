package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.BalanceDto;
import com.kat.recruitapp.dtos.PromoCodeDto;
import com.kat.recruitapp.entities.BalanceEntity;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.enums.PromoCode;
import com.kat.recruitapp.exceptions.ExistException;
import com.kat.recruitapp.mappers.BalanceMapper;
import com.kat.recruitapp.repositories.BalanceRepository;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.BalanceService;
import com.kat.recruitapp.services.UserCredentialsService;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import static com.kat.recruitapp.enums.PromoCode.*;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;

    private final UserCredentialsService userCredentialsService;

    public BalanceServiceImpl(BalanceRepository balanceRepository, UserRepository userRepository, UserCredentialsService userCredentialsService) {
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
        this.userCredentialsService = userCredentialsService;
    }

    @Override
    public BalanceDto addUserBalance(PromoCodeDto code) {
        String authenticatedUserUsername = userCredentialsService.getAuthenticatedCredentialUsername();
        Optional<UserEntity> userEntity = userRepository.getUserEntityByUsername(authenticatedUserUsername);

        validateBalanceForUser(userEntity.get());
        BalanceEntity balanceEntity = createBalance(code, userEntity);
        balanceRepository.save(balanceEntity);
        return BalanceMapper.mapToDto(balanceEntity);
    }

    private void validateBalanceForUser(UserEntity userEntity) {
        if (balanceRepository.existsById(userEntity.getId())) {
            throw new ExistException("Balance already exist  for that user");
        }
    }

    private BigDecimal mapPromotionCode(String code){
        Map<PromoCode, BigDecimal> bigDecimalValue = Map.of(
                KOD_1, BigDecimal.valueOf(100),
                KOD_2, BigDecimal.valueOf(200),
                KOD_3, BigDecimal.valueOf(300),
                KOD_4, BigDecimal.valueOf(400),
                KOD_5, BigDecimal.valueOf(500)
        );

        return bigDecimalValue.get(PromoCode.valueOf(code));
    }

    private BalanceEntity createBalance(PromoCodeDto code, Optional<UserEntity> userEntity){
        return BalanceEntity.builder()
                .amount(mapPromotionCode(code.getCode()))
                .balanceId(RandomString.make(10))
                .userEntity(userEntity.get())
                .build();
    }
}
