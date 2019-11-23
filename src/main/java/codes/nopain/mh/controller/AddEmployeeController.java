package codes.nopain.mh.controller;

import codes.nopain.mh.database.Employee;
import codes.nopain.mh.database.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AddEmployeeController {
    private final EmployeeRepository repository;

    @GetMapping(value = {"/", "/add"})
    public String getMethod(ModelMap model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("notification", "");
        return "add";
    }

    @PostMapping(value = {"/", "/add"})
    public String postMethod(@ModelAttribute Employee employee, Model model) {
        employee.setDepartment(employee.getDepartment().trim());
        employee.setPay(employee.getSalary() * employee.getCoe());
        repository.save(employee);

        model.addAttribute("employee", new Employee());
        model.addAttribute("notification", "success");
        return "add";
    }
}
