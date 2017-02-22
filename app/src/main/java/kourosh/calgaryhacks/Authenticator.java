package kourosh.calgaryhacks;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

/**
 * Created by Ahmed on 2/21/2017.
 */

public class Authenticator
{
    FirebaseAuth auth;

    public void createNewUser(String email, String password)
    {
        email = email.trim();

        if (email.endsWith("@ucalgary.ca"))
        {
            Task<AuthResult> task = auth.createUserWithEmailAndPassword(email, password);
            task.addOnSuccessListener(this::onCreateUserSuccess);
            task.addOnFailureListener(this::onCreateUserFailure);
        }
        else
        {
            // NOT A UCALGARY EMAIL
        }
    }

    public void signInUser(String email, String password)
    {
        email = email.trim();

        if (email.endsWith("@ucalgary.ca"))
        {
            Task<AuthResult> task = auth.signInWithEmailAndPassword(email, password);
            task.addOnSuccessListener(this::onSignInSuccess);
            task.addOnFailureListener(this::onSignInFailure);
        }
        else
        {
            // NOT A UCALGARY EMAIL
        }
    }

    private void onCreateUserSuccess(AuthResult result)
    {
        // Creating user was successful, we are now signed in
        // Go to next screen
    }

    private void onCreateUserFailure(Exception ex)
    {
        if (ex instanceof FirebaseAuthWeakPasswordException)
        {
            // Password too weak
        }
        else if (ex instanceof FirebaseAuthInvalidCredentialsException)
        {
            // Error with email
        }
        else if (ex instanceof FirebaseAuthUserCollisionException)
        {
            // Email already exists
        }
    }

    private void onSignInSuccess(AuthResult auth)
    {
        // Sign in successful
    }

    private void onSignInFailure(Exception ex)
    {
        if (ex instanceof FirebaseAuthInvalidUserException)
        {
            // user doesnt exist
        }
        else if (ex instanceof FirebaseAuthInvalidCredentialsException)
        {
            // password is wrong
        }
    }
}
