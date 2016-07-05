package com.example.bogdan.weatherapplication.api;

import com.example.bogdan.weatherapplication.di.model.entity.WeatherData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public interface WeatherApi {

  @GET("weather/")
  Observable<WeatherData> getWeather(@Query("q") String city,
                                     @Query("appid") String appId);
}
