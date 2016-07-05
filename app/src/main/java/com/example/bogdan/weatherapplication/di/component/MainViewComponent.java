package com.example.bogdan.weatherapplication.di.component;

import com.example.bogdan.weatherapplication.di.ActivityScope;
import com.example.bogdan.weatherapplication.di.module.MainViewModule;
import com.example.bogdan.weatherapplication.view.MainActivity;

import dagger.Subcomponent;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@ActivityScope
@Subcomponent(modules = {MainViewModule.class})
public interface MainViewComponent {
  void inject(MainActivity activity);
}
