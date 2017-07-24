package org.androidtown.exam8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by kjy on 2017-07-19.
 */

public class Schedule extends Activity {

    EditText editText;
    EditText editText2;
    EditText editText3;

    //대화상자에서 각각의 빈칸의 데이터를 접근하기위해 에딧텍스트 객체생성
    public void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_schedule);

        editText=(EditText) findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);
        editText3=(EditText) findViewById(R.id.editText3);


    }
    // 저장 버튼 클릭시 resultIntent를 이용하여 결과값을 메인 엑티비티로 전달
    public void onButton1Clicked(View v){

        Intent resultIntent=new Intent();
        resultIntent.putExtra("resultTitle",""+editText.getText());
        resultIntent.putExtra("resultHour",""+editText2.getText());
        resultIntent.putExtra("resultMin",""+editText3.getText());
        setResult(RESULT_OK,resultIntent);
        finish();
    }

    //닫기버튼
    public void onButton2Clicked(View v){
        finish();;
    }


}
