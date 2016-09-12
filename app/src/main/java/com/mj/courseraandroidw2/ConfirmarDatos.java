package com.mj.courseraandroidw2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    TextView myName ;
    TextView myBirthDate;
    TextView myPhone;
    TextView myEmail;
    TextView myCD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        Bundle extras = getIntent().getExtras();

        myName = (TextView) findViewById(R.id.tvName);
        myName.setText(extras.get("myName").toString());
        myBirthDate = (TextView) findViewById(R.id.tvDDBD2);
        myBirthDate.setText(extras.get("myBirthDate").toString());
        myPhone = (TextView) findViewById(R.id.tvTel2);
        myPhone.setText(extras.get("myPhone").toString());
        myEmail = (TextView) findViewById(R.id.tvEm2);
        myEmail.setText(extras.get("myEmail").toString());
        myCD  = (TextView) findViewById(R.id.tvDC2);
        myCD.setText(extras.get("myCD").toString());
    }

    public void editData(View view) {
        // Do something in response to button
        myName = (TextView) findViewById(R.id.tvName);
        myBirthDate = (TextView) findViewById(R.id.tvDDBD2);
        myPhone = (TextView) findViewById(R.id.tvTel2);
        myEmail = (TextView) findViewById(R.id.tvEm2);
        myCD = (TextView) findViewById(R.id.tvDC2);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class );
        intent.putExtra("myName", myName.getText().toString());
        intent.putExtra("myBirthDate", myBirthDate.getText().toString());
        intent.putExtra("myPhone", myPhone.getText().toString());
        intent.putExtra("myEmail", myEmail.getText().toString());
        intent.putExtra("myCD", myCD.getText().toString());
        startActivity(intent);
        finish();
    }

}
