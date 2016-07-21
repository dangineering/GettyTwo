package com.example.dangineering.gettytwo.executor;

import android.os.Handler;
import android.os.Looper;

public class MainThreadExecutorImpl implements MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutorImpl() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
}