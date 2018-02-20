package kourosh.calgaryhacks;

/**
 * Created by Ahmed on 2/22/2017.
 */

public interface AuthenticatorActivity
{
    public void setEmailError(String error);
    public void setPasswordError(String error);
    public void onSuccess();
}
