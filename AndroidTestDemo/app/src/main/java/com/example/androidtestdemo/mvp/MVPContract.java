package com.example.androidtestdemo.mvp;

public interface MVPContract {

    interface Presenter {
        String getUserName();

        String getPassword();
    }
}
