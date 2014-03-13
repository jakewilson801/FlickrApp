package com.jakewilson.flickr;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakewilson on 3/12/14.
 */
public class Factory {

    public static List<Item> getItems(JSONObject jsonObject) {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            JSONArray photos = jsonObject.getJSONObject("photos").getJSONArray("photo");
            for (int i = 0; i < photos.length(); i++) {
                JSONObject photo = (JSONObject) photos.get(i);
                items.add(new Item(photo.getInt("id"), photo.getString("title"), photo.getString("secret"), photo.getString("url_m"), photo.getLong("dateupload"), photo.getString("ownername")));
            }
        } catch (Exception e) {
        Log.d("HELP",e.toString());
        }
      return items;
    }



}
