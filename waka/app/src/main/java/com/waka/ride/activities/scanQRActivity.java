package com.waka.ride.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageButton;

import com.waka.ride.R;
import com.waka.ride.databinding.ActivityScanQRBinding;
import com.waka.ride.models.AttendanceResponse;
import com.waka.ride.models.Utils;
import com.waka.ride.models.loginResponse.User;
import com.waka.ride.retrofit.RetrofitAPI;
import com.waka.ride.retrofit.RetrofitService;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import info.androidhive.barcode.BarcodeReader;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class scanQRActivity extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {

    private ActivityScanQRBinding binding;
    private final static String TAG = scanQRActivity.class.getSimpleName();
    private BarcodeReader barcodeReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScanQRBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_scanner);
        assert barcodeReader != null;
        barcodeReader.setBeepSoundFile("shutter.mp3");

        ImageButton btnBack = findViewById(R.id.imgbtn_back);
        btnBack.setOnClickListener(back -> finish());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onScanned(Barcode barcode) {
        barcodeReader.playBeep();
        barcodeReader.pauseScanning();
        Log.d(TAG, barcode.displayValue);
        String s = barcode.rawValue;
        User sharedPref = Utils.getUser(scanQRActivity.this);
        RetrofitService service = new RetrofitService(scanQRActivity.this);
        RetrofitAPI api = service.createService(RetrofitAPI.class);
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Log.e(TAG,"error -> "+errorMessage);
    }

    @Override
    public void onCameraPermissionDenied() {
        Log.e(TAG,"Camera permission not granted");
    }
    private class apiResponse implements Callback<AttendanceResponse> {

        @Override
        public void onResponse(@NonNull Call<AttendanceResponse> call, Response<AttendanceResponse> response) {
            if(response.isSuccessful()){
                AttendanceResponse attendanceResponse = response.body();
                if(attendanceResponse != null){
                    new AlertDialog.Builder(scanQRActivity.this)
                            .setTitle("Response")
                            .setMessage(attendanceResponse.getMsg())
                            .setCancelable(false)
                            .setPositiveButton("OK",((dialog, which) -> finish())).show();
                }else {
                    new AlertDialog.Builder(scanQRActivity.this)
                            .setTitle("Response")
                            .setMessage("Empty Response.")
                            .setCancelable(false)
                            .setPositiveButton("OK",((dialog, which) -> finish())).show();
                }
            }
        }

        @Override
        public void onFailure(@NonNull Call<AttendanceResponse> call, Throwable t) {
            new AlertDialog.Builder(scanQRActivity.this)
                    .setTitle("Response")
                    .setMessage(t.getMessage())
                    .setPositiveButton("OK",((dialog, which) -> barcodeReader.resumeScanning())).show();
        }
    }
}
