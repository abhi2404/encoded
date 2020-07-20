package com.example.notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    private static final String TAG ="run" ;
    EditText edit_1; EditText edit_2;
    Button Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

        edit_1=(EditText)findViewById(R.id.title);
        edit_2=(EditText)findViewById(R.id.body);
        Add=(Button)findViewById(R.id.add);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NewActivity.this,MainActivity.class);
                i.putExtra("Title",edit_1.getText().toString());
                i.putExtra("body",edit_2.getText().toString());
                startActivity(i);

            }
        });
    }
}
