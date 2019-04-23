package com.example.personalwellness;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AsyncClientCheckForUser extends AsyncTask<URL, String, String> {

    public static int mentalHealth = 0;
    public static int physicalHealth = 0;
    public static int stress = 0;
    public static int community = 0;
    public static int accountNum = 0;

    private static final String TAG = AsyncClientCheckForUser.class.getSimpleName();

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

            Scanner in = new Scanner(url.openStream());
            String msg = in.nextLine();

            ArrayList<String> userInfo = new ArrayList<>();
            boolean realUser = false;
            while (in.hasNextLine()) {
                if (in.nextLine().contains("username")) {
                    realUser = true;
                }
            }
            if (realUser) {
                return "bad";
            }
            return "good";

        }catch (Exception e) {
            return e.toString();
        }
    }
}
