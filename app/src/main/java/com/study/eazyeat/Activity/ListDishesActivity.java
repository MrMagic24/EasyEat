package com.study.eazyeat.Activity;

import android.app.ListActivity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.study.eazyeat.Database.AppDatabase;
import com.study.eazyeat.Database.Dish;
import com.study.eazyeat.R;

import java.util.List;

public class ListDishesActivity extends ListActivity {

    private static AppDatabase DishesDB;

    List<Dish> listDishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_dishes);

        StartInsertDish();

        String[] namesDishes = new String[listDishes.size()];

        for (int i = 0; i < listDishes.size(); i++) {
            namesDishes[i] = listDishes.get(i).getName().toString();
        }

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, namesDishes);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, DetailDishActivity.class);
        intent.putExtra("Dish", position + 1);

        startActivity(intent);
    }

    public static AppDatabase getDishesDB() {
        return DishesDB;
    }

    public void StartInsertDish(){

        DishesDB = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                "dishDB").allowMainThreadQueries().build();

        listDishes = getDishesDB().dishDao().getAllDish();

        if (listDishes.size() == 0){
            Dish dish = new Dish("Пирог с яблоком", "Пирог с яблоком", "Яблоко яблоко");
            Dish dish2 = new Dish("Пирог с вишней", "Приготовить пирог в духовке", "Тесто, вишня, прямые руки");
            Dish dish3 = new Dish("Пирог с апельсином", "Приготовить пирог в печи", "Апельсин, тесто");

            getDishesDB().dishDao().InsertAll(dish, dish2, dish3);

            listDishes = getDishesDB().dishDao().getAllDish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Заполнение меню элементами
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_make_dish:
                //
                Intent intentmake = new Intent(this, MakeDishActivity.class);
                startActivity(intentmake);
                return true;
            case R.id.action_settings:
                //

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
