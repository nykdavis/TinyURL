package com.davis.pieRsqure.tinyURL.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TinyURL_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class URLEntity {
	
	    @Id
	    private String id;

	    @Column(name = "original_url", nullable = false)
	    private String originalUrl;

	    @Column(name = "shorten_url", nullable = false)
	    private String shortenUrl;

	    @Column(name = "created_date", nullable = false)
	    private LocalDateTime createdDate;

	    @Column(name = "expiry_date")
	    private LocalDateTime expiryDate;

}
