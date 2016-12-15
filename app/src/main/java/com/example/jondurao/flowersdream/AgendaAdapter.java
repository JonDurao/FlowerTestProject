package com.example.jondurao.flowersdream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import static com.example.jondurao.flowersdream.UtilsListeners.*;

/**
 * Created by jondurao on 7/11/16.
 */

public class AgendaAdapter extends ArrayAdapter<ContactosDatabase> {
    public AgendaAdapter(Context context, List<ContactosDatabase> contactos){
        super(context, 0, contactos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ContactosDatabase contact = getItem(position);

        ListView lv = (ListView) parent;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.agenda_list_template, parent, false);
        }

        ImageView deleteElement = (ImageView) convertView.findViewById(R.id.delete_icon_agenda);
        RelativeLayout layoutRel = (RelativeLayout) convertView.findViewById(R.id.agenda_data_row);
        TextView agendaNombre = (TextView) convertView.findViewById(R.id.agenda_nombre_text);
        TextView agendaEmail = (TextView) convertView.findViewById(R.id.agenda_email_text);
        TextView agendaTelefono = (TextView) convertView.findViewById(R.id.agenda_telefono_text);

        agendaNombre.setText(contact._nombre);
        agendaNombre.setHint(String.valueOf(contact._id));
        agendaEmail.setText(contact._email);

        if (!contact._movil.isEmpty()){
            agendaTelefono.setText(contact._movil);
        } else if (!contact._casa.isEmpty()){
            agendaTelefono.setText(contact._casa);
        } else {
            agendaTelefono.setText(contact._trabajo);
        }

        SetOnClickListenerDelete(getContext(), deleteElement, agendaNombre);
        SetOnClickListenerDetails(getContext(), layoutRel, agendaNombre);

        return convertView;
    }
}
