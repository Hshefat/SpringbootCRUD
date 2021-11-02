package com.sts.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.sts.model.ImageFile;
import com.sts.model.Img;
import com.sts.repository.ImageFileRepository;
import com.sts.repository.ImgRepository;
import com.sts.service.ImageFileService;

@Controller
public class ImgController {

	
	
	
	@GetMapping("/upload")
	public String imageFile() {
		return "upload";
	}
	
	
	
	
	
	 @Autowired private ImgRepository imgRepository;
	 @Autowired	private ImageFileService imageFileService;
	 
	 
	 
	    @PostMapping("/users/save")
	    public RedirectView saveUser(Img user,
	            @RequestParam("image") MultipartFile multipartFile) throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        user.setPhotos(fileName);
	         
	        Img savedUser = imgRepository.save(user);
	 
	        String uploadDir = "photos/" + savedUser.getId();
	 
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	         
	        return new RedirectView("/upload", true);
	    }
	    
	    
	    
	    
	    
}
