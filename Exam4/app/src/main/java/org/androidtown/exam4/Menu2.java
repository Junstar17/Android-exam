package org.androidtown.exam4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kjy on 2017-06-18.
 */

public class Menu2 extends Activity{



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);
    }

    public void onButton7Clicked(View v){
        Intent resultIntent=new Intent();
        Button resultbutton7=(Button) findViewById(R.id.button7);
        resultIntent.putExtra("result","매출관리 버튼을 누르셨습니다." );
        setResult(RESULT_OK,resultIntent);
        finish();
    }
}
