package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Teacher;
import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("teachers", teacherService.getAll());
        return "teachers-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("persons", personService.getAll());
        return "teacher-form";
    }


    @PostMapping
    public String save(@RequestParam("personId") Long personId,
                       @RequestParam("teacherCode") String teacherCode,
                       @RequestParam("proMajor") String proMajor) {
        Person person = personService.getEntityById(personId);
        if (person != null) {
            Teacher teacher = new Teacher();
            teacher.setPerson(person);
            teacher.setTeacherCode(teacherCode);
            teacher.setProMajor(proMajor);
            teacherService.save(teacher);
        }
        return "redirect:/teachers";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        teacherService.delete(id);
        return "redirect:/teachers";
    }
}
