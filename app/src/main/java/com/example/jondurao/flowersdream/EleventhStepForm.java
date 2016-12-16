package com.example.jondurao.flowersdream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.example.jondurao.flowersdream.Commons.setTextButtons;
import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardForm;

public class EleventhStepForm extends AppCompatActivity {
    String [] valores, botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eleventh_form_lay);

        valores = getResources().getStringArray(R.array.saber_mas);
        botones = getResources().getStringArray(R.array.saber_mas_botones);
        setTextButtons(this, valores, botones, "CheckBox");

        ImageView forwardButton = (ImageView) findViewById(R.id.eleventh_forward_button);

        SetOnClickListenerForwardForm(this, forwardButton, TwelfthStepForm.class, 11);
    }
}
