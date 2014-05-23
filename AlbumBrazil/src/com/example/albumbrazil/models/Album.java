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
	private HashMap<Integer, Integer> repetidas; //id,numero de veces repetida con put lo actualizas put(id, get(id)+1)
	public static HashMap<Integer, String> catalogo = new HashMap<Integer, String>(){{
		put(1,"Iker Casillas");
		put(2,"Bastian Schweinsteiger");
		put(3,"Xavi");
		put(4,"Andres Iniesta");
		put(5,"Lionel Mesi");
		put(6,"Javier Hernandez");
		put(7,"Robin VanPersie");
		put(8,"Rafael Marquez");
		put(9,"Neymar");
		put(10,"Wayne Rooney");
		put(11,"Karim Benzama");
		put(12,"Arjen Robben");
		put(13,"Fran Ribery");
		put(14,"Samuel Eto'o");
		put(15, "Radamel Falcao");
		put(16, "Didier Drogba");
		put(17, "Clint Dempsey");
		put(18, "Philipp Lahm");
		put(19, "Mesut Özil");
		put(20, "Luis Suárez");
		put(21, "Segio Agüero");
		put(22, "Oribe Peralta");
		put(23, "Cristiano Ronaldo");
		put(24, "Kaká");
		put(25, "Yaya Touré");
		put(26, "Mario Balotelli");
		put(27, "Antonio Valencia");
		put(28, "Thiago Silva");
		put(29, "Wesley Sneijder");
		put(30, "Mario Mandzukic");
		put(31, "Alexis Sánchez");
		put(32, "Nani");
		put(33, "Sergio Ramos");
		put(34, "Lukas Podolski");
		put(35, "Theo Walcott");
		put(36, "Carlos Tévez");
		put(37, "Alexandre Pato");
		put(38, "Steven Gerrard");
		put(39, "Ángel Di María");
		put(40, "Shinji Kagawa");
		put(41, "Diego Costa");
		put(42, "Manuel Neuer");
		put(43, "Stephan El Shaarawy");
		put(44, "Luka Modric");
		put(45, "Hulk");
		put(46, "Andrea Pirlo");
		put(47, "Edinson Cavani");
		put(48, "Mario Gómez");
		put(49, "Rio Ferdinand");
		put(50, "David Luiz");
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
	
	
	
	

	

}
