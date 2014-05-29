package com.example.albumbrazil.models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Estampa> estampasPegadas;
	private ArrayList<Integer> misEstampas = new ArrayList<Integer>(){{ 
				add(1);
				add(2);
				add(5);
				add(15);
				add(30);
				add(31);
				add(9);
				add(16);
				add(20);
				add(24);
				}};
	private HashMap<Integer, Integer> repetidas; //id,numero de veces repetida con put lo actualizas put(id, get(id)+1)
	public static HashMap<Integer, String> catalogo = new HashMap<Integer, String>(){{
		put(1,"Casillas");
		put(2,"Schweinsteiger");
		put(3,"Xavi");
		put(4,"Iniesta");
		put(5,"Messi");
		put(6,"Hernandez");
		put(7,"Vanpersie");
		put(8,"Marquez");
		put(9,"Neymar");
		put(10,"Rooney");
		put(11,"Benzema");
		put(12,"Robben");
		put(13,"Ribery");
		put(14,"Eto");
		put(15, "Falcao");
		put(16, "Drogba");
		put(17, "Dempsey");
		put(18, "Lahm");
		put(19, "Ozil");
		put(20, "Suarez");
		put(21, "Aguero");
		put(22, "Peralta");
		put(23, "Cristiano");
		put(24, "Kaka");
		put(25, "Toure");
		put(26, "Balotelli");
		put(27, "Valencia");
		put(28, "Silva");
		put(29, "Sneijder");
		put(30, "Mandzukic");
		put(31, "Sanchez");
		put(32, "Nani");
		put(33, "Ramos");
		put(34, "Podolski");
		put(35, "Walcott");
		put(36, "Tevez");
		put(37, "Pato");
		put(38, "Gerrard");
		put(39, "Dimaria");
		put(40, "Kagawa");
		put(41, "Costa");
		put(42, "Neuer");
		put(43, "Shaarawy");
		put(44, "Modric");
		put(45, "Hulk");
		put(46, "Pirlo");
		put(47, "Cavani");
		put(48, "Gomez");
		put(49, "Gerdinand");
		put(50, "Luiz");
	}};
	
	
	
	public ArrayList<Estampa> getEstampas() {
		return estampasPegadas;
	}
	public void setEstampas(ArrayList<Estampa> estampas) {
		estampasPegadas = estampas;
	}
	public HashMap<Integer, Integer> getRepetidas() {
		return repetidas;
	}
	public void setRepetidas(HashMap<Integer, Integer> repetidas) {
		this.repetidas = repetidas;
	}
	public static HashMap<Integer, String> getCatalogo() {
		return catalogo;
	}
	
	public void shit(String s){
		System.out.println(s);
	}
	
	
	public ArrayList<Integer> getMisEstampas(){
		return misEstampas;
	}
	

	

}
