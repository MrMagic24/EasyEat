package com.study.eazyeat.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.Menu;

import com.study.eazyeat.Database.AppDatabase;
import com.study.eazyeat.Database.Dish;
import com.study.eazyeat.R;

public class DetailDishActivity extends Activity {

    int id_Dish;
    Dish dish;
    private static AppDatabase DishesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dish);

        // Кнопка возврата к родительской активности
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        id_Dish = (int) getIntent().getSerializableExtra("Dish");

        getDish(id_Dish);

        TextView textViewName = (TextView)findViewById(R.id.dish_name);
        textViewName.setText(dish.getName());
        TextView textViewRecipe = (TextView)findViewById(R.id.dish_recipe_detail);
        textViewRecipe.setText(dish.getRecipe());
        TextView textViewIngridients = (TextView)findViewById(R.id.dish_ingridients_detail);
        textViewIngridients.setText(dish.getIngredients());
    }

    public static AppDatabase getDishesDB() {
        return DishesDB;
    }

    public void getDish(int id){
        DishesDB = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                "dishDB").allowMainThreadQueries().build();

        dish = getDishesDB().dishDao().getDish(id);
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
