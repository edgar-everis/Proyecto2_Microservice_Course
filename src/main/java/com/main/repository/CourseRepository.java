package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.main.model.Course;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String> {

  Flux<Course> findByIdcourse(String idcourse);
  
  

}
