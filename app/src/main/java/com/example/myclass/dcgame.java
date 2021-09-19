package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class dcgame extends AppCompatActivity {

    String st, st0, st1, st2, st3, st4, st5, st6, st16, st17, st18, st20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcgame);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        st16 = getIntent().getExtras().getString("qa");
        st17 = getIntent().getExtras().getString("qb");
        st18 = getIntent().getExtras().getString("qc");
        st20 = getIntent().getExtras().getString("cvideo");
    }

    public void dcgameclose(View view){
        Intent intent = new Intent (dcgame.this,page.class);
        intent.putExtra ("value", st);
        intent.putExtra ("gid", st1);
        intent.putExtra ("SID", st3);
        intent.putExtra ("SIDNAME", st2);
        intent.putExtra ("SIDPDF", st0);
        intent.putExtra ("CIDNAME", st4);
        intent.putExtra ("CID", st5);
        intent.putExtra ("CPDF", st6);
        intent.putExtra("qa",st16);
        intent.putExtra("qb",st17);
        intent.putExtra("qc",st18);
        intent.putExtra("cvideo",st20);

        startActivity (intent);
    }

    public void degameok(View view){

        st5 = getIntent().getExtras().getString("CID");

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/deletegame.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(dcgame.this, "Delete All Games Answers", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(dcgame.this,page.class);
                        intent.putExtra ("value", st);
                        intent.putExtra ("gid", st1);
                        intent.putExtra ("SID", st3);
                        intent.putExtra ("SIDNAME", st2);
                        intent.putExtra ("SIDPDF", st0);
                        intent.putExtra ("CIDNAME", st4);
                        intent.putExtra ("CID", st5);
                        intent.putExtra ("CPDF", st6);
                        intent.putExtra("qa",st16);
                        intent.putExtra("qb",st17);
                        intent.putExtra("qc",st18);
                        intent.putExtra("cvideo",st20);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(dcgame.this, "Delete All Games Answers", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());

                        Intent intent = new Intent(dcgame.this,page.class);
                        intent.putExtra ("value", st);
                        intent.putExtra ("gid", st1);
                        intent.putExtra ("SID", st3);
                        intent.putExtra ("SIDNAME", st2);
                        intent.putExtra ("SIDPDF", st0);
                        intent.putExtra ("CIDNAME", st4);
                        intent.putExtra ("CID", st5);
                        intent.putExtra ("CPDF", st6);
                        intent.putExtra("qa",st16);
                        intent.putExtra("qb",st17);
                        intent.putExtra("qc",st18);
                        intent.putExtra("cvideo",st20);
                        startActivity(intent);

                    }
                });

        queue.add(request);
    }

}
