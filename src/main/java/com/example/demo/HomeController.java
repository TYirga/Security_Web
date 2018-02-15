package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    ResumeRepository resumeRepository;

//@RequestMapping("/")
//public String mainPage(){
  // return "index";
//}

    @RequestMapping("/")
    public String resumeList(Model model){
        model.addAttribute("resumes", resumeRepository.findAll());

        return "list";
    }


    @GetMapping("/add")
    public String ResumeForm(Model model){
        model.addAttribute("resume", new Resume());
    return "resumeForm";}



   // @GetMapping("/resumeform")
    //public String loadFormPage(Model model) {
       // model.addAttribute("resume", new Resume());
        //return "resumeform";}


    @PostMapping("/process")
    public String loadFromPage(@Valid @ModelAttribute("resume") Resume resume, BindingResult result) {
        if (result.hasErrors()) {
            return "resumeform";
        }
        resumeRepository.save(resume);
        return "redirect:/";}


        @RequestMapping("/detail/{id}")
        public String ShowResume ( @PathVariable("id") long id, Model model){
            model.addAttribute("resume", resumeRepository.findOne(id));
            return "detail";
        }

    @RequestMapping("/update/{id}")
    public String updateResume ( @PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "resumeForm";
    }

}




