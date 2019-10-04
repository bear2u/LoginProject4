package com.example.login.login.model.datasources;

import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.User;
import com.example.login.login.model.datasources.local.UserEntity;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface DataSource {
    public void setRepository(LoginRepository repository);
    Single<Boolean> loginProc(User user);

    Completable registerProc(User user);
}
