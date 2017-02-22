package login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kourosh.calgaryhacks.Authenticator;
import kourosh.calgaryhacks.AuthenticatorActivity;
import kourosh.calgaryhacks.R;

public class RegisterActivity extends AppCompatActivity implements AuthenticatorActivity
{

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.register_email);
        mPasswordView = (EditText) findViewById(R.id.register_password);
        mRegisterButton = (Button) findViewById(R.id.registerButton);

        Authenticator.current.setActivity(this);

        mRegisterButton.setOnClickListener((View v) -> Authenticator.current.createNewUser(getEmail(), getPassword()));
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
