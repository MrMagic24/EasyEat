package com.study.eazyeat;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listMenu = (ListView)findViewById(R.id.menu_items);

        //Create the listener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> listMenu,
                                            View itemView,
                                            int position,
                                            long id) {
                        //Pass the drink the user clicks on to DrinkActivity
                        if (id == 0) {
                            Log.d(TAG, "onClick idButton: " + id);
                            Intent intent = new Intent(MainActivity.this, MakeDishActivity.class);
                            startActivity(intent);
                        }
                    }
                };

        //Assign the listener to the list view

        listMenu.setOnItemClickListener(itemClickListener);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "dishDB").allowMainThreadQueries().build();
        DishDao dishDao = db.dishDao();

        StartInsertDish(db);
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
                Intent intent = new Intent(this, MakeDishActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                //
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void StartInsertDish(AppDatabase db){
        List<Dish> listDish = db.dishDao().getAllDish();

        if (listDish.size() == 0){
            Dish dish = new Dish("Пирог с яблоком", "Пирог с яблоком", "Яблоко яблоко");
            Dish dish2 = new Dish("Пирог с вишней", "Приготовить пирог в духовке", "Тесто, вишня, прямые руки");
            Dish dish3 = new Dish("Пирог с апельсином", "Приготовить пирог в печи", "Апельсин, тесто");

            db.dishDao().InsertAll(dish, dish2, dish3);

            Log.d(TAG, "Dish name: " + dish.getName().toString());
            Log.d(TAG, "Dish name: " + dish2.getName().toString());
            Log.d(TAG, "Dish name: " + dish3.getName().toString());
        }
    }
}
