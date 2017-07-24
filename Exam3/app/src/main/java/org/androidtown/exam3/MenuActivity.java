package org.androidtown.exam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kjy on 2017-06-18.
 */

public class MenuActivity extends Activity {


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onButton2Clicked(View v){
        Intent resultIntent=new Intent();
        Button resultbutton1=(Button) findViewById(R.id.button2);
        resultIntent.putExtra("result","고객관리 버튼을 누르셨습니다." );
        setResult(RESULT_OK,resultIntent);
        finish();
    }
    public void onButton3Clicked(View v){
        Intent resultIntent=new Intent();
        Button resultbutton2=(Button) findViewById(R.id.button3);
        resultIntent.putExtra("result","매출관리 버튼을 누르셨습니다." );
        setResult(RESULT_OK,resultIntent);
        finish();
    }

    public void onButton4Clicked(View v){
        Intent resultIntent=new Intent();
        Button resultbutton3=(Button) findViewById(R.id.button4);
        resultIntent.putExtra("result","상품관리 버튼을 누르셨습니다." );
        setResult(RESULT_OK,resultIntent);
        finish();
    }


}
