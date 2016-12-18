package com.example.jondurao.flowersdream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardForm;

public class TwelfthStepForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twelfth_form_lay);

        ImageView forwardButton = (ImageView) findViewById(R.id.twelfth_forward_button);

        SetOnClickListenerForwardForm(this, forwardButton, ThirteenthStepForm.class, 12);
    }
}
