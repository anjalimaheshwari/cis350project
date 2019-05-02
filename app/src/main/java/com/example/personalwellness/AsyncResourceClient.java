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

    private static final String TAG = AsyncResourceClient.class.getSimpleName();

    protected String doInBackground(URL... urls) {
        try {
            //get the first URL from the array
            URL url = urls[0];
            Log.d(TAG, "----------- got url " + url);
            // create connection and send HTTP request
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            Log.d(TAG, "----------- created connection ");
            conn.setRequestMethod("GET");
            conn.connect();// read first line of data that is returned
            Log.d(TAG, "----------- read first line of data that is returned ");
            Scanner in = new Scanner(url.openStream());
            String msg = in.nextLine();


            ArrayList<String> resourceInfo = new ArrayList<>();

            while (in.hasNextLine()) {
                String s = in.nextLine();
                resourceInfo.add(s);
            }

            ArrayList<Resource> resourcesList = getResourceFromText(resourceInfo);
            ResourceDB db = ResourceDB.getResourceDB();
            db.setResourceDB(resourcesList);

            return "";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public ArrayList<Resource> getResourceFromText(ArrayList<String> resourceInfo) {
        ArrayList<Resource> resourcesList = new ArrayList<>();
        String name = "";
        String image = "";
        String summary = "";
        String category = "";
        String address = "";
        String website = "";
        double lat = 0;
        double lon = 0;
        String phonenumber = "";
        boolean isSpotify = false;

        for (int i = 0; i < resourceInfo.size(); i++) {
            //Log.d(TAG, "----------- resource name: " + resourceInfo.get(i));
            if (resourceInfo.get(i).contains("Name")) {
                String[] resources = resourceInfo.get(i).split("<li>");
                String[] nfields = resourceInfo.get(i).split("</a>");
                String[] nameFields = nfields[0].split("=");
                name = nameFields[2].substring(0, nameFields[2].length() - 5);
                Log.d(TAG, "----------- name " + name);
                i+=2;
            }
            //Log.d(TAG, "----------- entire field " + resourceInfo.get(i));
            if (resourceInfo.get(i).contains("Address")) {
                String[] addy = resourceInfo.get(i).split("<ul> Address: ");
                address = addy[1].substring(0, addy[1].length() - 5);
                Log.d(TAG, "----------- address " + address);
                i++;
            }
            if (resourceInfo.get(i).contains("Category")) {
                String[] catty = resourceInfo.get(i).split("<ul> Category: ");
                category = catty[1].substring(0, catty[1].length() - 5);
                Log.d(TAG, "----------- category " + category);
                i++;

            }
            if (resourceInfo.get(i).contains("Summary")) {
                String[] summy = resourceInfo.get(i).split("<ul> Summary: ");
                summary = summy[1].substring(0, summy[1].length() - 5);
                Log.d(TAG, "----------- summary " + summary);
                i++;

            }
            if (resourceInfo.get(i).contains("Latitude")) {
                String[] latty = resourceInfo.get(i).split("<ul> Latitude: ");
                String latt = latty[1].substring(0, latty[1].length() - 5);
                lat = Double.parseDouble(latt);
                Log.d(TAG, "----------- lat " + lat);
                i++;

            }
            if (resourceInfo.get(i).contains("Longitude")) {
                String[] longy = resourceInfo.get(i).split("<ul> Longitude: ");
                String lonn = longy[1].substring(0, longy[1].length() - 5);
                lon = Double.parseDouble(lonn);
                Log.d(TAG, "----------- lon " + lon);
                i++;

            }
            if (resourceInfo.get(i).contains("Phone")) {
                String[] phoney = resourceInfo.get(i).split("<ul> Phone: ");
                phonenumber = phoney[1].substring(0, phoney[1].length() - 5);;
                Log.d(TAG, "----------- phone " + phonenumber);
                i++;

            }
            if (resourceInfo.get(i).contains("Spotify")) {
                String[] spotty = resourceInfo.get(i).split("<ul> Spotify: ");
                String spot = spotty[1].substring(0, spotty[1].length() - 5);
                if (spot.equals("true")) {
                    isSpotify = true;
                } else {
                    isSpotify = false;
                }
                Log.d(TAG, "----------- spotify " + isSpotify);
                i++;
                Resource r = new Resource(name, "", summary, category, address, website, lat, lon, phonenumber, isSpotify);
                resourcesList.add(r);
            }
        }
        return resourcesList;
    }
}
