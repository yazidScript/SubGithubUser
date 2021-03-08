package com.example.subgithubuser.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelUser implements Parcelable {
    private String ID;
    private String USERNAME;
    private String AVATAR_URL;
    private int AVATAR;
    private String NAME;
    private String FOLLOWER;
    private String FOLLOWING;
    private String COMPANY;
    private String BIO;

    public ModelUser(String username, int avatar, String name, String follower, String following, String company, String bio) {
        USERNAME = username;
        AVATAR = avatar;
        NAME = name;
        FOLLOWER = follower;
        FOLLOWING = following;
        COMPANY = company;
        BIO = bio;
    }

    public ModelUser(Parcel in) {
        ID = in.readString();
        AVATAR_URL = in.readString();
        USERNAME = in.readString();
        AVATAR = in.readInt();
        NAME = in.readString();
        FOLLOWER = in.readString();
        FOLLOWING = in.readString();
        COMPANY = in.readString();
        BIO = in.readString();
    }

    public static final Creator<ModelUser> CREATOR = new Creator<ModelUser>() {
        @Override
        public ModelUser createFromParcel(Parcel in) {
            return new ModelUser(in);
        }

        @Override
        public ModelUser[] newArray(int size) {
            return new ModelUser[size];
        }
    };

    public ModelUser() {

    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAVATAR_URL() {
        return AVATAR_URL;
    }

    public void setAVATAR_URL(String AVATAR_URL) {
        this.AVATAR_URL = AVATAR_URL;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getAVATAR() {
        return AVATAR;
    }

    public void setAVATAR(int AVATAR) {
        this.AVATAR = AVATAR;
    }

    public String getFOLLOWER() {
        return FOLLOWER;
    }

    public void setFOLLOWER(String FOLLOWER) {
        this.FOLLOWER = FOLLOWER;
    }

    public String getFOLLOWING() {
        return FOLLOWING;
    }

    public void setFOLLOWING(String FOLLOWING) {
        this.FOLLOWING = FOLLOWING;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public String getBIO() {
        return BIO;
    }

    public void setBIO(String BIO) {
        this.BIO = BIO;
    }

    public static Creator<ModelUser> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeString(AVATAR_URL);
        dest.writeString(USERNAME);
        dest.writeInt(AVATAR);
        dest.writeString(NAME);
        dest.writeString(FOLLOWER);
        dest.writeString(FOLLOWING);
        dest.writeString(COMPANY);
        dest.writeString(BIO);
    }
}
