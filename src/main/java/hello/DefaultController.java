package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller
 */
@RestController
public class DefaultController {

    private static final Logger log = LoggerFactory.getLogger(DefaultController.class);

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/")
    public String home(){
        return "It's home!";
    }

    @RequestMapping("/customers")
    public Iterable<Customer> customers() {
        return repository.findAll();
    }

}
