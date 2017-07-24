package org.androidtown.exam8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 그리드뷰를 이용해 월별 캘린더를 만드는 방법에 대해 알 수 있습니다.
 *
 * @author Mike
 */
public class MainActivity extends AppCompatActivity {

    public static final int TAG =1001;

    //대화상자의 입력값 전달 받는 변수들
    String resultTitle;
    String resultHour;
    String resultMin;

    int curDay;
    /**
     * 월별 캘린더 뷰 객체
     */
    GridView monthView;

    /**
     * 월별 캘린더 어댑터
     */
    MonthAdapter monthViewAdapter;
    MonthItemView curItemView;

    /**
     * 월을 표시하는 텍스트뷰
     */
    TextView monthText;

    /**
     * 현재 연도
     */
    int curYear;

    /**
     * 현재 월
     */
    int curMonth;

    //입력값들을 저장하는 배열 선언
    ArrayList<String> dateTitleArray;
    ArrayList<String> dateHourArray;
    ArrayList<String> dateMinArray;

    //어댑터 인스턴스를 저장할 어댑터 배열
    ScheduleAdapter adapterArray[];

    GridView gridView;




    //메뉴옵션 만들기
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    //메뉴 클릭시 대화상자 띄우기
    public boolean onOptionsItemSelected(MenuItem item){
        int curId=item.getItemId();
        if(curId==R.id.menu_input)
        {
            Intent intent=new Intent(getApplicationContext(),Schedule.class);
            startActivityForResult(intent,TAG);
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    *Result 값 데이터 전달받기 이제 이 값을 리스트뷰로 옮기기위한 작업필요 */
    protected void onActivityResult(int requestCode,int resultCode,Intent intent){
        super.onActivityResult(requestCode,resultCode,intent);

        if(requestCode==TAG){
           if(resultCode==RESULT_OK){


               resultTitle=intent.getExtras().getString("resultTitle");
               resultHour=intent.getExtras().getString("resultHour");
               resultMin=intent.getExtras().getString("resultMin");

               dateTitleArray.set(curDay,resultTitle);
               dateHourArray.set(curDay,resultHour);
               dateMinArray.set(curDay,resultMin);
               //listView.setAdapter(adapterArray[curDay]);

               //해당 날짜에 어댑터가 만들어져있지않다면(일정이없다면) 어댑터생성
               if(adapterArray[curDay]==null) {
                   adapter = new ScheduleAdapter();

               }
               //해당 날짜에 어댑터가 만들어져있다면 기존 어댑터 불러와서 사용
                else{
                   adapter=adapterArray[curDay];
               }

               //아이템에 데이터삽입, 각각의 아이템 완성 *위치중요!! 갱신이 필요한 코드들은 갱신포인트지점 잘 보고 짜기
               adapter.addItem(new ScheduleItem(dateTitleArray.get(curDay), dateHourArray.get(curDay), dateMinArray.get(curDay)));
               adapterArray[curDay] = adapter;      //어댑터배열에 어댑터 저장(어댑터는 날짜별로고유함)

               //색채우기
               monthViewAdapter.setSelectedPosition(curDay+monthViewAdapter.firstDay-1);
               //색채운후 달력 다시 갱신
               monthView.setAdapter(monthViewAdapter);
                //일정 추가후 바로 리스트뷰 띄우기

               listView.setAdapter(adapterArray[curDay]);



            }

        }

    }


    //어댑터 정의
    class ScheduleAdapter extends BaseAdapter{

        //배열리스트 자료형이 ScheduleItme 이고 배열의 이름이 items인
        ArrayList<ScheduleItem> items = new ArrayList<ScheduleItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ScheduleItem item){ items.add(item);}

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            ScheduleItemView itemView=new ScheduleItemView(getApplicationContext());

            ScheduleItem curItem=items.get(i);

            itemView.setTime(""+curItem.getHour()+" : "+curItem.getMin() );
            itemView.setTitle(curItem.getTitle());
            //Toast.makeText(getApplicationContext(),"결과 확인 : "+curItem.getTitle(),Toast.LENGTH_LONG).show();
            return itemView;

        }
    }

    ListView listView;
    ScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 월별 캘린더 뷰 객체 참조
        monthView = (GridView) findViewById(R.id.monthView);
        monthViewAdapter = new MonthAdapter(this);
        curItemView=new MonthItemView(this);
        monthView.setAdapter(monthViewAdapter);
        gridView=(GridView) findViewById(R.id.monthView);

        //리스트 뷰 객체 생성후 접합
        listView=(ListView)findViewById(R.id.listView);

        //어댑터 배열 초기화
        adapterArray=new ScheduleAdapter[100];

        //배열 초기화
        dateTitleArray=new ArrayList<String>(100);
        dateHourArray=new ArrayList<String>(100);
        dateMinArray=new ArrayList<String>(100);
        for(int i=0; i<100; i++) {
            dateTitleArray.add(null);
            dateHourArray.add(null);
            dateMinArray.add(null);
        }
        // 리스너 설정 & 수정파트
        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // 현재 선택한 일자 정보 표시
                MonthItem curItem = (MonthItem) monthViewAdapter.getItem(position);
                int day = curItem.getDay();
                Log.d("MainActivity", "Selected : " + day);


                curDay=day; //클릭된 일자 정보 저장

                Toast.makeText(getApplicationContext(),"날짜가 클릭되었습니다 : "+curDay,Toast.LENGTH_LONG).show();
                //리스트뷰 화면에 띄우기
                listView.setAdapter(adapterArray[curDay]);

            }
        });
        monthText = (TextView) findViewById(R.id.monthText);
        setMonthText();

        // 이전 월로 넘어가는 이벤트 처리
        Button monthPrevious = (Button) findViewById(R.id.monthPrevious);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setPreviousMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

        // 다음 월로 넘어가는 이벤트 처리
        Button monthNext = (Button) findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monthViewAdapter.setNextMonth();
                monthViewAdapter.notifyDataSetChanged();

                setMonthText();
            }
        });

    }



    /**
     * 월 표시 텍스트 설정
     */
    private void setMonthText() {
        curYear = monthViewAdapter.getCurYear();
        curMonth = monthViewAdapter.getCurMonth();

        monthText.setText(curYear + "년 " + (curMonth + 1) + "월");
    }



}
