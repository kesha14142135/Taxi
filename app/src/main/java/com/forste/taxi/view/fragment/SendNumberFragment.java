package com.forste.taxi.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.forste.taxi.R;
import com.forste.taxi.contract.SendNumberContract;
import com.forste.taxi.presenter.SendTelephoneNumberPresenter;
import com.forste.taxi.view.RegistrationNumberContract;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class SendNumberFragment extends Fragment implements SendNumberContract.View, View.OnClickListener, Validator.ValidationListener, RegistrationNumberContract.Fragment {

    @NotEmpty(messageResId = R.string.error_phone_number_empty)
    @Password(min = 10, scheme = Password.Scheme.NUMERIC, messageResId = R.string.error_phone_number_min)
    private EditText mEditTextPhoneNumber;
    private Validator mValidator;
    private SendNumberContract.Presenter mPresenter;
    private View mView;
    private RegistrationNumberContract.Activity mActivityContract;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivityContract = (RegistrationNumberContract.Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_send_number, container, false);
        updateViewDependencies(mView);
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mPresenter = new SendTelephoneNumberPresenter();
        mPresenter.attachView(this);
        return mView;
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_send_telephone_number: {
                mValidator.validate();
                break;
            }case R.id.button_enter_without_registration:{
                mActivityContract.openWithOutRegistration();
                break;
            }
        }
    }

    @Override
    public void onValidationSucceeded() {
        mPresenter.addNumberPhone(mEditTextPhoneNumber.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(view.getContext());
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Snackbar.make(mView.findViewById(R.id.relative_layout_send_number_phone), message, Snackbar.LENGTH_LONG)
                        .show();
            }
        }
    }

    @Override
    public void onSuccessSendTelephoneNumber() {
        mActivityContract.openWithRegistration();
    }

    @Override
    public void onFailingSendTelephoneNumber() {

    }

    private void updateViewDependencies(View view) {
        view.findViewById(R.id.button_send_telephone_number)
                .setOnClickListener(this);
        view.findViewById(R.id.button_enter_without_registration)
                .setOnClickListener(this);
        mEditTextPhoneNumber = (EditText) view.findViewById(R.id.edit_text_telephone_number);
    }
}
