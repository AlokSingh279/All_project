package com.sb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sb.entity.Student;
import com.sb.service.StudentService;
import com.sb.service.StudentServiceImpl;

@SpringBootApplication
public class MyBootCrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyBootCrudApplication.class, args);
		StudentService bean = context.getBean(StudentServiceImpl.class);

//	      Student st=new Student();
//	      st.setName("praveen SIngh");
//	      st.setCity("noida");
//	      st.setEmail("goldensingh2000@gmail.com");
//	      
//	      boolean status=true;
//	      boolean student = bean.addStudent(st);
//	      
//	       if(student!=false) {
//	    	   System.out.println("record inserted successfully");
//	       }else {
//	    	   System.out.println("record found some erroe");
//	       }

//		List<Student> list = bean.list();
//		list.forEach(e -> System.out.println(e));

//		Student student = bean.getStudentById(2L);
//		System.out.println(student);

//		Student stu = bean.getStudentById(2L);
//		stu.setCity("bhopal");
//		stu.setEmail("pankajsingh@gmail.com");
//		bean.updateStudent(stu, 2L);
		
		bean.deleteStudent(52L);

	}

}
