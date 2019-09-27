package com.main.model;



import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Course")
public class Course {

  @NotEmpty private String coursename;

  @Id private String id;

  @NotEmpty private String idcourse;

  @NotEmpty private String idstudent;

  @NotEmpty private String idteacher;

  @NotEmpty private String maxstudent;

  @NotEmpty private String minstudent;
  
 

  @NotEmpty private String typeusu;
  

}
