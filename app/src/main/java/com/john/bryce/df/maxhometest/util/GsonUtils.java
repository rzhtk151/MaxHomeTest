package com.john.bryce.df.maxhometest.util;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.john.bryce.df.maxhometest.util.jsonmodel.Data;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Utilities class that holds a single instance of Gson that is used throughout the application
 * using functions provided in this class.
 */
public final class GsonUtils {

    public static final String LOCAL_GSON_NAME = "jsonObject";
    private static final Gson gson = new Gson();

    private GsonUtils() {

    }

    public static <T> T fromJson(@NonNull String json, @NonNull Class<T> classOfT) {
        return gson.fromJson( json, classOfT );
    }

    public static String loadJSONFromAsset(Activity activity, String fileName) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open( fileName + ".json" );
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read( buffer );
            is.close();
            json = new String( buffer, "UTF-8" );
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static Data getData(Activity activity) throws JSONException {
        String str = loadJSONFromAsset( activity, LOCAL_GSON_NAME );
        final Data object1 = fromJson( str, Data.class );
        return object1;
    }
}
