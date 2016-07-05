package com.example.bogdan.weatherapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.bogdan.weatherapplication.R;
import com.example.bogdan.weatherapplication.WeatherApplication;
import com.example.bogdan.weatherapplication.di.module.MainViewModule;
import com.example.bogdan.weatherapplication.model.entity.WeatherData;
import com.example.bogdan.weatherapplication.presenter.MainPresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import javax.inject.Inject;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class MainActivity extends AppCompatActivity implements MainView, OnMapReadyCallback {
  private static final int LAYOUT = R.layout.main_layout;

  private GoogleMap mGoogleMap;

  @Inject
  MainPresenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WeatherApplication.get(this).getAppComponent().plus(new MainViewModule(this)).inject(this);
    setContentView(LAYOUT);
    initMap();
    presenter.onCreate();
  }

  @Override
  public void showWeatherData(WeatherData weatherData) {

  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;
  }

  private void initMap() {
    SupportMapFragment mapFragment =
        ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map));
    mapFragment.getMapAsync(this);
  }

}
