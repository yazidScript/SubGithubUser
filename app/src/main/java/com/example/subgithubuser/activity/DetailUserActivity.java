package com.example.subgithubuser.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.subgithubuser.R;
import com.example.subgithubuser.model.ModelUser;

public class DetailUserActivity extends AppCompatActivity {

    private TextView tv_username, tv_follower, tv_following, tv_company, tv_bio, tv_name;
    private ImageView iv_avatar;
    private ModelUser modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        binding();
        modelList = getIntent().getExtras().getParcelable("extra_list");
        if (modelList != null){
            tv_username.setText(modelList.getUSERNAME());
            tv_follower.setText(modelList.getFOLLOWER());
            tv_following.setText(modelList.getFOLLOWING());
            tv_company.setText(modelList.getCOMPANY());
            tv_bio.setText(modelList.getBIO());
            tv_name.setText(modelList.getNAME());

        }

    }
    private void binding(){
        tv_username = findViewById(R.id.tvUsername);
        tv_follower = findViewById(R.id.tv_follower);
        tv_following = findViewById(R.id.tv_following);
        tv_company = findViewById(R.id.tv_company);
        tv_bio = findViewById(R.id.tv_bio);
        tv_name = findViewById(R.id.tv_name);
        iv_avatar = findViewById(R.id.ivUser);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}