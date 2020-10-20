package com.waka.ride.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.waka.ride.databinding.ActivityDashboardBinding;
import com.waka.ride.models.Utils;
import com.waka.ride.models.loginResponse.User;


public class Dashboard extends AppCompatActivity {

    private ActivityDashboardBinding binding;
    private static final int PERMISSION_CAMERA = 121;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        validateUserStatus();
        binding.ScanQR.setOnClickListener(scan -> {
            /*if(Utils.getBaseURL(this) != null){
                checkPermissions();
            }else {
                new AlertDialog.Builder(Dashboard.this)
                        .setTitle("No Base URL")
                        .setMessage("No base url found.Set one?")
                        .setPositiveButton("ok",((dialog, which) ->
                                Utils.startDialog(getSupportFragmentManager(), dialog_baseUrl.newInstance())))
                        .setNegativeButton("Cancel",((dialog, which) -> dialog.dismiss())).show();
            }*/
            checkPermissions();
        });
        binding.btnLogout.setOnClickListener(logout -> {
            Utils.setLogin(this,false);
            startActivity(new Intent(this,login.class));
            finish();
        });
       /* binding.btnURL.setOnClickListener(URL ->
                Utils.startDialog(getSupportFragmentManager(), dialog_baseUrl.newInstance()));
        binding.ViewAttendance.setOnClickListener(view ->{
            if(Utils.getBaseURL(this) != null){
                startActivity(new Intent(this,viewAttendance.class));
            }else {
                new AlertDialog.Builder(Dashboard.this)
                        .setTitle("No Base URL")
                        .setMessage("No base url found.Set one?")
                        .setPositiveButton("ok",((dialog, which) ->
                                Utils.startDialog(getSupportFragmentManager(), dialog_baseUrl.newInstance())))
                        .setNegativeButton("Cancel",((dialog, which) -> dialog.dismiss())).show();
            }
            startActivity(new Intent(this,viewAttendance.class));
        });
        binding.viewQR.setOnClickListener(viewQR ->
                startActivity(new Intent(this,ViewQRActivity.class)));*/

    }

    private void validateUserStatus() {
        User user = Utils.getUser(this);
        if(user.getUser_status() == null || !user.getUser_status().equals("enable")){
            binding.ScanQR.setVisibility(View.GONE);
            binding.ViewAttendance.setVisibility(View.GONE);
            binding.confirmEmail.setVisibility(View.VISIBLE);
        }else if(user.getUser_status().equals("enable")){
            binding.ScanQR.setVisibility(View.VISIBLE);
            binding.ViewAttendance.setVisibility(View.VISIBLE);
            binding.confirmEmail.setVisibility(View.GONE);
        }
    }

    private void checkPermissions() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(this,scanQRActivity.class));
        }else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                new AlertDialog.Builder(this).
                        setTitle("Permission needed")
                        .setMessage("Camera permission needed for this app to work. Grant permission")
                        .setNegativeButton("No",((dialog, which) -> {
                            dialog.dismiss();
                            finish();
                        }))
                        .setPositiveButton("Ok",((dialog, which) ->
                                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_CAMERA)))
                        .show();
            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},PERMISSION_CAMERA);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(new Intent(this,scanQRActivity.class));
            }
        }
    }
}
