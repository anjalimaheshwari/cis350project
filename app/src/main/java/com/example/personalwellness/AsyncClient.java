package com.example.personalwellness;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AsyncClient extends AsyncTask<URL, String, String> {

    public static User curr = null;
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

            ArrayList<String> userInfo = new ArrayList<>();

            while (in.hasNextLine()) {
                userInfo.add(in.nextLine());
            }
            curr = getUserFromText(userInfo);

            return "";
        }catch (Exception e) {
            return e.toString();
        }
    }

    public static User getCurrentUser() {
        return curr;
    }

    /*
     This method is called in foreground after doInBackground finishes.
     It can access and update Views in user interface.
     */
    protected void onPostExecute(String msg) {
        // not implemented but you can use this if you’d like}
    }

    public User getUserFromText(ArrayList<String> userInfo) {
        String name = null;
        String username = null;
        String password = null;
        for (String s : userInfo) {
            String[] pieces = s.split("'");
            if (pieces.length >= 3) {
                if (pieces[1].equals("name")) {
                    name = pieces[3];
                }
                if (pieces[1].equals("username")) {
                    username = pieces[3];
                }
                if (pieces[1].equals("password")) {
                    password = pieces[3];
                }
            }
        }
        if (name != null && username != null && password != null) {
            User u = new User(name, username, password);
            for (String s : userInfo) {
                String[] pieces = s.split("'");
                if (pieces.length >= 3) {
                    if (pieces[1].equals("stress")) {

                        try {
                            stress = Integer.parseInt(pieces[3]);
                        } catch (Exception e) {

                        };
                    }

                    if (pieces[1].equals("physicalHealth")) {

                        try {
                            physicalHealth = Integer.parseInt(pieces[3]);
                        } catch (Exception e) {

                        };
                    }


                    if (pieces[1].equals("mentalHealth")) {

                        try {
                            mentalHealth = Integer.parseInt(pieces[3]);
                        } catch (Exception e) {

                        };
                    }


                    if (pieces[1].equals("accountNum")) {

                        try {
                            accountNum = Integer.parseInt(pieces[3]);
                        } catch (Exception e) {

                        };
                    }


                    if (pieces[1].equals("community")) {

                        try {
                            community = Integer.parseInt(pieces[3]);
                        } catch (Exception e) {

                        };
                    }



                }
            }

            return new User(name, username, password);
        }
        return null;
    }
}