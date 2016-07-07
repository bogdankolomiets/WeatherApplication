package com.example.bogdan.weatherapplication.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.bogdan.weatherapplication.CurrentLocationListener;
import com.example.bogdan.weatherapplication.R;
import com.example.bogdan.weatherapplication.WeatherApplication;
import com.example.bogdan.weatherapplication.di.module.MainViewModule;
import com.example.bogdan.weatherapplication.model.entity.WeatherData;
import com.example.bogdan.weatherapplication.presenter.MainPresenter;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class MainActivity extends AppCompatActivity implements MainView,
    OnMapReadyCallback,
    OnMapLongClickListener,
    CurrentLocationListener.OnCurrentLocationChanged,
    TextWatcher{
  private static final int LAYOUT = R.layout.main_layout;

  private GoogleMap mGoogleMap;
  private Toolbar mToolbar;
  private WeatherMarker mWeatherMarker;
  private Marker mMarker;
  private CurrentLocationListener mCurrentLocationListener;
  private ArrayAdapter mAdapter;
  private ArrayList<String> mList;

  @BindView(R.id.searchField)
  AutoCompleteTextView mAutoCompleteTextView;

  @Inject
  MainPresenter presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WeatherApplication.get(this).getAppComponent().plus(new MainViewModule(this)).inject(this);
    setContentView(LAYOUT);
    ButterKnife.bind(this);
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
        createLocationListener();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public void showWeatherData(WeatherData weatherData) {
    if (mWeatherMarker != null) {
      setupWeatherMarker(weatherData);
    }
  }

  @Override
  public void showCity(String city) {
    mAdapter.add(city);
    mAdapter.notifyDataSetChanged();
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mGoogleMap = googleMap;
    mGoogleMap.setOnMapLongClickListener(this);
  }

  @Override
  public void onMapLongClick(LatLng latLng) {
    if (mMarker != null) {
      deleteMarker();
    }
    presenter.onLocationSelect(latLng.latitude, latLng.longitude);
    setupMarkerPosition(latLng);
  }

  @Override
  public void onLocationChanged(double latitude, double longitude) {
    if (mMarker != null) {
      deleteMarker();
    }
    setupMarkerPosition(new LatLng(latitude, longitude));
    presenter.onCurrentLocationChanged(latitude, longitude);
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

  }

  @Override
  public void afterTextChanged(Editable editable) {

  }

  private void iniToolbar() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);

    mList = new ArrayList<>();
    mAutoCompleteTextView.addTextChangedListener(this);
    mAdapter = new ArrayAdapter(this,
        android.R.layout.simple_dropdown_item_1line);
    mAutoCompleteTextView.setAdapter(mAdapter);
    mAutoCompleteTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        presenter.onCityFieldCLick();
      }
    });
  }

  private void initMap() {
    SupportMapFragment mapFragment =
        ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map));
    mapFragment.getMapAsync(this);
  }

  private void setupMarkerPosition(LatLng position) {
    mMarker = mGoogleMap.addMarker(new MarkerOptions()
        .position(position)
        .visible(false));
  }

  private void deleteMarker() {
    mWeatherMarker = null;
    mMarker.remove();
  }

  private void setupWeatherMarker(WeatherData weatherData) {
    mWeatherMarker = new WeatherMarker(this);
    mWeatherMarker.setTemperature(weatherData.getTemperature());
    mWeatherMarker.setPressure(weatherData.getPressure());
    mWeatherMarker.setHumidity(weatherData.getHumidity());
    mWeatherMarker.setWindSpeed(weatherData.getWindSpeed());
    mWeatherMarker.setDescription(weatherData.getDescription());
    mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(mWeatherMarker.getBitmapWeatherMarker()));
    mMarker.setVisible(true);
    mMarker.setAnchor(0.5f, 1);
  }

  private void createLocationListener() {
    if (mCurrentLocationListener == null) {
      mCurrentLocationListener = new CurrentLocationListener(MainActivity.this, this);
    }
    mCurrentLocationListener.registerCurrentLocationListener();
  }
}
