package com.maqcoding.sbmongoresponseexceptionerrorhandling.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Data
@AllArgsConstructor
@Document("student")
public class Student {

        @Id
        private int id;
        private String name;
        private String college;
        
       
        
        
       
}