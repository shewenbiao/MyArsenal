package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/16.
 */

public class EntryFiled extends Widget {

    private String mText;

    public EntryFiled(DialogDirector dialogDirector) {
        super(dialogDirector);
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
