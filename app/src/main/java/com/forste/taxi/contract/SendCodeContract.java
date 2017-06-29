package com.forste.taxi.contract;

/**
 * Created by sergejkozin on 6/29/17.
 */

public interface SendCodeContract {
    interface View extends BaseContract.View {
        void onSuccessSendCode();

        void onFailingSendCode();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void addCode(String code);
    }
}
