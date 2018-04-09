package com.practice.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
public class Main {
	private  List<Men> mens;
	private  List<Women> womens;
	private  List<Men> unengaged;
	private  Map<Women,List<Men>> priorityf;
	private Map<Men,List<Women>> prioritym;
	private  Women w1,w2,w3,w4,w5;
	private  Map<Women,Men> pairs;
	
	public Map<Women, List<Men>> getPriorityf() {
		return priorityf;
	}
	public void setPriorityf(Map<Women, List<Men>> priorityf) {
		this.priorityf = priorityf;
	}
	public Map<Men, List<Women>> getPrioritym() {
		return prioritym;
	}
	public void setPrioritym(Map<Men, List<Women>> prioritym) {
		this.prioritym = prioritym;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.initializeList();
		m.matchingAlgorithm();
		//STarting the algorithm
		/*The algorithm aism at providing a stable soultion to the matching problem*/
		
	}
	 void initializeList(){
		mens = new ArrayList<Men>();
		womens = new ArrayList<Women>();
		w1 = new Women(25,"Carmella");
		w2 = new Women(28,"Gianna");
		w3 = new Women(29,"Eva");
		w4 = new Women(22,"Kate");
		w5 = new Women(26,"Kayden");
		womens.add(w1);
		womens.add(w2);
		womens.add(w3);
		womens.add(w4);
		womens.add(w5);
		mens.add(new Men(25,"Aatur"));
		mens.add(new Men(22,"John"));
		mens.add(new Men(30,"Piper"));
		mens.add(new Men(32,"Karry"));
		mens.add(new Men(29,"Nathan"));
		initializePriorities(womens,mens);
		unengaged = new ArrayList<Men>(mens);
		System.out.println("Initialization Done..");
	}
	/**
	 * @param wom
	 */
	 private void initializePriorities(List<Women> wom,List<Men> men){
		Iterator<Women> itrf = wom.iterator();
		Iterator<Men> itrm = men.iterator();
		priorityf = new HashMap<Women,List<Men>>();
		prioritym = new HashMap<Men,List<Women>>();
		Women x;
		Men y;
		while(itrf.hasNext()){
			x = itrf.next();
			Collections.shuffle(men);
			priorityf.put(x, men);
			System.out.println("The shuffled list for women"+x+" is: "+ priorityf.get(x).toString());
		}
		while(itrm.hasNext()){
			y = itrm.next();
			Collections.shuffle(wom);
			prioritym.put(y, wom);
			System.out.println("The Shuffled list for men "+y+"is: "+prioritym.get(y).toString());
		}
		
	}
	 
	 public Map<Women, Men> getPairs() {
		return pairs;
	}
	public void setPairs(Map<Women, Men> pairs) {
		this.pairs = pairs;
	}
	void matchingAlgorithm(){
		ListIterator<Men> litr = unengaged.listIterator();
		pairs = new HashMap<Women, Men>();
		while(litr.hasNext()){
			Men x = litr.next();
			ListIterator<Women> itrw = this.getPrioritym().get(x).listIterator();
			while(itrw.hasNext()){
				Women y = itrw.next();
				if(y.isEngaged()){
					Men curr = y.getCurrent();
					int curr_index = this.getPriorityf().get(y).indexOf(curr);
					int req_index = this.getPriorityf().get(y).indexOf(x);
					if(curr_index > req_index){
						y.setCurrent(x);
						itrw.set(y);
						pairs.replace(y, x);
						litr.add(curr);
					}
				}else{
					y.setEngaged(true);
					pairs.put(y,x);
					y.setCurrent(x);
					litr.remove();
					break;
				}
			}
			
			
		}
		Iterator<Women> f_pairs = pairs.keySet().iterator();
		
		while(f_pairs.hasNext()){
			Women f_w = f_pairs.next();
			System.out.println("The pairs are: "+f_w.getName()+",and "+pairs.get(f_w).getName());
			
		}
		
		
	 }

}
