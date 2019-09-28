package com.example.login.login;

import com.example.login.login.model.User;

public class LoginContract {
    public interface View {
        void loginDone();
    }

    public interface Presenter {
        void setView(View view);
        void loginProc(User user);
    }

    public interface Model {
        void login(User user);
    }
}
