package com.example.blovvme.savingdataactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        
//intent recoge la data de la otra actividad
        Intent intent = getIntent();
        Person person = intent.getParcelableExtra("person");
        Toast.makeText(this, person.getName() + " " +  person.getGender(), Toast.LENGTH_SHORT).show();
    }
}
