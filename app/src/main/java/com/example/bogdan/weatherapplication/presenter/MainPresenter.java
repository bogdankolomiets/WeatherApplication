package com.example.bogdan.weatherapplication.presenter;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public interface MainPresenter {

  void onCreate();

  void onCurrentLocationChanged(double latitude, double longitude);

  void onCityFieldCLick();

  void onCitySelect(String city);

  void onLocationSelect(double latitude, double longitude);
}
