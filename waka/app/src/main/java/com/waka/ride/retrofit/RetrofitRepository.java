package com.waka.ride.retrofit;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.lifecycle.MutableLiveData;

import com.waka.ride.models.ViewAttendance.ViewAttendance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepository {
   /* public static MutableLiveData<ViewAttendance> getAttendanceDetail(Context context,ProgressBar progressBar, String id){
        MutableLiveData<ViewAttendance> attendanceDetail = new MutableLiveData<>();
        RetrofitService service = new RetrofitService(context);
        RetrofitAPI api = service.createService(RetrofitAPI.class);
        api.getAttendance(id).enqueue(new Callback<ViewAttendance>() {
            @Override
            public void onResponse(Call<ViewAttendance> call, Response<ViewAttendance> response) {
                if(response.isSuccessful()){
                    ViewAttendance attendance = response.body();
                    if(attendance != null){
                        attendanceDetail.setValue(attendance);
                    }
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ViewAttendance> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });
        return attendanceDetail;
    }*/
}
