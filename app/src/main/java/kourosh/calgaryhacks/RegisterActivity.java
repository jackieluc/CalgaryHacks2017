package kourosh.calgaryhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegisterActivity extends AppCompatActivity {

    Spinner dropdown;

    public String email;
    public String password;
    public String firstName;
    public String lastName;
    public String spinnerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        populateSpinner();
    }

    private void populateSpinner() {
        dropdown = (Spinner)findViewById(R.id.register_spinner);
        String[] items = new String[]{"Student", "Professor"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }
}
