package com.maqcoding.sbmongoresponseexceptionerrorhandling.model;

import java.util.List;

import javax.annotation.security.DenyAll;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("products")
public class Products {

	@Id
	private String name;
	private int quantity;
	private int price;
	
	 @Field("student_id")
	 @DocumentReference
     private Student student;
	
	
}
