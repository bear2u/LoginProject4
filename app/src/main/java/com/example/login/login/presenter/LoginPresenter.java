package com.example.login.login.presenter;

import com.example.login.login.LoginContract;
import com.example.login.base.BasePresenterImpl;
import com.example.login.login.model.LoginRepository;
import com.example.login.login.model.LoginRepositoryImpl;
import com.example.login.login.model.User;

import org.reactivestreams.Subscription;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter
        extends BasePresenterImpl<LoginContract.View>
        implements LoginContract.Presenter {

    LoginContract.View view;

    LoginRepository repository = new LoginRepositoryImpl();

    CompositeDisposable cd = new CompositeDisposable();

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
        repository.setPresenter(this);
    }

    @Override
    public void removeView() {
        view = null;
        cd.clear();
    }


    @Override

    public void loginProc(User user) {
        Disposable d = repository.loginProc(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(isLogin -> {
                    if(isLogin)
                        view.loginDone();
                    else
                        view.loginFailed();
                });

        cd.add(d);
    }


    @Override
    public void loginDone() {
        view.loginDone();
    }

    @Override
    public void registerProc(User user) {
        Disposable d = repository.registerProc(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.registerDone());

        cd.add(d);
    }

    @Override
    public void registerDone() {
        view.registerDone();
    }
}
