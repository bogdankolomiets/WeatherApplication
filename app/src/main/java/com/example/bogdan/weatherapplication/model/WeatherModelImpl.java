package com.example.bogdan.weatherapplication.model;

import com.example.bogdan.weatherapplication.Constants;
import com.example.bogdan.weatherapplication.api.CityApi;
import com.example.bogdan.weatherapplication.api.WeatherApi;
import com.example.bogdan.weatherapplication.model.entity.City;
import com.example.bogdan.weatherapplication.model.entity.WeatherData;

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
  private final CityApi mCityApi;

  @Inject
  public WeatherModelImpl(Observable.Transformer schedulerTransformer,
                          WeatherApi apiInterface,
                          CityApi cityApi) {
    mSchedulerTransformer = schedulerTransformer;
    mApiInterface = apiInterface;
    mCityApi = cityApi;
  }

  @Override
  public Observable<WeatherData> getWeatherDataByCity(String city, String appId) {
    return mApiInterface
        .getWeatherByCity(city, appId)
        .compose(applySchedulers());
  }

  @Override
  public Observable<WeatherData> getWeatherDataByCoord(double latitude, double longitude, String appId) {
    return mApiInterface
        .getWeatherByCoord(latitude, longitude, appId, Constants.HTTP.UNITS, Constants.HTTP.LANGUAGE)
        .compose(applySchedulers());
  }

  @Override
  public Observable<String> getCity() {
    return mCityApi
        .getCityByName()
        .compose(applySchedulers());
  }

  @SuppressWarnings("unchecked")
  private <T> Observable.Transformer<T, T> applySchedulers() {
    return (Observable.Transformer<T, T>) mSchedulerTransformer;
  }
}
