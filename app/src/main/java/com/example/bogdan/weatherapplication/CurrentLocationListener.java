package com.example.bogdan.weatherapplication;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 06.07.16
 */
public class CurrentLocationListener implements LocationListener {
  private Context mContext;
  private LocationManager mLocationManager;
  private LocationListener mlocationListener;
  private OnCurrentLocationChanged mOnCurrentLocationChanged;

  public CurrentLocationListener(Context context,
                                 OnCurrentLocationChanged onCurrentLocationChanged) {
    mContext = context;
    mOnCurrentLocationChanged = onCurrentLocationChanged;
  }

  @Override
  public void onLocationChanged(Location location) {
    mOnCurrentLocationChanged.onLocationChanged(location.getLatitude(), location.getLongitude());
    deleteCurrentLocationListener();
  }

  @Override
  public void onStatusChanged(String s, int i, Bundle bundle) {

  }

  @Override
  public void onProviderEnabled(String s) {

  }

  @Override
  public void onProviderDisabled(String s) {

  }

  public void registerCurrentLocationListener() {
    mLocationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
  }

  private void deleteCurrentLocationListener() {
    try {
      mLocationManager.removeUpdates(this);
      mLocationManager = null;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public interface OnCurrentLocationChanged {
    void onLocationChanged(double latitude, double longitude);
  }
}
