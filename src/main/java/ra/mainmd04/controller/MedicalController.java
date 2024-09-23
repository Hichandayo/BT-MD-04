package ra.mainmd04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.mainmd04.dao.IMedical;
import ra.mainmd04.dao.MedicalDaoImpl;
import ra.mainmd04.model.Medical;

import java.util.List;

@Controller
@RequestMapping("/medical")
public class MedicalController {
    private IMedical medicalDao = new MedicalDaoImpl();

    @GetMapping
    public String showForm(Model model) {
        List<Medical> medical = medicalDao.getAll();
        model.addAttribute("medicalForm", medical);
        return "medical-form";
    }

    @GetMapping("/medical-update/{id}")
    public String updateMedical(@PathVariable int id, Model model) {
        Medical medical = medicalDao.findById(id);
        model.addAttribute("medical", medical);
        return "medical-from-update";
    }

    @PostMapping("/medical-update")
    public String updateMedicalString(@ModelAttribute("medical") Medical medical) {
        medicalDao.update(medical);
        return "redirect:/medical";
    }
}