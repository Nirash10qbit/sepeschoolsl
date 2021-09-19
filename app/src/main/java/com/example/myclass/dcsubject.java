package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class dcsubject extends AppCompatActivity {

    String st,st1,st2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcsubject);

        tv = findViewById(R.id.dd);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("sid");

        tv.setText(st2);
    }

    public void dcsubclose(View view){
        Intent intent = new Intent (dcsubject.this,subject .class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);

        startActivity (intent);
    }

    public void deok(View view){

        st2 = getIntent().getExtras().getString("sid");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/deletesub.php?sid="+st2+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(dcsubject.this, "Delete Subject", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(dcsubject.this,subject.class);
                        intent.putExtra("value",st);
                        intent.putExtra("gid",st1);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(dcsubject.this, "Delete Subject", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());

                        Intent intent = new Intent(dcsubject.this,subject.class);
                        intent.putExtra("value",st);
                        intent.putExtra("gid",st1);
                        startActivity(intent);

                    }
                });

        queue.add(request);
    }

}
