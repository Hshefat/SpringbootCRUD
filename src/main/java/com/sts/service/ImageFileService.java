package com.sts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.sts.model.ImageFile; 
import com.sts.repository.ImageFileRepository;



@Service
public class ImageFileService {
	@Autowired
	private ImageFileRepository imageFileRepository;
	
	
	
	/*
	 * public void addImage (ImageFile img) {
	 * 
	 * imageFileRepository.save(img); }
	 */
	public ImageFile saveImage(ImageFile imageFile) {
		imageFileRepository.save(imageFile);
		return null;
	}
	
	
	public List<ImageFile> getAllImg(){

		return imageFileRepository.findAll();
	}

	public ImageFile getImgById(int id) {
		Optional<ImageFile> img = imageFileRepository.findById(id);
		if(img.isPresent()) {
			return img.get();
		}
		return null;
	}

	public void deleteImg(int id) {
		imageFileRepository.deleteById(id);
	}

	
}
