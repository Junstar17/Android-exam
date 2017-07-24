package org.androidtown.exam3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int TAG =1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent=new Intent(getApplicationContext(),MenuActivity.class);
        startActivityForResult(intent,TAG);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);

        if(requestCode==TAG){
            Toast.makeText(getBaseContext(),"onActivityResult메소드가 호출됨.요청코드 : "+requestCode+"결과 코드: "+resultCode,Toast.LENGTH_LONG).show();
        if(resultCode==RESULT_OK){
            String result=intent.getExtras().getString("result");
            Toast.makeText(getBaseContext(),""+result,Toast.LENGTH_LONG).show();
        }

        }

    }
}
