package se.jbnu.final_project_3year;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Quiz_Short_Answer_List_Activity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_short_answer_list);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button imageButtonQuizShortAnswer1= (Button) findViewById(R.id.buttonQuiz_ShortAnswer1);
        Button imageButtonQuizShortAnswer2 = (Button) findViewById(R.id.buttonQuiz_ShortAnswer2);
        Button imageButtonQuizShortAnswer3 = (Button) findViewById(R.id.buttonQuiz_ShortAnswer3);
        Button imageButtonQuizGoHome= (Button) findViewById(R.id.GoHome);
        if(checkFirst(Fragment_Progress.check_SUB[0]))
        {
            imageButtonQuizShortAnswer1.setSelected(false);
            imageButtonQuizShortAnswer2.setSelected(false);
            imageButtonQuizShortAnswer3.setSelected(false);
            imageButtonQuizShortAnswer1.setEnabled(true);
            imageButtonQuizShortAnswer2.setEnabled(false);
            imageButtonQuizShortAnswer3.setEnabled(false);

        }
        if(!checkFirst(Fragment_Progress.check_SUB[0]) && checkFirst(Fragment_Progress.check_SUB[1]) )
        {
            imageButtonQuizShortAnswer1.setSelected(true);
            imageButtonQuizShortAnswer2.setSelected(false);
            imageButtonQuizShortAnswer3.setSelected(false);
            imageButtonQuizShortAnswer1.setEnabled(true);
            imageButtonQuizShortAnswer2.setEnabled(true);
            imageButtonQuizShortAnswer3.setEnabled(false);

        }
        if(!checkFirst(Fragment_Progress.check_SUB[0]) && !checkFirst(Fragment_Progress.check_SUB[1]) && checkFirst(Fragment_Progress.check_SUB[1]))
        {
            imageButtonQuizShortAnswer1.setSelected(true);
            imageButtonQuizShortAnswer2.setSelected(true);
            imageButtonQuizShortAnswer3.setSelected(false);
            imageButtonQuizShortAnswer1.setEnabled(true);
            imageButtonQuizShortAnswer2.setEnabled(true);
            imageButtonQuizShortAnswer3.setEnabled(true);

        }
        if(!checkFirst(Fragment_Progress.check_SUB[0]) && !checkFirst(Fragment_Progress.check_SUB[1]) && checkFirst(Fragment_Progress.check_SUB[1]))
        {
            imageButtonQuizShortAnswer1.setSelected(true);
            imageButtonQuizShortAnswer2.setSelected(true);
            imageButtonQuizShortAnswer3.setSelected(true);
            imageButtonQuizShortAnswer1.setEnabled(true);
            imageButtonQuizShortAnswer2.setEnabled(true);
            imageButtonQuizShortAnswer3.setEnabled(true);

        }
        imageButtonQuizGoHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        imageButtonQuizShortAnswer1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_Activity.class);
                startActivity(intent);
            }
        });
        imageButtonQuizShortAnswer2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_Activity2.class);
                startActivity(intent);
            }
        });
        imageButtonQuizShortAnswer3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_Activity3.class);
                startActivity(intent);
            }
        });
    }
    public void saveKeyValue(String key, String value){
        //  SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences sharedPreferences = this.getSharedPreferences(key, MODE_PRIVATE);    // test 이름의 기본모드 설정
        SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언
        editor.putString(key,value); // key,value 형식으로 저장
        editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
    }
    public String getValue(String key){
        SharedPreferences sharedPreferences = this.getSharedPreferences(key, MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        String str_Block = sharedPreferences.getString(key,"false");
        return str_Block;
    }
    public boolean checkFirst(String str){
        Log.d("CHECK_FIRST_STR", str);
        Log.d("CHECK_FIRST",getValue(str));
        Log.d("CHECK_FIRST_RESULT", Boolean.toString(getValue(str).equals("false")));

        return getValue(str).equals("false");
    }

}