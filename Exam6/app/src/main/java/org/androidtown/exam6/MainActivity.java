package org.androidtown.exam6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Animation translateDownAnim;
    Animation translateUpAnim;
    Button button;
    LinearLayout slidingPanel;
    boolean isPageOpen=false;
    WebView webView;
    EditText editText;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);

        webView = (WebView)findViewById(R.id.webView);
        WebSettings settings=webView.getSettings();
        settings.setJavaScriptEnabled(true);

        translateDownAnim= AnimationUtils.loadAnimation(this,R.anim.translate_down);
        translateUpAnim= AnimationUtils.loadAnimation(this,R.anim.translate_up);

        translateDownAnim.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setText("닫기");
                isPageOpen=true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        button = (Button) findViewById(R.id.button);
        slidingPanel=(LinearLayout) findViewById(R.id.slidingPanel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPageOpen){
                    slidingPanel.setVisibility(View.VISIBLE);
                    slidingPanel.startAnimation(translateDownAnim);
                    button.startAnimation(translateDownAnim);
                }
                else if(isPageOpen){
                    slidingPanel.startAnimation(translateUpAnim);
                    button.setText("열기");
                    slidingPanel.setVisibility(View.GONE);
                    isPageOpen=false;
                }
            }
        });

    }
    public void onButton1Clicked(View v){
        str=editText.getText().toString(); // toString 을해야 안드로이드 문자열을 자바 문자열로
        Toast.makeText(getApplication(),""+str,Toast.LENGTH_LONG).show();
        webView.setWebViewClient(new WebViewClient()); // 새로운 웹창을 안띄우고 웹뷰이용
        webView.loadUrl(str);
    }
}
