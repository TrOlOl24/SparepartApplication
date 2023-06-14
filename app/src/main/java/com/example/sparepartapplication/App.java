package com.example.sparepartapplication;

import android.app.Application;
import android.util.Log;

import androidx.room.Room;

import com.example.sparepartapplication.API.RetrofitService;
import com.example.sparepartapplication.API.SparePartApi;
import com.example.sparepartapplication.Room.SparePart;
import com.example.sparepartapplication.Room.SparePartDao;
import com.example.sparepartapplication.Room.SparePartDatabase;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class App extends Application {

    private SparePartDatabase database;
    private SparePartDao sparePartDao;

    private Timer timer;
    private TimerTask timerTask;

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                        SparePartDatabase.class, "sparepart_db")
                .allowMainThreadQueries()
                .build();

        sparePartDao = database.sparePartDao();

        startPeriodTask();
    }

    public void startPeriodTask() {
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                RetrofitService retrofitService = new RetrofitService();
                SparePartApi sparePartApi = retrofitService.getRetrofit().create(SparePartApi.class);
                sparePartApi.getAll()
                        .enqueue(new Callback<List<SparePart>>() {
                            @Override
                            public void onResponse(Call<List<SparePart>> call, Response<List<SparePart>> response) {
                                sparePartDao.saveAll(response.body());
                            }

                            @Override
                            public void onFailure(Call<List<SparePart>> call, Throwable t) {
                                Log.d("R", "Данные не загрузились", t);
                            }
                        });
            }
        };
        timer.schedule(timerTask, 0, 60000);
    }

    public SparePartDatabase getDatabase() {
        return database;
    }

    public void setDatabase(SparePartDatabase database) {
        this.database = database;
    }

    public SparePartDao getSparePartDao() {
        return sparePartDao;
    }

    public void setSparePartDao(SparePartDao sparePartDao) {
        this.sparePartDao = sparePartDao;
    }
}
