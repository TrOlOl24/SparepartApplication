package com.example.sparepartapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sparepartapplication.Adapters.Adapter;
import com.example.sparepartapplication.App;
import com.example.sparepartapplication.R;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Запчасти по фильтру");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String model = intent.getStringExtra("model");
        String type = intent.getStringExtra("type");

        recyclerView = findViewById(R.id.list_detail);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        Adapter adapter = new Adapter(App.getInstance().getSparePartDao().getDetailOfTypeAndModel(model,type));
        recyclerView.setAdapter(adapter);
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
            Intent intentFilter = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intentFilter);
        }
        if(item.getItemId() == R.id.menu_info) {
            Intent intentInfo = new Intent(DetailActivity.this, InfoActivity.class);
            startActivity(intentInfo);
        }
        return true;
    }
}