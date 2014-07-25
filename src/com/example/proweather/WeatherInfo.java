package com.example.proweather;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;
import com.example.proweather.R;

public class WeatherInfo extends AsyncTask<String, Void, List<String>> {
    private final static String SUGGEST_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=xml&units=metric&cnt=8&q=";

    private Context context;

    public WeatherInfo(Context context) {
        this.context = context;
    }

	@Override
    protected List<String> doInBackground(String... params) {
        List<String> result = new ArrayList<String>();
        HttpURLConnection conn = null;
        String error = null;
        try {
            String query = URLEncoder.encode(params[0], "UTF-8");
            URL url = new URL(SUGGEST_URL + query);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();

            XmlPullParser xpp = Xml.newPullParser();
            xpp.setInput(conn.getInputStream(), "UTF-8");
            for (int et = xpp.getEventType(); et != XmlPullParser.END_DOCUMENT; 
                     et = xpp.next()) {
            	String tag = "time";
            	String attr = "day";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }
                
            	tag = "symbol";
            	attr = "name";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }

            	tag = "windSpeed";
            	attr = "mps";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }

            	tag = "temperature";
            	attr = "min";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }
                
            	tag = "temperature";
            	attr = "max";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }
                
            	tag = "pressure";
            	attr = "value";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }
                
            	tag = "humidity";
            	attr = "value";
                if (et == XmlPullParser.START_TAG
                        && xpp.getName().equalsIgnoreCase(tag)) {
                    for (int i = 0; i < xpp.getAttributeCount(); i++)
                        if (xpp.getAttributeName(i).equalsIgnoreCase(attr))
                            result.add(xpp.getAttributeValue(i));
                }

            }
        }
        catch (Exception e) {
            error = context.getString(R.string.error_message) + ": " + e.toString();
            Log.e("WeatherInfo", error);
        }
        finally {
            if (conn != null)
                conn.disconnect();
        }
        if (error != null) {
            result.clear();
            result.add(error);
        }
        if (result.size() == 0)
            result.add(context.getString(R.string.no_result_message));

        return result;
    }
}
