package com.example.bogdan.weatherapplication.di.module;

import dagger.Module;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
@Module
public class ApiModule {
  private String mBaseUrl;

  public ApiModule(String baseUrl) {
    mBaseUrl = baseUrl;
  }


}
