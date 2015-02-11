package hello;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
	
	/* (non-Javadoc)
	 * @see hello.HelloService#doSomething()
	 */
	public void doSomething(){
		System.out.println("Hello spring");
	}
}
