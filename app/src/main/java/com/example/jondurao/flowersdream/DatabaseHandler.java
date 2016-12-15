package com.example.jondurao.flowersdream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jondurao on 7/11/16.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 6;

    // Database Name
    private static final String DATABASE_NAME = "contactos";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    // Contacts Table Columns names
    public static final String TABLE_NAME = "Clientas";
    private static final String CLIENTA_ID = "id";
    public static final String CLIENTA_COLUMNA_FECHA = "ColumnaFecha";
    public static final String CLIENTA_COLUMNA_NOMBRE = "ColumnaNombre";
    public static final String CLIENTA_COLUMNA_CORREO = "ColumnaCorreo";
    public static final String CLIENTA_COLUMNA_MOVIL = "ColumnaMovil";
    public static final String CLIENTA_COLUMNA_CASA = "ColumnaCasa";
    public static final String CLIENTA_COLUMNA_TRABAJO = "ColumnaTrabajo";
    public static final String CLIENTA_COLUMNA_TURNO = "ColumnaTurno";
    public static final String CLIENTA_COLUMNA_METODO_CONTACTO = "ColumnaMetodoContacto";
    public static final String CLIENTA_COLUMNA_DIRECCION = "ColumnaDireccion";
    public static final String CLIENTA_COLUMNA_CUMPLEAÑOS = "ColumnaCumpleaños";
    public static final String CLIENTA_COLUMNA_ANIVERSARIO = "ColumnaAniversario";
    public static final String CLIENTA_COLUMNA_PROFESION = "ColumnaProfesion";
    public static final String CLIENTA_COLUMNA_TIPO_PIEL = "ColumnaTipoPiel";
    public static final String CLIENTA_COLUMNA_MAYOR_PREOCUPACION = "ColumnaMayorPreocupacion";
    public static final String CLIENTA_COLUMNA_OTRA_PREOCUPACION = "ColumnaOtraPreocupacion";
    public static final String CLIENTA_COLUMNA_RUTINA_DIARIA = "ColumnaRutinaDiaria";
    public static final String CLIENTA_COLUMNA_BENEFICIO_MASCARA = "ColumnaBeneficioMascara";
    public static final String CLIENTA_COLUMNA_TIPO_COBERTURA = "ColumnaTipoCobertura";
    public static final String CLIENTA_COLUMNA_TONOS_MAQUILLAJE = "ColumnaTonosMaquillaje";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    CLIENTA_ID + " INTEGER PRIMARY KEY," +
                    CLIENTA_COLUMNA_FECHA + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_NOMBRE + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_CORREO + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_MOVIL + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_CASA + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_TRABAJO + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_TURNO + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_METODO_CONTACTO + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_DIRECCION + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_CUMPLEAÑOS + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_ANIVERSARIO + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_PROFESION + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_TIPO_PIEL + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_MAYOR_PREOCUPACION + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_OTRA_PREOCUPACION + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_RUTINA_DIARIA + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_BENEFICIO_MASCARA + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_TIPO_COBERTURA + TEXT_TYPE + COMMA_SEP +
                    CLIENTA_COLUMNA_TONOS_MAQUILLAJE + TEXT_TYPE + " )";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {;
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addContact(ContactosDatabase contactos) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(CLIENTA_COLUMNA_FECHA, contactos.get_fecha());
        cv.put(CLIENTA_COLUMNA_NOMBRE, contactos.get_nombre());
        cv.put(CLIENTA_COLUMNA_CORREO, contactos.get_email());
        cv.put(CLIENTA_COLUMNA_MOVIL, contactos.get_movil());
        cv.put(CLIENTA_COLUMNA_CASA, contactos.get_casa());
        cv.put(CLIENTA_COLUMNA_TRABAJO, contactos.get_trabajo());
        cv.put(CLIENTA_COLUMNA_TURNO, contactos.get_turno());
        cv.put(CLIENTA_COLUMNA_METODO_CONTACTO, contactos.get_metodoContacto());
        cv.put(CLIENTA_COLUMNA_DIRECCION, contactos.get_direccion());
        cv.put(CLIENTA_COLUMNA_CUMPLEAÑOS, contactos.get_cumpleaños());
        cv.put(CLIENTA_COLUMNA_ANIVERSARIO, contactos.get_aniversario());
        cv.put(CLIENTA_COLUMNA_PROFESION, contactos.get_profesion());
        cv.put(CLIENTA_COLUMNA_TIPO_PIEL, contactos.get_tipoPiel());
        cv.put(CLIENTA_COLUMNA_MAYOR_PREOCUPACION, contactos.get_mayorPreocupacion());
        cv.put(CLIENTA_COLUMNA_OTRA_PREOCUPACION, contactos.get_otrasPreocupaciones());
        cv.put(CLIENTA_COLUMNA_RUTINA_DIARIA, contactos.get_rutinaDiaria());
        cv.put(CLIENTA_COLUMNA_BENEFICIO_MASCARA, contactos.get_beneficioMascara());
        cv.put(CLIENTA_COLUMNA_TIPO_PIEL, contactos.get_tipoPiel());
        cv.put(CLIENTA_COLUMNA_TONOS_MAQUILLAJE, contactos.get_tonosMaquillaje());

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }

    // Getting single contact
    public ContactosDatabase getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {CLIENTA_ID, CLIENTA_COLUMNA_FECHA,
                CLIENTA_COLUMNA_NOMBRE, CLIENTA_COLUMNA_CORREO, CLIENTA_COLUMNA_MOVIL, CLIENTA_COLUMNA_CASA,
                CLIENTA_COLUMNA_TRABAJO, CLIENTA_COLUMNA_TURNO, CLIENTA_COLUMNA_METODO_CONTACTO, CLIENTA_COLUMNA_DIRECCION,
                CLIENTA_COLUMNA_CUMPLEAÑOS, CLIENTA_COLUMNA_ANIVERSARIO, CLIENTA_COLUMNA_PROFESION, CLIENTA_COLUMNA_TIPO_PIEL,
                CLIENTA_COLUMNA_MAYOR_PREOCUPACION, CLIENTA_COLUMNA_OTRA_PREOCUPACION, CLIENTA_COLUMNA_RUTINA_DIARIA,
                CLIENTA_COLUMNA_BENEFICIO_MASCARA, CLIENTA_COLUMNA_TIPO_PIEL, CLIENTA_COLUMNA_TONOS_MAQUILLAJE}, CLIENTA_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        ContactosDatabase cd = new ContactosDatabase(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11),
                cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16),
                cursor.getString(17), cursor.getString(18), cursor.getString(19));
        return cd;
    }

    // Getting All Contacts
    public List<ContactosDatabase> getAllContacts() {
        List<ContactosDatabase> contactList = new ArrayList<ContactosDatabase>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ContactosDatabase contactos = new ContactosDatabase();
                contactos.set_id(Integer.parseInt(cursor.getString(0)));
                contactos.set_fecha(cursor.getString(1));
                contactos.set_nombre(cursor.getString(2));
                contactos.set_email(cursor.getString(3));
                contactos.set_movil(cursor.getString(4));
                contactos.set_casa(cursor.getString(5));
                contactos.set_trabajo(cursor.getString(6));
                contactos.set_turno(cursor.getString(7));
                contactos.set_metodoContacto(cursor.getString(8));
                contactos.set_direccion(cursor.getString(9));
                contactos.set_cumpleaños(cursor.getString(10));
                contactos.set_aniversario(cursor.getString(11));
                contactos.set_profesion(cursor.getString(12));
                contactos.set_tipoPiel(cursor.getString(13));
                contactos.set_mayorPreocupacion(cursor.getString(14));
                contactos.set_otrasPreocupaciones(cursor.getString(15));
                contactos.set_rutinaDiaria(cursor.getString(16));
                contactos.set_beneficioMascara(cursor.getString(17));
                contactos.set_tipoPiel(cursor.getString(18));
                contactos.set_tonosMaquillaje(cursor.getString(19));

                // Adding contact to list
                contactList.add(contactos);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;
    }

    // Updating single contact
    // public int updateContact(ContactosDatabase contactos) {}

    // Deleting single contact
    public void deleteContact(int position) {
        SQLiteDatabase db = this.getWritableDatabase();
        //db.delete(TABLE_NAME, CLIENTA_ID + " = ?",
        //        new String[] { String.valueOf(contactos.get_id()) });

        db.delete(TABLE_NAME, CLIENTA_ID + " = ?", new String[] {String.valueOf(position)});

        db.close();
    }
}
