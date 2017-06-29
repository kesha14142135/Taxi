package com.forste.taxi.presenter;

import android.content.Context;

import com.forste.taxi.contract.SendNumberContract;
import com.forste.taxi.data.RegistrationBaseDataSource;
import com.forste.taxi.data.RegistrationDataSource;

/**
 * Created by sergejkozin on 6/29/17.
 */

public class SendTelephoneNumberPresenter implements SendNumberContract.Presenter {
    private Context mContext;
    private SendNumberContract.View mView;
    private RegistrationDataSource mDataSource;

    public SendTelephoneNumberPresenter() {
        mDataSource = new RegistrationBaseDataSource();
    }

    @Override
    public void attachView(SendNumberContract.View view) {
        mView = view;
        mContext = view.getContext();
    }

    @Override
    public void detachView() {

    }

    @Override
    public void addNumberPhone(String numberPhone) {
        mDataSource.addTelephoneNumber(numberPhone, new RegistrationDataSource.CallbackNumber() {
            @Override
            public void onSuccess() {
                mView.onSuccessSendTelephoneNumber();
            }

            @Override
            public void onFailure() {
                mView.onFailingSendTelephoneNumber();
            }
        });
    }
}
