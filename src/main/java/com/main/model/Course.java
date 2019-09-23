package com.main.model;



import javax.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Course")
public class Course {
	
	@Id
    private String id;
    
	@NotEmpty
	private String idcourse;
	
	@NotEmpty
    private String coursename;
   
    @NotEmpty
    private String idteacher;
    
    @NotEmpty
    private String typeusu;
    
    @NotEmpty
    private String idstudent;
    
    @NotEmpty
    private String minstudent;
    
    @NotEmpty
    private String maxstudent;
    
   
   
  
   
   

}
