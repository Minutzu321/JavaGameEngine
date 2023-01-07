package me.seby.pew.engine;

import java.util.LinkedList;

import me.seby.pew.entitati.EntityA;
import me.seby.pew.entitati.EntityB;

public class Fizici {

	public static boolean colid(EntityA enta, LinkedList<EntityB> entb){
		for(int i =0;i<entb.size(); i++){
			if(enta.getArie().intersects(entb.get(i).getArie())){
				return true;
			}
		}
		return false;
	}
	
	public static boolean colid(EntityB entb, LinkedList<EntityA> enta){
		for(int i =0;i<enta.size(); i++){
			if(entb.getArie().intersects(enta.get(i).getArie())){
				return true;
			}
		}
		return false;
	}
	
}
