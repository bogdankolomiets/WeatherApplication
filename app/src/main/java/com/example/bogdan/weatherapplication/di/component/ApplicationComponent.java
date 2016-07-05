package com.example.bogdan.weatherapplication.di.component;

import com.example.bogdan.weatherapplication.di.module.ApiModule;
import com.example.bogdan.weatherapplication.di.module.ApplicationModule;
import com.example.bogdan.weatherapplication.di.module.MainViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

  MainViewComponent plus(MainViewModule mainViewModule);
}
