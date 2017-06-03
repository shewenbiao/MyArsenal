package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/16.
 */

public interface DialogDirector {
    void showDialog();
    void dismissDialog();
    void widgetChanged(Widget widget);
    void createWidgets();
}
