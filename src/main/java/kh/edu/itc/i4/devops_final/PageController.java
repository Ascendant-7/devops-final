import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String welcome() {
        return "index"; // Looks for index.html in src/main/resources/templates/
    }
}
