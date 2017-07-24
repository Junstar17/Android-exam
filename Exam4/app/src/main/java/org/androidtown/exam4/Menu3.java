package org.androidtown.exam4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kjy on 2017-06-18.
 */

public class Menu3 extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu3);
    }

    public void onButton8Clicked(View v){
        Intent resultIntent=new Intent();
        Button resultbutton8=(Button) findViewById(R.id.button8);
        resultIntent.putExtra("result","상품관리 버튼을 누르셨습니다." );
        setResult(RESULT_OK,resultIntent);
        finish();
    }
}
