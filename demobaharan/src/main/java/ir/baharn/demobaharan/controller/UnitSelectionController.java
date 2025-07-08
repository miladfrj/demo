package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Student;
import ir.baharn.demobaharan.model.UnitSelection;
import ir.baharn.demobaharan.service.CourseService;
import ir.baharn.demobaharan.service.StudentService;
import ir.baharn.demobaharan.service.UnitSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/unit-selection")
public class UnitSelectionController {

    @Autowired
    private UnitSelectionService unitSelectionService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showSelectionForm(Model model) {
        List<Student> students = studentService.getAll();
        if(students.isEmpty()){
            return "redirect:/students/new";
        }
        Student student = students.get(0);

        model.addAttribute("student", student);
        model.addAttribute("courses", courseService.getAll());
        model.addAttribute("unitSelection", new UnitSelection());
        return "unit-selection-form";
    }

    @PostMapping
    public String selectUnit(@ModelAttribute UnitSelection unitSelection) {
        unitSelectionService.save(unitSelection);
        return "redirect:/unit-selection";
    }
}