package com.main.service;

import com.main.model.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

 
  Mono <Course> CreateCourse(Course course);

  Mono<Void> DeleteById(String id);

  Mono<Course> findById(String id);

  Flux<Course> findByIdcourse(String idcourse);

  Flux<Course> GetAll();

  Mono<Course> ModifyCourse(String id, Course course);
}
