package org.rbk.androidworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity {




    // 1. First define objects from each class you want to use from the UI (XML)
    EditText etName, etPhone, etEmail, etPassword;
    RadioButton rbMale, rbFemale;
    RadioGroup rgGender;
    Spinner spCity;
    CheckBox cbAgree;
    Button btnRegister;

    // Define a list of cities
    String[] cities = {"Amman", "Ibrid", "Salet", "Aqaba", "Maan"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        // 2. Refer to UI from the java code --> Link between java and xml
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rbFemale = (RadioButton) findViewById(R.id.rbFemale);
        rbMale = (RadioButton) findViewById(R.id.rbMale);
        cbAgree = (CheckBox) findViewById(R.id.cbAgree);
        spCity = (Spinner) findViewById(R.id.spCity);
        rgGender = (RadioGroup) findViewById(R.id.rgGender);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        // 3. Write java code to control the UI from Java
        // now you can set and get the values of the UI

        // link between Spinner and array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item , cities);
        spCity.setAdapter(adapter);

        // this will disable the button for validation
//        btnRegister.setEnabled(false);

    }

    public void showUserInfo(View v){
        Toast.makeText(this, // Context : this, Current class , Where the Toast msg supposed to be shown
                "Name: " + etName.getText() // the message
                + " Phone " + etPhone.getText()
                + " Email " + etEmail.getText()
                , Toast.LENGTH_SHORT) // The duration : Toast.LENGTH_LONG
                .show();

    }
}
