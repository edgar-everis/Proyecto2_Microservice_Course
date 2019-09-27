package com.main.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import com.main.model.Course;
import com.main.repository.CourseRepository;
import com.main.service.CourseService;
import org.springframework.stereotype.Service;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired private CourseRepository courserepo;

  @Override
  public Mono<Course> CreateCourse(Course course) {
    return courserepo.save(course);
  }

  @Override
  public Mono<Void> DeleteById(String id) {
    return courserepo.deleteById(id);
  }

  @Override
  public Mono<Course> findById(String id) {
    return courserepo.findById(id);
  }

  @Override
  public Flux<Course> findByIdcourse(String idcourse) {

    return courserepo.findByIdcourse(idcourse);
  }

  @Override
  public Flux<Course> GetAll() {
    return courserepo.findAll();
  }

  @Override
  public Mono<Course> ModifyCourse(String id, Course course) {
    course.setId(id);
    return courserepo.save(course);
  }

}
