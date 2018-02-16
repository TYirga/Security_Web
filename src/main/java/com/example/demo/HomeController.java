package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    ExperianceRepository experianceRepository;


    @Autowired
    SkillRepository skillRepository;
    @RequestMapping("/")
    public String Resume(Model model){
        return "index";
    }

    @GetMapping("/add")
    public String contactForm(Model model){
        model.addAttribute("resume",new Resume());
        return "resumeform";
    }

    @PostMapping("/process")
    public String contactprocessForm(@Valid Resume resume, BindingResult result){
        if(result.hasErrors()){
            return "resumeform";
        }
        resumeRepository.save(resume);
        return "redirect:/";
    }
    @RequestMapping("/update/{id}")
    public String updateResume ( @PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "resumeForm";
    }
    @GetMapping("/addeducation")
    public String educationForm(Model model){
        model.addAttribute("education",new Education());
        return "educationform";
    }

    @PostMapping("/educationprocess")
    public String educationProcessForm(@Valid Education education, BindingResult result){
        if(result.hasErrors()){
            return "educationform";
        }
        educationRepository.save(education);
        return "redirect:/";
    }
    @RequestMapping("/updateeducation/{id}")
    public String updatEducation ( @PathVariable("id") long id, Model model){
        model.addAttribute("education", educationRepository.findOne(id));
        return "educationForm";
    }
    @GetMapping("/addexperiance")
    public String ExperianceForm(Model model){
        model.addAttribute("experiance",new Experiance());
        return "experianceform";
    }

    @PostMapping("/processexperiance")
    public String processExperianceForm(@Valid Experiance experiance, BindingResult result){
        if(result.hasErrors()){
            return "experianceform";
        }
        experianceRepository.save(experiance);
        return "redirect:/";
    }

    @GetMapping("/addskill")
    public String SkillForm(Model model){
        model.addAttribute("skill",new Skill());
        return "skillform";
    }

    @PostMapping("/processskill")
    public String processSkillForm(@Valid Skill skill, BindingResult result){
        if(result.hasErrors()){
            return "skillform";
        }
        skillRepository.save(skill);
        return "resume";
    }
    @RequestMapping("/updateskill/{id}")
    public String updateSkill (@PathVariable("id") long id, Model model){
        model.addAttribute("skill", skillRepository.findOne(id));
        return "skillForm";
    }
    @RequestMapping("/resume")
    public String ResumePage(Model model){

        model.addAttribute("resumes",resumeRepository.findAll());
        model.addAttribute("educations",educationRepository.findAll());
       model.addAttribute("experiances", experianceRepository.findAll());
       model.addAttribute("skills", skillRepository.findAll());
        return "resume";
    }


}