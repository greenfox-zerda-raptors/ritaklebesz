package com.example.rita.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    ListView listView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        ArrayList<Message> listOfMessages = new ArrayList<>(Arrays.asList(
                new Message("User1", "Random text 1", "2016-12-23"),
                new Message("User2", "Random text 2", "2016-12-23"),
                new Message("User3", "Random text 3", "2016-12-23")
        ));
    }

    public void sendMessage(View view) {
        
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }


}
