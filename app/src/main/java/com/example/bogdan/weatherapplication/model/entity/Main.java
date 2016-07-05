package com.example.bogdan.weatherapplication.model.entity;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 05.07.16
 */
public class Main {
  private double temp;
  private double pressure;
  private int humidity;

  public double getTemperature() {
    return temp;

  }

  public int getPressure() {
    return (int)(pressure * 0.75);
  }

  public int getHumidity() {
    return humidity;
  }
}
