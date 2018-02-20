package kourosh.calgaryhacks;

import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Ahmed on 2/22/2017.
 */

public class Database
{
    public static Database current;

    private static final String DATABASE_URL = "https://calgaryhacks2017.firebaseio.com/";
    private boolean isLoaded;

    public static void Initialize()
    {
        try {
            FileInputStream serviceAccount = new FileInputStream("service-account.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setDatabaseUrl(DATABASE_URL)
                    .build();
        }
        catch (IOException ex){}
    }
}
