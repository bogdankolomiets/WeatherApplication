package com.example.bogdan.weatherapplication.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 06.07.16
 */
public class City {
  private String mName;

  private Coordinates mCoordinates;

  public String getName() {
    return mName;
  }

  public Coordinates getCoordinates() {
    return mCoordinates;
  }
}
