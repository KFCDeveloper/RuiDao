package testspringannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestController {
	
	//we are sure, Spring uses Java Reflection mechanism to update its private field
	
	@Autowired
	private TestService testService;
	
	/*public void setTestService(TestService testService) {
		this.testService = testService;
	}*/
	
	public void outputcollaborators()
	{
		//invoke method the service
		testService.outputinfo();
	}

}
