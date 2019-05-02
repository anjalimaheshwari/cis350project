package com.example.personalwellness;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AsyncResourceClient extends AsyncTask<URL, String, String> {

    public static int mentalHealth = 0;
    public static int physicalHealth = 0;
    public static int stress = 0;
    public static int community = 0;
    public static int accountNum = 0;

    private static final String TAG = AsyncClient.class.getSimpleName();

    protected String doInBackground(URL... urls) {
        try {
            //get the first URL from the array
            URL url = urls[0];
            Log.d(TAG, "----------- got url " + url);
            // create connection and send HTTP request
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            Log.d(TAG, "----------- created connection ");
            conn.setRequestMethod("GET");
            conn.connect();// read first line of data that is returned
            Log.d(TAG, "----------- read first line of data that is returned ");
            Scanner in = new Scanner(url.openStream());
            String msg = in.nextLine();


            ArrayList<String> resourceInfo = new ArrayList<>();

            while (in.hasNextLine()) {
                String s = in.nextLine();
                Log.d(TAG, "----------- " + s);
                resourceInfo.add(s);
            }
            Log.d(TAG, "----------- resourceInfo " + resourceInfo);

            getResourceFromText(resourceInfo);

            return "";
        }catch (Exception e) {
            return e.toString();
        }
    }

    public void getResourceFromText(ArrayList<String> resourceInfo) {

    }
}
