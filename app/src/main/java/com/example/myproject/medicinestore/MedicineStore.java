package com.example.myproject.medicinestore;

import android.app.Application;

import com.firebase.client.Firebase;

public class MedicineStore extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
