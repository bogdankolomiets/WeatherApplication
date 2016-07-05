package com.example.bogdan.weatherapplication.di.model;

import com.example.bogdan.weatherapplication.di.model.entity.WeatherData;

import java.util.List;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public interface WeatherModel {

  Observable<WeatherData> getWeatherData(String city, String appId);

}
