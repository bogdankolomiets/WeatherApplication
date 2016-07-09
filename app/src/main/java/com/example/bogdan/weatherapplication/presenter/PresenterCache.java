package com.example.bogdan.weatherapplication.presenter;

import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 08.07.16
 */
public class PresenterCache {
  private static PresenterCache instance = null;
  private SimpleArrayMap<String, BasePresenter> mPresenters;

  private PresenterCache() {

  }

  public static PresenterCache getInstance(){
    if (instance == null) {
      instance = new PresenterCache();
    }

    return instance;
  }

  public final <T extends BasePresenter> T getPresenter(String who, PresenterFactory<T> factory) {
    if (mPresenters == null) {
      mPresenters = new SimpleArrayMap<>();
    }
    T p = null;
    try {
      p = (T) mPresenters.get(who);
    } catch (ClassCastException e) {
      Log.w("PresenterActivity", "Duplicate Presenter " +
          "tag identified: " + who + ". This could " +
          "cause issues with state.");
    }
    if (p == null) {
      p = factory.createPresenter();
      mPresenters.put(who, p);
    }
    return p;
  }

  public final void removePresenter(String who) {
    if (mPresenters != null) {
      mPresenters.remove(who);
    }
  }
}
