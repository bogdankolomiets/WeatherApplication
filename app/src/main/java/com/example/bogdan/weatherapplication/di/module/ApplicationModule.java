package com.example.bogdan.weatherapplication.di.module;

import android.content.Context;

import com.example.bogdan.weatherapplication.WeatherApplication;
import com.example.bogdan.weatherapplication.api.CityApi;
import com.example.bogdan.weatherapplication.api.WeatherApi;
import com.example.bogdan.weatherapplication.model.WeatherModel;
import com.example.bogdan.weatherapplication.model.WeatherModelImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

  @Singleton
  @Provides
  Observable.Transformer provideSchedulerTransformer() {
    return o -> ((Observable) o).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .unsubscribeOn(Schedulers.io());
  }

  @Singleton
  @Provides
  WeatherModel provideWeatherModel(Observable.Transformer schedulerTransformer,
                                   WeatherApi api,
                                   CityApi cityApi) {
    return new WeatherModelImpl(schedulerTransformer, api, cityApi);
  }
}
