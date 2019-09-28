package com.example.login.login;

import com.example.login.login.common.BasePresenter;
import com.example.login.login.common.BaseView;
import com.example.login.login.model.User;

public class LoginContract {
    public interface View {
        void loginDone();
    }

    public interface Presenter{
        void setView(LoginContract.View view);
        void loginProc(User user);
        void loginDone();
    }
}
