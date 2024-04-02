package com.kat.recruitapp.bootstrap;

import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.enums.PreferredNotificationChannel;
import com.kat.recruitapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    public BootstrapData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity mlem = new UserEntity();
        mlem.setUsername("Mlemoslaw");
        mlem.setPassword("MlemMlem12!");
        mlem.setEmail("mlemmlem@gmail.com");
        mlem.setPhoneNumber("999555111");
        mlem.setPreferredNotificationChannel(PreferredNotificationChannel.EMAIL);

        UserEntity savedMlem = userRepository.save(mlem);
    }
}
