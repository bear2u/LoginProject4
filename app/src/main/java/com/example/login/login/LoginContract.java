package com.example.login.login;

import com.example.login.base.BasePresenter;
import com.example.login.base.BaseView;
import com.example.login.login.model.User;

public class LoginContract {
    public interface View extends BaseView {
        void loginDone();
    }

    public interface Presenter extends BasePresenter<View> {
        void loginProc(User user);
        void loginDone();
    }
}
