package com.waka.ride.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import com.waka.ride.adapters.AttendanceAdapter;
import com.waka.ride.databinding.ActivityViewAttendanceBinding;
import com.waka.ride.models.Utils;
import com.waka.ride.models.ViewAttendance.Data;
import com.waka.ride.models.loginResponse.User;

import java.util.ArrayList;
import java.util.Arrays;

public class viewAttendance extends AppCompatActivity {

    private ActivityViewAttendanceBinding binding;
    private AttendanceModel model;
    private AttendanceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewAttendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(AttendanceModel.class);

        setupRecyclerView();
        setSearchManager();
        binding.imgbtnBack.setOnClickListener(back -> finish());
    }

    private void setupRecyclerView() {
        ArrayList<Data> details = new ArrayList<>();
        adapter = new AttendanceAdapter(this,details);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        User user = Utils.getUser(this);
        if(user.getUser_id() != null){
            model.init(this,binding.progressBar,user.getUser_id());
            model.getAttendanceDetail().observe(this,attendance -> {
                if(attendance != null){
                    details.addAll(Arrays.asList(attendance.getData()));
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }

    private void setSearchManager() {
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = binding.searchView;
        if(searchManager != null){
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    adapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }
}
