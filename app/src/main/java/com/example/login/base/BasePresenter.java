package com.example.login.base;

public interface BasePresenter<T> {
    void setView(T view);
    void removeView();
}
