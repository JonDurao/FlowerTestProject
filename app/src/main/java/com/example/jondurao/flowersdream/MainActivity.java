package com.example.jondurao.flowersdream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.jondurao.flowersdream.UtilsListeners.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nuevaClientaTV = (TextView) findViewById(R.id.nueva_clienta_button);
        TextView agendaTV = (TextView) findViewById(R.id.agenda_button);

        SetOnClickListenerMainScreen(this, nuevaClientaTV);
        SetOnClickListenerMainScreen(this, agendaTV);
    }
}
