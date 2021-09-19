package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zgamec extends AppCompatActivity {

    String st,st0,st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st16,st17,st18;
    TextView tv,tv0,tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv16,tv17,tv18;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zgamec);

        tv = findViewById(R.id.ltext5);
        st = getIntent().getExtras().getString("value");
        tv.setText(st);
        tv1 = findViewById(R.id.ltext6);
        st1= getIntent().getExtras().getString("gid");
        tv1.setText(st1);
        tv2 = findViewById(R.id.ltext7);
        st2 = getIntent().getExtras().getString("SIDNAME");
        tv2.setText(st2);
        tv3 = findViewById(R.id.ltext8);
        st3 = getIntent().getExtras().getString("SID");
        tv3.setText(st3);
        tv4 = findViewById(R.id.ltext9);
        st4 = getIntent().getExtras().getString("CIDNAME");
        tv4.setText(st4);
        tv5 = findViewById(R.id.ltext10);
        st5 = getIntent().getExtras().getString("CID");
        tv5.setText(st5);
        tv6 = findViewById(R.id.ltext11);
        st6 = getIntent().getExtras().getString("CPDF");
        tv6.setText(st6);
        tv0 = findViewById(R.id.ltext12);
        st0 = getIntent().getExtras().getString("SIDPDF");
        tv0.setText(st0);
        tv16 = findViewById(R.id.ltext16);
        st16 = getIntent().getExtras().getString("qa");
        tv16.setText(st16);

        tv17 = findViewById(R.id.ltext17);
        st17 = getIntent().getExtras().getString("qb");
        tv17.setText(st17);

        tv18 = findViewById(R.id.ltext18);
        st18 = getIntent().getExtras().getString("qc");
        tv18.setText(st18);

        tv7 = findViewById(R.id.bordc);
        st7 = getIntent().getExtras().getString("qc");
        tv7.setText(st7);

        lv = findViewById(R.id.gameclist);




        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {


                tv8 = view.findViewById(R.id.tvn);
                st8 = tv8.getText().toString();

                tv9 = view.findViewById(R.id.tvan);
                st9 = tv9.getText().toString();

                tv10 = view.findViewById(R.id.tvnn);
                st10 = tv10.getText().toString();


                int leone = st8.length ();
                int letwo = st10.length ();

                if(leone == letwo){
                    MediaPlayer mysong = MediaPlayer.create (zgamec.this,R.raw.omai);
                    mysong.start ();

                    LayoutInflater inflater = getLayoutInflater ();
                    View layout = inflater.inflate (R.layout.wrong,(ViewGroup)findViewById (R.id.wrong_laypout));

                    final Toast toast = new Toast (getApplicationContext ());
                    toast.setGravity (Gravity.CENTER_HORIZONTAL,0,0);
                    toast.setDuration (Toast.LENGTH_SHORT);
                    toast.setView (layout);
                    toast.show ();

                    Handler handler = new Handler();
                    handler.postDelayed (new Runnable ( ) {
                        @Override
                        public void run() {
                            Intent intent = new Intent(zgamec.this,zgamec.class);
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
                            startActivity (intent);

                        }
                    },1500);
                }

                else {

                    MediaPlayer mysong = MediaPlayer.create (zgamec.this,R.raw.mix);
                    mysong.start ();

                    LayoutInflater inflater = getLayoutInflater ();
                    View layout = inflater.inflate (R.layout.right,(ViewGroup)findViewById (R.id.right_layout));

                    final Toast toast = new Toast (getApplicationContext ());
                    toast.setGravity (Gravity.CENTER_HORIZONTAL,0,0);
                    toast.setDuration (Toast.LENGTH_SHORT);
                    toast.setView (layout);
                    toast.show ();
                    Handler handler = new Handler();
                    handler.postDelayed (new Runnable ( ) {
                        @Override
                        public void run() {
                            Intent intent = new Intent(zgamec.this,zpage.class);
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
                            startActivity (intent);

                        }
                    },1500);

                }
            }
        });


    }

    public void gamecback(View view){
        Intent intent = new Intent (this,zgameb.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CID",st5);
        intent.putExtra("CPDF",st6);
        intent.putExtra("qa",st16);
        intent.putExtra("qb",st17);
        intent.putExtra("qc",st18);
        startActivity (intent);
    }

    public void gamecnext(View view){
        Intent intent = new Intent (this,zpage.class);
        intent.putExtra("value",st);
        intent.putExtra("gid",st1);
        intent.putExtra("SID",st3);
        intent.putExtra("SIDNAME",st2);
        intent.putExtra("SIDPDF",st0);
        intent.putExtra("CIDNAME",st4);
        intent.putExtra("CID",st5);
        intent.putExtra("CPDF",st6);
        intent.putExtra("qa",st16);
        intent.putExtra("qb",st17);
        intent.putExtra("qc",st18);
        startActivity (intent);
    }

    protected void onResume(){
        super.onResume();
        loadSession();
    }

    public void loadSession(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://eschoolslgit1.000webhostapp.com/gamea.php?gid="+st1+"&&cid="+st5+"";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        setSessions(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(com.example.myclass.zgamec.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
                        Log.d("VOLLEY", error.getMessage());


                    }
                });

        queue.add(request);
    }
    public void setSessions(JSONArray response){
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        try{
            for(int i=0;i <response.length()  ;i++){
                JSONObject obj = response.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();

                map.put("nna",obj.getString("nna"));
                map.put("nc",obj.getString("nc"));
                map.put("anc",obj.getString("anc"));

                list.add(map);
            }
            //1.layout file
            int layout= R.layout.gam;
            //2.views
            int[] views = {R.id.tvnn,R.id.tvn,R.id.tvan};
            //3.Columms
            String[]  columns = {"nna","nc","anc"};

            SimpleAdapter adapter = new SimpleAdapter(this, list, layout, columns, views);
            lv.setAdapter(adapter);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}