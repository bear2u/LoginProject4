package com.example.login.login.base;

public interface BasePresenter<T> {
    void setView(T view);
    void removeView();
}
