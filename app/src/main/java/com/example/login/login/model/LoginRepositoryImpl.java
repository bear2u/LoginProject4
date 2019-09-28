package com.example.login.login.model;

import com.example.login.login.LoginContract;

public class LoginRepositoryImpl implements LoginRepository{

    LoginContract.Presenter presenter;
    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loginProc(User user) {
        this.presenter.loginDone();
    }
}
