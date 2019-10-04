package com.example.login.login.model;

import com.example.login.login.LoginContract;

import io.reactivex.Completable;
import io.reactivex.Single;

// Data Layer
public interface LoginRepository {
    void setPresenter(LoginContract.Presenter presenter);
    Single<Boolean> loginProc(User user);
    void loginDone();

    Completable registerProc(User user);
}
