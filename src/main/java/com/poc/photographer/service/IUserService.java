package com.poc.photographer.service;

import com.poc.photographer.model.UserEntity;

import java.util.List;

public interface IUserService
{
    List<UserEntity> getUsers();
}
