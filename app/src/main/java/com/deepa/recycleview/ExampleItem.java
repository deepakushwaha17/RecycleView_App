package com.deepa.recycleview;

public class ExampleItem {
    private int mImageResource;
    private String mtext;

    public ExampleItem(int imageResource , String text)
    {
        mImageResource= imageResource;
        mtext=text;

    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getmtext() {
        return mtext;
    }

    public void setmtext(String mtext) {
        this.mtext = mtext;
    }
}
