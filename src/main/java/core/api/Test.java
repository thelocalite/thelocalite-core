package core.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Test
 */
@RestController
@RequestMapping("/")
public class Test {

  @GetMapping("/test")
  public String test() {
    return "{\"message\": \"Hello, World!\"}";
  }

}