package com.study.eazyeat.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.study.eazyeat.R;

public class MainActivity extends Activity {

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
                            Intent intent = new Intent(MainActivity.this, MakeDishActivity.class);
                            startActivity(intent);
                        }

                        if (id == 1){
                            Intent intentlist = new Intent(MainActivity.this, ListDishesActivity.class);
                            startActivity(intentlist);
                        }
                    }
                };
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
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
