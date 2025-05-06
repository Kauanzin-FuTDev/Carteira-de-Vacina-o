package com.dashflow.Domain.Entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hospital")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
}
