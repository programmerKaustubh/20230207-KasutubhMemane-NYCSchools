package com.icebergs.a20230207_kasutubhmemane_nycschools.ui.main.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
    /**
     * This method checks if the device has an active network connection.
     *
     * @param context The context of the calling activity or application.
     * @return Returns true if the device has an active network connection, and false otherwise.
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}