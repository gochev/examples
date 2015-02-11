package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtherServiceImpl implements OtherService {
	
		@Autowired
		private HelloService helloService;
	
		/* (non-Javadoc)
		 * @see hello.OtherService#otherMethod()
		 */
		public void otherMethod(){
			System.out.println("I am in otherService");
			helloService.doSomething();
		}
}	
