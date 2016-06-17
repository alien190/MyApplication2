package com.example.ivanovnv.myapplication;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;
import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetContent();
    }

    protected void onPause() {
        super.onPause();
        SetContent();
    }
    public void setText(View view) {
        TextView TextFiled = (TextView) findViewById(R.id.textView1);
        Switch ControlSwitch = (Switch) findViewById(R.id.switch1);

        ImageView imgView=(ImageView) findViewById(R.id.imageView);

        if(ControlSwitch.isChecked())
        {
            TextFiled.setText("Checked__");
            Drawable drawable= getResources().getDrawable(R.drawable.img2,null);
            imgView.setImageDrawable(drawable);

        }
        else
        {
            TextFiled.setText("Not checked__");
            Drawable drawable = imgView.getDrawable();
            imgView.setImageDrawable(null);
        }
    }

    private void GetContent(){
        TextView TextFiled = (TextView) findViewById(R.id.textView1);
        Switch ControlSwitch = (Switch) findViewById(R.id.switch1);


        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        TextFiled.setText(sharedPref.getString("TextField1","start"));
        ControlSwitch.setChecked(sharedPref.getBoolean("switch1",false));


        if(ControlSwitch.isChecked())
        {
            ImageView imgView=(ImageView) findViewById(R.id.imageView);
            Drawable drawable= getResources().getDrawable(R.drawable.img2,null);
            imgView.setImageDrawable(drawable);
        }


    }

    private void SetContent(){
        TextView TextFiled = (TextView) findViewById(R.id.textView1);
        Switch ControlSwitch = (Switch) findViewById(R.id.switch1);

        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPref.edit();
        ed.putString("TextField1", (String)TextFiled.getText());
        ed.putBoolean("switch1",ControlSwitch.isChecked());
        ed.commit();
    }
}


