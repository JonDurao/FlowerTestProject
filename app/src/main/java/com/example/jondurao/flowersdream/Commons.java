package com.example.jondurao.flowersdream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by jondurao on 7/11/16.
 */

public class Commons {
    private static CheckBox cb;
    private static RadioGroup rg;
    private static RadioButton rb;
    private static Calendar calendar;

    public static String[] TIPO_PIEL = {
            "Normalmente mi rostro se siente tirante y mis poros no son visibles",
            "Mi piel es suave, con grasa en la zona 'T' y sequedad en los extremos del rostro",
            "Mi rostro brilla y los poros son claramente visibles"};

    public static String[] MAYOR_PREOCUPACION = {
            "Mejorar la apariencia de las profundas líneas de expresión y arrugas",
            "Minimizar la apariencia de las finas lineas de exresión y arrugas",
            "Un cuidado de la piel sencillo para una piel joven",
            "Controlar la grasa y el ácne ocasional y prevenir la aparición de granitos",
            "Disminuir las zonas oscuras y eliminar las bolsas de la zona de los ojos",
            "Una piel sensible y final",
            "Reducir las manchas oscuras e igualar el tono facial",
            "Lo básico: limpiar, exfoliar e hidratar"
    };

    public static String[] OTRA_PREOCUPACION = {
            "Mejorar la apariencia de las profundas líneas de expresión y arrugas",
            "Protección contra el daño solar",
            "Mejorar la textura de la piel y minimizar la apariencia de los poros",
            "Reafirmar la piel",
            "Conseguir un extra de hidratación",
            "Hidratar y minimizar las arrugas alrededor de los ojos",
            "Suavizar los ojos cansados",
            "Desmaquillar mi piel de una manera suave",
            "Reducir las finas líneas y arrugas alrededor de los labios",
            "Suavizar los labios secos",
            "Igualar el tono de piel y reducir las machas oscuras"
    };

    public static String[] RUTINA_DIARIA = {
            "Limpiar",
            "Proteccion Solar",
            "Base de Maquillaje",
            "Tonificar y Refrescar",
            "Hidratacion",
            "Mascarilla",
            "Productos para igualar el tono de piel",
            "Cuidado del contorno del ojo"
    };

    public static String[] BENEFICIO_MASCARA = {
            "Cuidado Antiedad",
            "Hidratacion",
            "Ingredientes Minerales",
            "Control de Grasa"
    };

    public static String[] TIPO_COBERTURA = {
            "Ligera: Prefiero un acabado natural sin sensación grasa",
            "Media: Busco igualar mi tono de piel con una pequeña cobertura con la que me sienta cómoda",
            "Alta: Prefiero una alta cobertura para esconder imperfecciones y conseguir un acabado que se funda con mi piel"
    };

    public static String[] TONOS_MAQUILLAJE = {
            "Tonos tierra que expresen naturalidad y añadan un suave matiz a mi tono de piel",
            "Looks de maquillaje con un acabado perfecto con tonos que potencien mi tono natural de piel",
            "Colores vivos que contraste con mi tono de piel"
    };

    private static String[] OTRA_PREOCUPACION_CHECKBOXES = {
            "new_worries_0",
            "new_worries_1",
            "new_worries_2",
            "new_worries_3",
            "new_worries_4",
            "new_worries_5",
            "new_worries_6",
            "new_worries_7",
            "new_worries_8",
            "new_worries_9",
            "new_worries_10"
    };

    private static String[] RUTINA_DIARIA_CHECKBOXES = {
            "rutina_0",
            "rutina_1",
            "rutina_2",
            "rutina_3",
            "rutina_4",
            "rutina_5",
            "rutina_6",
            "rutina_7"
    };

    private static ArrayList<String> erroresDatos = new ArrayList<>();

    public static void setTextButtons(Activity context, String[] vector, String[] elementos){
        int resource;
        RadioButton boton;

        if (vector.length < elementos.length){
            for (int j = 0; j < (elementos.length - vector.length); j++){
                resource = context.getResources().getIdentifier(elementos[(vector.length+j)], "id", context.getPackageName());
                View vistaGen = context.findViewById(resource);
                vistaGen.setVisibility(View.GONE);
            }
        }

        for (int i = 0; i < vector.length; i++){
            resource = context.getResources().getIdentifier(elementos[i], "id", context.getPackageName());
            boton = (RadioButton) context.findViewById(resource);
            boton.setText(vector[i]);
            boton.setHint(vector[i]);
        }
    }

    public static void OpenAlertDialog(final Activity context, String title, String message, String button, final String action){
        AlertDialog.Builder adb = new AlertDialog.Builder(context);

        adb.setTitle(title);
        adb.setMessage(message);

        adb.setPositiveButton(button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (action == "Go Home"){
                    context.startActivity(new Intent(context, MainActivity.class));
                }
            }
        });

        adb.show();
    }

    public static String RetrieveEditText(Activity context, int id){
        EditText et = (EditText) context.findViewById(id);

        return et.getText().toString();
    }

    public static String RetrieveRadioGroupChecked(Activity context, int id){
        rg = (RadioGroup) context.findViewById(id);
        rb = (RadioButton) context.findViewById(rg.getCheckedRadioButtonId());

        return rb.getHint().toString();
    }

    public static String RetrieveCheckBoxStatus(Activity context, int id){
        cb = (CheckBox) context.findViewById(id);

        if (cb.isChecked()){
            return cb.getHint().toString();
        }else {
            return "";
        }
    }

    public static ContactosDatabase RetrieveDatabaseInfo(Activity context, int id){
        ContactosDatabase db;

        DatabaseHandler dbh = new DatabaseHandler(context);
        db = dbh.getContact(id);

        return db;
    }

    public static TextWatcher DateTextWatcher(final EditText fechaEdit, final Boolean cumpAni){
        TextWatcher tw = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String working = s.toString();
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                boolean isValid = true;

                if (working.length() == 2 && before == 0) {
                    working = working.substring(0).concat("/");
                    fechaEdit.setText(working);
                    fechaEdit.setSelection(working.length());
                } else if (working.length() >= 5 && before == 0 && cumpAni == false) {
                    if (working.lastIndexOf("/") == 2) {
                        working = working.substring(0, 5).concat("/") + working.substring(5);
                        fechaEdit.setText(working);
                        fechaEdit.setSelection(working.length());
                    }
                }

                if (working.length() != 10 && cumpAni == false) {
                    isValid = false;
                } else if (working.length() != 5 && cumpAni == true){
                    isValid = false;
                }else if (working.length() == 10 && cumpAni == false){

                    if (Integer.parseInt(working.substring(0, 2)) < 1 || Integer.parseInt(working.substring(0,2))>31){
                        if (!erroresDatos.contains("DiaErroneo")) {
                            erroresDatos.add("DiaErroneo");
                        }
                    } else {
                        if (erroresDatos.contains("DiaErroneo")){
                            erroresDatos.remove("DiaErroneo");
                        }
                    }

                    if (Integer.parseInt(working.substring(3,5)) < 1 || Integer.parseInt(working.substring(3,5))>12) {
                        if (!erroresDatos.contains("MesErroneo")) {
                            erroresDatos.add("MesErroneo");
                        }
                    } else {
                        if (erroresDatos.contains("MesErroneo")){
                            erroresDatos.remove("MesErroneo");
                        }
                    }

                    if (cumpAni == false){
                        if (Integer.parseInt(working.substring(6)) != currentYear) {
                            if (!erroresDatos.contains("AñoErroneo")){
                                erroresDatos.add("AñoErroneo");
                            }
                        } else {
                            if (erroresDatos.contains("AñoErroneo")){
                                erroresDatos.remove("AñoErroneo");
                            }
                        }
                    }

                } else if (working.length() == 5 && cumpAni == true){
                    if (Integer.parseInt(working.substring(0, 2)) < 1 || Integer.parseInt(working.substring(0,2))>31){
                        if (!erroresDatos.contains("DiaErroneo")) {
                            erroresDatos.add("DiaErroneo");
                        }
                    } else {
                        if (erroresDatos.contains("DiaErroneo")){
                            erroresDatos.remove("DiaErroneo");
                        }
                    }

                    if (Integer.parseInt(working.substring(3,5)) < 1 || Integer.parseInt(working.substring(3,5))>12) {
                        if (!erroresDatos.contains("MesErroneo")) {
                            erroresDatos.add("MesErroneo");
                        }
                    } else {
                        if (erroresDatos.contains("MesErroneo")){
                            erroresDatos.remove("MesErroneo");
                        }
                    }
                }

                if (!erroresDatos.isEmpty()){
                    if (erroresDatos.contains("DiaErroneo")){
                        if (erroresDatos.contains("MesErroneo")) {
                            if (erroresDatos.contains("AñoErroneo")){
                                fechaEdit.setError("Dia, Mes y Año Incorrecto");
                            }else {
                                fechaEdit.setError("Dia y Mes Incorrecto");
                            }
                        } else  if (erroresDatos.contains("AñoErroneo")){
                            fechaEdit.setError("Dia y Año Incorrecto");
                        }else {
                            fechaEdit.setError("Dia Incorrecto");
                        }
                    } else if (erroresDatos.contains("MesErroneo")){
                        if (erroresDatos.contains("AñoErroneo")){
                            fechaEdit.setError("Mes y Año Incorrecto");
                        }else {
                            fechaEdit.setError("Mes Incorrecto");
                        }
                    } else if (erroresDatos.contains("AñoErroneo")){
                        fechaEdit.setError("Año Incorrecto");
                    }
                } else if (!isValid && cumpAni == false) {
                    fechaEdit.setError("Formato de fecha: DD/MM/YYYY");
                } else if (!isValid && cumpAni == true){
                    fechaEdit.setError("Formato de fecha: DD/MM");
                } else {
                    fechaEdit.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        };

        return tw;
    }

    public static void SetData(Activity context, ContactosDatabase contacto, int step){
        if (step == 1){
            contacto.set_fecha(RetrieveEditText(context, R.id.fecha_edit));
            contacto.set_nombre(RetrieveEditText(context, R.id.nombre_edit));
            contacto.set_email(RetrieveEditText(context, R.id.email_edit));
            contacto.set_movil(RetrieveEditText(context, R.id.movil_edit));
            contacto.set_casa(RetrieveEditText(context, R.id.casa_edit));
            contacto.set_trabajo(RetrieveEditText(context, R.id.trabajo_edit));
            contacto.set_turno(RetrieveRadioGroupChecked(context, R.id.turnos_radio_group));
            contacto.set_metodoContacto(RetrieveRadioGroupChecked(context, R.id.opciones_contacto_radio_group));
        } else if (step == 2){
            contacto.set_direccion(RetrieveEditText(context, R.id.direccion_edit));
            contacto.set_cumpleaños(RetrieveEditText(context, R.id.cumpleaños_edit));
            contacto.set_aniversario(RetrieveEditText(context, R.id.aniversario_edit));
            contacto.set_profesion(RetrieveEditText(context, R.id.profesion_edit));
        } else if (step == 3){
            contacto.set_tipoPiel(TIPO_PIEL[Integer.parseInt(RetrieveRadioGroupChecked(context, R.id.piel_radio_group))]);
        } else if (step == 4){
            contacto.set_mayorPreocupacion(MAYOR_PREOCUPACION[Integer.parseInt(RetrieveRadioGroupChecked(context, R.id.mayor_preocupacion_radio_group))]);
        } else if (step == 5){
            contacto.set_otrasPreocupaciones(getSelectedBoxesHints(context, OTRA_PREOCUPACION_CHECKBOXES));
        } else if (step == 6){
            String total = getSelectedBoxesHints(context, RUTINA_DIARIA_CHECKBOXES);
            if (!RetrieveEditText(context, R.id.otra_rutina_edit).isEmpty()){
                total = total + RetrieveEditText(context, R.id.otra_rutina_edit) + "/";
            }
            contacto.set_rutinaDiaria(total);
        } else if (step == 7){
            contacto.set_beneficioMascara(BENEFICIO_MASCARA[Integer.parseInt(RetrieveRadioGroupChecked(context, R.id.base_maquillaje_radio_group))]);
        } else if (step == 8){
            contacto.set_tipoCobertura(TIPO_COBERTURA[Integer.parseInt(RetrieveRadioGroupChecked(context, R.id.tipo_cobertura_radio_group))]);
        } else if (step == 9){
            contacto.set_tonosMaquillaje(TONOS_MAQUILLAJE[Integer.parseInt(RetrieveRadioGroupChecked(context, R.id.tonos_maquillaje_radio_group))]);
        } else if (step == 10){
            contacto.set_colorPelo(RetrieveEditText(context, R.id.color_pelo_edit));
            contacto.set_colorOjos(RetrieveEditText(context, R.id.color_ojos_edit));
            contacto.set_formaLabios(RetrieveRadioGroupChecked(context, R.id.labios_forma_radio_group));
            contacto.set_formaOjos(RetrieveRadioGroupChecked(context, R.id.ojos_forma_radio_group));
            contacto.set_formaCara(RetrieveRadioGroupChecked(context, R.id.cara_forma_radio_group));
        }
    }

    public static String getSelectedBoxesHints(Activity context, String[] array){
        int aux = 0;
        int res;
        String auxString = "";

        while (aux < array.length){
            res = context.getResources().getIdentifier(array[aux], "id", context.getPackageName());

            if (!RetrieveCheckBoxStatus(context, res).isEmpty()){
                if (auxString.isEmpty()){
                    auxString = RetrieveCheckBoxStatus(context, res) + "/";
                } else {
                    auxString = auxString + RetrieveCheckBoxStatus(context, res) + "/";
                }
            }
            aux ++;
        }

        return auxString;
    }

    public static Boolean CheckMissingFields(Activity context, int step){
        if (step == 1){
            EditText fechaEdit = (EditText) context.findViewById(R.id.fecha_edit);
            EditText nombreEdit = (EditText) context.findViewById(R.id.nombre_edit);
            EditText emailEdit = (EditText) context.findViewById(R.id.email_edit);
            EditText movilEdit = (EditText) context.findViewById(R.id.movil_edit);
            EditText casaEdit = (EditText) context.findViewById(R.id.casa_edit);
            EditText trabajoEdit = (EditText) context.findViewById(R.id.trabajo_edit);

            if (RetrieveEditText(context, R.id.fecha_edit).isEmpty()){
                erroresDatos.add("MissingDate");
                fechaEdit.setError("Introduce una fecha");
            } else {
                if (erroresDatos.contains("MissingDate")){
                    fechaEdit.setError(null);
                    erroresDatos.remove("MissingDate");
                }
            }

            if (RetrieveEditText(context, R.id.nombre_edit).isEmpty()){
                erroresDatos.add("MissingName");
                nombreEdit.setError("Introduce un nombre");
            } else {
                if (erroresDatos.contains("MissingName")){
                    nombreEdit.setError(null);
                    erroresDatos.remove("MissingName");
                }
            }

            if (RetrieveEditText(context, R.id.email_edit).isEmpty()
                    || !RetrieveEditText(context, R.id.email_edit).contains("@")
                    || !RetrieveEditText(context, R.id.email_edit).contains(".")){
                erroresDatos.add("MissingEmail");
                emailEdit.setError("Introduce un Email");
            } else {
                if (erroresDatos.contains("MissingEmail")){
                    emailEdit.setError(null);
                    erroresDatos.remove("MissingEmail");
                }
            }

            if (RetrieveEditText(context, R.id.movil_edit).isEmpty()
                    && RetrieveEditText(context, R.id.casa_edit).isEmpty()
                    && RetrieveEditText(context, R.id.trabajo_edit).isEmpty()){
                erroresDatos.add("MissingPhone");

                movilEdit.setError("Introduce al menos un telefono");
                casaEdit.setError("Introduce al menos un telefono");
                trabajoEdit.setError("Introduce al menos un telefono");
            } else {
                if (erroresDatos.contains("MissingPhone")){
                    movilEdit.setError(null);
                    casaEdit.setError(null);
                    trabajoEdit.setError(null);
                    erroresDatos.remove("MissingPhone");
                }
            }

            if (erroresDatos.isEmpty()){
                return true;
            }else{
                return false;
            }
        } else if (step == 2){
            EditText cumpleañosEdit = (EditText) context.findViewById(R.id.cumpleaños_edit);

            if (RetrieveEditText(context, R.id.cumpleaños_edit).isEmpty()){
                erroresDatos.add("MissingBirthdate");
                cumpleañosEdit.setError("Introduce un cumpleaños");
            } else {
                if (erroresDatos.contains("MissingBirthdate")){
                    cumpleañosEdit.setError(null);
                    erroresDatos.remove("MissingBirthdate");
                }
            }

            if (erroresDatos.isEmpty()){
                return true;
            }else{
                return false;
            }
        } else if (step == 3){
            try {
                RadioGroup rg = (RadioGroup) context.findViewById(R.id.piel_radio_group);
                if (rg.getCheckedRadioButtonId() != -1){
                    return true;
                } else {
                    return false;
                }
            }catch (Exception e){
                OpenAlertDialog(context, "Error", "No has seleccionado ningun tipo de piel", "OK", null);
                return false;
            }

        } else if (step == 4){
            try {
                RadioGroup rg = (RadioGroup) context.findViewById(R.id.mayor_preocupacion_radio_group);

                if (rg.getCheckedRadioButtonId() != -1){
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                OpenAlertDialog(context, "Error", "No has seleccionado ningun problema", "OK", null);
                return false;
            }
        } else if (step == 5) {
            return true;
        } else if (step == 6){
            return true;
        }  else if (step == 7){
            try {
                RadioGroup rg = (RadioGroup) context.findViewById(R.id.base_maquillaje_radio_group);

                if (rg.getCheckedRadioButtonId() != -1){
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                OpenAlertDialog(context, "Error", "No has seleccionado ninguna base", "OK", null);
                return false;
            }
        } else if (step == 8) {
            try {
                RadioGroup rg = (RadioGroup) context.findViewById(R.id.tipo_cobertura_radio_group);

                if (rg.getCheckedRadioButtonId() != -1){
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                OpenAlertDialog(context, "Error", "No has seleccionado ninguna cobertura", "OK", null);
                return false;
            }
        } else if (step == 9) {
            try {
                RadioGroup rg = (RadioGroup) context.findViewById(R.id.tonos_maquillaje_radio_group);

                if (rg.getCheckedRadioButtonId() != -1){
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                OpenAlertDialog(context, "Error", "No has seleccionado ningun tono de piel", "OK", null);
                return false;
            }
        } else if (step == 10) {
            try {
                RadioGroup rg1 = (RadioGroup) context.findViewById(R.id.labios_forma_radio_group);
                RadioGroup rg2 = (RadioGroup) context.findViewById(R.id.ojos_forma_radio_group);
                RadioGroup rg3 = (RadioGroup) context.findViewById(R.id.cara_forma_radio_group);

                if (rg1.getCheckedRadioButtonId() != -1 && rg2.getCheckedRadioButtonId() != -1 && rg3.getCheckedRadioButtonId() != -1){
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e){
                OpenAlertDialog(context, "Error", "Selecciona un elemento en cada grupo", "OK", null);
                return false;
            }
        } else{
                return false;
        }
    }
}
