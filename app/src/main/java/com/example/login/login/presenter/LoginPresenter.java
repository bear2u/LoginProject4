package com.example.login.login.presenter;

import com.example.login.login.LoginContract;
import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.LoginRepositoryImpl;
import com.example.login.login.model.User;

public class LoginPresenter implements LoginContract.Presenter {
    LoginContract.View view;

    LoginRepository repository = new LoginRepositoryImpl();

    @Override

    public void setView(LoginContract.View view) {

        this.view = view;

        repository.setPresenter(this);

    }


    @Override

    public void loginProc(User user) {

        //push Repository

        repository.loginProc(user);

    }


    @Override

    public void loginDone() {

        view.loginDone();

    }
}
