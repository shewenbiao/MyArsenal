package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/16.
 */

public class OkButton extends Widget{

    public OkButton(DialogDirector dialogDirector) {
        super(dialogDirector);
    }

    @Override
    public void handleMouseEvent(MouseEvent event) {
        super.handleMouseEvent(event);
        changed();
    }
}
