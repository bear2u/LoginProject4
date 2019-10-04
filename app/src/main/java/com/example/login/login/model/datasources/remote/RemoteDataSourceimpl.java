package com.example.login.login.model.datasources.remote;

import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.User;
import com.example.login.login.model.datasources.DataSource;
import com.example.login.login.model.datasources.local.UserEntity;

import io.reactivex.Completable;
import io.reactivex.Single;

public class RemoteDataSourceimpl implements DataSource {
    @Override
    public void setRepository(LoginRepository repository) {

    }

    @Override
    public Single<Boolean> loginProc(User user) {
        return null;
    }

    @Override
    public Completable registerProc(User user) {
        return null;
    }
}
