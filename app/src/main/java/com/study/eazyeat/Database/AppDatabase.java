package com.study.eazyeat.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Dish.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DishDao dishDao();
}
