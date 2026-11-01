package com.example.explicitintent1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText e_name,e_contact;
    Button b_design1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_design1 = findViewById(R.id.b_design1);
        e_name = findViewById(R.id.m_e_name);
        e_contact = findViewById(R.id.m_e_contact);


        b_design1.setOnClickListener(v->{
            String name = e_name.getText().toString();
            String contact = e_contact.getText().toString();

            Intent intent = new Intent(MainActivity.this,design1.class);
            intent.putExtra ("name",name);
            intent.putExtra("contact",contact);
            startActivity(intent);
        });

    }
}
