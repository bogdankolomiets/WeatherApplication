package com.example.bogdan.weatherapplication.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 06.07.16
 */
public class Coordinates {
  @SerializedName("lat")
  @Expose
  private double mLatitude;

  @SerializedName("lon")
  @Expose
  private double mLongitude;

  public double getLat() {
    return mLatitude;
  }

  public double getLon() {
    return mLongitude;
  }
}
