package com.example.login.login.presenter;

import com.example.login.login.LoginContract;
import com.example.login.login.model.User;

public class LoginPresenter implements LoginContract.Presenter{
    LoginContract.View view;

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void loginProc(User user) {
        view.loginDone();
    }
}
