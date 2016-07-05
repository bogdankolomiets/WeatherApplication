package com.example.bogdan.weatherapplication.di.module;

import com.example.bogdan.weatherapplication.di.ActivityScope;
import com.example.bogdan.weatherapplication.model.WeatherModel;
import com.example.bogdan.weatherapplication.presenter.MainPresenter;
import com.example.bogdan.weatherapplication.presenter.MainPresenterImpl;
import com.example.bogdan.weatherapplication.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@Module
public class MainViewModule {
  private MainView mView;

  public MainViewModule(MainView view) {
    mView = view;
  }

  @ActivityScope
  @Provides
  MainPresenter provideMainPresenter(WeatherModel model) {
    return new MainPresenterImpl(model, mView);
  }
}
