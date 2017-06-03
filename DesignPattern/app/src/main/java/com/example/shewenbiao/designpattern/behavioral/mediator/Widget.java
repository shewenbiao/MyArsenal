package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/16.
 */

public abstract class Widget {

    public DialogDirector mDialogDirector;

    public Widget(DialogDirector dialogDirector) {
        mDialogDirector = dialogDirector;
    }

    public void changed() {
        mDialogDirector.widgetChanged(this);
    }

    public void handleMouseEvent(MouseEvent event) {

    }
}
