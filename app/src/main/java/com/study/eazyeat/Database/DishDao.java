package com.study.eazyeat.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.study.eazyeat.Database.Dish;

import java.util.List;

@Dao
public interface DishDao {
    @Query("SELECT * FROM dish")
    List<Dish> getAllDish();

    @Query("SELECT * FROM dish WHERE id = :dishId")
    Dish getDish(int dishId);

    @Insert
    void InsertAll(Dish... dish);
}
