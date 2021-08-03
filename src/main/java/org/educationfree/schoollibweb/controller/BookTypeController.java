package org.educationfree.schoollibweb.controller;

import org.educationfree.schoollibweb.model.catalog.BookType;
import org.educationfree.schoollibweb.model.catalog.Person;
import org.educationfree.schoollibweb.service.catalog.BookTypeServiceImpl;
import org.educationfree.schoollibweb.service.catalog.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookTypeController {
    @Autowired
    private BookTypeServiceImpl bookTypeService;

    @RequestMapping(value = "/booktypes", method = RequestMethod.GET)
    public String showBookTypeList(Model model){
        List<BookType> bookTypeList = bookTypeService.findAll();
        model.addAttribute("booktypes", bookTypeList);
        return "booktype";
    }

    @RequestMapping(value = "/booktype-edit/{id}", method = RequestMethod.GET)
    public String showBookTypeForm(Model model, @PathVariable Long id){
        BookType bookType = bookTypeService.findById(id).orElseThrow();
        model.addAttribute("booktype", bookType);
        return "booktype-form";
    }
}
