package com.example.subgithubuser.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.subgithubuser.R;
import com.example.subgithubuser.adapter.UserAdapter;
import com.example.subgithubuser.adapter.UserAutoCompleteAdapter;
import com.example.subgithubuser.helper.AppHelper;
import com.example.subgithubuser.model.ModelUser;
import com.example.subgithubuser.ui.DelayAutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private List<ModelUser> mList;
    private UserAdapter mAdapter;
    private RecyclerView rvUser;
    private DelayAutoCompleteTextView tvSearch;
    private ImageView ivClear;

    private static final int TIME_LIMIT = 1500;
    private static long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        rvUser = findViewById(R.id.rvUser);
        rvUser.setHasFixedSize(true);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        tvSearch = findViewById(R.id.tvSearch);
        ivClear = findViewById(R.id.ivClear);
        ivClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSearch.setText("");
            }
        });

        tvSearch.setThreshold(4);
        tvSearch.setAdapter(new UserAutoCompleteAdapter(this));
        tvSearch.setLoadingIndicator((android.widget.ProgressBar) findViewById(R.id.pbSearch));
        tvSearch.setClearIndicator((ImageView) findViewById(R.id.ivClear));
        tvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            private void doNothing() {

            }

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ModelUser rowData = (ModelUser) adapterView.getItemAtPosition(position);
                tvSearch.setText(rowData.getUSERNAME());
                AppHelper.goToUserDetail(UserActivity.this, rowData);
            }
        });



        mList = new ArrayList<>();
        mList.add(
                new ModelUser(
                        "yazidScript",
                        R.drawable.avatar,
                        "Yazid Shollakhudin Ainur Khafid",
                        "46",
                        "34",
                        "PT Jaya Abadi",
                        "Seorang Android Developer"));

        mList.add(
                new ModelUser(
                        "janna12",
                        R.drawable.avatar_3,
                        "Janna Aminsalim",
                        "35",
                        "34",
                        "PT Jaya Abadi",
                        "Seorang Web Developer"));

        mList.add(
                new ModelUser(
                        "hafizriy",
                        R.drawable.avatar_2,
                        "Hafiz Riyandi",
                        "57",
                        "14",
                        "PT Jaya Abadi",
                        "Seorang Android Developer"));

        mList.add(
                new ModelUser(
                        "hasansan",
                        R.drawable.avatar_6,
                        "Hasan nurdin",
                        "89",
                        "44",
                        "PT Jaya Abadi",
                        "Seorang Web Developer"));

        mList.add(
                new ModelUser(
                        "abu123",
                        R.drawable.avatar_4,
                        "Qudsy Abu",
                        "2",
                        "14",
                        "PT Nusa Indah",
                        "Seorang Game Developer"));

        mList.add(
                new ModelUser(
                        "dika098",
                        R.drawable.avatar_5,
                        "Dika mukhlisin",
                        "5",
                        "4",
                        "PT Nusa Indah",
                        "Seorang Designer"));

        mList.add(
                new ModelUser(
                        "rei",
                        R.drawable.avatar_7,
                        "Reinaldi",
                        "103",
                        "130",
                        "PT Nusa Indah",
                        "Seorang Game Developer"));

        mList.add(
                new ModelUser(
                        "AgusLight",
                        R.drawable.avatar_2,
                        "Agus Purnomo",
                        "27",
                        "4",
                        "Sembooh",
                        "Seorang Marketing"));

        mList.add(
                new ModelUser(
                        "rizal_zal",
                        R.drawable.avatar_8,
                        "Afrizal Sandi",
                        "74",
                        "41",
                        "Sembooh",
                        "Seorang Content Writer"));

        mList.add(
                new ModelUser(
                        "dod62",
                        R.drawable.avatar,
                        "Dodi Rahman",
                        "17",
                        "14",
                        "PT Kita Bisa",
                        "Seorang Software Engineer"));

        mList.add(
                new ModelUser(
                        "fakhr",
                        R.drawable.avatar_2,
                        "Fakhrur",
                        "56",
                        "145",
                        "PT Kita Bisa",
                        "Seorang Fullstack"));

        mList.add(
                new ModelUser(
                        "angga23",
                        R.drawable.avatar_1,
                        "Angga Amin",
                        "57",
                        "1",
                        "PT Kita Bisa",
                        "Seorang Designer"));


        mAdapter = new UserAdapter(this, mList);
        rvUser.setAdapter(mAdapter);
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