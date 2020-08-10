package main.main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "homePage";
    }

    @RequestMapping("/secured")
    @ResponseBody
    public String secured(){
        return "vehicle";
    }
}
