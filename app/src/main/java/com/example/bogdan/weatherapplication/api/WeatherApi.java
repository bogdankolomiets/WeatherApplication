package com.example.bogdan.weatherapplication.api;

import com.example.bogdan.weatherapplication.model.entity.WeatherData;

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
  Observable<WeatherData> getWeatherByCity(@Query("q") String city,
                                           @Query("appid") String appId);

  @GET("weather/")
  Observable<WeatherData> getWeatherByCoord(@Query("lat") double latitude,
                                            @Query("lon") double longitude,
                                            @Query("appid") String appId,
                                            @Query("units") String metrics,
                                            @Query("lang") String language);
}
