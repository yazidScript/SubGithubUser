package com.example.subgithubuser.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.subgithubuser.R;
import com.example.subgithubuser.model.ModelUser;

public class DetailUserActivity extends AppCompatActivity {

    private TextView tvUsername, tvFollower, tvFollowing, tvCompany, tvBio, tvName;
    private ImageView ivAvatar;
    private ModelUser modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        binding();
        modelList = getIntent().getExtras().getParcelable("extra_list");
        if (modelList != null){
            tvUsername.setText(modelList.getUSERNAME());
            tvCompany.setText(modelList.getCOMPANY());
            tvBio.setText(modelList.getBIO());
            tvName.setText(modelList.getNAME());

        }

    }
    private void binding(){
        tvUsername = findViewById(R.id.tvUsername);
        tvCompany = findViewById(R.id.tvCompany);
        tvBio = findViewById(R.id.tvBio);
        tvName = findViewById(R.id.tvName);
        ivAvatar = findViewById(R.id.ivUser);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}