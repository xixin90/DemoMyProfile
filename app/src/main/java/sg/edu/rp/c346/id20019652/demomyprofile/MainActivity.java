package sg.edu.rp.c346.id20019652.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }
    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        String strGPA = etGPA.getText().toString();
        float gpa = Float.parseFloat(strGPA);

        //Step 1: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Step 2: Create a SHaredPreferences Edit by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Step 3: Set a key-value pair in the editor
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);
        //Step 4: Call commit() to save the changes made to the SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 1: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //Step 2: Retrieve the saved data from the SharedReferences
        // with a default value if no matching data
        String msg = prefs.getString("name", "No greetings name");
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }

}