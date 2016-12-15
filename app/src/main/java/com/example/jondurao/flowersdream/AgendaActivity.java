package com.example.jondurao.flowersdream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

import java.util.List;

public class AgendaActivity extends AppCompatActivity {

    static Activity act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        act = this;
        DatabaseHandler dbh = new DatabaseHandler(this);

        List<ContactosDatabase> contactosTodos = dbh.getAllContacts();
        AgendaAdapter adapter = new AgendaAdapter(this, contactosTodos);

        ListView lv = (ListView) findViewById(R.id.agenda_lista);
        lv.setAdapter(adapter);
    }

    public static void updateData(){
        DatabaseHandler dbh = new DatabaseHandler(act);
        List<ContactosDatabase> contactosTodos = dbh.getAllContacts();

        AgendaAdapter adapter = new AgendaAdapter(act, contactosTodos);
        ListView lv = (ListView) act.findViewById(R.id.agenda_lista);
        lv.setAdapter(adapter);
    }

    public static void openDetails(Context context, int pos){
        Intent in = new Intent(context, ContactoDetallesActivity.class);
        in.putExtra("position", pos);

        context.startActivity(in);
    }
}
