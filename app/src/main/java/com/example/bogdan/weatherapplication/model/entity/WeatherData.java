package com.example.bogdan.weatherapplication.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class WeatherData {

  @SerializedName("weather")
  @Expose
  private List<Weather> mWeather;

  @SerializedName("main")
  @Expose
  private Main mMain;

  @SerializedName("wind")
  @Expose
  private Wind mWindSpeed;

  public String getDescription() {
    return mWeather.get(0).getDescription();
  }

  public double getTemperature() {
    return mMain.getTemperature();
  }

  public int getPressure() {
    return mMain.getPressure();
  }

  public int getHumidity() {
    return mMain.getHumidity();
  }

  public double getWindSpeed() {
    return mWindSpeed.getSpeed();
  }

  @Override
  public String toString() {
    return "[Description = "
        + getDescription() + ", "
        + "Temperature = "
        + getTemperature() + ", "
        + "Pressure = "
        + getPressure() + ", "
        + "Humidity = "
        + getHumidity() + ", "
        + "WindSpeed = "
        + getWindSpeed() + "]";
  }
}
