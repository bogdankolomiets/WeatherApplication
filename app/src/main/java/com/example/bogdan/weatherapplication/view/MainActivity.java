package com.example.bogdan.weatherapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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
  private Toolbar mToolbar;
  @Inject
  MainPresenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WeatherApplication.get(this).getAppComponent().plus(new MainViewModule(this)).inject(this);
    setContentView(LAYOUT);
    iniToolbar();
    initMap();
    presenter.onCreate();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.checkCurrentLocation:
        presenter.onCurrentLocationClick();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void showWeatherData(WeatherData weatherData) {

  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;
  }

  private void iniToolbar() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
  }

  private void initMap() {
    SupportMapFragment mapFragment =
        ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map));
    mapFragment.getMapAsync(this);
  }

}
