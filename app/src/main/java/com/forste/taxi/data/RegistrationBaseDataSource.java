package com.forste.taxi.data;

/**
 * Created by sergejkozin on 6/29/17.
 */

public class RegistrationBaseDataSource implements RegistrationDataSource {

    @Override
    public void addTelephoneNumber(String telephoneNumber, CallbackNumber callback) {
        callback.onSuccess();
    }

    @Override
    public void addCode(String code, CallbackCode callback) {

    }
}
