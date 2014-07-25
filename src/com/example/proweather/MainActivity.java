package com.example.proweather;

import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.proweather.R;

public class MainActivity extends Activity {
    private final static String TAG = "MainActivity";

    private EditText inputText;
    private Button suggestButton;

//  private ImageView icon1;
    private TextView date1;
    private TextView desc1;
    private TextView windSpeed1;
    private TextView minTemp1;
    private TextView maxTemp1;
    private TextView press1;
    private TextView humid1;

    private TextView date2;
    private TextView desc2;
    private TextView windSpeed2;
    private TextView minTemp2;
    private TextView maxTemp2;
    private TextView press2;
    private TextView humid2;

    private TextView date3;
    private TextView desc3;
    private TextView windSpeed3;
    private TextView minTemp3;
    private TextView maxTemp3;
    private TextView press3;
    private TextView humid3;

    private TextView date4;
    private TextView desc4;
    private TextView windSpeed4;
    private TextView minTemp4;
    private TextView maxTemp4;
    private TextView press4;
    private TextView humid4;

    private TextView date5;
    private TextView desc5;
    private TextView windSpeed5;
    private TextView minTemp5;
    private TextView maxTemp5;
    private TextView press5;
    private TextView humid5;

    private TextView date6;
    private TextView desc6;
    private TextView windSpeed6;
    private TextView minTemp6;
    private TextView maxTemp6;
    private TextView press6;
    private TextView humid6;

    private TextView date7;
    private TextView desc7;
    private TextView windSpeed7;
    private TextView minTemp7;
    private TextView maxTemp7;
    private TextView press7;
    private TextView humid7;

    private TextView date8;
    private TextView desc8;
    private TextView windSpeed8;
    private TextView minTemp8;
    private TextView maxTemp8;
    private TextView press8;
    private TextView humid8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        setupUI();
    }

    private void setupUI() {
        inputText = (EditText) findViewById(R.id.input_text);
        suggestButton = (Button) findViewById(R.id.suggest_button);

//      icon1 = (ImageView) findViewById(R.id.icon1);        
        date1 = (TextView) findViewById(R.id.date1);
        desc1 = (TextView) findViewById(R.id.desc1);
        windSpeed1 = (TextView) findViewById(R.id.windSpeed1);
        minTemp1 = (TextView) findViewById(R.id.minTemp1);
        maxTemp1 = (TextView) findViewById(R.id.maxTemp1);
        press1 = (TextView) findViewById(R.id.press1);
        humid1 = (TextView) findViewById(R.id.humid1);
        
        date2 = (TextView) findViewById(R.id.date2);
        desc2 = (TextView) findViewById(R.id.desc2);
        windSpeed2 = (TextView) findViewById(R.id.windSpeed2);
        minTemp2 = (TextView) findViewById(R.id.minTemp2);
        maxTemp2 = (TextView) findViewById(R.id.maxTemp2);
        press2 = (TextView) findViewById(R.id.press2);
        humid2 = (TextView) findViewById(R.id.humid2);

        date3 = (TextView) findViewById(R.id.date3);
        desc3 = (TextView) findViewById(R.id.desc3);
        windSpeed3 = (TextView) findViewById(R.id.windSpeed3);
        minTemp3 = (TextView) findViewById(R.id.minTemp3);
        maxTemp3 = (TextView) findViewById(R.id.maxTemp3);
        press3 = (TextView) findViewById(R.id.press3);
        humid3 = (TextView) findViewById(R.id.humid3);

        date4 = (TextView) findViewById(R.id.date4);
        desc4 = (TextView) findViewById(R.id.desc4);
        windSpeed4 = (TextView) findViewById(R.id.windSpeed4);
        minTemp4 = (TextView) findViewById(R.id.minTemp4);
        maxTemp4 = (TextView) findViewById(R.id.maxTemp4);
        press4 = (TextView) findViewById(R.id.press4);
        humid4 = (TextView) findViewById(R.id.humid4);

        date5 = (TextView) findViewById(R.id.date5);
        desc5 = (TextView) findViewById(R.id.desc5);
        windSpeed5 = (TextView) findViewById(R.id.windSpeed5);
        minTemp5 = (TextView) findViewById(R.id.minTemp5);
        maxTemp5 = (TextView) findViewById(R.id.maxTemp5);
        press5 = (TextView) findViewById(R.id.press5);
        humid5 = (TextView) findViewById(R.id.humid5);

        date6 = (TextView) findViewById(R.id.date6);
        desc6 = (TextView) findViewById(R.id.desc6);
        windSpeed6 = (TextView) findViewById(R.id.windSpeed6);
        minTemp6 = (TextView) findViewById(R.id.minTemp6);
        maxTemp6 = (TextView) findViewById(R.id.maxTemp6);
        press6 = (TextView) findViewById(R.id.press6);
        humid6 = (TextView) findViewById(R.id.humid6);

        date7 = (TextView) findViewById(R.id.date7);
        desc7 = (TextView) findViewById(R.id.desc7);
        windSpeed7 = (TextView) findViewById(R.id.windSpeed7);
        minTemp7 = (TextView) findViewById(R.id.minTemp7);
        maxTemp7 = (TextView) findViewById(R.id.maxTemp7);
        press7 = (TextView) findViewById(R.id.press7);
        humid7 = (TextView) findViewById(R.id.humid7);

        date8 = (TextView) findViewById(R.id.date8);
        desc8 = (TextView) findViewById(R.id.desc8);
        windSpeed8 = (TextView) findViewById(R.id.windSpeed8);
        minTemp8 = (TextView) findViewById(R.id.minTemp8);
        maxTemp8 = (TextView) findViewById(R.id.maxTemp8);
        press8 = (TextView) findViewById(R.id.press8);
        humid8 = (TextView) findViewById(R.id.humid8);

        suggestButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuery(inputText.getText().toString().trim());
            }
        });
    }

    private void startQuery(String text) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new WeatherInfo(this) {
                @Override
                public void onPostExecute(List<String> result) {
                	date1.setText(result.get(0).substring(5,10));
                	desc1.setText(result.get(1));
                	windSpeed1.setText(result.get(2)+"mps");
                	minTemp1.setText(result.get(3)+"\u00b0");
                	maxTemp1.setText(result.get(4)+"\u00b0");
                	press1.setText(result.get(5)+"hPa");
                	humid1.setText(result.get(6)+"%");

                	date2.setText(result.get(7).substring(5,10));
                	desc2.setText(result.get(8));
                	windSpeed2.setText(result.get(9)+"mps");
                	minTemp2.setText(result.get(10)+"\u00b0");
                	maxTemp2.setText(result.get(11)+"\u00b0");
                	press2.setText(result.get(12)+"hPa");
                	humid2.setText(result.get(13)+"%");

                	date3.setText(result.get(14).substring(5,10));
                	desc3.setText(result.get(15));
                	windSpeed3.setText(result.get(16)+"mps");
                	minTemp3.setText(result.get(17)+"\u00b0");
                	maxTemp3.setText(result.get(18)+"\u00b0");
                	press3.setText(result.get(19)+"hPa");
                	humid3.setText(result.get(20)+"%");

                	date4.setText(result.get(21).substring(5,10));
                	desc4.setText(result.get(22));
                	windSpeed4.setText(result.get(23)+"mps");
                	minTemp4.setText(result.get(24)+"\u00b0");
                	maxTemp4.setText(result.get(25)+"\u00b0");
                	press4.setText(result.get(26)+"hPa");
                	humid4.setText(result.get(27)+"%");

                	date5.setText(result.get(28).substring(5,10));
                	desc5.setText(result.get(29));
                	windSpeed5.setText(result.get(30)+"mps");
                	minTemp5.setText(result.get(31)+"\u00b0");
                	maxTemp5.setText(result.get(32)+"\u00b0");
                	press5.setText(result.get(33)+"hPa");
//                	humid5.setText(result.get(34)+"%");

                	date6.setText(result.get(35).substring(5,10));
                	desc6.setText(result.get(36));
                	windSpeed6.setText(result.get(37)+"mps");
                	minTemp6.setText(result.get(38)+"\u00b0");
                	maxTemp6.setText(result.get(39)+"\u00b0");
                	press6.setText(result.get(40)+"hPa");
//                	humid6.setText(result.get(41)+"%");

                	date7.setText(result.get(42).substring(5,10));
                	desc7.setText(result.get(43));
                	windSpeed7.setText(result.get(44)+"mps");
                	minTemp7.setText(result.get(45)+"\u00b0");
                	maxTemp7.setText(result.get(46)+"\u00b0");
                	press7.setText(result.get(47)+"hPa");
//                	humid7.setText(result.get(48)+"%");

                	date8.setText(result.get(49).substring(5,10));
                	desc8.setText(result.get(50));
                	windSpeed8.setText(result.get(51)+"mps");
                	minTemp8.setText(result.get(52)+"\u00b0");
                	maxTemp8.setText(result.get(53)+"\u00b0");
                	press8.setText(result.get(54)+"hPa");
//                	humid8.setText(result.get(55)+"%");
                }
            }.execute(text);
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.no_network_alert_title))
                    .setNeutralButton(getString(R.string.no_network_alert_ok),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                        int which) {}
                            }).show();
        }
    }
}
