package com.forste.taxi.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.forste.taxi.R;
import com.forste.taxi.contract.SendCodeContract;
import com.forste.taxi.contract.SendNumberContract;
import com.forste.taxi.presenter.SendCodePresenter;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

public class SendCodeFragment extends Fragment implements SendCodeContract.View, View.OnClickListener, Validator.ValidationListener {

    @NotEmpty(messageResId = R.string.error_code_empty)
    @Password(min = 4, scheme = Password.Scheme.NUMERIC, messageResId = R.string.error_code_min)
    private EditText mEditTextCode;
    private Validator mValidator;
    private SendCodeContract.Presenter mPresenter;
    private View mView;

    public SendCodeFragment() {
    }

    public static SendCodeFragment newInstance() {
        SendCodeFragment fragment = new SendCodeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_send_code, container, false);
        updateViewDependencies(mView);
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mPresenter = new SendCodePresenter();
        mPresenter.attachView(this);
        return mView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onSuccessSendCode() {

    }

    @Override
    public void onFailingSendCode() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_send_code : {
                mValidator.validate();
                break;
            }
        }

    }

    private void updateViewDependencies(View view) {
        view.findViewById(R.id.button_send_code)
                .setOnClickListener(this);
        view.findViewById(R.id.button_did_not_receive_sms)
                .setOnClickListener(this);
        mEditTextCode = (EditText) view.findViewById(R.id.edit_text_code);
    }

    @Override
    public void onValidationSucceeded() {
        mPresenter.addCode(mEditTextCode.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }
}
