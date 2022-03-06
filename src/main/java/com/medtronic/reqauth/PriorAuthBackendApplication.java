package com.medtronic.reqauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PriorAuthBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriorAuthBackendApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(StudentRepository studentRepository, TutorialRepository tutorialRepository) {
//
//		return args -> {
//
//			Tutorial tut1 = new Tutorial("Greggs Big Adventure", "Gregg goes trotting around the world", false);
//			Tutorial tut2 = new Tutorial("Toms Big Adventure", "Gregg goes trotting around the world", false);
//			Tutorial tut3 = new Tutorial("How to solve any puzzle", "Gregg goes trotting around the world", false);
//			Tutorial tut4 = new Tutorial("Learn C# in three easy steps", "Gregg goes trotting around the world", false);
//
//			Student mark = new Student("Mark", "Jones", "mark.jones@amigoscode.edu", 21, Gender.MALE);
//			Student maria = new Student("Maria", "Jones", "maria.jones@amigoscode.edu", 22, Gender.FEMALE);
//			Student ahmed = new Student("Ahmed", "Ali", "ahmed.ali@amigoscode.edu", 18, Gender.MALE);
//			Student joe = new Student("Joe", "Davault", "joe.davault@gmail.com", 18, Gender.MALE);
//
//			System.out.println("ADD TUTORIALS");
//			tutorialRepository.save(tut1);
//			tutorialRepository.save(tut2);
//			tutorialRepository.save(tut3);
//			tutorialRepository.save(tut4);
//
//			System.out.println("ADD TEST USERS TO DB");
//			studentRepository.save(mark);
//			studentRepository.save(maria);
//			studentRepository.save(ahmed);
//			studentRepository.save(joe);
//
//
//		};
//	}

}
