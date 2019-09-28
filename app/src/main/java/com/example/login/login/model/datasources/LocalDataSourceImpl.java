package com.example.login.login.model.datasources;

import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.User;

public class LocalDataSourceImpl implements DataSource {

    LoginRepository loginRepository;
    @Override
    public void setRepository(LoginRepository repository) {
        this.loginRepository = repository;
    }

    @Override
    public void loginProc(User user) {
        this.loginRepository.loginDone();
    }
}
