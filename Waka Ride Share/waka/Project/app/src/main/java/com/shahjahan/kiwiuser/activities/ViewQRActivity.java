package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.waka.ride.databinding.ActivityViewQrBinding;
import com.waka.ride.models.Utils;
import com.waka.ride.models.loginResponse.User;

public class ViewQRActivity extends AppCompatActivity {

    private ActivityViewQrBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewQrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setNavigationOnClickListener(v -> {
            finish();
        });

        User user = Utils.getUser(this);
        if(user.getUser_id() != null){
            binding.webView.loadUrl("http://dashboard.kiwisignin.co.nz/qrcard.php?id="+user.getUser_id());
        }
    }
}
