package com.example.rita.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    ListView listView;
    EditText editText;
    Button button;
    MessageAdapter arrayAdapter;
    MessageService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        ArrayList<Message> listOfMessages = new ArrayList<>();
        arrayAdapter = new MessageAdapter(this);
        arrayAdapter.addAll(listOfMessages);
        listView.setAdapter(arrayAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://zerda-raptor.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(MessageService.class);


    }

    public void sendMessage(View view) {
        Message messageToSend = new Message("Rita&Sopi", editText.getText().toString());
        arrayAdapter.add(messageToSend);
        editText.setText("");
        service.postMessageCall(new MessageWrapper(messageToSend)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    // itt csinálhatunk valamit, mert tudjuk, hogy sikeresen elküldtük a szervernek az adatokat
                    // pl frissíthetjük az üzeneteink listáját (új lekérés a szervertől)
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("rossz");
                // itt valami elbaszarintódott, logoljuk ki, adjunk hibaüzenetet, valami.
            }
        });
    }


}
