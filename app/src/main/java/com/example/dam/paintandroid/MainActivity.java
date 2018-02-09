package com.example.dam.paintandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPainted viewPainted;
    private SeekBar pincelSizeBar;
    private TextView pincelSizeText;
    private Spinner spinnerPincelColor;
    private Spinner spinnerBackColor;
    private int BRUSH_SIZE = 10;
    private String dColor;
    private int DEFAULT_COLOR = Color.BLACK;
    private int backgroundColor = Color.WHITE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pincelSizeBar = (SeekBar) findViewById(R.id.pincelSizeBar);

        viewPainted = (ViewPainted) findViewById(R.id.viewPainted);

        //posicion
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        //tamaño pincel
        pincelSizeText = (TextView) findViewById(R.id.pincelSizeText);
        BRUSH_SIZE = Integer.parseInt(pincelSizeText.getText().toString());

        //Spiner color y bgcolor
        spinnerBackColor = (Spinner) findViewById(R.id.spinnerBackColor);
        spinnerBackColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                dColor = parent.getItemAtPosition(pos).toString();
                Log.v("xyzyx", dColor);
                switch (dColor){
                    case "Black":
                        backgroundColor = Color.BLACK;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "White":
                        backgroundColor = Color.WHITE;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Yellow":
                        backgroundColor = Color.YELLOW;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Purple":
                        backgroundColor = Color.rgb(204, 0, 153);
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Blue":
                        backgroundColor = Color.BLUE;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Bronw":
                        backgroundColor = Color.rgb(102, 51, 0);
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Red":
                        backgroundColor = Color.RED;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Orange":
                        backgroundColor = Color.rgb(255, 102, 0);
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        spinnerPincelColor = (Spinner) findViewById(R.id.spinnerPincelColor);
        spinnerPincelColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View selectedItemView, int pos, long id) {
                dColor = parent.getItemAtPosition(pos).toString();
                Log.v("xyzyx", dColor);
                switch (dColor){
                    case "Black":
                        DEFAULT_COLOR = Color.BLACK;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "White":
                        DEFAULT_COLOR = Color.WHITE;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Yellow":
                        DEFAULT_COLOR = Color.YELLOW;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Purple":
                        DEFAULT_COLOR = Color.rgb(204, 0, 153);
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Blue":
                        DEFAULT_COLOR = Color.BLUE;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Bronw":
                        DEFAULT_COLOR = Color.rgb(102, 51, 0);
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Red":
                        DEFAULT_COLOR = Color.RED;
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    case "Orange":
                        DEFAULT_COLOR = Color.rgb(255, 102, 0);
                        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        pincelSizeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                pincelSizeText.setText(String.valueOf(progress));
                BRUSH_SIZE = Integer.parseInt(pincelSizeText.getText().toString());
                viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR, backgroundColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        viewPainted.init(metrics, BRUSH_SIZE, DEFAULT_COLOR);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.normal:
                viewPainted.normal();
                return true;
            case R.id.emboss:
                viewPainted.emboss();
                return true;
            case R.id.blur:
                viewPainted.blur();
                return true;
            case R.id.clear:
                viewPainted.clear();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
