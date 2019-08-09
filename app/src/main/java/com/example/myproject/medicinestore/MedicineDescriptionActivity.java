package com.example.myproject.medicinestore;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MedicineDescriptionActivity extends AppCompatActivity {
    private String name,key;
    private TextView medicineName, medicineCompany, medicineCategory, medicineDescription, medicinePrice, medicineDisease;
    DatabaseReference databaseReference;
    Medicine medicine;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_description);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                name= null;
            } else {
                name= extras.getString("name");
            }
        } else {
            name= (String) savedInstanceState.getSerializable("name");
        }
        setTitle(name);

        medicineName = findViewById(R.id.nameTextView);
        medicineCompany = findViewById(R.id.companyTextView);
        medicineCategory = findViewById(R.id.categoryTextView);
        medicineDescription = findViewById(R.id.descriptionTextView);
        medicinePrice = findViewById(R.id.priceTextView);
        medicineDisease = findViewById(R.id.diseaseTextView);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Medicine");
        databaseReference.orderByChild("name").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                medicineName.setText(name);
                for(DataSnapshot userContact : dataSnapshot.getChildren()) {

                    medicine = userContact.getValue(Medicine.class);
                    medicineCompany.setText(String.valueOf(medicine.getCompany()));
                    medicineCategory.setText(String.valueOf(medicine.getCategory()));
                    medicineDescription.setText(String.valueOf(medicine.getDescription()));
                    medicineDisease.setText(String.valueOf(medicine.getDisease()));
                    medicinePrice.setText(String.valueOf(medicine.getPrice()));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
