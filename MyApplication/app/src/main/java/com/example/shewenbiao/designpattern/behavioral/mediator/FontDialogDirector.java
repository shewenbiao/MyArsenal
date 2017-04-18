package com.example.shewenbiao.designpattern.behavioral.mediator;

/**
 * Created by shewenbiao on 17/4/17.
 */

public class FontDialogDirector implements DialogDirector {

    private OkButton mOkButton;
    private EntryFiled mEntryFiled;
    private ListBox mListBox;

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void widgetChanged(Widget widget) {
        if (widget instanceof ListBox) {
            mEntryFiled.setText(mListBox.getSelection());
        } else if (widget instanceof OkButton) {
            // apply font changed
            //...

            //dismiss dialog
            dismissDialog();
        }

    }

    @Override
    public void createWidgets() {
        mOkButton = new OkButton(this);
        mEntryFiled = new EntryFiled(this);
        mListBox = new ListBox(this);

        // fill the ListBox with the available font names

        //assemble the widgets int the dialog
    }
}
