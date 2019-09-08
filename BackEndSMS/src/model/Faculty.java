package model;

/*
 * Each faculty member has their name,
 * campus address, and campus phone extension. 
 */

public class Faculty {

	// Attributes 

	String name;
	String address;
	int extension;

	public Faculty(String name, String address, int extension){

		this.name = name;
		this.address = address;
		this.extension = extension;

	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getExtension() {
		return extension;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}
	
	public String getDescription () {
		String result = "";
		
		result = "Faculty member " + this.name + " has campus address " + this.address + " and phone entension " + this.extension + ".";
		
		return result;
	}
}



