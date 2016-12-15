package com.example.jondurao.flowersdream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.jondurao.flowersdream.FirstStepForm.*;
import static com.example.jondurao.flowersdream.Commons.*;

/**
 * Created by jondurao on 2/11/16.
 */

public class UtilsListeners extends AppCompatActivity {

    public static void SetOnClickListenerMainScreen (final Activity context, TextView button){
        final String textButton = button.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textButton.contains("Agenda")){
                    context.startActivity(new Intent(context, AgendaActivity.class));
                }else {
                    context.startActivity(new Intent(context, FirstStepForm.class));
                }
            }
        });
    }

    public static void SetOnClickListenerForwardForm(final Activity context, View forwardButton, final Class clase, final int step){
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (CheckMissingFields(context, step)){
                        SetData(context, CONTACTO_INIT, step);

                        context.startActivity(new Intent(context, clase));
                    } else {
                        //Commons.OpenAlertDialog(context, "Error", "Algunos datos son incorrectos o no han sido introducidos", "OK");
                    }
                }catch (Exception e){
                    Commons.OpenAlertDialog(context, "Error", "Algunos datos son incorrectos o no han sido introducidos", "OK", null);
                }
            }
        });
    }

    public static void SetOnClickListenerForwardFinalForm(final Activity context, View forwardButton, final int step){
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (CheckMissingFields(context, step)) {
                        DatabaseHandler dbh = new DatabaseHandler(context);

                        SetData(context, CONTACTO_INIT, step);

                        dbh.addContact(CONTACTO_INIT);
                        Commons.OpenAlertDialog(context, "Bien", "Fin de formulario", "OK", "Go Home");
                    }
                }catch (Exception e){
                    Commons.OpenAlertDialog(context, "Error", "Algunos datos son incorrectos o no han sido introducidos", "OK", null);
                }
            }
        });
    }

    public static void SetOnClickListenerDelete(final Context context, final View deleteView, final TextView hintView){
        deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(context);

                //final int position = listaView.getPositionForView(deleteView);
                int id = Integer.parseInt(hintView.getHint().toString());
                db.deleteContact(id);

                AgendaActivity.updateData();
            }
        });
    }

    public static void SetOnClickListenerDetails(final Context context, final View deleteView, final TextView hintView){
        deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(context);

                //final int position = listaView.getPositionForView(deleteView);
                int id = Integer.parseInt(hintView.getHint().toString());

                AgendaActivity.openDetails(context, id);
            }
        });
    }

}
