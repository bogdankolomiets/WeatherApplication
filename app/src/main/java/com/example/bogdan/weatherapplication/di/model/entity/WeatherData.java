package com.example.bogdan.weatherapplication.di.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class WeatherData {

  @SerializedName("weather.description")
  @Expose
  private String mDescription;

  @SerializedName("main.temp")
  @Expose
  private double mTemperature;

  @SerializedName("main.pressure")
  @Expose
  private int mPressure;

  @SerializedName("main.humiduty")
  @Expose
  private int mHumidity;

  @SerializedName("wind.speed")
  @Expose
  private double mWindSpeed;

  public String getDescription() {
    return mDescription;
  }

  public double getTemperature() {
    return mTemperature;
  }

  public int getPressure() {
    return mPressure;
  }

  public int getHumidity() {
    return mHumidity;
  }

  public double getWindSpeed() {
    return mWindSpeed;
  }

}
