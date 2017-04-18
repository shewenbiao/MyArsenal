package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/19.
 */

public class ConcreteMediator extends Mediator {

    private ColleagueA mColleagueA;
    private ColleagueB mColleagueB;

    @Override
    public void contact(String message, Colleague colleague) {
        if (colleague instanceof ColleagueA) {
            mColleagueB.receiveMessage(message);
        } else if (colleague instanceof ColleagueB) {
            mColleagueA.receiveMessage(message);
        }

    }

    public void setColleagueA(ColleagueA colleagueA) {
        mColleagueA = colleagueA;
    }

    public void setColleagueB(ColleagueB colleagueB) {
        mColleagueB = colleagueB;
    }
}
