package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.model.Developer;
import net.proselyte.springmvc.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeveloperController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/indexTask";//"/index";
    }
    @RequestMapping(value = "developer", method = RequestMethod.GET)
    public ModelAndView developer() {
        return new ModelAndView("developer", "command", new Developer());
    }

    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("mvc-dispatcher") Developer developer,
                             ModelMap model) {
        model.addAttribute("id", developer.getId());
        model.addAttribute("name", developer.getName());
        model.addAttribute("specilaty", developer.getSpecialty());
        model.addAttribute("experience", developer.getExperience());

        return "result";
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public ModelAndView task() {
        return new ModelAndView("task", "command", new Task());
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("mvc-dispatcher") Task task,
                             ModelMap model) {
        model.addAttribute("id", task.getId());
        model.addAttribute("name", task.getName());
        model.addAttribute("description", task.getDescription());

        return "resultTask";
    }
}
