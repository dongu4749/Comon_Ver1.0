package se.jbnu.final_project_3year.Quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import se.jbnu.final_project_3year.Fragment.Fragment_Progress;
import se.jbnu.final_project_3year.HomeActivity;
import se.jbnu.final_project_3year.R;

public class Quiz_Block_Coding_List_Activity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_block_coding_list);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Button imageButtonQuizBlock_Coding1= (Button) findViewById(R.id.buttonQuiz_Block_Coding1);
        Button imageButtonQuizGoHome= (Button) findViewById(R.id.GoHome);
        if(checkFirst(Fragment_Progress.check_MUL[0]))
        {
            imageButtonQuizBlock_Coding1.setSelected(false);
            imageButtonQuizBlock_Coding1.setEnabled(true);
        }
        if(!checkFirst(Fragment_Progress.check_BC[0]))
        {
            imageButtonQuizBlock_Coding1.setSelected(true);
            imageButtonQuizBlock_Coding1.setEnabled(true);
        }
        imageButtonQuizBlock_Coding1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Block_Coding_Activity.class);
                startActivity(intent);
            }
        });

        imageButtonQuizGoHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
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