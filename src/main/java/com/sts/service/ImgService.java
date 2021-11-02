package com.sts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.sts.model.Img; 
import com.sts.repository.ImgRepository;








@Service
public class ImgService {
	
	@Autowired
	private ImgRepository imgRepository;
	
	
	
	
	
	
	public Img saveImage(Img user) {
		imgRepository.save(user);
		return null;
	}
	
	
	public List<Img> getAllImg(){

		return imgRepository.findAll();
	}

	public Img getImgById(int id) {
		Optional<Img> user = imgRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	public void deleteImg(int id) {
		imgRepository.deleteById(id);
	}
}
