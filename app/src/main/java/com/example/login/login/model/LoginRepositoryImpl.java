package com.example.login.login.model;

import com.example.login.login.LoginContract;
import com.example.login.login.model.datasources.DataSource;
import com.example.login.login.model.datasources.local.LocalDataSourceImpl;
import com.example.login.login.model.datasources.remote.RemoteDataSourceimpl;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LoginRepositoryImpl implements LoginRepository{

    LoginContract.Presenter presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        localDataSource.setRepository(this);
        remoteDataSource = new RemoteDataSourceimpl();
        remoteDataSource.setRepository(this);
    }

    @Override
    public Single<Boolean> loginProc(User user) {
       return localDataSource.loginProc(user);

    }

    @Override
    public void loginDone() {
        this.presenter.loginDone();
    }


    @Override
    public Completable registerProc(User user) {
        return localDataSource.registerProc(user);
    }
}
