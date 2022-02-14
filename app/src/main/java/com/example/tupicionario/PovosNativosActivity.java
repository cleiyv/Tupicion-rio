package com.example.tupicionario;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class PovosNativosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_povos_nativos);

        String[] povosNativosArray = getResources().getStringArray(R.array.povos_nativos);
        final String[] povosNativosDescArray = getResources().getStringArray(R.array.povos_nativos_desc);

        ArrayList<Item> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            String titulo = povosNativosArray[i];
            String desc = povosNativosDescArray[i];

            Item item = new Item(titulo, desc, R.drawable.povos);
            list.add(item);
        }
        ItemAdapter adapter = new ItemAdapter(this, list, R.color.povos_nativos_categoria);
        ListView listView = findViewById(R.id.rootPovosNativos);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = povosNativosDescArray[position];
                Toast.makeText(PovosNativosActivity.this,desc,Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}