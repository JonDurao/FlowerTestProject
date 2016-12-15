package com.example.jondurao.flowersdream;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import static com.example.jondurao.flowersdream.UtilsListeners.*;
import static com.example.jondurao.flowersdream.Commons.*;

public class FirstStepForm extends AppCompatActivity {
    public static ContactosDatabase CONTACTO_INIT = new ContactosDatabase();
    private static EditText fechaEdit;
    private static ImageView backwardButton, forwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_form_lay);

        fechaEdit = (EditText) findViewById(R.id.fecha_edit);
        forwardButton = (ImageView) findViewById(R.id.first_forward_button);

        fechaEdit.addTextChangedListener(DateTextWatcher(fechaEdit, false));

        SetOnClickListenerForwardForm(this, forwardButton, SecondStepForm.class, 1);
    }
}
