package com.example.myproject.medicinestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] Options = {"Medicine List","Symptoms","Instruments","Extras","Order Now","Add Items"};
    int[] OptionImage = {R.drawable.medicine,R.drawable.symptoms,R.drawable.instruments,R.drawable.informations,R.drawable.add_item,R.drawable.order};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    /*Intent intent = new Intent(getApplicationContext(), TrainingActivity.class);
                    startActivity(intent);*/
                }
                else if (i == 6) {
                    /*Intent intent = new Intent(getApplicationContext(), Quiz_main_activity.class);
                    startActivity(intent);*/
                }
                else if (i == 2) {
                    /*Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
                    startActivity(intent);*/

                }
                else if (i == 3) {
                    /*Intent intent = new Intent(getApplicationContext(), GuideActivity.class);
                    startActivity(intent);
*/                }
                else if (i == 1) {
                   // Intent intent = new Intent(getApplicationContext(), SignUp.class);
                    //startActivity(intent);

                }

                else {
  /*                  Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
  */              }
            }
        });

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return OptionImage.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.fruits);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(Options[i]);
            image.setImageResource(OptionImage[i]);
            return view1;
        }
    }

}
