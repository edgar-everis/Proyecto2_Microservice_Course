package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.main.model.Course;

public interface CourseRepository extends ReactiveMongoRepository<Course, String>{

}
