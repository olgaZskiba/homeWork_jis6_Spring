package io.github.olgazskiba.lectureSpring;

import io.github.olgazskiba.lectureSpring.mySpring.MyContext;
import io.github.olgazskiba.lectureSpring.mySpring.bean.Humanable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LectureSpringApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LectureSpringApplication.class, args);

		Humanable human1 = MyContext.getHuman("SuperHuman");
		Humanable human2 = MyContext.getHuman("Oleg");

//		human1.speak();
//		human2.speak();
	}

}
