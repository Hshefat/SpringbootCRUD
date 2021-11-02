package com.sts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image_file")
public class ImageFile {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length =45, nullable= true )
	private String image;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ImageFile(int id, String image, String description) {
		 
		this.id = id;
		this.image = image;
		this.description = description;
	}
	public ImageFile() {
		 
	}
	@Override
	public String toString() {
		return "ImageFile [id=" + id + ", image=" + image + ", description=" + description + "]";
	}
	
	
	
}
