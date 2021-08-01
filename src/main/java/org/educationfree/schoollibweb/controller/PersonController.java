package org.educationfree.schoollibweb.controller;

import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.service.catalog.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @RequestMapping(value = "/person-list", method = RequestMethod.GET)
    public String showPersonList(Model model){
        List<Person> personList = personService.findAll();
        model.addAttribute("persons", personList);
        return "person";
    }

    @RequestMapping(value = "/person-edit/{id}", method = RequestMethod.GET)
    public String showPersonForm(Model model, @PathVariable Long id){
        Person person = personService.findById(id).orElseThrow();
        model.addAttribute("person", person);
        return "person-form";
    }
}
