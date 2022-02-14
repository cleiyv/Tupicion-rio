package com.example.tupicionario;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class PlantasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantas);


        String[] plantasArray = getResources().getStringArray(R.array.plantas);
        final String[] plantasDescArray = getResources().getStringArray(R.array.plantas_desc);

        ArrayList<Item> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            String titulo = plantasArray[i];
            String desc = plantasDescArray[i];

            Item item = new Item (titulo, desc, R.drawable.plantas);
            list.add(item);
        }
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.plantas_categoria);
        ListView listView = findViewById(R.id.rootPlantas);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = plantasDescArray[position];
                Toast.makeText(PlantasActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
