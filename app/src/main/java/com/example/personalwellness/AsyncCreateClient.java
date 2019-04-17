package com.example.personalwellness;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

class AsyncCreateClient extends AsyncTask<URL, String, String> {

    public void addUser (User user) {

    }

    private static final String TAG = AsyncClient.class.getSimpleName();

    @Override
    protected String doInBackground(URL... urls) {
        try {

            URL url = urls[0];
            Log.d(TAG, "----------- got url " + url);
            // create connection and send HTTP request
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            Log.d(TAG, "----------- created connection ");
            conn.setRequestMethod("GET");
            conn.connect();// read first line of data that is returned
            Log.d(TAG, "----------- read first line of data that is returned ");
//            Scanner in = new Scanner(url.openStream());

            return "";
        }catch (Exception e) {
            return e.toString();
        }
    }
}
