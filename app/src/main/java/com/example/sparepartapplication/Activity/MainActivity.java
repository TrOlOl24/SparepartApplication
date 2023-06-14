package com.example.sparepartapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sparepartapplication.Adapters.Adapter;
import com.example.sparepartapplication.App;
import com.example.sparepartapplication.R;
import com.example.sparepartapplication.Room.SparePart;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Автозапчасти");

        searchView = findViewById(R.id.search);
        recyclerView = findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        Adapter adapter = new Adapter(App.getInstance().getSparePartDao().getAll());
        recyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                String search = "%" + newText + "%";
                List<SparePart> spareParts = App.getInstance().getSparePartDao().getDetail(search);
                adapter.filterList(spareParts);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_filter) {
            Intent intentFilter = new Intent(MainActivity.this, ModelActivity.class);
            startActivity(intentFilter);
        }
        if(item.getItemId() == R.id.menu_info) {
            Intent intentInfo = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(intentInfo);
        }
        return true;
    }
}