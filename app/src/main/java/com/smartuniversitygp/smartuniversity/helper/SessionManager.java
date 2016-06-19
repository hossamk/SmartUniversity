package com.smartuniversitygp.smartuniversity.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.content.SharedPreferences.Editor;

/**
 * Created by hossam on 6/19/16 .
 */


public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "SmartUniversityLogin";

    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_TOKEN = "loginToken";
    private static final String KEY_FIRST = "loginFirstName";
    private static final String KEY_LAST = "loginLastName";
    private static final String KEY_EMAIL = "loginEmail";
    private static final String KEY_TYPE = "loginType";



    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(boolean isLoggedIn, User user) {
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.putString(KEY_TOKEN, user.getToken());
        editor.putString(KEY_FIRST, user.getFirstName());
        editor.putString(KEY_LAST, user.getLastName());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_TYPE, user.getType());

        // commit changes
        editor.commit();
    }

    public void logout() {
        editor.remove(KEY_IS_LOGGEDIN);
        editor.remove(KEY_TOKEN);

        // commit changes
        editor.commit();
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public User getUser(){
        String first = pref.getString(KEY_FIRST, "");
        String last = pref.getString(KEY_LAST, "");
        String email = pref.getString(KEY_EMAIL, "");
        String type = pref.getString(KEY_TYPE, "");
        String token = pref.getString(KEY_TOKEN, "");

        User user = new User(first, last, email, type, token);
        return user;
    }

    public String getToken(){
        return pref.getString(KEY_TOKEN, "");
    }
}
