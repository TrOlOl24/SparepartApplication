package com.example.sparepartapplication.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SparePart.class}, version = 1, exportSchema = false)
public abstract class SparePartDatabase extends RoomDatabase {
    public abstract SparePartDao sparePartDao();
}
