package com.example.bogdan.weatherapplication.presenter;

import android.support.annotation.NonNull;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 08.07.16
 */
public interface PresenterFactory<T extends BasePresenter> {
  @NonNull T createPresenter();
}
