package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/19.
 */

public abstract class Colleague {
    protected Mediator mMediator;
    protected String mName;

    public Colleague(String name, Mediator mediator) {
        mName = name;
        mMediator = mediator;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}
