package org.androidtown.exam4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by kjy on 2017-06-18.
 */

public class MenuActivity extends AppCompatActivity {
    public static final int TAG1 =1002;
    public static final int TAG2 =1003;
    public static final int TAG3 =1004;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onButton2Clicked(View v){
        Intent intent1=new Intent(getApplicationContext(),Menu1.class);
        startActivityForResult(intent1,TAG1);
    }
    public void onButton3Clicked(View v){
        Intent intent2=new Intent(getApplicationContext(),Menu2.class);
        startActivityForResult(intent2,TAG2);
    }

    public void onButton4Clicked(View v){
        Intent intent3=new Intent(getApplicationContext(),Menu3.class);
        startActivityForResult(intent3,TAG3);
    }

    public void onButton5Clicked(View v){

        Intent resultIntent1=new Intent();
        Button resultbutton5=(Button) findViewById(R.id.button5);
        resultIntent1.putExtra("result","메뉴화면에서 뒤로왔습니다." );
        setResult(RESULT_OK,resultIntent1);
        finish();
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);

        if(requestCode==TAG1){
            Toast.makeText(getBaseContext(),"onActivityResult메소드가 호출됨.요청코드 : "+requestCode+"결과 코드: "+resultCode,Toast.LENGTH_LONG).show();
            if(resultCode==RESULT_OK){
                String result=intent.getExtras().getString("result");
                Toast.makeText(getBaseContext(),""+result,Toast.LENGTH_LONG).show();
            }

        }
        else if(requestCode==TAG2){
            Toast.makeText(getBaseContext(),"onActivityResult메소드가 호출됨.요청코드 : "+requestCode+"결과 코드: "+resultCode,Toast.LENGTH_LONG).show();
            if(resultCode==RESULT_OK){
                String result=intent.getExtras().getString("result");
                Toast.makeText(getBaseContext(),""+result,Toast.LENGTH_LONG).show();
            }

        }
        else if(requestCode==TAG3){
            Toast.makeText(getBaseContext(),"onActivityResult메소드가 호출됨.요청코드 : "+requestCode+"결과 코드: "+resultCode,Toast.LENGTH_LONG).show();
            if(resultCode==RESULT_OK){
                String result=intent.getExtras().getString("result");
                Toast.makeText(getBaseContext(),""+result,Toast.LENGTH_LONG).show();
            }

        }

    }


}
