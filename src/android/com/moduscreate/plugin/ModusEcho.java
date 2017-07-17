package com.moduscreate.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;
import android.location.Address;
import android.location.Geocoder;
import java.util.List;
import java.io.IOException;

public class ModusEcho extends CordovaPlugin {

  @Override
  public boolean execute(
    String action, 
    JSONArray args, 
    CallbackContext callbackContext
  ) throws JSONException {
    if ("echo".equals(action)) {
      echo(args.getString(0), callbackContext);
      return true;
    }

    if ("echo2".equals(action)) {
      echo2(args.getString(0), callbackContext);
      return true;
    }

    if ("androidcode".equals(action)) {
      androidcode(args.getString(0), callbackContext);
      return true;
    }

    if ("getZipFromAirportCode".equals(action)) {
      getZipFromAirportCode(args.getString(0), callbackContext);
      return true;
    }

    return false;
  }

  private void echo(
    String msg, 
    CallbackContext callbackContext
  ) {

    if (msg == null || msg.length() == 0) {
      callbackContext.error("Empty message!");
    } else {
      Toast.makeText(
        webView.getContext(), 
        msg+" Go!!!!",
        Toast.LENGTH_LONG
      ).show();
      callbackContext.success(msg);
    }
  }

  private void echo2(
          String msg,
          CallbackContext callbackContext
  ) {

    if (msg == null || msg.length() == 0) {
      callbackContext.error("Empty message!");
    } else {
      Toast.makeText(
              webView.getContext(),
              msg+" Upper",
              Toast.LENGTH_LONG
      ).show();
      callbackContext.success(msg);
    }
  }

  private void androidcode(
          String msg,
          CallbackContext callbackContext
  ) {

    if (msg == null || msg.length() == 0) {
      callbackContext.error("Empty message!");
    }
    else {
     int versionInt= Build.VERSION.SDK_INT;
     String version=Integer.toString(versionInt);
      Toast.makeText(
              webView.getContext(),
              "SDK:"+version,
              Toast.LENGTH_LONG
      ).show();
      callbackContext.success(msg);
    }
  }

  private void getZipFromAirportCode(
          String airportCode,
          CallbackContext callbackContext
  ) {
	
	String messageToShow=null;
    if (airportCode == null || airportCode.length() !=3) {
	Toast.makeText(
              webView.getContext(),
              "Airport code must have 3 characters!",
              Toast.LENGTH_LONG
      ).show();
      callbackContext.error("Airport code must have 3 characters!");
    }
    else {

		Geocoder geocoder=new Geocoder(webView.getContext());
		List<Address> sfo=null;
		try {
			sfo = geocoder.getFromLocationName(airportCode, 1);
			messageToShow="Zip code for airport " + airportCode + ":" + sfo.get(0).getPostalCode();
		} catch (IOException e) {
			e.printStackTrace();
			messageToShow="Error:"+e.getMessage();
		}

      Toast.makeText(
              webView.getContext(),
              messageToShow,
              Toast.LENGTH_LONG
      ).show();
      callbackContext.success("Plugin Working!");
    }
  }


}