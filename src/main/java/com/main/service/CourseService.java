package com.main.service;

import com.main.model.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    Flux<Course> GetAll();

    Mono<Course> findById(String id);

    Mono<Course> CreateCourse(Course course);

    Mono<Course> ModifyCourse(String id,Course course);

    Mono<Void> DeleteById(String id);
}
