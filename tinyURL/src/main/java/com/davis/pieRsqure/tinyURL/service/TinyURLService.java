package com.davis.pieRsqure.tinyURL.service;

import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davis.pieRsqure.tinyURL.entity.URLEntity;
import com.davis.pieRsqure.tinyURL.repository.TinyUrlRepository;

@Service
public class TinyURLService {

//	@Autowired
//	private URLEntity urlEntity;

	@Autowired
	private TinyUrlRepository tinyUrlRepository;

	private static String DOMAIN_NAME = "https://www.davis.com/";

	public String generateTinyURL(String originalUrl) {

		String uniqueIdentifier = Integer.toHexString(originalUrl.hashCode());
		String shortenedURL = generateShortenedURL(uniqueIdentifier);
		tinyUrlRepository.save(createUrlEntity(uniqueIdentifier, originalUrl, shortenedURL));
		return shortenedURL;

	}

	public static URLEntity createUrlEntity(String uniqueIdentifier, String originalUrl, String shortenedUrl) {
		URLEntity urlEntity = new URLEntity();
		urlEntity.setId(uniqueIdentifier);
		urlEntity.setOriginalUrl(originalUrl);
		urlEntity.setShortenUrl(shortenedUrl);
		urlEntity.setCreatedDate(LocalDateTime.now());
		urlEntity.setExpiryDate(calculateExpiryDate());
		return urlEntity;
	}

	private static LocalDateTime calculateExpiryDate() {
		return LocalDateTime.now().plusDays(10);
	}

	public static String generateShortenedURL(String uniqueIdentifier) {
		String encoding = Base64.getUrlEncoder().encodeToString(uniqueIdentifier.getBytes());
		return DOMAIN_NAME.concat(encoding);
	}

}
