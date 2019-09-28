package com.example.login.login.model.datasources;

import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.User;

public interface DataSource {
    public void setRepository(LoginRepository repository);
    public void loginProc(User user);
}
