package com.example.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class login extends AppCompatActivity {

    EditText etname, etpassword;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etname = findViewById(R.id.lusername);
        etpassword = findViewById(R.id.lpassword);
        progressBar = findViewById(R.id.progressBarlr);

        progressBar.setVisibility(View.INVISIBLE);

    }

    public void llog(View view) {

        String uname = etname.getText().toString();
        String password =etpassword.getText().toString();

        if (isValied(uname, password)){
            loginl(uname,password);
        }

    }



    private boolean isValied(String uname, String password) {

        if (uname.isEmpty()){
            showMessage("UserName is empty");
            etname.setText(null);
            return false;
        }
        if(password.isEmpty()){

            showMessage("Password is Empty");
            etpassword.setText(null);
            return false;
        }

        progressBar.setVisibility(View.VISIBLE);
        return true;

    }



    private void loginl(final String uname, final String password) {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.login_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    progressBar.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(login.this,zmenus.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(login.this,"Invalid User Name or Password", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(login.this,login.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(login.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(login.this,login.class);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("uname", uname);
                params.put("password",password);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void showMessage(String msg) { Toast.makeText(this,msg , Toast.LENGTH_SHORT).show(); }

}