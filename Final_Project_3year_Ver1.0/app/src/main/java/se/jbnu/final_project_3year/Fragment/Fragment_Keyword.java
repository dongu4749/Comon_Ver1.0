package se.jbnu.final_project_3year.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import se.jbnu.final_project_3year.HomeActivity;
import se.jbnu.final_project_3year.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Keyword#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Keyword extends PreferenceFragmentCompat {
    SharedPreferences prefs;

    public static Fragment_Keyword newInstance() {
        return new Fragment_Keyword();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.keyword_preference);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

        Preference buttonInterface = (Preference) findPreference("Interface");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("극단적으로 동일한 목적 하에 동일한 기능을 수행하게끔 강제하는 것이 바로 인터페이스의 역할이자 개념이다. 조금 더 자세히 말하면, 자바의 다형성을 극대화하여 개발코드 수정을 줄이고 프로그램 유지보수성을 높이기 위해 인터페이스를 사용한다. ");

        AlertDialog alertDialog = builder.create();

        buttonInterface.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
                alertDialog.show();
                return true;
            }
        });
    }

    SharedPreferences.OnSharedPreferenceChangeListener prefListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    // key값에 해당하는 명령 넣기
                }
            };

    public void onBackPressed() { //뒤로가기 했을 때
        Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        return ;
    }

}