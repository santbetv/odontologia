package com.ceiba.cita.modelo.entidad;

import java.util.ArrayList;

public class Festivos {

	private int anio;
	private ArrayList<String> listaFestivos;

	public Festivos(int anio) {
		this.anio = anio;
		this.listaFestivos = new ArrayList<>();
		this.listaFestivos.add("1:1");
		this.listaFestivos.add("1:11");
		this.listaFestivos.add("3:22");
		this.listaFestivos.add("4:1");
		this.listaFestivos.add("4:2");
		this.listaFestivos.add("5:1");
		this.listaFestivos.add("5:17");
		this.listaFestivos.add("6:3");
		this.listaFestivos.add("6:14");
		this.listaFestivos.add("7:5");
		this.listaFestivos.add("7:20");
		this.listaFestivos.add("8:7");
		this.listaFestivos.add("8:16");
		this.listaFestivos.add("10:18");
		this.listaFestivos.add("11:15");
		this.listaFestivos.add("12:8");
		this.listaFestivos.add("12:25");
	}

	public boolean esFestivo(int month, int day) {
		return this.listaFestivos.contains(month + ":" + day);
	}

	public int anioEnFestivo() {
		return anio;
	}
}
