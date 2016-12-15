package com.example.jondurao.flowersdream;

import java.io.Serializable;

/**
 * Created by jondurao on 7/11/16.
 */

public class ContactosDatabase implements Serializable{
    int _id;
    String _fecha, _nombre, _email, _movil, _casa, _trabajo, _turno, _metodoContacto, _direccion, _cumpleaños, _aniversario,
            _profesion, _tipoPiel, _mayorPreocupacion, _otrasPreocupaciones, _rutinaDiaria, _beneficioMascara, _tipoCobertura, _tonosMaquillaje,
            _colorPelo, _colorOjos, _formaLabios, _formaOjos, _formaCara, _saberMas;

    public ContactosDatabase(){

    }

    public ContactosDatabase(int id, String fecha, String nombre, String email, String movil, String casa, String trabajo, String turno, String metodoContacto,
                             String direccion, String cumpleaños, String aniversario, String profesion, String tipoPiel, String mayorPreocupacion,
                             String otrasPreocupaciones, String rutinaDiaria, String beneficioMascara, String tipoCobertura, String tonosMaquillaje,
                             String colorPelo, String colorOjos, String formaLabios, String formaOjos, String formaCara, String saberMas){
        this._id = id;
        this._fecha = fecha;
        this._nombre = nombre;
        this._email = email;
        this._movil = movil;
        this._casa = casa;
        this._trabajo = trabajo;
        this._turno = turno;
        this._metodoContacto = metodoContacto;
        this._direccion = direccion;
        this._cumpleaños = cumpleaños;
        this._aniversario = aniversario;
        this._profesion = profesion;
        this._tipoPiel = tipoPiel;
        this._mayorPreocupacion = mayorPreocupacion;
        this._otrasPreocupaciones = otrasPreocupaciones;
        this._rutinaDiaria = rutinaDiaria;
        this._beneficioMascara = beneficioMascara;
        this._tipoCobertura = tipoCobertura;
        this._tonosMaquillaje = tonosMaquillaje;
        this._colorPelo = colorPelo;
        this._colorOjos = colorOjos;
        this._formaLabios = formaLabios;
        this._formaOjos = formaOjos;
        this._formaCara = formaCara;
        this._saberMas = saberMas;
    }

    public int get_id(){
        return this._id;
    }

    public void set_id(int id){
        _id = id;
    }

    public String get_fecha(){
        return this._fecha;
    }

    public void set_fecha(String fecha){
        _fecha = fecha;
    }

    public String get_nombre(){
        return this._nombre;
    }

    public void set_nombre(String nombre){
        _nombre = nombre;
    }

    public String get_email(){
        return this._email;
    }

    public void set_email(String email){
        _email = email;
    }

    public String get_movil(){
        return this._movil;
    }

    public void set_movil(String movil){
        _movil = movil;
    }

    public String get_casa(){
        return this._casa;
    }

    public void set_casa(String casa){
        _casa = casa;
    }

    public String get_trabajo(){
        return this._trabajo;
    }

    public void set_trabajo(String trabajo){
        _trabajo = trabajo;
    }

    public String get_turno(){
        return this._turno;
    }

    public void set_turno(String turno){
        _turno = turno;
    }

    public String get_metodoContacto(){
        return this._metodoContacto;
    }

    public void set_metodoContacto(String metodoContacto){
        _metodoContacto = metodoContacto;
    }

    public String get_direccion(){
        return this._direccion;
    }

    public void set_direccion(String direccion) {_direccion = direccion;}

    public String get_cumpleaños() {return this._cumpleaños;}

    public void set_cumpleaños(String cumpleaños) {_cumpleaños = cumpleaños;}

    public String get_aniversario() {return this._aniversario;}

    public void set_aniversario(String aniversario) {_aniversario = aniversario;}

    public String get_profesion() {return this._profesion;}

    public void set_profesion(String profesion) {_profesion = profesion;}

    public String get_tipoPiel() {return this._tipoPiel;}

    public void set_tipoPiel(String tipoPiel) {_tipoPiel = tipoPiel;}

    public String get_mayorPreocupacion() {return this._mayorPreocupacion;}

    public void set_mayorPreocupacion(String mayorPreocupacion) {this._mayorPreocupacion = mayorPreocupacion;}

    public String get_otrasPreocupaciones() {return this._otrasPreocupaciones;}

    public void set_otrasPreocupaciones(String otrasPreocupaciones) { this._otrasPreocupaciones = otrasPreocupaciones;}

    public String get_rutinaDiaria() {return _rutinaDiaria;}

    public void set_rutinaDiaria(String _rutinaDiaria) {this._rutinaDiaria = _rutinaDiaria;}

    public String get_beneficioMascara() {return _beneficioMascara;}

    public void set_beneficioMascara(String _beneficioMascara) {this._beneficioMascara = _beneficioMascara;}

    public String get_tipoCobertura() {return _tipoCobertura;}

    public void set_tipoCobertura(String _tipoCobertura) {this._tipoCobertura = _tipoCobertura;}

    public String get_tonosMaquillaje() {return _tonosMaquillaje;}

    public void set_tonosMaquillaje(String _tonosMaquillaje) {this._tonosMaquillaje = _tonosMaquillaje;}

    public String get_colorPelo() {return _colorPelo;}

    public void set_colorPelo(String _colorPelo) {this._colorPelo = _colorPelo;}

    public String get_colorOjos() {return _colorOjos;}

    public void set_colorOjos(String _colorOjos) {this._colorOjos = _colorOjos;}

    public String get_formaLabios() {return _formaLabios;}

    public void set_formaLabios(String _formaLabios) {this._formaLabios = _formaLabios;}

    public String get_formaOjos() {return _formaOjos;}

    public void set_formaOjos(String _formaOjos) {this._formaOjos = _formaOjos;}

    public String get_formaCara() {return _formaCara;}

    public void set_formaCara(String _formaCara) {this._formaCara = _formaCara;}

    public String get_saberMas() {return _saberMas;}

    public void set_saberMas(String _saberMas) {this._saberMas = _saberMas;}
}
