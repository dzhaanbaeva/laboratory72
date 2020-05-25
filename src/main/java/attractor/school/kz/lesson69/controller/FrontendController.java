package attractor.school.kz.lesson69.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
class FrontendController {

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        var map = new HashMap<String, Object>();
        map.put("Идентификатор сессии", session.getId());

        session.getAttributeNames()
                .asIterator()
                .forEachRemaining(key -> map.put(key, session.getAttribute(key).toString()));

        model.addAttribute("sessionAttributes", map);
        return "index";
    }


}
