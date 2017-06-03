package com.example.shewenbiao.designpattern.behavioral.mediator;


/**
 * Created by shewenbiao on 17/4/19.
 */

public class ColleagueB extends Colleague {

    public ColleagueB(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void sendMessage(String message) {
        mMediator.contact(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("同事B" + mName + "获得信息:" + message);
    }
}
