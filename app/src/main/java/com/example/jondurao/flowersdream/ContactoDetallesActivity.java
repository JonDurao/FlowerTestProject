package com.example.jondurao.flowersdream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.jondurao.flowersdream.Commons.*;

public class ContactoDetallesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_detalles);

        Intent in = getIntent();
        int position = in.getIntExtra("position", 0);

        updateDetails(RetrieveDatabaseInfo(this, position));
    }

    private void updateDetails(ContactosDatabase contacto){
        CheckFullness(contacto.get_nombre(), findViewById(R.id.nombre_contacto_label), (TextView) findViewById(R.id.nombre_contacto_detalle));
        CheckFullness(contacto.get_email(), findViewById(R.id.email_contacto_label), (TextView) findViewById(R.id.email_contacto_detalle));
        CheckFullness(contacto.get_movil(), findViewById(R.id.movil_contacto_label), (TextView) findViewById(R.id.movil_contacto_detalle));
        CheckFullness(contacto.get_casa(), findViewById(R.id.casa_contacto_label), (TextView) findViewById(R.id.casa_contacto_detalle));
        CheckFullness(contacto.get_trabajo(), findViewById(R.id.trabajo_contacto_label), (TextView) findViewById(R.id.trabajo_contacto_detalle));
        CheckFullness(contacto.get_turno(), findViewById(R.id.turno_contacto_label), (TextView) findViewById(R.id.turno_contacto_detalle));
        CheckFullness(contacto.get_metodoContacto(), findViewById(R.id.metodo_contacto_label), (TextView) findViewById(R.id.metodo_contacto_detalle));
        CheckFullness(contacto.get_direccion(), findViewById(R.id.direccion_label), (TextView) findViewById(R.id.direccion_detalle));
        CheckFullness(contacto.get_cumpleaños(), findViewById(R.id.cumpleaños_label), (TextView) findViewById(R.id.cumpleaños_detalle));
        CheckFullness(contacto.get_aniversario(), findViewById(R.id.aniversario_label), (TextView) findViewById(R.id.aniversario_detalle));
        CheckFullness(contacto.get_profesion(), findViewById(R.id.profesion_label), (TextView) findViewById(R.id.profesion_detalle));
        CheckFullness(contacto.get_tipoPiel(), findViewById(R.id.tipo_piel_label), (TextView) findViewById(R.id.tipo_piel_detalle));
        CheckFullness(contacto.get_mayorPreocupacion(), findViewById(R.id.mayor_preocupacion_label), (TextView) findViewById(R.id.mayor_preocupacion_detalle));
        CheckFullness(contacto.get_otrasPreocupaciones(), OTRA_PREOCUPACION, findViewById(R.id.otras_preocupaciones_label), (TextView) findViewById(R.id.otras_preocupaciones_detalle));
        CheckFullness(contacto.get_rutinaDiaria(), RUTINA_DIARIA, findViewById(R.id.rutina_label), (TextView) findViewById(R.id.rutina_detalle));
        CheckFullness(contacto.get_beneficioMascara(), findViewById(R.id.base_maquillaje_label), (TextView) findViewById(R.id.base_maquillaje_detalle));
        CheckFullness(contacto.get_tipoCobertura(), findViewById(R.id.tipo_cobertura_label), (TextView) findViewById(R.id.tipo_cobertura_detalle));
        CheckFullness(contacto.get_tonosMaquillaje(), findViewById(R.id.tonos_maquillaje_label), (TextView) findViewById(R.id.tonos_maquillaje_detalle));
        CheckFullness(contacto.get_colorPelo(), findViewById(R.id.color_pelo_label), (TextView) findViewById(R.id.color_pelo_detalle));
        CheckFullness(contacto.get_colorOjos(), findViewById(R.id.color_ojos_label), (TextView) findViewById(R.id.color_ojos_detalle));
        CheckFullness(contacto.get_formaLabios(), findViewById(R.id.labios_forma_label), (TextView) findViewById(R.id.labios_forma_detalle));
        CheckFullness(contacto.get_formaOjos(), findViewById(R.id.ojos_forma_label), (TextView) findViewById(R.id.ojos_forma_detalle));
        CheckFullness(contacto.get_formaCara(), findViewById(R.id.cara_forma_label), (TextView) findViewById(R.id.cara_forma_detalle));
        CheckFullness(contacto.get_saberMas(), this.getResources().getStringArray(R.array.saber_mas), findViewById(R.id.saber_mas_label), (TextView) findViewById(R.id.saber_mas_detalle));
        CheckFullness(contacto.get_noPuedoVivir(), findViewById(R.id.no_puedo_vivir_label), (TextView) findViewById(R.id.no_puedo_vivir_detalle));
        CheckFullness(contacto.get_otrasMarcas(), findViewById(R.id.otras_marcas_label), (TextView) findViewById(R.id.otras_marcas_detalle));
        CheckFullness(contacto.get_otrosProductosComprar(), findViewById(R.id.otros_productos_comprar_label), (TextView) findViewById(R.id.otros_productos_comprar_detalle));
        CheckFullness(contacto.get_nuevoContacto(), getResources().getStringArray(R.array.nuevos_contactos_detalle_label_ids), getResources().getStringArray(R.array.nuevos_contactos_detalle_ids));
    }

    private void CheckFullness(String info, View tvLabel, TextView tvDetalle){
        if (info.isEmpty()){
            tvLabel.setVisibility(View.GONE);
            tvDetalle.setVisibility(View.GONE);
        }else {
            tvDetalle.setText(info);
        }
    }

    private void CheckFullness(String info, String[] labels, String[] detalles){
        if (info.isEmpty()){
            for (int i = 0; i < labels.length; i++){
                findViewById(getResources().getIdentifier(labels[i], "id", getPackageName())).setVisibility(View.GONE);
                findViewById(getResources().getIdentifier(detalles[i], "id", getPackageName())).setVisibility(View.GONE);
            }
        }else {
            String[] valores = info.split("/");

            if (valores.length < labels.length){
                for (int j = valores.length; j < labels.length; j++){
                    findViewById(getResources().getIdentifier(labels[j], "id", getPackageName())).setVisibility(View.GONE);
                    findViewById(getResources().getIdentifier(detalles[j], "id", getPackageName())).setVisibility(View.GONE);
                }
            }

            for (int x = 0; x < valores.length; x++){
                String[] contacto = valores[x].split("-");

                TextView nombTv = (TextView) findViewById(getResources().getIdentifier(labels[x], "id", getPackageName()));
                EditText telefEt = (EditText) findViewById(getResources().getIdentifier(detalles[x], "id", getPackageName()));
                nombTv.setText(contacto[0]);
                telefEt.setText(contacto[contacto.length-1]);
            }
        }
    }

    private void CheckFullness(String info, String[] todoDatos, View tvLabel, TextView tvDetalle){
        if (info.isEmpty()){
            tvLabel.setVisibility(View.GONE);
            tvDetalle.setVisibility(View.GONE);
        }else {
            Boolean entero;
            String resultCheckBoxes = "";
            ArrayList<String> total = new ArrayList<>();
            String[] todosIds = info.split("/", info.lastIndexOf("/") - 1);

            for (int i = 0; i < todosIds.length; i++){
                if (!todosIds[i].isEmpty()){
                    try{
                        Integer.parseInt(todosIds[i]);
                        entero = true;
                    } catch (Exception e){
                        entero = false;
                    }

                    if (entero == true){
                        if (total.isEmpty()){
                            total.add(i, todoDatos[i]);
                        } else {
                            total.add(i, "\n\n" + todoDatos[i]);
                        }
                    } else if (entero == false){
                        if (total.isEmpty()){
                            total.add(i, todosIds[i]);
                        } else {
                            total.add(i, "\n\n" + todosIds[i]);
                        }
                    }
                }
            }

            for (int auxTotal = 0; auxTotal<total.size(); auxTotal++){
                resultCheckBoxes = resultCheckBoxes + total.get(auxTotal);
            }

            tvDetalle.setText(resultCheckBoxes);
        }
    }
}
