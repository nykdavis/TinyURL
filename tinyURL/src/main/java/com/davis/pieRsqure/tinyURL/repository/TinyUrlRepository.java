package com.davis.pieRsqure.tinyURL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davis.pieRsqure.tinyURL.entity.URLEntity;

@Repository
public interface TinyUrlRepository extends JpaRepository<URLEntity, String>{

}
