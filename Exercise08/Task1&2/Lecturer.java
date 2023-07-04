package Aufgabe1und2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Lecturer {
	
	private String firstName = "";
	private String lastName = "";
	
	public Lecturer() {
		super();
	}
	
	public Lecturer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(firstName);
		result.append(" ");
		result.append(lastName);
		return result.toString();
	}

	public void save (DataOutputStream dos) throws IOException {
		dos.writeUTF(firstName);
		dos.writeUTF(lastName);
	}

	public void load(DataInputStream dis) throws IOException {
		firstName = dis.readUTF();
		lastName = dis.readUTF();
	}

}
