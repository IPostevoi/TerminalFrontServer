package server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import server.CurrencyType;
import server.Operation;
import server.Orchestration;

/**
 * REST контроллеры приложения, отвечают за прием, отдачу данных на браузер
 *
 */
@Controller
public class FrontServerController {

    @Autowired
    private Orchestration orchestration;

//    @RequestMapping("/greeting")
//    public String greeting(@RequestParam(value="name") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(String pin) {
        if (orchestration.validatePin(pin)) {
            return "redirect:/main.html";
        }
        return "redirect:/pinInvalid.html";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

//    @RequestMapping(value = "/main", method = RequestMethod.POST)
//    public String chooseOperation(@RequestParam("name") String name) {
//        System.out.println(name);
//        return "main";
//    }

//    @RequestMapping("/pinInvalid")
//    public String pinInvalid() {
//        return "pinInvalid";
//    }

    @RequestMapping("/accountState")
    public String state() {
        return "accountState";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String put() {
        return "put";
    }

    @RequestMapping(value = "/put", method = RequestMethod.POST)
    public String putPost(String amount, Model model) {
        boolean success = orchestration.putCash("RUR", Double.parseDouble(amount));
        model.addAttribute("success", success);
        return "success";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw() {
        return "withdraw";
    }

//    @RequestMapping("/success")
//    public String success(String success, Model model) {
//        model.addAttribute("success", success);
//        return "success";
//    }

}