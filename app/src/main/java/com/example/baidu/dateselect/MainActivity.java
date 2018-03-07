package com.example.baidu.dateselect;

import android.animation.TimeInterpolator;
import android.graphics.SurfaceTexture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Class c = Class.forName("com.example.baidu.dateselect.mytest");
            Log.e("test", c.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
