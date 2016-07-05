package com.example.bogdan.weatherapplication.di.module;

import android.content.Context;

import com.example.bogdan.weatherapplication.WeatherApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@Module
public class ApplicationModule {
  private WeatherApplication mApplication;

  public ApplicationModule(WeatherApplication application) {
    mApplication = application;
  }

  @Singleton
  @Provides
  Context provideApplication() {
    return mApplication;
  }
}
