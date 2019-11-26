package com.example.usedsharedpreferences.by.bistu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editId;
    EditText editName;
    EditText editOld;
    Button buttonRedo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonDo = (Button) findViewById(R.id.buttonDO);
        Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
        editId = (EditText) findViewById(R.id.editId);
        editName = (EditText) findViewById(R.id.editName);
        editOld = (EditText) findViewById(R.id.editOld);
        buttonRedo = (Button) findViewById(R.id.buttonRedo);
        buttonRedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                String id = pref.getString("id", "");
                int age = pref.getInt("age", 0);
                editId.setText(id);
                editName.setText(name);
                editOld.setText(String.valueOf(age));
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editId.setText("");
                editName.setText("");
                editOld.setText("");

            }
        });
        buttonDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("id", editId.getText().toString());
                editor.putString("name", editName.getText().toString());
                editor.putInt("age", Integer.valueOf(editOld.getText().toString()));
                editor.apply();
            }
        });

    }
}
