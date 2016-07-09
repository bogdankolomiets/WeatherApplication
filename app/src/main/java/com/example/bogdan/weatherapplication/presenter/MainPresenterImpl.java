package com.example.bogdan.weatherapplication.presenter;

import com.example.bogdan.weatherapplication.Constants;
import com.example.bogdan.weatherapplication.model.WeatherModel;
import com.example.bogdan.weatherapplication.model.entity.WeatherData;
import com.example.bogdan.weatherapplication.view.MainView;

import javax.inject.Inject;

import rx.Observer;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class MainPresenterImpl extends BasePresenter implements MainPresenter {
  private MainView mView;

  @Inject
  public MainPresenterImpl(WeatherModel model, MainView view) {
    super(model);
    mView = view;
  }

  @Override
  public void onCreate() {

  }

  @Override
  public void onCurrentLocationChanged(double latitude, double longitude) {
    onLocationSelect(latitude, longitude);
  }

  @Override
  public void onCitySelect(String city) {
    mModel
        .getWeatherDataByCity(city, Constants.HTTP.APPID)
        .subscribe(new Observer<WeatherData>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onNext(WeatherData weatherData) {
            mView.showWeatherData(weatherData);
          }
        });
  }

  @Override
  public void onLocationSelect(double latitude, double longitude) {
    mModel
        .getWeatherDataByCoord(latitude, longitude, Constants.HTTP.APPID)
        .subscribe(new Observer<WeatherData>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {
            e.printStackTrace();
          }

          @Override
          public void onNext(WeatherData weatherData) {
            mView.showWeatherData(weatherData);
          }
        });
  }

}
