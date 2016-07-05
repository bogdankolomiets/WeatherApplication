package com.example.bogdan.weatherapplication.di.component;

import com.example.bogdan.weatherapplication.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

}
