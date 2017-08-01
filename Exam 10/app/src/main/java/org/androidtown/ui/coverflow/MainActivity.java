package org.androidtown.ui.coverflow;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileInputStream;

/**
 * 갤러리를 변형하여 커버플로우를 만드는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 간격
     */
    public ImageView[] mImages;
    public static int spacing = -45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 커버플로우에 어댑터 설정
        CoverFlow coverFlow = (CoverFlow) findViewById(R.id.coverflow);
        final ImageAdapter coverImageAdapter = new ImageAdapter(this);
        coverFlow.setAdapter(coverImageAdapter);

        // 커버플로우에 속성 설정
        coverFlow.setSpacing(spacing);
        coverFlow.setSelection(2, true);
        coverFlow.setAnimationDuration(3000);
        final LinearLayout layout=(LinearLayout)findViewById(R.id.layout);
        final ImageView imageView1=(ImageView)findViewById(R.id.imageView);
        final TextView textView=(TextView)findViewById(R.id.textView);
        final String Book1 ="이름 : Book1 \n출판사: 타운출판사 \n출판일 : 2010.07.02 \n저자 : 홍길동";
        final String Book2 ="이름 : Book2 \n출판사: 타운출판사 \n출판일 : 2010.07.02 \n저자 : 홍길동";
        final String Book3 ="이름 : Book3 \n출판사: 타운출판사 \n출판일 : 2010.07.02 \n저자 : 홍길동";
        final String Book4 ="이름 : Book4 \n출판사: 타운출판사 \n출판일 : 2010.07.02 \n저자 : 홍길동";
        final String Book5 ="이름 : Book5 \n출판사: 타운출판사 \n출판일 : 2010.07.02 \n저자 : 홍길동";


        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    imageView1.setImageResource(R.drawable.item01);
                    textView.setText(Book1);

                }else if (position==1 ){
                    imageView1.setImageResource(R.drawable.item02);
                    textView.setText(Book2);
                }
                else if (position==2 ){
                    imageView1.setImageResource(R.drawable.item03);
                    textView.setText(Book3);
                }
                else if (position==3 ){
                    imageView1.setImageResource(R.drawable.item04);
                    textView.setText(Book4);
                }
                else if (position==4 ){
                    imageView1.setImageResource(R.drawable.item05);
                    textView.setText(Book5);
                }
            }
        });


    }


    /**
     * 어댑터 클래스 정의
     */
    public class ImageAdapter extends BaseAdapter {

        int itemBackground;
        private Context mContext;
        private FileInputStream outstream;

        private Integer[] mImageIds = { R.drawable.item01, R.drawable.item02,
                R.drawable.item03, R.drawable.item04, R.drawable.item05 };





        public ImageAdapter(Context c) {
            mContext = c;
            mImages = new ImageView[mImageIds.length];  //길이가 5인 ImageView 인스턴스 생성
        }




        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {



            ImageView img = new ImageView(mContext); //또다른 이미지 뷰 생성

            img.setImageResource(mImageIds[position]);  //하나의 이미지 뷰에 하나의 이미지 주소값 저장
            img.setLayoutParams(new CoverFlow.LayoutParams(500, 280));
            img.setScaleType(ImageView.ScaleType.CENTER_INSIDE); //스케일 타입 지정

            BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
            drawable.setAntiAlias(true); //살짝 대각으로

            return img;
        }

        public float getScale(boolean focused, int offset) {
            return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
        }

    }

}
