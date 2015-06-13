package org.gochev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//old school
		
//		LoginService ls = new LoginService();
//		boolean result = ls.login("4o4o", "go4o");
//		if(result){
//			System.out.println("wohooo");
//		}
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				"org.gochev");
		
		LoginService ls = context.getBean(LoginService.NAME, LoginService.class);
		boolean result = ls.login("4o4o", "go4o");
		if(result){
			System.out.println("wohooo");
		}
	}

}
