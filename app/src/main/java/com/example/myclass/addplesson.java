package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class addplesson extends AppCompatActivity {

    EditText etcid,etcidname,etcpdf,etcact;
    Button etadd;
    ProgressBar progressBaradd;

    String st,st1,st2,st3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplesson);

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.cadd);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("sid");
        st3 = getIntent().getExtras().getString("sidname");



        etcid = findViewById(R.id.cid);
        etcidname = findViewById(R.id.cidname);
        etcpdf = findViewById(R.id.cpdf);
        etcact = findViewById(R.id.cact);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gid = st1;
                String sid = st2;
                String cid = etcid.getText().toString();
                String cidname = etcidname.getText().toString();
                String cpdf = etcpdf.getText().toString();
                String cvideo = "";
                String cact = etcact.getText().toString();



                if(isValied(cid,cidname)){
                    addclasses(gid,sid,cid,cidname,cpdf,cvideo,cact);
                }
            }


        });

    }
    private boolean isValied( String cid, String cidname ) {


        if(cid.isEmpty()){
            showMessage("Please Enter the lesson id");
            return false;
        }
        if(cidname.isEmpty()){
            showMessage("Please Enter the lesson name");
            return false;
        }





        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String gid, final String sid,  final String cid, final String cidname, final String cpdf, final String cvideo,final String cact){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addpless_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(addplesson.this,"Your Register is Successful", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addplesson.this,subject.class);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    startActivity(intent);

                }
                if (response.equals("sg08")) {

                    Toast.makeText(addplesson.this,"sg08", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(addplesson.this,"Please Change User Name", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(addplesson.this,addplesson.class);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    intent.putExtra("sid",st3);
                    intent.putExtra("sidname",st2);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(addplesson.this, "Please check your Interner Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(addplesson.this,addplesson.class);
                intent.putExtra("value",st);
                intent.putExtra("gid",st1);
                intent.putExtra("sid",st3);
                intent.putExtra("sidname",st2);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("gid",gid);
                params.put("sid", sid);
                params.put("cid",cid);
                params.put("cidname",cidname);
                params.put("cpdf",cpdf);
                params.put("cvideo",cvideo);
                params.put("cact",cact);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backpless(View view){
        Intent intent = new Intent (addplesson.this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);

        startActivity(intent);
    }


}