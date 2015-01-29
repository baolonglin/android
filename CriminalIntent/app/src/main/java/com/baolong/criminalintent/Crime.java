package com.baolong.criminalintent;

import java.util.UUID;

/**
 * Created by ebaolin on 1/29/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public String getTitle() {
        return mTitle;
    }
    public Crime() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }




}
