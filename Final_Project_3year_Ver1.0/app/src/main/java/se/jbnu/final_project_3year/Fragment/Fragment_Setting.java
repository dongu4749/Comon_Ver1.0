package se.jbnu.final_project_3year.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import se.jbnu.final_project_3year.HomeActivity;
import se.jbnu.final_project_3year.LoginActivity;
import se.jbnu.final_project_3year.R;
import se.jbnu.final_project_3year.TutorialActivity;


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
                    // key?????? ???????????? ?????? ??????

                }
            };

    public void onBackPressed() { //???????????? ?????? ???
        Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        return ;
    }


}
