package com.forste.taxi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.forste.taxi.R;
import com.forste.taxi.view.RegistrationNumberContract;
import com.forste.taxi.view.fragment.SendCodeFragment;
import com.forste.taxi.view.fragment.SendNumberFragment;

public class RegistretionActivity extends AppCompatActivity implements RegistrationNumberContract.Activity {

    private FragmentTransaction mTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        Fragment numberFragment = new SendNumberFragment();
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.add(R.id.frame_layout_registration, numberFragment);
        mTransaction.commit();
    }

    @Override
    public void openWithOutRegistration() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void openWithRegistration() {
        Fragment numberFragment = new SendCodeFragment();
        mTransaction = getSupportFragmentManager().beginTransaction();
        mTransaction.replace(R.id.frame_layout_registration, numberFragment);
        mTransaction.addToBackStack(null);
        mTransaction.commit();
    }
}
