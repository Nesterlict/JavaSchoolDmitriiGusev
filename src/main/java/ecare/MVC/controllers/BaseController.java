package ecare.MVC.controllers;

import ecare.MVC.entities.Options;
import ecare.services.api.OptionsService;
import ecare.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BaseController {

    @Autowired
    OptionsService optionsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView baseController() {
        List<Options> options = optionsService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("proto");
        modelAndView.addObject("optionList",options);
        return modelAndView;
    }
}
