package org.androidtown.exam11_1;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView nameText;
    TextView countText;
    ImageView imageView;
    String[] PhoneBook={"홍길동 \n 010-0000-0000","허준 \n 010-1111-0000","암행어사 \n 010-2222-0000"};
    int[] imageList={R.drawable.emoticon1,R.drawable.emoticon2,R.drawable.emoticon3};
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText=(TextView)findViewById(R.id.contentTextView);
        countText=(TextView)findViewById(R.id.countTextView);
        imageView=(ImageView)findViewById(R.id.imageView);

        ImageThread thread=new ImageThread();
        thread.start();

    }
    class ImageThread extends  Thread {

        int index=0;
        public  void run() {
            while (true) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        nameText.setText(PhoneBook[index]);
                        imageView.setImageResource(imageList[index]);

                    }
                });
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                index++;

                if (index > 2) {
                    index = 0;
                }


            }
        }
        }
    }

