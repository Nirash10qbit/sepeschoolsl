package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class addgame extends AppCompatActivity {

    String st, st0, st1, st2, st3, st4, st5, st6, st16, st17, st18, st20;
    TextView etana, etgana, etbna,etgbna,etcna,etgcna,etanb, etganb, etbnb,etgbnb,etcnb,etgcnb,
            etanc, etganc, etbnc,etgbnc,etcnc,etgcnc,etand, etgand, etbnd,etgbnd,etcnd,etgcnd,tv16, tv17, tv18;

    Button etadd;
    ProgressBar progressBaradd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgame);

        progressBaradd = findViewById(R.id.progressBaradd);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.etaddg);

        st = getIntent().getExtras().getString("value");
        st1 = getIntent().getExtras().getString("gid");
        st2 = getIntent().getExtras().getString("SIDNAME");
        st3 = getIntent().getExtras().getString("SID");
        st4 = getIntent().getExtras().getString("CIDNAME");
        st5 = getIntent().getExtras().getString("CID");
        st6 = getIntent().getExtras().getString("CPDF");
        st0 = getIntent().getExtras().getString("SIDPDF");
        tv16 = findViewById(R.id.q1q);
        st16 = getIntent().getExtras().getString("qa");
        tv16.setText(st16);

        tv17 = findViewById(R.id.q2q);
        st17 = getIntent().getExtras().getString("qb");
        tv17.setText(st17);

        tv18 = findViewById(R.id.q3q);
        st18 = getIntent().getExtras().getString("qc");
        tv18.setText(st18);
        st20 = getIntent().getExtras().getString("cvideo");


        etana = findViewById(R.id.ana);
        etgana = findViewById(R.id.gana);
        etbna = findViewById(R.id.bna);
        etgbna = findViewById(R.id.gbna);
        etcna = findViewById(R.id.cna);
        etgcna = findViewById(R.id.gcna);


        etanb = findViewById(R.id.anb);
        etganb = findViewById(R.id.ganb);
        etbnb = findViewById(R.id.bnb);
        etgbnb = findViewById(R.id.gbnb);
        etcnb = findViewById(R.id.cnb);
        etgcnb = findViewById(R.id.gcnb);


        etanc = findViewById(R.id.anc);
        etganc = findViewById(R.id.ganc);
        etbnc = findViewById(R.id.bnc);
        etgbnc = findViewById(R.id.gbnc);
        etcnc = findViewById(R.id.cnc);
        etgcnc = findViewById(R.id.gcnc);


        etand = findViewById(R.id.and);
        etgand = findViewById(R.id.gand);
        etbnd = findViewById(R.id.bnd);
        etgbnd = findViewById(R.id.gbnd);
        etcnd = findViewById(R.id.cnd);
        etgcnd = findViewById(R.id.gcnd);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gid = st1;
                String cid = st5;
                String nna = "0";

                String ana = etana.getText().toString();
                String gana = etgana.getText().toString();
                String bna = etbna.getText().toString();
                String gbna = etgbna.getText().toString();
                String cna = etcna.getText().toString();
                String gcna = etgcna.getText().toString();

                String anb = etanb.getText().toString();
                String ganb = etganb.getText().toString();
                String bnb = etbnb.getText().toString();
                String gbnb = etgbnb.getText().toString();
                String cnb = etcnb.getText().toString();
                String gcnb = etgcnb.getText().toString();

                String anc = etanc.getText().toString();
                String ganc = etganc.getText().toString();
                String bnc = etbnc.getText().toString();
                String gbnc = etgbnc.getText().toString();
                String cnc = etcnc.getText().toString();
                String gcnc = etgcnc.getText().toString();

                String and = etand.getText().toString();
                String gand = etgand.getText().toString();
                String bnd = etbnd.getText().toString();
                String gbnd = etgbnd.getText().toString();
                String cnd = etcnd.getText().toString();
                String gcnd = etgcnd.getText().toString();


                if(isValied(ana,gana,bna,gbna,cna,gcna,anb,ganb,bnb,gbnb,cnb,gcnb,anc,ganc,bnc,gbnc,cnc,gcnc,and,gand,bnd,gbnd,cnd,gcnd)){
                    addclasses(gid,cid,nna,ana,gana,bna,gbna,cna,gcna,anb,ganb,bnb,gbnb,cnb,gcnb,anc,ganc,bnc,gbnc,cnc,gcnc,and,gand,bnd,gbnd,cnd,gcnd);
                }
            }


        });

    }
    private boolean isValied( String ana, String gana ,String bna ,String gbna ,String cna,String gcna,String anb, String ganb ,String bnb ,String gbnb ,String cnb,String gcnb,
                              String anc, String ganc ,String bnc ,String gbnc ,String cnc,String gcnc,String and, String gand ,String bnd ,String gbnd ,String cnd,String gcnd) {


        if(ana.isEmpty()){
            showMessage("Please Enter the Q1 NA");
            return false;
        }
        if(gana.isEmpty()){
            showMessage("Please Enter the Q1 Answer 01");
            return false;
        }

        if(bna.isEmpty()){
            showMessage("Please Enter the Q2 NA");
            return false;
        }
        if(gbna.isEmpty()){
            showMessage("Please Enter the Q2 Answer 01");
            return false;
        }
        if(cna.isEmpty()){
            showMessage("Please Enter the Q3 NA");
            return false;
        }
        if(gcna.isEmpty()){
            showMessage("Please Enter the Q3 Answer 01");
            return false;
        }


        if(anb.isEmpty()){
            showMessage("Please Enter the Q1 NB");
            return false;
        }
        if(ganb.isEmpty()){
            showMessage("Please Enter the Q1 Answer 02");
            return false;
        }

        if(bnb.isEmpty()){
            showMessage("Please Enter the Q2 NB");
            return false;
        }
        if(gbnb.isEmpty()){
            showMessage("Please Enter the Q2 Answer 02");
            return false;
        }
        if(cnb.isEmpty()){
            showMessage("Please Enter the Q3 NB");
            return false;
        }
        if(gcnb.isEmpty()){
            showMessage("Please Enter the Q3 Answer 02");
            return false;
        }

        if(anc.isEmpty()){
            showMessage("Please Enter the Q1 NC");
            return false;
        }
        if(ganc.isEmpty()){
            showMessage("Please Enter the Q1 Answer 03");
            return false;
        }

        if(bnc.isEmpty()){
            showMessage("Please Enter the Q2 NC");
            return false;
        }
        if(gbnc.isEmpty()){
            showMessage("Please Enter the Q2 Answer 03");
            return false;
        }
        if(cnc.isEmpty()){
            showMessage("Please Enter the Q3 NC");
            return false;
        }
        if(gcnc.isEmpty()){
            showMessage("Please Enter the Q3 Answer 03");
            return false;
        }

        if(and.isEmpty()){
            showMessage("Please Enter the Q1 ND");
            return false;
        }
        if(gand.isEmpty()){
            showMessage("Please Enter the Q1 Answer 04");
            return false;
        }

        if(bnd.isEmpty()){
            showMessage("Please Enter the Q2 ND");
            return false;
        }
        if(gbnd.isEmpty()){
            showMessage("Please Enter the Q2 Answer 04");
            return false;
        }
        if(cnd.isEmpty()){
            showMessage("Please Enter the Q3 ND");
            return false;
        }
        if(gcnd.isEmpty()){
            showMessage("Please Enter the Q3 Answer 04");
            return false;
        }



        progressBaradd.setVisibility(View.VISIBLE);
        return true;

    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    private void addclasses( final String gid, final String cid,  final String nna, final String ana, final String gana, final String bna,final String gbna, final String cna, final String gcna,
                             final String anb, final String ganb, final String bnb,final String gbnb, final String cnb, final String gcnb,
                             final String anc, final String ganc, final String bnc,final String gbnc, final String cnc, final String gcnc,
                             final String and, final String gand, final String bnd,final String gbnd, final String cnd, final String gcnd){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.addgame_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(addgame.this,"Your Register is Successful", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(addgame.this,page.class);
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
                if (response.equals("sg6")) {

                    Toast.makeText(addgame.this,"sg6", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(addgame.this,"Please Change User Name", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(addgame.this,addgame.class);
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
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(addgame.this, "Please check your Interner Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBaradd.setVisibility(View.VISIBLE);
                Intent intent = new Intent(addgame.this,addgame.class);
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
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("gid",gid);
                params.put("cid",cid);
                params.put("nna",nna);
                params.put("ana",ana);
                params.put("gana",gana);
                params.put("bna",bna);
                params.put("gbna",gbna);
                params.put("cna",cna);
                params.put("gcna",gcna);

                params.put("anb",anb);
                params.put("ganb",ganb);
                params.put("bnb",bnb);
                params.put("gbnb",gbnb);
                params.put("cnb",cnb);
                params.put("gcnb",gcnb);


                params.put("anc",anc);
                params.put("ganc",ganc);
                params.put("bnc",bnc);
                params.put("gbnc",gbnc);
                params.put("cnc",cnc);
                params.put("gcnc",gcnc);

                params.put("and",and);
                params.put("gand",gand);
                params.put("bnd",bnd);
                params.put("gbnd",gbnd);
                params.put("cnd",cnd);
                params.put("gcnd",gcnd);

                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void backless(View view){
        Intent intent = new Intent (addgame.this,game.class);
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

}