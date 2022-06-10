package se.jbnu.final_project_3year;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       try {
           Thread.sleep(2000);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
       startActivity(new Intent(this, Survey1.class));
       finish();
    }

}
