package com.example.jondurao.flowersdream;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardFinalForm;
import static com.example.jondurao.flowersdream.Commons.*;
import static com.example.jondurao.flowersdream.UtilsListeners.SetOnClickListenerForwardForm;

public class SecondStepForm extends AppCompatActivity {
    private static EditText cumpleañosEdit, aniversarioEdit;
    private ImageView forwardButton, backwardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_form_lay);

        cumpleañosEdit = (EditText) findViewById(R.id.cumpleaños_edit);
        aniversarioEdit = (EditText) findViewById(R.id.aniversario_edit);
        backwardButton = (ImageView) findViewById(R.id.second_backward_button);
        forwardButton = (ImageView) findViewById(R.id.second_forward_button);

        cumpleañosEdit.addTextChangedListener(DateTextWatcher(cumpleañosEdit, true));
        aniversarioEdit.addTextChangedListener(DateTextWatcher(aniversarioEdit, true));

        SetOnClickListenerForwardForm(this, forwardButton, ThirdStepForm.class, 2);
    }
}
