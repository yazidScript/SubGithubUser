package com.example.subgithubuser.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.subgithubuser.R;
import com.example.subgithubuser.helper.AppHelper;
import com.example.subgithubuser.model.ModelUser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class UserAutoCompleteAdapter extends BaseAdapter implements Filterable {
    private static final int MAX_RESULTS = 10;
    private Context mContext;
    private List<ModelUser> mResultList = new ArrayList<ModelUser>();
    private boolean mDebugMode = false;

    public UserAutoCompleteAdapter(Context context) {
        mContext = context;

    }

//    public UserAutoCompleteAdapter(Context context, String mode) {
//        mContext = context;
//        SharedPreferences sp = mContext.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        mUserId = sp.getString(Config.LOGIN_ID_SHARED_PREF, "");
//        mLoginToken = sp.getString(Config.LOGIN_TOKEN_SHARED_PREF, "");
//        mMode = mode;
//    }
//
//    public UserAutoCompleteAdapter(Context context, String userId, String loginToken) {
//        mContext = context;
//        mUserId = userId;
//        mLoginToken = loginToken;
//    }

    @Override
    public int getCount() {
        return mResultList.size();
    }

    @Override
    public ModelUser getItem(int index) {
        return mResultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.simple_dropdown_item_2line, parent, false);
            convertView = inflater.inflate(R.layout.list_item_search, parent, false);
        }

        //((TextView) convertView.findViewById(R.id.text1)).setText(getItem(position).getORD_CODE());
        //((TextView) convertView.findViewById(R.id.text2)).setText("Customer : " + getItem(position).getCUST_NAME());
        ((TextView) convertView.findViewById(R.id.tvUserSearch)).setText(getItem(position).getUSERNAME());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                JsonItemParse jip = new JsonItemParse();
                if (constraint != null) {
                    List<ModelUser> items;
                    items = jip.getParseJsonWCF(constraint.toString());
                    if(items != null) {
                        // Assign the data to the FilterResults
                        filterResults.values = items;
                        filterResults.count = items.size();
                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    mResultList = (List<ModelUser>) results.values;
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }

    class JsonItemParse {
        public JsonItemParse(){

        }

        public List<ModelUser> getParseJsonWCF(String sName) {
            List<ModelUser> listData = new ArrayList<ModelUser>();
            try {
                String temp = sName.replace(" ", "%20");

                URL js;

                String url = "https://api.github.com/search/users?q=" + temp;
                if(mDebugMode)  {
                    Toast.makeText(mContext, url, Toast.LENGTH_LONG).show();
                    Log.d("HBB", "url : " + url);
                }
                js = new URL(url);

                URLConnection jc = js.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
                String line = reader.readLine();
                if(mDebugMode)  {
                    Toast.makeText(mContext, line, Toast.LENGTH_LONG).show();
                    Log.d("HBB", "getParseJsonWCF :\n" + line);
                }

                JSONObject jObj = new JSONObject(line);
//                String resultStatus = jObj.getString("total_count");

//                if (resultStatus != null) {
//                    String message = jObj.optString("");

                    //JSONObject payload = jObj.optJSONObject(Config.RESPONSE_PAYLOAD_FIELD);
                    //int dataRows = payload.optInt("DATA_ROWS_TOTAL");
                    //JSONArray jsonDataContent = payload.optJSONArray("DATA_CONTENT");

                    JSONArray payload = jObj.getJSONArray("items");


                Log.d("YZD", "HASIL: "+payload);
                    if(payload == null) {
                        Toast.makeText(mContext, "Tidak ada data hasil pencarian", Toast.LENGTH_SHORT).show();
                        return listData;
                    }

                    for(int i=0; i<payload.length(); i++) {
                        JSONObject jsonPayload = payload.getJSONObject(i);
                        ModelUser item = AppHelper.mapUserModel(jsonPayload);

                        listData.add(item);
                    }
//                }
//                else {
//                    Toast.makeText(mContext, jObj.getString(Config.RESPONSE_MESSAGE_FIELD), Toast.LENGTH_LONG).show();
//                }
            }
            catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            return listData;
        }
    }

}

