package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class HomeController {
    @Autowired
    ReferenceRepository referenceRepository;
    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    ExperianceRepository experianceRepository;


    @Autowired
    SkillRepository skillRepository;

    @Autowired
    private UserService  userService;
    @Autowired
    SummaryRepository summaryRepository;

    @Autowired
    CoverRepository coverRepository;

    @RequestMapping("/")
    public String Resume(Model model){
        return "index";
    }

@RequestMapping(value="/register", method= RequestMethod.GET)
public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
}
@RequestMapping(value="/register", method=RequestMethod.POST)
public String ProcessRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
  model.addAttribute("user", user) ;
  if(result.hasErrors()){
      return "registration";}
      else {
          userService.saveUser(user);
          model.addAttribute(("message"), "User account successfully created");
      }
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
        return "returningpage";
    }
    @RequestMapping("/update/{id}")
    public String updateResume ( @PathVariable("id") long id, Model model){
        model.addAttribute("resume", resumeRepository.findOne(id));
        return "resumeform";
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
        return "returningpage";
    }
    @RequestMapping("/updateducation/{id}")
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
        return "returningpage";
    }

    @RequestMapping("/updatexperiance/{id}")
    public String updatExperiance ( @PathVariable("id") long id, Model model){
        model.addAttribute("experiance", experianceRepository.findOne(id));
        return "experianceform";}

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
        return "returningpage";
    }
    @RequestMapping("/updateskill/{id}")
    public String updateSummary (@PathVariable("id") long id, Model model){
        model.addAttribute("skill", skillRepository.findOne(id));
        return "skillform";
    }


    @GetMapping("/addreference")
    public String referenceForm(Model model){
        model.addAttribute("reference",new Reference());
        return "referenceform";
    }

    @PostMapping("/processreference")
    public String processReferenceForm(@Valid Reference reference, BindingResult result){
        if(result.hasErrors()){
            return "referenceform";
        }
        referenceRepository.save(reference);
        return "returningpage";
    }
    @RequestMapping("/updatereference/{id}")
    public String updateReference (@PathVariable("id") long id, Model model){
        model.addAttribute("reference", skillRepository.findOne(id));
        return "referenceform";
    }
   // @RequestMapping("/reference")
   // public String ShowReference(User user, Principal p, Model model){

       // model.addAttribute("references", referenceRepository.findAll());
       // return "showreference";
    //}



    @GetMapping("/addsummary")
    public String SummaryForm(Model model){
        model.addAttribute("summary",new Summary());
        return "summaryform";
    }

    @PostMapping("/processsummary")
    public String processSummaryForm(@Valid Summary summary, BindingResult result){
        if(result.hasErrors()){
            return "summaryform";
        }
        summaryRepository.save(summary);
        return "returningpage";
    }
    @RequestMapping("/updatesummary/{id}")
    public String updateSkill (@PathVariable("id") long id, Model model){
        model.addAttribute("summary", summaryRepository.findOne(id));
        return "summaryform";
    }

    @GetMapping("/addcover")
    public String CoverForm(Model model){
        model.addAttribute("cover",new Cover());
        return "coverform";
    }

    @PostMapping("/processcover")
    public String processCoverForm(@Valid Cover cover, BindingResult result){
        if(result.hasErrors()){
            return "coverform";
        }
        coverRepository.save(cover);
        return "returningpage";
    }

    @RequestMapping("/resume")
    public String ResumePage(Model model){
        model.addAttribute("resumes",resumeRepository.findAll());
        model.addAttribute("educations",educationRepository.findAll());
       model.addAttribute("experiances",experianceRepository.findAll());
        model.addAttribute("references",referenceRepository.findAll());
       model.addAttribute("skills", skillRepository.findAll());
       model.addAttribute("summaries", summaryRepository.findAll());
        model.addAttribute("covers", coverRepository.findAll());
        return "resume";
    }

@RequestMapping("/login")
    public String login(){
        return "login";
}
@RequestMapping("/secure")
    public String secure(){
        return "secure";
}
}