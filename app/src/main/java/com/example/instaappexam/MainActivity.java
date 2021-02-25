package com.example.instaappexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.instaappexam.midcomponent.MidAdapter;
import com.example.instaappexam.midcomponent.MidItem;
import com.example.instaappexam.topcomponent.TopAdapter;
import com.example.instaappexam.topcomponent.TopItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTop, rvMid;
    private TopAdapter topAdapter;
    private MidAdapter midAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topInit();
        midInit();
    }

    private void topInit(){
        List topList = new ArrayList();
        for(int i=1; i<10; i++){
            topList.add(new TopItem("Your Story"+i));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rvTop = findViewById(R.id.rv_top);
        rvTop.setLayoutManager(manager); // RecyclerView 에 매니저(manager) 세팅

        topAdapter = new TopAdapter(topList); // userAdapter 에 users 세팅
        rvTop.setAdapter(topAdapter); // RecyclerVide 에 userAdapter 세팅팅
    }

    private void midInit() {
        List midList = new ArrayList();
        for(int i=1; i<4; i++){
            midList.add(new MidItem("Username"+i));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvMid = findViewById(R.id.rv_mid);
        rvMid.setLayoutManager(manager); // RecyclerView 에 매니저(manager) 세팅

        midAdapter = new MidAdapter(midList); // userAdapter 에 users 세팅
        rvMid.setAdapter(midAdapter); // RecyclerVide 에 userAdapter 세팅팅
    }
}