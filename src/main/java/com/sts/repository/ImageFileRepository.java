package com.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.model.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile, Integer> {

}
