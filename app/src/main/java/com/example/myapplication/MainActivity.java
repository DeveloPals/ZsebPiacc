package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TabItem;
import android.text.Html;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnTouchListener;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {
/*próba*/
    private AutoCompleteTextView mEmail;
    private AutoCompleteTextView mPassword;
    private Button mLogin;
    private TextView mCreateAccount;
    private TextView mForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = (AutoCompleteTextView) findViewById(R.id.userEmail);
        mPassword = (AutoCompleteTextView) findViewById(R.id.userPassword);
        mLogin = (Button) findViewById(R.id.user_login);

        mCreateAccount = (TextView) findViewById(R.id.tv_create_account);
        String text = "Nincs fiókja? <font color='#f7cb00'> Fiók létrehozása.</font>";
        mCreateAccount.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);

        mForgotPassword = (TextView) findViewById(R.id.tv_forgot_password);

        mCreateAccount.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String text;
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        text = "Nincs fiókja? <font color='#e2ba00'> Fiók létrehozása.</font>";
                        mCreateAccount.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);
                        break;
                    case MotionEvent.ACTION_UP:
                        text = "Nincs fiókja? <font color='#f7cb00'> Fiók létrehozása.</font>";
                        mCreateAccount.setText(Html.fromHtml(text), TextView.BufferType.SPANNABLE);

                        Intent sharedIntent = new Intent(MainActivity.this, SharedActivity.class);

                        Pair[] pairs = new Pair[3];
                        pairs[0] = new Pair<View, String>(mEmail, "emailTransition");
                        pairs[1] = new Pair<View, String>(mPassword, "passwordTransition");
                        pairs[2] = new Pair<View, String>(mLogin, "loginTransition");

                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                        startActivity(sharedIntent, options.toBundle());
                        break;
                }
                return true;
            }
        });
    }


    public void createAccountClick(View view) {



   }





   /* GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build();*/



}
