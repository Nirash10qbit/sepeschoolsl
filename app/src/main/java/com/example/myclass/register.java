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

public class register extends AppCompatActivity {

    EditText etname,etemail,etpassword;
    Button etadd;
    ProgressBar progressBaradd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBaradd = findViewById(R.id.progressBarr);
        progressBaradd.setVisibility(View.INVISIBLE);

        etadd = findViewById(R.id.register);

        etname = findViewById(R.id.rname);
        etemail = findViewById(R.id.remail);
        etpassword = findViewById(R.id.rpassword);

        etadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();
                String is_admin = "0";


                if(isValied(name,email,password)){
                    addclasses(name,email,password,is_admin);
                }
            }


        });

    }
    private boolean isValied(String name, String email, String password) {

        if(name.isEmpty()){
            showMessage("Please Enter User Name ");
            return false;
        }
        if(name.length() > 20){
            showMessage("User Name Is Too Long ");
            return false;
        }
        if(email.isEmpty()){
            showMessage("Please Enter the Email ");
            return false;
        }
        if(password.isEmpty()){
            showMessage("Please Enter the Password ");
            return false;
        }
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern) && name.length() > 0 && email.length() > 0 && password.length() > 0){
            progressBaradd.setVisibility(View.VISIBLE);
            return true;
        }
        showMessage("Please Enter valid Email");
        return false;
    }

    private void showMessage(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    private void addclasses( final String name, final String email, final  String password, final String is_admin ){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Endspoint.register_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response.equals("success")) {

                    Toast.makeText(register.this," Registration Successfully", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(register.this,login.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(register.this,"User Name or Email Already Exists", Toast.LENGTH_SHORT).show();
                    progressBaradd.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(register.this,register.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(register.this, "Please check your Internet Connection",Toast.LENGTH_SHORT).show();
                Log.d("VOLLEY", error.getMessage());

                Intent intent = new Intent(register.this,register.class);
                startActivity(intent);

            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",name);
                params.put("email", email);
                params.put("password",password);
                params.put("is_admin",is_admin);
                return  params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

//    public void backsub(View view){
//        Intent intent = new Intent (register.this,login.class);
//        startActivity(intent);
//    }

}