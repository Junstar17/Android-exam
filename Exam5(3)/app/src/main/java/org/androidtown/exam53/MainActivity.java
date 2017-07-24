package org.androidtown.exam53;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    SimpleDateFormat today;
    Button button;
    String str;
    long now=System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button)findViewById(R.id.button);
        Date date=new Date(now);
        today= new SimpleDateFormat("yyyy년 MM월 dd일");
        str=today.format(date);
        button.setText(str);


    }

    public void onButton1Clicked(View v){
        //DateFormat dateInstance = SimpleDateFormat.getDateInstance();
        DatePickerDialog datePick = new DatePickerDialog(this,this,2017,07,05);
        datePick.show();

    }

    public void onButton2Clicked(View v){
        Toast.makeText(getApplicationContext(),"저장되었습니다.",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Date setdate=new Date(year,month,dayOfMonth);
        str=today.format(setdate);
        button.setText(str);
    }
}
