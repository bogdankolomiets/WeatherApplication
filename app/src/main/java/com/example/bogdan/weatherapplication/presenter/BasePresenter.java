package com.example.bogdan.weatherapplication.presenter;

import com.example.bogdan.weatherapplication.model.WeatherModel;

import rx.subscriptions.CompositeSubscription;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public abstract class BasePresenter {
  private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
  protected final WeatherModel mModel;

  public BasePresenter(WeatherModel model) {
    mModel = model;
  }

  protected void addSubscription() {

  }


}
