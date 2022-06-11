package se.jbnu.final_project_3year.Quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import se.jbnu.final_project_3year.Fragment.Fragment_Progress;
import se.jbnu.final_project_3year.HomeActivity;
import se.jbnu.final_project_3year.R;

public class Quiz_Multiple_choice_List_Activity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_multiple_choice_list);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button imageButtonQuizMultiple1= (Button) findViewById(R.id.buttonQuiz_Multiple1);
        Button imageButtonQuizMultiple2 = (Button) findViewById(R.id.buttonQuiz_Multiple2);
        Button imageButtonQuizMultiple3 = (Button) findViewById(R.id.buttonQuiz_Multiple3);
        Button imageButtonQuizGoHome= (Button) findViewById(R.id.GoHome);
        imageButtonQuizGoHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        if(checkFirst(Fragment_Progress.check_MUL[0]))
        {
            imageButtonQuizMultiple1.setSelected(false);
            imageButtonQuizMultiple2.setSelected(false);
            imageButtonQuizMultiple3.setSelected(false);
            imageButtonQuizMultiple1.setEnabled(true);
            imageButtonQuizMultiple2.setEnabled(false);
            imageButtonQuizMultiple3.setEnabled(false);

        }
        if(!checkFirst(Fragment_Progress.check_MUL[0]) && checkFirst(Fragment_Progress.check_MUL[1]) )
        {
            imageButtonQuizMultiple1.setSelected(true);
            imageButtonQuizMultiple2.setSelected(false);
            imageButtonQuizMultiple3.setSelected(false);
            imageButtonQuizMultiple1.setEnabled(true);
            imageButtonQuizMultiple2.setEnabled(true);
            imageButtonQuizMultiple3.setEnabled(false);

        }
        if(!checkFirst(Fragment_Progress.check_MUL[0]) && !checkFirst(Fragment_Progress.check_MUL[1]) && checkFirst(Fragment_Progress.check_MUL[1]))
        {
            imageButtonQuizMultiple1.setSelected(true);
            imageButtonQuizMultiple2.setSelected(true);
            imageButtonQuizMultiple3.setSelected(false);
            imageButtonQuizMultiple1.setEnabled(true);
            imageButtonQuizMultiple2.setEnabled(true);
            imageButtonQuizMultiple3.setEnabled(true);

        }
        if(!checkFirst(Fragment_Progress.check_MUL[0]) && !checkFirst(Fragment_Progress.check_MUL[1]) && !checkFirst(Fragment_Progress.check_MUL[1]))
        {
            imageButtonQuizMultiple1.setSelected(true);
            imageButtonQuizMultiple2.setSelected(true);
            imageButtonQuizMultiple3.setSelected(true);
            imageButtonQuizMultiple1.setEnabled(true);
            imageButtonQuizMultiple2.setEnabled(true);
            imageButtonQuizMultiple3.setEnabled(true);

        }
        imageButtonQuizMultiple1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity.class);
                startActivity(intent);
            }
        });
        imageButtonQuizMultiple2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity2.class);
                startActivity(intent);
            }
        });
        imageButtonQuizMultiple3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity3.class);
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