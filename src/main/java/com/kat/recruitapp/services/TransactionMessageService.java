package com.kat.recruitapp.services;

import com.kat.recruitapp.entities.UserEntity;

public interface TransactionMessageService {

    void sendInformationAboutTransaction(UserEntity user, String message);
}
