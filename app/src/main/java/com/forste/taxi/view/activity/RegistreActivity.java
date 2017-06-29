package com.forste.taxi.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.forste.taxi.R;
import com.forste.taxi.view.fragment.SendNumberFragment;


public class RegistreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        Fragment numberFragment = new SendNumberFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_layout_registration, numberFragment);
        transaction.commit();
    }




}
