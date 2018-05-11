package com.study.eazyeat;

        import android.arch.persistence.room.Entity;
        import android.arch.persistence.room.PrimaryKey;

@Entity
public class Dish {

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String recipe;
    private String ingredients;

    public Dish(String name, String recipe, String ingredients) {
        this.name = name;
        this.recipe = recipe;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
