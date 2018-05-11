package com.study.eazyeat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.widget.Button;
import android.widget.EditText;

public class MakeDishActivity extends Activity {

    EditText name;
    EditText recipe;
    EditText ingredients;
    Button button_make_dish;

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
