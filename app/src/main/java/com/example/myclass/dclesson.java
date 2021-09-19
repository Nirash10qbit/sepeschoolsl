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

public class dclesson extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5;
    TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dclesson);

        tv = findViewById(R.id.dd);
        tv1 = findViewById(R.id.de);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st3 = getIntent().getExtras().getString("sid");
        st5 = getIntent().getExtras().getString("CID");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st0 = getIntent().getExtras().getString("SIDPDF");
        st4 = getIntent().getExtras().getString("CIDNAME");

        tv.setText(st5);
        tv1.setText(st1);
    }

    public void dclessclose(View view){
        Intent intent = new Intent (dclesson.this,subject .class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);

        startActivity (intent);
    }

    public void deok(View view){

        st5 = getIntent().getExtras().getString("CID");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/deleteless.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(dclesson.this, "Delete Lesson", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(dclesson.this,subject.class);
                        intent.putExtra("value",st);
                        intent.putExtra("gid",st1);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(dclesson.this, "Delete Lesson", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());

                        Intent intent = new Intent(dclesson.this,subject.class);
                        intent.putExtra("value",st);
                        intent.putExtra("gid",st1);
                        startActivity(intent);

                    }
                });

        queue.add(request);
    }

}
