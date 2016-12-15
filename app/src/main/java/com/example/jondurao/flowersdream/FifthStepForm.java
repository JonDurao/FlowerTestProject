package com.example.jondurao.flowersdream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardFinalForm;
import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardForm;

public class FifthStepForm extends AppCompatActivity {
    public static String selectedMoreWorries = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_form_lay);

        ImageView forwardButton = (ImageView) findViewById(R.id.fifth_forward_button);

        SetOnClickListenerForwardForm(this, forwardButton, SixthStepForm.class, 5);
    }
}
