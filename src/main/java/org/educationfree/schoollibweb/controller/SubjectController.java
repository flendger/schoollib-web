package org.educationfree.schoollibweb.controller;


import lombok.RequiredArgsConstructor;
import org.educationfree.schoollibweb.dto.SubjectDto;
import org.educationfree.schoollibweb.model.catalog.Subject;
import org.educationfree.schoollibweb.repository.catalog.model.SubjectRepository;
import org.educationfree.schoollibweb.service.catalog.CatalogService;
import org.educationfree.schoollibweb.service.catalog.SubjectServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final CatalogService<Subject, SubjectDto> subjectService;
    private final SubjectRepository subjectRepository;
    private final SubjectServiceImpl subjectServiceImpl;
    @GetMapping
    public String showSubjectList(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "subject";
    }
    @GetMapping("/filter")
    public String showSubjectList(Model model, @RequestParam(value = "name", required = false) String name) {
//        model.addAttribute("subjects", subjectServiceImpl.findSubjectByName(name));

        model.addAttribute("subjects", subjectServiceImpl.findSubjectByName(name));

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
