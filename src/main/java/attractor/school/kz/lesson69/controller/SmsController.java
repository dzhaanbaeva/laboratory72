package attractor.school.kz.lesson69.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
class SmsController {

    @GetMapping("/sms/add")
    public String cart(Model model, @SessionAttribute(name = Constants.USER_ID, required = false) List<String> sms) {
        if (sms != null) {
            model.addAttribute("cartItems", sms);
        }
        return "index";
    }

    // это метод для асинхронных запросов
    // демонстрация добавления в "корзину" через параметр @SessionAttribute cart_model
    @PostMapping("/sms/add")
    @ResponseBody
    public boolean addToListRest(@RequestParam String value, @SessionAttribute(name = Constants.USER_ID, required = false) List<String> sms) {
        if (sms != null) {
            sms.add(value);
        }

        return true;
    }


    @PostMapping("/sms/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.USER_ID);

        return "redirect:/sms";
    }


}
