package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> alisverisListesi;
    private ArrayAdapter<String> adapter;
    private EditText editText;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alisverisListesi = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alisverisListesi);

        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button ekleButton = findViewById(R.id.ekleButton);
        ekleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yeniOge = editText.getText().toString();
                if (!yeniOge.isEmpty()) {
                    alisverisListesi.add(yeniOge);
                    adapter.notifyDataSetChanged();
                    editText.getText().clear();
                }
            }
        });

        Button temizleButton = findViewById(R.id.temizleButton);
        temizleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alisverisListesi.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
