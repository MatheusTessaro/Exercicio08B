package com.example.exercicio08b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentButton.OnIncrementListener {

    private FragmentCount leftFragment;
    private FragmentCount rightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentButton fragmentButton = new FragmentButton();
        fragmentTransaction.add(R.id.layButton, fragmentButton);

        leftFragment = new LeftFragment();
        fragmentTransaction.add(R.id.layLeft, leftFragment);

        rightFragment = new RightFragment();
        fragmentTransaction.add(R.id.layRight, rightFragment);

        fragmentTransaction.commit();
    }

    @Override
    public void onIncrement() {
        leftFragment.increment();
        rightFragment.increment();
    }

}