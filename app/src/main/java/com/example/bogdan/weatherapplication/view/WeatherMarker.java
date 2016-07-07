package com.example.bogdan.weatherapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bogdan.weatherapplication.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 07.07.16
 */
public class WeatherMarker extends LinearLayout {

  @BindView(R.id.markerTemperature)
  TextView temperature;

  @BindView(R.id.markerPressure)
  TextView pressure;

  @BindView(R.id.markerHumidity)
  TextView humidity;

  @BindView(R.id.markerWindSpeed)
  TextView windSpeed;

  @BindView(R.id.markerDescription)
  TextView description;

  @BindView(R.id.markerIcon)
  ImageView icon;

  public WeatherMarker(Context context) {
    super(context);
    initView();
    ButterKnife.bind(this);
  }

  public Bitmap getBitmapWeatherMarker() {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    setLayoutParams(new ViewGroup
        .LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
    layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    buildDrawingCache();

    Bitmap bitmap =
        Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    draw(canvas);

    return bitmap;
  }

  public void setTemperature(int dTemperature) {
    if (dTemperature > 0) {
      temperature.setText("+ " + dTemperature + " \u00b0C");
      return;
    }
    temperature.setText(dTemperature + " \u00b0C");
  }

  public void setIcon(String iconId) {
    Picasso.with(getContext())
        .load("http://openweathermap.org/img/w/" + iconId + ".png")
        .into(icon);
  }

  public void setPressure(int dPressure) {
    pressure.setText(dPressure + " мм рт. ст.");
  }

  public void setHumidity(int iHumidity) {
    humidity.setText(iHumidity + " % влажности");
  }

  public void setWindSpeed(double speed) {
    windSpeed.setText(speed + " м/с");
  }

  public void setDescription(String sDescription) {
    description.setText(sDescription);
  }

  private void initView() {
    View view = inflate(getContext(), R.layout.marker_layout, this);
    ButterKnife.bind(view);
  }
}
