package ma.neoxia.message.actions;

public class Value {
private String code;
private String libelle;



public Value(String code, String libelle) {
	super();
	this.code = code;
	this.libelle = libelle;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

public Value(){}


}
