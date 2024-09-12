package com.example.Voting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name="mat")
@Entity
public class Voting {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private int  vote;
	private int vott;
	
	public Voting()
	{
		
	}

	public Voting(int id, String name, int vote, int vott) {
		super();
		this.id = id;
		this.name = name;
		this.vote = vote;
		this.vott = vott;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public int getVott() {
		return vott;
	}

	public void setVott(int vott) {
		this.vott = vott;
	}

	
	@Override
	public String toString() {
		return "Voting [id=" + id + ", name=" + name + ", vote=" + vote + ", vott=" + vott + ", result=" + "]";
	}

	
	
	
	
}
