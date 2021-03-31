/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.example.foodapp.view.home;

import com.example.foodapp.model.Categories;
import com.example.foodapp.model.Meals;

import java.util.List;

public interface HomeView {

    void showLoading();
    void hideLoading();

    //void setMeals(List<Meals.Meal> meal);

   // void setMeal(List<Meals.Meal> meal);

    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);

    void setMeal(List<Meals.Meal> meal);
}
