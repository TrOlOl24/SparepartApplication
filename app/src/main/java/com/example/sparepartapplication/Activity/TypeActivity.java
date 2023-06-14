package com.example.sparepartapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sparepartapplication.Adapters.AdapterType;
import com.example.sparepartapplication.App;
import com.example.sparepartapplication.R;

public class TypeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        getSupportActionBar().setTitle("Типы запчастей");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String model = intent.getStringExtra("model");

        recyclerView = findViewById(R.id.list_type);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        AdapterType adapterType = new AdapterType(App.getInstance().getSparePartDao().getTypeOfModel(model), model);
        recyclerView.setAdapter(adapterType);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        if(item.getItemId() == R.id.menu_home) {
            Intent intentFilter = new Intent(TypeActivity.this, MainActivity.class);
            startActivity(intentFilter);
        }
        if(item.getItemId() == R.id.menu_info) {
            Intent intentInfo = new Intent(TypeActivity.this, InfoActivity.class);
            startActivity(intentInfo);
        }
        return true;
    }


}