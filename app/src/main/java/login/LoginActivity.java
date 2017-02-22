package login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kourosh.calgaryhacks.Authenticator;
import kourosh.calgaryhacks.AuthenticatorActivity;
import kourosh.calgaryhacks.R;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AuthenticatorActivity
{
    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private Button mSignInButton;
    private TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mRegister = (TextView) findViewById(R.id.register);

        Authenticator.current.setActivity(this);

        mSignInButton.setOnClickListener((View v) -> Authenticator.current.signInUser(getEmail(), getPassword()));

        mRegister.setOnClickListener((View v) -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));
    }

    private String getEmail()
    {
        return mEmailView.getText().toString().trim();
    }

    private String getPassword()
    {
        return mPasswordView.getText().toString().trim();
    }

    public void setEmailError(String error)
    {
        mEmailView.setError(error);
    }

    public void setPasswordError(String error)
    {
        mPasswordView.setError(error);
    }

    public void onSuccess()
    {

    }
}

