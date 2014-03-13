package com.jakewilson.flickr;

/**
 * Created by jakewilson on 3/12/14.
 */

import android.content.Context;
import android.widget.Toast;

public class Util {

    public static boolean isNullOrEmpty(String s){
        if(s == null)
            return true;
        if(s.trim().equals(""))
            return true;

        return false;
    }

    public static void say(String s, Context c){
        Toast.makeText(c, s, Toast.LENGTH_SHORT).show();
    }

    public static String searchEndpont(String query){
        return String.format("http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=%s&text=%s&extras=url_m,date_upload,owner_name&per_page=25&page=1&format=json&nojsoncallback=1", "1dd17dde0fed7286935d83875fcc17dd", query);
    }

    public static String searchForPicture(int id , String secret){
        return String.format("http://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=f9ae375a2416533457300946e323f13d&photo_id=%d&secret=%s&format=json&nojsoncallback=1", id, secret );
    }

}
