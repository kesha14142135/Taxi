package com.forste.taxi.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forste.taxi.R;

public class SendCodeFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_send_code, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
