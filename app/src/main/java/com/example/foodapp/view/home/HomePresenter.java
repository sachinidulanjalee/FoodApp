/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.example.foodapp.view.home;

import com.example.foodapp.Utils;
import com.example.foodapp.model.Categories;
import com.example.foodapp.model.Meals;
import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private HomeView view;

    public HomePresenter(HomeView view) {
        this.view = view;
    }

    void getMeals() {
        view.showLoading();
        Call<Meals> mealsCall = Utils.getApi().getMeal();
        mealsCall.enqueue(new Callback<Meals>() {
            @Override
            public void onResponse(@NotNull Call<Meals> call, @NotNull Response<Meals> response) {
                view.hideLoading();

                if (response.isSuccessful() && response.body() != null) {
                   view.setMeal(response.body().getMeals());


                }
                else {
                    view.onErrorLoading(response.message());

                }
            }

            @Override
            public void onFailure(@NotNull Call<Meals> call,@NotNull Throwable t) {


                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }


    void getCategories() {
       view.showLoading();

        Call<Categories> categoriesCall = Utils.getApi().getCategories();

        categoriesCall.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(@NotNull  Call<Categories> call,@NotNull Response<Categories> response) {

                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {

                    view.setCategory(response.body().getCategories());

                }
                else {
                   view.onErrorLoading(response. message());

                }
            }

            @Override
            public void onFailure(@NotNull Call<Categories> call,@NotNull Throwable t) {
             view.hideLoading();
             view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
