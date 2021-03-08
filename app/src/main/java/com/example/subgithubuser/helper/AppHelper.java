package com.example.subgithubuser.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.subgithubuser.activity.DetailUserActivity;
import com.example.subgithubuser.model.ModelUser;

import org.json.JSONObject;

public final class AppHelper {
    public static ModelUser mapUserModel(JSONObject rowData) {
        ModelUser item = new ModelUser();
        item.setID(rowData.optString("id"));
        item.setUSERNAME(rowData.optString("login"));
        item.setAVATAR_URL(rowData.optString("avatar_url"));
        item.setCOMPANY(rowData.optString("company"));
        item.setBIO(rowData.optString("bio"));
        item.setNAME(rowData.optString("name"));

        return item;
    }

    public static void goToUserDetail(Context context, ModelUser rowData) {
        Bundle bundle = new Bundle();

        bundle.putString("id", String.valueOf(rowData.getID()));
        bundle.putString("name", rowData.getNAME());
        bundle.putString("company", rowData.getCOMPANY());
        bundle.putString("login", rowData.getUSERNAME());
        bundle.putString("bio", rowData.getBIO());
        bundle.putString("follower", rowData.getFOLLOWER());
        bundle.putString("following", rowData.getFOLLOWING());

        Intent i = new Intent(context, DetailUserActivity.class);
        //NOTE : bisa pake bundle, bisa pake parcelable
        i.putExtra("extra_user",rowData);
        //i.putExtras(bundle);
        context.startActivity(i);
    }
}
