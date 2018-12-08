package com.example.beverly.colorlist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    //property declarations
    SeekBar redBar, greenBar, blueBar;
    TextView colorValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate properties
        redBar = (SeekBar)this.findViewById(R.id.seekBar1);
        greenBar = (SeekBar)this.findViewById(R.id.seekBar2);
        blueBar = (SeekBar)this.findViewById(R.id.seekBar3);
        colorValue = (TextView) this.findViewById(R.id.textView4);

        //add an event listener to the seekbars
        redBar.setOnSeekBarChangeListener(this);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // get the seekbar values
        int red = this.redBar.getProgress();
        int green = this.greenBar.getProgress();
        int blue = this.blueBar.getProgress();
        colorValue.setBackgroundColor(Color.rgb(red,green,blue));

        String color = String.format("#%02X%02X%02X",red,green,blue);
        this.colorValue.setText(color);
        this.colorValue.setTextColor(Color.rgb(0xff-red,0xff-green,0xff-blue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
    