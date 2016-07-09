package com.example.bogdan.weatherapplication.api;

import android.content.Context;

import com.example.bogdan.weatherapplication.model.entity.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 06.07.16
 */
@Singleton
public class CityApi {
  private final Context mContext;

  @Inject
  public CityApi(Context context) {
    mContext = context;
  }

  public Observable<String> getCityByName() {
    return Observable.from(getCities());
  }

  private List<String> getCities() {
    List<String> cityList;
    try {
      JSONArray obj = new JSONArray(loadJson("city_list.json"));
      cityList = new ArrayList<>(obj.length());

      for (int i = 0; i < obj.length(); i++) {
        JSONObject name = obj.getJSONObject(i);
        cityList.add(name.getString("name"));
      }
    } catch (JSONException e) {
      e.printStackTrace();
      return null;
    }

    return cityList;
  }

  private String loadJson(String name) {
    String json;
    try {
      InputStream inputStream = mContext.getAssets().open(name);
      int size = inputStream.available();
      byte[] buffer = new byte[size];
      inputStream.read(buffer);
      inputStream.close();
      json = new String(buffer, "UTF-8");
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

    return json;
  }
}
