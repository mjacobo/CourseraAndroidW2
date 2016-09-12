package com.mj.courseraandroidw2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    TextView myName ;
    TextView myBirthDate;
    TextView myPhone;
    TextView myEmail;
    TextView myCD;
    Calendar calendar;
    int year, month, day;
    String[] tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();


        if (extras != null) {
            myName = (TextView) findViewById(R.id.field_name);
            myName.setText(extras.get("myName").toString());
            myBirthDate = (TextView) findViewById(R.id.edtBirthDate);
            myBirthDate.setText(extras.get("myBirthDate").toString());
            myPhone = (TextView) findViewById(R.id.field_phone);
            myPhone.setText(extras.get("myPhone").toString());
            myEmail = (TextView) findViewById(R.id.field_email);
            myEmail.setText(extras.get("myEmail").toString());
            myCD = (TextView) findViewById(R.id.field_Description);
            myCD.setText(extras.get("myCD").toString());
            tmp = new String(extras.get("myBirthDate").toString()).split("/");
            calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(tmp[2]), Integer.parseInt(tmp[1]) - 1, Integer.parseInt(tmp[0]));
        } else {
            calendar = Calendar.getInstance();
        }
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            showDate(year, month + 1, day);
    }

    private void showDate(int year, int month, int day) {
        myBirthDate = (TextView) findViewById(R.id.edtBirthDate);
        myBirthDate.setText(new StringBuilder().append(day).append("/").append(month).append("/").append(year));
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };


    public void confirmData(View view) {
        // Do something in response to button
        myName = (TextView) findViewById(R.id.field_name);
        myBirthDate = (TextView) findViewById(R.id.edtBirthDate);
        myPhone = (TextView) findViewById(R.id.field_phone);
        myEmail = (TextView) findViewById(R.id.field_email);
        myCD = (TextView) findViewById(R.id.field_Description);

        Intent intent = new Intent(getApplicationContext(), ConfirmarDatos.class );
        intent.putExtra("myName", myName.getText().toString());
        intent.putExtra("myBirthDate", myBirthDate.getText().toString());
        intent.putExtra("myPhone", myPhone.getText().toString());
        intent.putExtra("myEmail", myEmail.getText().toString());
        intent.putExtra("myCD", myCD.getText().toString());
        startActivity(intent);
        finish();
    }

}
