package core.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.services.TestService;

@RestController
public class TestApi {

	@Autowired
	TestService testService;
	
	@RequestMapping("/")
	public void testCrud(){
		testService.testCrud();
	}
}
