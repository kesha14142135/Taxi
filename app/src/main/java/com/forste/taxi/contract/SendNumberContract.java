package com.forste.taxi.contract;

/**
 * Created by sergejkozin on 6/29/17.
 */

public interface SendNumberContract {
    interface View extends BaseContract.View {
        void onSuccessSendTelephoneNumber();

        void onFailingSendTelephoneNumber();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void addNumberPhone(String numberPhone);
    }
}
