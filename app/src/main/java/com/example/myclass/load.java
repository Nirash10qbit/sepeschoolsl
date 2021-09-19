package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.agrawalsuneet.dotsloader.loaders.TashieLoader;

public class load extends AppCompatActivity {



    TashieLoader tashieLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        checkconnection();

        tashieLoader = findViewById(R.id.progress);

        TashieLoader tashie = new TashieLoader(
                this, 5,
                20, 5,
                ContextCompat.getColor(this, R.color.blue));

        tashie.setAnimDuration(100);
        tashie.setAnimDelay(50);
        tashie.setInterpolator(new LinearInterpolator ());

        tashieLoader.addView(tashie);


    }
    public void checkconnection(){

        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();

        if(null!=activeNetwork){
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){
                //  Toast.makeText(this,"Connection Enable",Toast.LENGTH_SHORT).show();

            }
            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){
                // Toast.makeText(this,"Data Network Enable",Toast.LENGTH_SHORT).show();

            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(load.this, login.class);
                    startActivity(intent);
                }
            }, 2000);


        }
        else {
            Toast.makeText(this,"Please check your Internet Connection",Toast.LENGTH_SHORT).show();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(load.this, load.class);
                    startActivity(intent);
                }
            }, 10000);
        }
    }

}