package com.forste.taxi.presenter;

import android.content.Context;

import com.forste.taxi.contract.SendCodeContract;

/**
 * Created by sergejkozin on 6/29/17.
 */

public class SendCodePresenter implements SendCodeContract.Presenter {

    private Context mContext;
    private SendCodeContract.View mView;

    @Override
    public void attachView(SendCodeContract.View view) {
        mView = view;
        mContext = view.getContext();
    }

    @Override
    public void detachView() {

    }

    @Override
    public void addCode(String code) {

    }
}
