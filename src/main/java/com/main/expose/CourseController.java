package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Course;
import com.main.service.CourseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("API/Course")
public class CourseController {

  @Autowired private CourseService service;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono <Course> CreateCourse(@RequestBody Course course) {
   
      return  service.CreateCourse(course);
	   
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteCourse(@PathVariable String id) {
    return service.DeleteById(id);
  }

  @GetMapping("/findcourse/{idcourse}")
  public Flux<Course> findByIdcourse(@PathVariable String idcourse) {
    return service.findByIdcourse(idcourse);
  }

  @GetMapping
  public Flux<Course> Getall() {
    return service.GetAll();
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
    return service.ModifyCourse(id, course);
  }
}
