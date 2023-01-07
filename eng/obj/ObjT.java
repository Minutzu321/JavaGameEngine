package eng.obj;

public enum ObjT {
	FULGER("Fulger"),
	EFECT("Efect"),
	NORI("Nori"),
	PICATURA("Picatura");
	
	String t;
	ObjT(String s){
		t=s;
	}
	public String getStr(){
		return t;
	}
}
