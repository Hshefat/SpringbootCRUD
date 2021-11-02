package com.sts.model;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "users")
public class Img {
	@Column(nullable = true, length = 64)
    private String photos;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	 
 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Img(int id) {
		super();
		this.id = id;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Img(String photos) {
		super();
		this.photos = photos;
	}

	public Img() {
		super();
	}
	
	
	
	
	
	
	
	 @Transient
	    public String getPhotosImagePath() {
	        if (photos == null  ) return null;
	         
	        return "/user-photos/" + id + "/" + photos;
	    }
	 
	 
	 
	
}
