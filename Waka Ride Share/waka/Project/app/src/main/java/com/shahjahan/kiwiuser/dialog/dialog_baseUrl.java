package com.waka.ride.dialog;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.fragment.app.DialogFragment;


import com.waka.ride.databinding.DialogBaseurlBinding;
import com.waka.ride.models.Utils;

import java.util.Objects;

public class dialog_baseUrl extends DialogFragment {

    public dialog_baseUrl() {
        // Required empty public constructor
    }
    private DialogBaseurlBinding binding;

    public static dialog_baseUrl newInstance() {
        return new dialog_baseUrl();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DialogBaseurlBinding.inflate(inflater,container,false);
        String url = Utils.getBaseURL(Objects.requireNonNull(getContext()));
        if(url != null){
            binding.txtUrl.setText(url);
        }
        binding.btnOK.setOnClickListener(ok -> {
            String temp = binding.txtUrl.getText().toString().trim();
            Utils.setBaseURL(getContext(),temp);
            dismiss();
        });
        binding.btnCancel.setOnClickListener(cancel -> dismiss());
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        Window window = Objects.requireNonNull(getDialog()).getWindow();
        Point size = new Point();

        // Store dimensions of the screen in `size`
        Display display = null;
        if (window != null) {
            display = window.getWindowManager().getDefaultDisplay();
            display.getSize(size);

            // Set the width of the dialog proportional to 75% of the screen width
            window.setLayout((int) (size.x * 0.80), WindowManager.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
        }


        // Call super onResume after sizing
        super.onResume();
    }
}
