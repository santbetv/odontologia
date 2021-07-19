package com.ceiba.cita.modelo.entidad;

import java.util.ArrayList;

public class Festivos {

	
	private int anio;

	private ArrayList<String> festivos;


    public Festivos(int anio) {
        this.anio = anio;
        this.festivos = new ArrayList<>();
        this.festivos.add("1:1");               // Primero de Enero
        this.festivos.add("1:11");               // Primero de Enero
        this.festivos.add("3:22");               // Primero de Enero
        this.festivos.add("4:1");               // Primero de Enero
        this.festivos.add("4:2");               // Primero de Enero
        this.festivos.add("5:1");               // Dia del trabajo 1 de mayo
        this.festivos.add("5:17");               // Dia del trabajo 1 de mayo
        this.festivos.add("6:3");               // Dia del trabajo 1 de mayo
        this.festivos.add("6:14");               // Dia del trabajo 1 de mayo
        this.festivos.add("7:5");              //Independencia 20 de Julio
        this.festivos.add("7:20");              //Independencia 20 de Julio
        this.festivos.add("8:7");               //Batalla de boyaca 7 de agosto
        this.festivos.add("8:16");               //Batalla de boyaca 7 de agosto
        this.festivos.add("10:18");               //Batalla de boyaca 7 de agosto
        this.festivos.add("11:15");               //Batalla de boyaca 7 de agosto
        this.festivos.add("12:8");              //Maria inmaculada 8 de diciembre
        this.festivos.add("12:25");             //Navidad 25 de diciembre

    }


	public boolean esFestivo(int month, int day) {
		return this.festivos.contains(month + ":" + day);
	}


	public int anioEnFestivo() {
		return anio;
	}

	
}
