package com.smartuniversitygp.smartuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smartuniversitygp.smartuniversity.helper.SessionManager;
import com.smartuniversitygp.smartuniversity.helper.User;

public class MainActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvEmail;
    private Button btnLogout;

    private SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tv_name);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        User user = session.getUser();

        String name = user.getFirstName() + " " + user.getLastName();
        String email = user.getEmail();

        // Displaying the user details on the screen
        tvName.setText(name);
        tvEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.logout();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
