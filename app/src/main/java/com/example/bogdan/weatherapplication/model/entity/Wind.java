package com.example.bogdan.weatherapplication.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class Wind {
  @SerializedName("speed")
  @Expose
  private double mSpeed;

  public double getSpeed() {
    return mSpeed;
  }
}
