package se.jbnu.final_project_3year.Quiz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import se.jbnu.final_project_3year.Fragment.Fragment_Progress;
import se.jbnu.final_project_3year.R;

public class Quiz_Short_Answer_Activity2 extends AppCompatActivity {

    private boolean Quiz_Check=false;
    boolean short_check2 = false;
    Toolbar toolbar;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_short_answer2);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Dialog dialogcorrect = new Dialog(this);
        Dialog dialogwrong = new Dialog(this);
        dialogcorrect.setContentView(R.layout.activity_dialog_correct);
        dialogwrong.setContentView(R.layout.activity_dialog_wrong);

        EditText quiz_short2 = (EditText) findViewById(R.id.edittext_JavaQuiz_short_answer2);
        Button imageButtonQuizCheck2 = (Button) findViewById(R.id.buttonCheckQuiz_short_answer2);

        Button imageButtonSubmit = (Button) dialogcorrect.findViewById(R.id.buttonSubmit);
        Button imageButtonSubmit2 = (Button) dialogwrong.findViewById(R.id.buttonSubmit2);

        imageButtonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_List_Activity.class);
                startActivity(intent);
            }
        });
        imageButtonSubmit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_Activity2.class);
                startActivity(intent);
            }
        });

        imageButtonQuizCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = quiz_short2.getText().toString().trim();
                Quiz_Check = (answer.equals("????????????") || answer.equals("Algorithm") || answer.equals("algorithm"));

                if(Quiz_Check){
                    if(checkFirst(Fragment_Progress.check_SUB[1])){
                        // Fragment_Progress.progress_Short_Value += 10;
                        saveKeyValue(Fragment_Progress.check_SUB[1], "true");

                    }
                    short_check2 = true;
                    dialogcorrect.show();
                    dialogcorrect.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                } else{
                    dialogwrong.show();
                    dialogwrong.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
            }
        });


    }


    public void saveKeyValue(String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences(key, MODE_PRIVATE);    // test ????????? ???????????? ??????
        SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences??? ????????? editor??? ??????
        editor.putString(key,value); // key,value ???????????? ??????
        editor.commit();    //?????? ??????. ????????? ?????? ????????? ??????.
    }
    public String getValue(String key){
        SharedPreferences sharedPreferences= getSharedPreferences(key, Context.MODE_PRIVATE);    // test ????????? ???????????? ??????, ?????? test key?????? ????????? ?????? ?????? ?????????.
        String value = sharedPreferences.getString(key,"false");
        return value;
    }
    public boolean checkFirst(String str){
        return getValue(str).equals("false");
    }
}