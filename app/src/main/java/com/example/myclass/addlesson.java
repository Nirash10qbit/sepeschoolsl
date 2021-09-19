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

public class    addlesson extends AppCompatActivity {

    EditText etcid,etcidname,etcpdf,etqa,etqb,etqc;
    Button etadd;
    ProgressBar progressBaradd;

    String st,st1,st2,st3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlesson);

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
        etqa = findViewById(R.id.qa);
        etqb = findViewById(R.id.qb);
        etqc = findViewById(R.id.qc);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gid = st1;
                String sid = st2;
                String cid = etcid.getText().toString();
                String cidname = etcidname.getText().toString();
                String cpdf = etcpdf.getText().toString();
                String cvideo = "";
                String qa = etqa.getText().toString();
                String qb = etqb.getText().toString();
                String qc = etqc.getText().toString();


                if(isValied(cid,cidname,qa,qb,qc)){
                    addclasses(gid,sid,cid,cidname,cpdf,cvideo,qa,qb,qc);
                }
            }


        });

    }
    private boolean isValied( String cid, String cidname ,String qa ,String qb ,String qc) {


        if(cid.isEmpty()){
            showMessage("Please Enter the lesson id");
            return false;
        }
        if(cidname.isEmpty()){
            showMessage("Please Enter the lesson name");
            return false;
        }

        if(qa.isEmpty()){
            showMessage("Please Enter the Question 01");
            return false;
        }
        if(qb.isEmpty()){
            showMessage("Please Enter the Question 02");
            return false;
        }
        if(qc.isEmpty()){
            showMessage("Please Enter the Question 03");
            return false;
        }



        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String gid, final String sid,  final String cid, final String cidname, final String cpdf, final String cvideo,final String qa, final String qb, final String qc ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addless_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(addlesson.this,"Your Register is Successful", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addlesson.this,subject.class);
                    intent.putExtra("value",st);
                    intent.putExtra("gid",st1);
                    startActivity(intent);

                }
                if (response.equals("sg6")) {

                    Toast.makeText(addlesson.this,"sg6", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(addlesson.this,"Please Change User Name", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(addlesson.this,addlesson.class);
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

                Toast.makeText(addlesson.this, "Please check your Interner Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(addlesson.this,addlesson.class);
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
                params.put("qa",qa);
                params.put("qb",qb);
                params.put("qc",qc);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backless(View view){
        Intent intent = new Intent (addlesson.this,subject.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);

        startActivity(intent);
    }


}