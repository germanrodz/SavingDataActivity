package com.example.blovvme.savingdataactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    EditText editText,PersonName,PersonGender;
    TextView textView;
    Button btnMain,btnShareData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etname);
        textView = (TextView) findViewById(R.id.tvName);
        btnMain = (Button) findViewById(R.id.btnGoToSecond);
        PersonGender = (EditText)findViewById(R.id.PersonGender);
        PersonName = (EditText)findViewById(R.id.PersonName);
        btnShareData = (Button)findViewById(R.id.btnShareData);
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = textView.getText().toString();

        outState.putString("data", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("data"));
    }

//Para enviar data a otra actividad
//Explicit Intent
    public void doSomething(View view) {
        switch  (view.getId()){
            case R.id.changeText:
                String data = editText.getText().toString();
                textView.setText(data);
                break;
            case R.id.btnGoToSecond:

                Person person = new Person(PersonName.getText().toString(),PersonGender.getText().toString());
                Intent intent= new Intent(this,SecondActivity.class);
                intent.putExtra("person",person);
                startActivity(intent);
                break;
            case R.id.btnShareData:

                ///Implicit Intent
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

        }
    }
}

