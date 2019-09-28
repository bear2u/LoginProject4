package com.example.login.login.model;

import com.example.login.login.LoginContract;
import com.example.login.login.model.datasources.DataSource;
import com.example.login.login.model.datasources.local.LocalDataSourceImpl;
import com.example.login.login.model.datasources.remote.RemoteDataSourceimpl;

public class LoginRepositoryImpl implements LoginRepository{

    LoginContract.Presenter presenter;
    DataSource localDataSource;
    DataSource remoteDataSource;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
        localDataSource = new LocalDataSourceImpl();
        localDataSource.setRepository(this);
        remoteDataSource = new RemoteDataSourceimpl();
        remoteDataSource.setRepository(this);
    }

    @Override
    public void loginProc(User user) {
        //TODO DataSource 연결
        // 로컬에 데이터가 없는 경우
        // 서버통신 한후에 로컬에 다시 저장
        // 5분안에 local로 계속 호출해서 캐싱 전략
       localDataSource.loginProc(user);
    }

    @Override
    public void loginDone() {
        this.presenter.loginDone();
    }
}
