package com.example.login.login.model.datasources.local;

import android.util.Log;

import com.example.login.common.AppDatabaseProvider;
import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.User;
import com.example.login.login.model.datasources.DataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

public class LocalDataSourceImpl implements DataSource {

    LoginRepository loginRepository;
    UserDao userDao = null;

    public LocalDataSourceImpl() {
        try {
            userDao = AppDatabaseProvider.getINSTANCE().getUserDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setRepository(LoginRepository repository) {
        this.loginRepository = repository;
    }

    @Override
    public Completable registerProc(User user) {

        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                UserEntity entity = new UserEntity();
                entity.setId(user.getId());
                entity.setPwd(user.getPwd());
                userDao.addUser(entity);
            }
        });
    }

    @Override
    public Single<Boolean> loginProc(User user) {
        return userDao.login(user.getId(), user.getPwd())
                .map(userEntities -> {
                    Log.d("DB", "userEntitys = " + userEntities);
                    return userEntities.size() > 0;
                });
    }
}
