package com.medtronic.reqauth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medtronic.reqauth.models.Gender;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.parameters.P;
import org.springframework.test.web.servlet.MockMvc;

//https://stackabuse.com/guide-to-unit-testing-spring-boot-rest-apis/

@WebMvcTest(PhysicianController.class)
public class StudentControllerTest {
    MockMvc mockMvc;
    ObjectMapper mapper;

//    @MockBean
//    StudentRepository studentRepository;
//
//    Student RECORD_1 = new Student("Mark", "Jones", "mark.jones@amigoscode.edu", 21, Gender.MALE);
//    Student RECORD_2 = new Student("Maria", "Jones", "maria.jones@amigoscode.edu", 22, Gender.FEMALE);
//    Student RECORD_3 = new Student("Ahmed", "Ali", "ahmed.ali@amigoscode.edu", 18, Gender.MALE);

//    @Test
//    public void getAllRecords_success() throws Exception {
//        List<Student> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
//
//        Mockito.when(studentRepository.findAll()).thenReturn(records);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/v1/students")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect((ResultMatcher) jsonPath("$[2].firstName", is("Ahmed")));
//    }
//
//    @Test
//    public void getPatientById_success() throws Exception {
//        Mockito.when(studentRepository.findById(RECORD_1.getId())).thenReturn(java.util.Optional.of(RECORD_1));
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/api/v1/students/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect((ResultMatcher) jsonPath("$.name", is("Rayven Yor")));
//    }
}