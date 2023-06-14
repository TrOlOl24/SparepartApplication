package com.example.sparepartapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.sparepartapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class InfoActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView textAddress;
    TextView textPhone1;
    TextView textPhone2;
    TextView textSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        getSupportActionBar().setTitle("Справка");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textPhone1 = findViewById(R.id.info_phone_number1);
        textPhone2 = findViewById(R.id.info_phone_number2);
        textSite = findViewById(R.id.info_site);
        textAddress = findViewById(R.id.info_address);

        textPhone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "8 (499) 372-04-63";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        textPhone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+7 (916) 254-05-85";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        textSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.svautoz.ru/";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        textAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoURI = "geo:55.67544844802006, 37.47060421775279?z=11";
                Uri geo = Uri.parse(geoURI);
                Intent geoIntent = new Intent(Intent.ACTION_VIEW);

                geoIntent.setData(geo);
                if (geoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(geoIntent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        if(item.getItemId() == R.id.menu_filter) {
            Intent intentFilter = new Intent(InfoActivity.this, ModelActivity.class);
            startActivity(intentFilter);
        }
        if(item.getItemId() == R.id.menu_home) {
            Intent intent = new Intent(InfoActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        LatLng loc = new LatLng(55.67544844802006, 37.47060421775279);
        googleMap.addMarker(new MarkerOptions()
                .position(loc)
                .title("SV-AUTO"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}