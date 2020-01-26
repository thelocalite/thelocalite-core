package core.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Test
 */
@RestController
@RequestMapping("/")
public class Test {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public String test() {
    return "{\"message\": \"Hello, World!\"}";
  }

}