package com.example.arwa_shamaly_220212536;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;

    public VPAdapter(@NonNull FragmentActivity fragmentActivity,ArrayList<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments=fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
