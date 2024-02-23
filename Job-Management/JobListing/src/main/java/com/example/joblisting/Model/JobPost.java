package com.example.joblisting.Model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;
//desc
//"Software engineer who can work on enterprise projects using spring boo…"
//exp
//1
//profile
//"developer"
//
//techs
//Array (5)


@Document(collection="JobPost")
public class JobPost 
{
	private String desc;
	private int exp;
	private String profile;
	private String techs[];
	
	//constructor
	public JobPost() {
		super();
		
	}

	//getters and setters
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String[] getTechs() {
		return techs;
	}
	public void setTechs(String[] techs) {
		this.techs = techs;
	}

	//tostring
	@Override
	public String toString() {
		return "JobPost [desc=" + desc + ", exp=" + exp + ", profile=" + profile + ", techs=" + Arrays.toString(techs)
				+ "]";
	}
	
	
}
