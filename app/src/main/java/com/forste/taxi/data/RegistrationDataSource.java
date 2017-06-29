package com.forste.taxi.data;

/**
 * Created by sergejkozin on 6/29/17.
 */

public interface RegistrationDataSource {

    void addTelephoneNumber(String telephoneNumber, CallbackNumber callback);

    interface CallbackNumber {

        void onSuccess();

        void onFailure();
    }

    void addCode(String code, CallbackCode callback);

    interface CallbackCode {

        void onSuccess();

        void onFailure();
    }
}
