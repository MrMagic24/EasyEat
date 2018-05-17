package com.study.eazyeat.Activity;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.study.eazyeat.Database.AppDatabase;
import com.study.eazyeat.Database.Dish;
import com.study.eazyeat.R;

public class MakeDishActivity extends Activity {

    EditText name;
    EditText recipe;
    EditText ingredients;
    Button button_make_dish;

    private static AppDatabase DishesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_dish);

        // Кнопка возврата к родительской активности
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        name = (EditText)findViewById(R.id.name);
        recipe = (EditText)findViewById(R.id.recipe);
        ingredients = (EditText)findViewById(R.id.ingredients);
        button_make_dish = (Button) findViewById(R.id.button_make_dish);
    }

    public void onButtonClick(View view)
    {
        DishesDB = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,
                "dishDB").allowMainThreadQueries().build();

        if (TextUtils.isEmpty(name.getText().toString())
                || TextUtils.isEmpty(recipe.getText().toString())
                || TextUtils.isEmpty(ingredients.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Заполните все поля",  Toast.LENGTH_SHORT).show();
            return;
        }

        getDishesDB().dishDao().InsertAll(new Dish(name.getText().toString(), recipe.getText().toString(), ingredients.getText().toString()));
        Toast.makeText(getApplicationContext(), "Блюдо добавлено",  Toast.LENGTH_SHORT).show();
        name.setText("");
        recipe.setText("");
        ingredients.setText("");
    }

    public static AppDatabase getDishesDB() {
        return DishesDB;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //
        getMenuInflater().inflate(R.menu.menu_makedish, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                //
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
