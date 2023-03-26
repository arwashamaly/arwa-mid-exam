package com.example.arwa_shamaly_220212536;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arwa_shamaly_220212536.databinding.FragmentVPBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentVP#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVP extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters
    private int mParam1;


    public FragmentVP() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static FragmentVP newInstance(int param1) {
        FragmentVP fragment = new FragmentVP();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentVPBinding binding =FragmentVPBinding.inflate(inflater,container,false);

        binding.tv1.setText(1+"*"+mParam1+"="+1*mParam1);
        binding.tv2.setText(2+"*"+mParam1+"="+2*mParam1);
        binding.tv3.setText(3+"*"+mParam1+"="+3*mParam1);
        binding.tv4.setText(4+"*"+mParam1+"="+4*mParam1);
        binding.tv5.setText(5+"*"+mParam1+"="+5*mParam1);
        binding.tv6.setText(6+"*"+mParam1+"="+6*mParam1);
        binding.tv7.setText(7+"*"+mParam1+"="+7*mParam1);
        binding.tv8.setText(8+"*"+mParam1+"="+8*mParam1);
        binding.tv9.setText(9+"*"+mParam1+"="+9*mParam1);
        binding.tv10.setText(10+"*"+mParam1+"="+10*mParam1);
        binding.tv1.setText("");
        for (int i = 1; i <= 12; i++) {
            binding.tv1.append(i +"x"+mParam1+"="+i*mParam1+"\n");
        }
        return binding.getRoot();
            }
}