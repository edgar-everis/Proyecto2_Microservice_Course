package com.main.serviceimplement;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.model.Course;

import com.main.repository.CourseRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CourseServiceImplTest {

    @Mock private CourseRepository repo;

    @InjectMocks private CourseServiceImpl service;
    
  @Test
  public void testCreateCourse() {
      Course course = new Course();
      course.setId("1");
      course.setIdcourse("C01");
      course.setCoursename("algoritmos");
      course.setIdteacher("PR01");
      course.setTypeusu("STU");
      course.setIdstudent("STU01");
      when(repo.save(course)).thenReturn(Mono.just(course));
      Mono<Course> actual = service.CreateCourse(course);
      assertResults(actual, course);
  }

  @Test
  public void testDeleteById() {
      Course course = new Course();
      course.setId("1");
      course.setIdcourse("C01");
      course.setCoursename("algoritmos");
      course.setIdteacher("PR01");
      course.setTypeusu("STU");
      course.setIdstudent("STU01");
      when(repo.delete(course)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindById() {
      Course course = new Course();
      course.setId("1");
      course.setIdcourse("C01");
      course.setCoursename("algoritmos");
      course.setIdteacher("PR01");
      course.setTypeusu("STU");
      course.setIdstudent("STU01");

      when(repo.findById("1")).thenReturn(Mono.just(course));
      Mono<Course> actual = service.findById("1");
      assertResults(actual, course);
      System.out.println(actual);
  }

  @Test
  public void testFindByIdcourse() {
      Course course = new Course();
      course.setId("1");
      course.setIdcourse("C01");
      course.setCoursename("algoritmos");
      course.setIdteacher("PR01");
      course.setTypeusu("STU");
      course.setIdstudent("STU01");

      when(repo.findByIdcourse("C01")).thenReturn(Flux.just(course));
      Flux <Course> actual = service.findByIdcourse("C01");
      assertResults(actual, course);
      System.out.println(actual);
  }

  @Test
  public void testGetAll() {
      Course list = new Course();
      list.setId("1");
      list.setIdcourse("C01");
      list.setCoursename("Algoritmos");
      list.setIdteacher("PR01");
      list.setTypeusu("STU");
      list.setIdstudent("STU01");
      when(service.GetAll()).thenReturn(Flux.just(list));
      Flux<Course> actual = service.GetAll();
      assertResults(actual, list);
  }
  private void assertResults(
	      Publisher<Course> publisher, Course... expectedProducts) {
	    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
	  }
}
