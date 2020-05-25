package attractor.school.kz.lesson69.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class UserAdvice {

    @ModelAttribute(Constants.USER_ID)
    public List<String> getCartModel(HttpSession session) {
        var list = session.getAttribute(Constants.USER_ID);
        if (list == null) {
            session.setAttribute(Constants.USER_ID, new ArrayList<>());
        }
        return (List<String>) session.getAttribute(Constants.USER_ID);
    }

}
