package se.jbnu.final_project_3year;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;


public class Fragment_Setting extends PreferenceFragmentCompat {

    SharedPreferences prefs;

    public static Fragment_Setting newInstance() {
        return new Fragment_Setting();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_preference);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

        Preference buttonLogout = (Preference) findPreference("Logout");
        Preference buttonAccountDelete = (Preference) findPreference("AccountDelete");
        Preference buttonTutorial = (Preference) findPreference("Tutorial");

        buttonLogout.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
                LoginActivity.SignOut();
                Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                return true;
            }
        });
        buttonAccountDelete.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
                LoginActivity loginActivity = new LoginActivity();
                getActivity().finishAffinity();
                loginActivity.AccountDelete();
                System.runFinalization();
                System.exit(0);
                return true;
            }
        });
        buttonTutorial.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                //open browser or intent here
                LoginActivity.SignOut();
                Intent intent = new Intent(getActivity().getApplicationContext(), TutorialActivity.class);
                startActivity(intent);
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
