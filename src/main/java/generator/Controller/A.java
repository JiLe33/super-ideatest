package generator.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class A {

    @RequestMapping("/loginhtml")
    public String login(){
        return  "redirect:/backend/login.html";
    }


}
