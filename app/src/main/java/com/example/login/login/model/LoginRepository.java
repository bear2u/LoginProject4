package com.example.login.login.model;

import com.example.login.login.LoginContract;

// Data Layer
public interface LoginRepository {
    void setPresenter(LoginContract.Presenter presenter);
    void loginProc(User user);
    void loginDone();
}
