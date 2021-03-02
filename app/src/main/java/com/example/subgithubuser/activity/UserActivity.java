package com.example.subgithubuser.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.subgithubuser.R;
import com.example.subgithubuser.adapter.UserAdapter;
import com.example.subgithubuser.model.ModelUser;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private List<ModelUser> mList;
    private UserAdapter madapter;
    private RecyclerView recyclerView;
    private static final int TIME_LIMIT = 1500;
    private static long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
//        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();
//        mList.add(
//                new ModelUser(
//                        "yazidScript",
//                        R.drawable.avatar,
//                        "Yazid Shollakhudin Ainur Khafid",
//                        "46",
//                        "34",
//                        "PT Jaya Abadi",
//                        "Seorang Android Developer"));
//
//        mList.add(
//                new ModelList(
//                        "janna12",
//                        R.drawable.avatar_3,
//                        "Janna Aminsalim",
//                        "35",
//                        "34",
//                        "PT Jaya Abadi",
//                        "Seorang Web Developer"));
//
//        mList.add(
//                new ModelList(
//                        "hafizriy",
//                        R.drawable.avatar_2,
//                        "Hafiz Riyandi",
//                        "57",
//                        "14",
//                        "PT Jaya Abadi",
//                        "Seorang Android Developer"));
//
//        mList.add(
//                new ModelList(
//                        "hasansan",
//                        R.drawable.avatar_6,
//                        "Hasan nurdin",
//                        "89",
//                        "44",
//                        "PT Jaya Abadi",
//                        "Seorang Web Developer"));
//
//        mList.add(
//                new ModelList(
//                        "abu123",
//                        R.drawable.avatar_4,
//                        "Qudsy Abu",
//                        "2",
//                        "14",
//                        "PT Nusa Indah",
//                        "Seorang Game Developer"));
//
//        mList.add(
//                new ModelList(
//                        "dika098",
//                        R.drawable.avatar_5,
//                        "Dika mukhlisin",
//                        "5",
//                        "4",
//                        "PT Nusa Indah",
//                        "Seorang Designer"));
//
//        mList.add(
//                new ModelList(
//                        "rei",
//                        R.drawable.avatar_7,
//                        "Reinaldi",
//                        "103",
//                        "130",
//                        "PT Nusa Indah",
//                        "Seorang Game Developer"));
//
//        mList.add(
//                new ModelList(
//                        "AgusLight",
//                        R.drawable.avatar_2,
//                        "Agus Purnomo",
//                        "27",
//                        "4",
//                        "Sembooh",
//                        "Seorang Marketing"));
//
//        mList.add(
//                new ModelList(
//                        "rizal_zal",
//                        R.drawable.avatar_8,
//                        "Afrizal Sandi",
//                        "74",
//                        "41",
//                        "Sembooh",
//                        "Seorang Content Writer"));
//
//        mList.add(
//                new ModelList(
//                        "dod62",
//                        R.drawable.avatar,
//                        "Dodi Rahman",
//                        "17",
//                        "14",
//                        "PT Kita Bisa",
//                        "Seorang Software Engineer"));
//
//        mList.add(
//                new ModelList(
//                        "fakhr",
//                        R.drawable.avatar_2,
//                        "Fakhrur",
//                        "56",
//                        "145",
//                        "PT Kita Bisa",
//                        "Seorang Fullstack"));
//
//        mList.add(
//                new ModelList(
//                        "angga23",
//                        R.drawable.avatar_1,
//                        "Angga Amin",
//                        "57",
//                        "1",
//                        "PT Kita Bisa",
//                        "Seorang Designer"));


        madapter = new UserAdapter(this, mList);
        recyclerView.setAdapter(madapter);
    }

    @Override
    public void onBackPressed() {
        if (TIME_LIMIT + backPressed > System.currentTimeMillis()){
            super.onBackPressed();
        }else {
            Toast.makeText(getApplicationContext(),"Press once again to exit", Toast.LENGTH_SHORT).show();
        }
        backPressed =System.currentTimeMillis();
    }
}