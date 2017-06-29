package com.forste.taxi.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.forste.taxi.R;
import com.forste.taxi.contract.SendNumberContract;

public class SendNumberFragment extends Fragment implements SendNumberContract.View, View.OnClickListener {

    private EditText mEditTextPhoneNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_send_number, container, false);
        updateViewDependencies(view);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void sendNumberPhone(String phoneNumber) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void onClick(View v) {

    }

    private void updateViewDependencies(View view) {
        view.findViewById(R.id.button_send_telephone_number)
                .setOnClickListener(this);
        view.findViewById(R.id.button_enter_without_registration)
                .setOnClickListener(this);
        mEditTextPhoneNumber = (EditText) view.findViewById(R.id.edit_text_telephone_number);
    }
}
