package com.example.arwa_shamaly_220212536;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.arwa_shamaly_220212536.databinding.ActivityQuestion3Binding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class question3 extends AppCompatActivity {
ActivityQuestion3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestion3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Integer> tabNum =new ArrayList<>();
        for (int i = 1; i < 501; i++) {
            tabNum.add(i);
        }

        ArrayList<Fragment> fragments=new ArrayList<>();

        for (int i = 1; i < 501; i++) {
            fragments.add(FragmentVP.newInstance(i));
        }
        VPAdapter adapterVP=new VPAdapter(this,fragments);
        binding.vp.setAdapter(adapterVP);

       /* new TabLayoutMediator(binding.tb, binding.vp,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        int i =tabNum.get(position);
                        tab.setText(String.valueOf(i));
                    }
                }).attach();*/
    }
}