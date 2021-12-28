package com.maqcoding.sbmongoresponseexceptionerrorhandling.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maqcoding.sbmongoresponseexceptionerrorhandling.model.Products;
import com.maqcoding.sbmongoresponseexceptionerrorhandling.model.Student;
import com.maqcoding.sbmongoresponseexceptionerrorhandling.repo.ProductRepo;
import com.maqcoding.sbmongoresponseexceptionerrorhandling.repo.StudentRepo;
import com.maqcoding.sbmongoresponseexceptionerrorhandling.response.ApiResponse;
import com.maqcoding.sbmongoresponseexceptionerrorhandling.response.StudentNotFoundException;
import com.maqcoding.sbmongoresponseexceptionerrorhandling.response.StudentsData;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	

	
	@GetMapping("/list")
	public ResponseEntity getAllStudent() {
		
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setError("");
		apiResponse.setStatus(400);
		StudentsData studentsData = new  StudentsData();
		studentsData.setStudents(this.studentRepo.findAll());
		apiResponse.setData(studentsData);
		
		return ResponseEntity.status(200).body(apiResponse);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudent(@PathVariable final int id ) throws Exception {
		
		ApiResponse apiResponse=new ApiResponse();
		StudentsData studentsData = new  StudentsData();
		Optional<Student> student = this.studentRepo.findById(id);
		
		if (student.isPresent()) {
			studentsData.setStudents(student);
			apiResponse.setStatus(200);
		}else {
			throw new StudentNotFoundException(400,""+id+" not found");
		}
		
		apiResponse.setData(studentsData);
		
		return  ResponseEntity.status(200).body(apiResponse);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> deleteStudent(@RequestBody Student student) {
		//List<Products> products = student.getProducts();
		//products.forEach(products1-> productRepo.save(products1));
		
		return ResponseEntity.ok(this.studentRepo.save(student));
		
	}
	
	@PostMapping("/update1")
	public ResponseEntity<?> updStudent(@RequestBody Products products) {
		Student student =  products.getStudent();
		this.studentRepo.save(student);
		
		return ResponseEntity.ok(this.productRepo.save(products));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable final int id) {
        this.studentRepo.deleteById(id);		
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<?> getStudentByCity(@PathVariable final String city ) {
		return ResponseEntity.ok(this.studentRepo.findByCity(city));
		
	}
	
	@GetMapping("/product/{name}")
	public ResponseEntity<?> getStudentByProductName(@PathVariable final String name ) {
		return ResponseEntity.ok(this.studentRepo.findByProductName(name));
		
	}
	
	
	
	
}
