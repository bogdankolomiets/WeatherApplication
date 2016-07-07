package com.example.bogdan.weatherapplication.model;

import com.example.bogdan.weatherapplication.model.entity.WeatherData;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public interface WeatherModel {

  Observable<WeatherData> getWeatherDataByCity(String city,
                                               String appId);

  Observable<WeatherData> getWeatherDataByCoord(double latitude,
                                                double longitude,
                                                String appId);

  Observable<String> getCity();

}
