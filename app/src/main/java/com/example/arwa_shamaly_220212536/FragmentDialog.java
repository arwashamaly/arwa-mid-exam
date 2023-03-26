package com.example.arwa_shamaly_220212536;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arwa_shamaly_220212536.databinding.FragmentDialogBinding;
import com.example.arwa_shamaly_220212536.databinding.ItemDialogBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDialog extends DialogFragment {
interface Delete{
    void delete(int pos);
}

    private static final String ARG_MASS = "massage";

    private String massage;
    int pos;
   Delete deleteItem;

    @Override
    public void onAttach(@NonNull Context context) {
        if (massage!=null) {
            deleteItem = (Delete) context;
        }
        super.onAttach(context);
    }

    public FragmentDialog() {
        // Required empty public constructor
    }

    public static FragmentDialog newInstance(String massage) {
        FragmentDialog fragment = new FragmentDialog();
        Bundle args = new Bundle();
        args.putString(ARG_MASS,massage);
        fragment.setArguments(args);
        return fragment;
    }
    public static FragmentDialog newInstance1(String massage,int pos) {
        FragmentDialog fragment = new FragmentDialog();
        Bundle args = new Bundle();
        args.putString(ARG_MASS,massage);
        args.putInt("pos",pos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            massage=getArguments().getString(ARG_MASS);
            pos=getArguments().getInt("pos");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ItemDialogBinding binding =
                ItemDialogBinding.inflate(inflater,container,false);
        binding.tvMassege.setText(massage);
        binding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (massage.equals("Delete Product?")){
                    deleteItem.delete(pos);
                    dismiss();
                }else {
                    getActivity().finish();
                }
            }
        });
        binding.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return binding.getRoot();
    }

  /*  @Override
    public void onResume() {
        ViewGroup.LayoutParams params=getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);
        super.onResume();
    }*/
}