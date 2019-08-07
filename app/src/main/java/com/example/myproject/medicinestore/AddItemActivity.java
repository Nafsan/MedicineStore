package com.example.myproject.medicinestore;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class AddItemActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mDatabaseReference = mDatabase.getReference();

    EditText name, description,price;
    Button submit;
    AutoCompleteTextView categoryTextView,diseaseTextView;
    private Firebase mRootRef;
    private String pid= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final String[] categories = { "5-alpha-reductase inhibitors", "5-aminosalicylates", "5HT3 receptor antagonists", "alkylating agents", "allergenics", "alpha-glucosidase inhibitors", "alternative medicines", "amebicides",
                "aminoglycosides", "aminopenicillins", "aminosalicylates", "bacterial vaccines", "barbiturate anticonvulsants",
                "barbiturates", "calcimimetics", "calcineurin inhibitors", "calcitonin", "decongestants", "dermatological agents", "diagnostic radiopharmaceuticals", "diarylquinolines",
                "estrogens", "expectorants", "factor Xa inhibitors", "growth hormone receptor blockers", "growth hormones",
                "heparin antagonists", "heparins", "HER2 inhibitors", "herbal products", "inhaled corticosteroids", "inotropic agents", "insulin",
                "ketolides", "laxatives", "leprostatics", "medical gas", "meglitinides", "nasal preparations", "nasal steroids",
                "natural penicillins", "ophthalmic anesthetics", "ophthalmic anti-infectives", "PARP inhibitors", "PCSK9 inhibitors", "quinolones",
                "radiocontrast agents", "radiologic adjuncts", "salicylates", "sclerosing agents", "thioxanthenes", "urinary anti-infectives",
                "vaccine combinations"
        };
        String[] disease = {"Fever","Gastric","Ulcer","Cancer","Kidney","Heart Disease","Pain","Liver"};

        FirebaseApp.initializeApp(this);

        categoryTextView = findViewById(R.id.category);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, categories);

        categoryTextView.setThreshold(1);
        categoryTextView.setAdapter(arrayAdapter);


        diseaseTextView = findViewById(R.id.disease);
        ArrayAdapter<String> diseaseAdapter = new ArrayAdapter<>(this,
                android.R.layout.select_dialog_item,disease);
        diseaseTextView.setThreshold(1);
        diseaseTextView.setAdapter(diseaseAdapter);

        name = findViewById(R.id.medicine_id);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(AddItemActivity.this)
                        .setTitle("Submit?")
                        .setMessage("Are you sure you want to submit?")

                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                AddItem();
                                Intent intent = new Intent(AddItemActivity.this, MainActivity.class);
                                startActivity(intent);

                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }
    public void AddItem()
    {
        pid = FirebaseDatabase.getInstance().getReference().child("Medicine").push().getKey();

        final String Mname = name.getText().toString();
        final String Mdescription = description.getText().toString();
        final String Mcategory = categoryTextView.getText().toString();
        final String Mdisease = diseaseTextView.getText().toString();
        final String Mprice = price.getText().toString();

        mRootRef = new Firebase("https://medicinestore-4131e.firebaseio.com/Medicine");
        FirebaseDatabase.getInstance().getReference().child("Medicine").push().getKey();

        Query query = FirebaseDatabase.getInstance().getReference().child("Medicine").orderByChild("Medicine Name").equalTo(Mname);
        query.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if (!dataSnapshot.exists() && Mname!=null && Mcategory!=null && Mdisease!=null && Mdescription!=null && Mprice!=null) {
                    mDatabaseReference.child(pid).child("Medicine Name").setValue(Mname);
                    mDatabaseReference.child(pid).child("Category").setValue(Mcategory);
                    mDatabaseReference.child(pid).child("Description").setValue(Mdescription);
                    mDatabaseReference.child(pid).child("Disease").setValue(Mdisease);
                    mDatabaseReference.child(pid).child("Price").setValue(Mprice);

                    Toast.makeText(getApplicationContext(), "Item Added", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Item already added", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        });


    }
}
