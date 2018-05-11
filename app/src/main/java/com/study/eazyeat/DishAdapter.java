package com.study.eazyeat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.ViewHolder> {

    ArrayList<Dish> dishes;

    public DishAdapter(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public DishAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return null;
    }

    @Override
    public void onBindViewHolder(DishAdapter.ViewHolder holder, int position){}

    @Override
    public int getItemCount(){
        return dishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }


}
