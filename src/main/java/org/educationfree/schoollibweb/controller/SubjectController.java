package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.SubjectDto;
import org.educationfree.schoollibweb.model.catalog.Subject;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final CatalogService<Subject, SubjectDto> subjectService;

    @GetMapping
    public String showSubjectList(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "subject";
    }

    @GetMapping(value = "/{id}")
    public String showSubjectForm(Model model, @PathVariable Long id) {
        model.addAttribute("subject", subjectService.findById(id).orElseThrow());
        return "subject_form";
    }

    @PostMapping
    public String updateSubject(SubjectDto subject) {
        subjectService.save(subject);

        return "redirect:/subject";
    }

    @GetMapping("/new")
    public String addSubject(Model model) {
        SubjectDto subject = new SubjectDto();
        model.addAttribute("subject", subject);
        return "subject_form";
    }

    @GetMapping(value = "/delete/{id}") //TODO: DeleteMapping
    public String deleteSubject(@PathVariable Long id) {
        subjectService.setDeleted(id, true); //TODO: handle EntityNotFoundException
        return "redirect:/subject";
    }
}
