package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menus extends AppCompatActivity {

    String st,st1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
    }

    public void ssbtn(View view){
        Intent intent = new Intent (this,menus.class);
        startActivity (intent);
    }

    public void stbtn(View view){
        Intent intent = new Intent (this,menut.class);
        startActivity (intent);
    }

    public void sebtn(View view){
        Intent intent = new Intent (this,menue.class);
        startActivity (intent);
    }

    public void sa(View view){

        st = "01 වසර";
        st1="sg001";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }

    public void sb(View view){

        st = "02 වසර";
        st1="sg002";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sc(View view){

        st = "03 වසර";
        st1="sg003";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sd(View view){

        st = "04 වසර";
        st1="sg004";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void se(View view){

        st = "05 වසර";
        st1="sg005";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sf(View view){

        st = "06 වසර";
        st1="sg6";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sg(View view){

        st = "07 වසර";
        st1="sg7";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sh(View view){

        st = "08 වසර";
        st1="sg08";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void si(View view){

        st = "09 වසර";
        st1="sg09";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sj(View view){

        st = "10 වසර";
        st1="sg10";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sk(View view){

        st = "11 වසර";
        st1="sg11";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
    public void sl(View view){

        st = "විෂය";
        st1="sg12";
        Intent intent = new Intent(this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        startActivity(intent);
        finish();
    }
}
