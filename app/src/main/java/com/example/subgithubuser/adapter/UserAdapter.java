package com.example.subgithubuser.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.subgithubuser.R;
import com.example.subgithubuser.activity.DetailUserActivity;
import com.example.subgithubuser.model.ModelUser;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.AdapterViewHolder> {
    Context context;
    List<ModelUser> mList;


    public UserAdapter(Context context, List<ModelUser> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item,parent,false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        final ModelUser list = mList.get(position);

        holder.tv_username.setText(list.getUSERNAME());
        holder.tv_follower.setText(list.getFOLLOWER());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailUserActivity.class);
                intent.putExtra("extra_list",list);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_username, tv_follower;
        private ImageView iv_photo;
        private LinearLayout item;
        AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
//            tv_username = itemView.findViewById(R.id.tv_username);
//            tv_follower = itemView.findViewById(R.id.tv_followers);
//            iv_photo = itemView.findViewById(R.id.iv_photo);
            item = itemView.findViewById(R.id.item);

        }
    }
}
