package com.example.elsayedfahmy.application;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class setting extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        addPreferencesFromResource(R.xml.pref_general);

        bindpreferencessummerytovalue(findPreference(getString(R.string.pref_location_key)));


    }

    private void bindpreferencessummerytovalue(Preference preference)
    {

        preference.setOnPreferenceChangeListener(this);
        onPreferenceChange(preference,
                PreferenceManager.getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(),""));
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object value)
    {
        String stringvalue= value.toString();
        if (preference instanceof ListPreference) {

            ListPreference listPreference = (ListPreference) preference;
            int prefindex = listPreference.findIndexOfValue(stringvalue);
            if (prefindex >= 0) {
                preference.setSummary(listPreference.getEntries()[prefindex]);

            }
        }
            else  {
                preference.setSummary(stringvalue);
            }

        return true;
    }
}
