package com.example.tupicionario;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CulinariaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culinaria);


        String[] culinariaArray = getResources().getStringArray(R.array.culinaria);
        final String[] culinariaDescArray = getResources().getStringArray(R.array.culinaria_desc);

        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            String titulo = culinariaArray[i];
            String desc = culinariaDescArray[i];

            Item item = new Item(titulo, desc, R.drawable.culinaria);
            list.add(item);
        }
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.culinaria_categoria);
        ListView listView = findViewById(R.id.rootCulinaria);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = culinariaDescArray[position];
                Toast.makeText(CulinariaActivity.this, desc, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
