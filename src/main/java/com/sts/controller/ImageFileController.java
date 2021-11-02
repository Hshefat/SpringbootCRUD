package com.sts.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sts.model.ImageFile;
import com.sts.repository.ImageFileRepository;
import com.sts.service.ImageFileService;

 

@Controller
public class ImageFileController {
	
	
	@GetMapping("/image")
	public String imageFile() {
		return "imageFile";
	}
	
	 @Autowired private ImageFileRepository imageFileRepository;
	 @Autowired	private ImageFileService imageFileService;
	 
	 
	 
	 @PostMapping("/saveimage")
//	 @RequestMapping(value = "/saveimage", method = RequestMethod.POST)
	 public String saveImage(@ModelAttribute(name = "image_file") ImageFile imageFile, RedirectAttributes ra,
			 @RequestParam("image") MultipartFile multipartFile ) throws IOException {
		 
		 String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		 imageFile.setImage(fileName); 
		 ImageFile saveImage = imageFileService.saveImage(imageFile);
		 
		 String uploadDir = "/image/" + saveImage.getId();
		 Path uploadPath = Paths.get(uploadDir);
		 
		 if (!Files.exists(uploadPath)) {
			 Files.createDirectories(uploadPath);
		 }
		 
		 try (InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			
			System.out.println(filePath.toString());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception   e) {
			throw new IOException("Could not save" + fileName);
		}
		 ra.addFlashAttribute("message", "Saved successfully");
		 
		 
		 
		 return "redirect:/image";
	 }
	
}
