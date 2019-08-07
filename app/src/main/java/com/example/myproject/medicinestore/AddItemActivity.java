package com.example.myproject.medicinestore;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddItemActivity extends AppCompatActivity {

    AutoCompleteTextView categoryTextView,diseaseTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        String[] categories = { "5-alpha-reductase inhibitors", "5-aminosalicylates", "5HT3 receptor antagonists", "alkylating agents", "allergenics", "alpha-glucosidase inhibitors", "alternative medicines", "amebicides",
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


    }

}
