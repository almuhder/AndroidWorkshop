package org.rbk.androidworkshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity {


    // 1. First define objects from each class you want to use from the UI (XML)
    EditText etName, etPhone, etEmail, etPassword;
    RadioButton rbMale, rbFemale;
    ListView lvCity;
    CheckBox cbAgree;

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
        lvCity = (ListView) findViewById(R.id.lvCity);

        // 3. Write java code to control the UI from Java
        // now you can set and get the values of the UI

    }

    public void showUserInfo(View v){
        Toast.makeText(this, "Name: " + etName.getText()
                + " Phone " + etPhone.getText()
                + " Email " + etEmail.getText()
                , Toast.LENGTH_SHORT).show();

    }
}
