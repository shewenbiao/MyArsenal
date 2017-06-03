package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/19.
 */

public class Client {

    public static void main(String[] args) {
        // 定义中介者
        ConcreteMediator mediator = new ConcreteMediator();
        // 定义具体同事类
        ColleagueA colleagueA = new ColleagueA("张三", mediator);
        ColleagueB colleagueB = new ColleagueB("李四", mediator);
        // 中介者知晓每一个具体的Colleague类
        mediator.setColleagueA(colleagueA);
        mediator.setColleagueB(colleagueB);
        colleagueA.sendMessage("我是A，我要和同事B说说工作的事情");
        colleagueB.sendMessage("我是B, 我下午有时间,下午商量吧");
    }
}
