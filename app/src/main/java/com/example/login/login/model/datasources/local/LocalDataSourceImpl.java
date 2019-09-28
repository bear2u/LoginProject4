package com.example.login.login.model.datasources.local;

import android.util.Log;

import com.example.login.common.AppDatabaseProvider;
import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.User;
import com.example.login.login.model.datasources.DataSource;

public class LocalDataSourceImpl implements DataSource {

    LoginRepository loginRepository;

    @Override
    public void setRepository(LoginRepository repository) {
        this.loginRepository = repository;
    }

    @Override
    public void loginProc(User user) {

        new Thread(() -> {
            try {
                UserDao userDao = AppDatabaseProvider.getINSTANCE().getUserDao();
                UserEntity entity = new UserEntity();
                entity.setId(user.getId());
                entity.setPwd(user.getPwd());
                userDao.addUser(entity);

                UserEntity selectedEntity = userDao.login(user.getId(), user.getPwd());
                Log.d("DB", selectedEntity.toString());

                if(selectedEntity != null) {
                    this.loginRepository.loginDone();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}
