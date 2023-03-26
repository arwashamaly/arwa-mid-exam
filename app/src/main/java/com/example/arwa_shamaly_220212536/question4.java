package com.example.arwa_shamaly_220212536;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class question4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
    }

    @Override
    public void onBackPressed() {
        FragmentDialog fragmentDialog =FragmentDialog.newInstance("Do you want to confirm the checkout process?");
        fragmentDialog.show(getSupportFragmentManager(),"");
      //  super.onBackPressed();
    }
}