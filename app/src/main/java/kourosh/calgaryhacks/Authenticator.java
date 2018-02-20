package kourosh.calgaryhacks;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.*;

/**
 * Created by Ahmed on 2/21/2017.
 */

public class Authenticator
{
    public static Authenticator current;

    private FirebaseAuth auth;
    private AuthenticatorActivity activity;

    static
    {
        current = new Authenticator();
        current.auth = FirebaseAuth.getInstance();
    }

    public void setActivity(AuthenticatorActivity activity)
    {
        this.activity = activity;
    }

    public void createNewUser(String email, String password)
    {
        email = email.trim();

        if (email.endsWith("@ucalgary.ca"))
        {
            Task<AuthResult> task = auth.createUserWithEmailAndPassword(email, password);
            task.addOnSuccessListener((AuthResult a) -> activity.onSuccess());
            task.addOnFailureListener(this::onCreateUserFailure);
        }
        else
        {
            activity.setEmailError("Must be a ucalgary.ca email");
        }
    }

    public void signInUser(String email, String password)
    {
        email = email.trim();

        if (email.endsWith("@ucalgary.ca"))
        {
            Task<AuthResult> task = auth.signInWithEmailAndPassword(email, password);
            task.addOnSuccessListener((AuthResult a) -> activity.onSuccess());
            task.addOnFailureListener(this::onSignInFailure);
        }
        else
        {
            activity.setEmailError("Must be a ucalgary.ca email");
        }
    }

    private void onCreateUserFailure(Exception ex)
    {
        if (ex instanceof FirebaseAuthWeakPasswordException)
        {
            activity.setPasswordError("Password is too weak. " + ((FirebaseAuthWeakPasswordException)ex).getReason());
        }
        else if (ex instanceof FirebaseAuthInvalidCredentialsException)
        {
            activity.setEmailError("Email is invalid");
        }
        else if (ex instanceof FirebaseAuthUserCollisionException)
        {
            activity.setEmailError("This email already exists");
        }
    }

    private void onSignInFailure(Exception ex)
    {
        if (ex instanceof FirebaseAuthInvalidUserException)
        {
            activity.setEmailError("Email does not exist");
            // user doesnt exist
        }
        else if (ex instanceof FirebaseAuthInvalidCredentialsException)
        {
            activity.setPasswordError("Password is incorrect");
        }
    }
}
