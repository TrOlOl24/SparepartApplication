package com.example.sparepartapplication.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SparePartDao {

    @Query("SELECT * FROM sparepart ORDER BY name")
    List<SparePart> getAll();

    @Query("SELECT DISTINCT model_logo FROM sparepart ORDER BY model")
    List<String> getModel();

    @Query("SELECT DISTINCT type_picture FROM sparepart WHERE model_logo=(:model) ORDER BY type")
    List<String> getTypeOfModel(String model);

    @Query("SELECT * FROM sparepart WHERE model_logo=(:model) AND type_picture=(:type) ORDER BY name")
    List<SparePart> getDetailOfTypeAndModel(String model, String type);

    @Query("SELECT * FROM sparepart WHERE name LIKE (:example) ORDER BY name")
    List<SparePart> getDetail(String example);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<SparePart> spareParts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(SparePart sparePart);

    @Delete
    void delete(SparePart sparePart);
}
