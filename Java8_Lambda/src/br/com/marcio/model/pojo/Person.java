package br.com.marcio.model.pojo;

import java.io.Serializable;
import java.util.List;

import br.com.marcio.model.enums.GenreEnum;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private String profession;
	private Adress adress;
	private List<Phone> phoneContact;
	private GenreEnum genre;

	public Person(String name, int age, GenreEnum genre) {
		super();
		this.name = name;
		this.age = age;
		this.genre = genre;
	}

	public Person(String name, int age, String profession) {
		super();
		this.name = name;
		this.age = age;
		this.profession = profession;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Phone> getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(List<Phone> phoneContact) {
		this.phoneContact = phoneContact;
	}

	public GenreEnum getGenre() {
		return genre;
	}

	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}
}
