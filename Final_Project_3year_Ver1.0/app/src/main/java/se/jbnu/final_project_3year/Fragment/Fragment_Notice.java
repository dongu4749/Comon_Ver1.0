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
 * Use the {@link Fragment_Notice#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Notice extends PreferenceFragmentCompat {

    SharedPreferences prefs;

    public static Fragment_Notice newInstance() {
        return new Fragment_Notice();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.notices_preference);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

        Preference buttonVersion = (Preference) findPreference("Version");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("현재 버전은 1.0 입니다.");

        AlertDialog alertDialog = builder.create();

        buttonVersion.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
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