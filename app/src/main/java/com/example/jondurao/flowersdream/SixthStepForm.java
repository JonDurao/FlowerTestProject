package com.example.jondurao.flowersdream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardFinalForm;
import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardForm;

public class SixthStepForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_form_lay);

        ImageView forwardButton = (ImageView) findViewById(R.id.sixth_forward_button);

        SetOnClickListenerForwardForm(this, forwardButton, SeventhStepForm.class, 6);
    }
}
