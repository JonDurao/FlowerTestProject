package com.example.jondurao.flowersdream;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.jondurao.flowersdream.UtilsListeners.*;

public class ThirteenthStepForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirteenth_form_lay);

        FloatingActionButton floatBb = (FloatingActionButton) findViewById(R.id.add_nuevo_contacto_button);
        SetOnClickListenerAddContact(this, floatBb);
    }
}
