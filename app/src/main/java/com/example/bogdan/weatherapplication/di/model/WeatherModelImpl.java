package com.example.bogdan.weatherapplication.di.model;

import com.example.bogdan.weatherapplication.api.WeatherApi;
import com.example.bogdan.weatherapplication.di.model.entity.WeatherData;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@Singleton
public class WeatherModelImpl implements WeatherModel {
  private final Observable.Transformer mSchedulerTransformer;
  private final WeatherApi mApiInterface;

  @Inject
  public WeatherModelImpl(Observable.Transformer schedulerTransformer, WeatherApi apiInterface) {
    mSchedulerTransformer = schedulerTransformer;
    mApiInterface = apiInterface;
  }

  @Override
  public Observable<WeatherData> getWeatherData(String city, String appId) {
    return mApiInterface
        .getWeather(city, appId)
        .compose(applySchedulers());
  }

  @SuppressWarnings("unchecked")
  private <T> Observable.Transformer<T, T> applySchedulers() {
    return (Observable.Transformer<T, T>) mSchedulerTransformer;
  }
}
