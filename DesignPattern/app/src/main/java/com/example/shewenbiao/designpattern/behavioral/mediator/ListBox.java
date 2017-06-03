package com.example.shewenbiao.designpattern.behavioral.mediator;

import java.util.List;

/**
 * Created by shewenbiao on 17/4/16.
 */

public class ListBox extends Widget{

    private List<String> mList;

    public ListBox(DialogDirector dialogDirector) {
        super(dialogDirector);
    }

    @Override
    public void handleMouseEvent(MouseEvent event) {
        super.handleMouseEvent(event);
        changed();
    }

    public String getSelection() {
        return "";
    }

    public void setList(List<String> list) {
        mList = list;
    }
}
