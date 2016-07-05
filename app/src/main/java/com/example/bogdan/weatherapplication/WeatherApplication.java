package com.example.bogdan.weatherapplication;

import  android.app.Application;
import android.content.Context;

import com.example.bogdan.weatherapplication.di.component.ApplicationComponent;
import com.example.bogdan.weatherapplication.di.component.DaggerApplicationComponent;
import com.example.bogdan.weatherapplication.di.module.ApiModule;
import com.example.bogdan.weatherapplication.di.module.ApplicationModule;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class WeatherApplication extends Application {
  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    resolveDependency();
  }

  private void resolveDependency() {
    mApplicationComponent = DaggerApplicationComponent.builder()
        .apiModule(new ApiModule(Constants.HTTP.BASE_URL))
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public static WeatherApplication get(Context context) {
    return (WeatherApplication) context.getApplicationContext();
  }

  public ApplicationComponent getAppComponent() {
    return mApplicationComponent;
  }


}
