package com.waka.ride.activities;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.waka.ride.models.ViewAttendance.ViewAttendance;
import com.waka.ride.retrofit.RetrofitRepository;

public class AttendanceModel extends ViewModel {
    private MutableLiveData<ViewAttendance> attendance;

    void init(Context context,ProgressBar progressBar, String id){
        if(attendance != null){
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        attendance = RetrofitRepository.getAttendanceDetail(context,progressBar,id);
    }
    LiveData<ViewAttendance> getAttendanceDetail(){
        return attendance;
    }
}
