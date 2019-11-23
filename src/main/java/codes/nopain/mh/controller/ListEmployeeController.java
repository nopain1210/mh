package codes.nopain.mh.controller;

import codes.nopain.mh.database.Employee;
import codes.nopain.mh.database.EmployeeRepository;
import codes.nopain.mh.entity.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ListEmployeeController {
    private final EmployeeRepository repository;

    @GetMapping("/list")
    public String getMethod(ModelMap modelMap) {
        List<Employee> employeeList = repository.findAll();
        Map<String, Department> departmentMap = new HashMap<>();

        for (Employee employee : employeeList) {
            String departmentName = employee.getDepartment();
            Department department = departmentMap.get(departmentName);

            if (department == null) {
                department = new Department();
                departmentMap.put(departmentName, department);
            }

            department.getEmployeeList().add(employee);
        }

        for (Department department : departmentMap.values()) {
            List<Employee> employees = department.getEmployeeList();
            List<Employee> highestPayList = department.getHighestPayList();
            double highestPay = getHighestPay(department);

            for (Employee employee : employees) {
                if (employee.getPay() == highestPay) {
                    highestPayList.add(employee);
                }
            }
        }

        modelMap.addAttribute("departmentMap", departmentMap);
        return "list";
    }

    private double getHighestPay(Department department) {
        List<Employee> employees = department.getEmployeeList();
        double highestPay = employees.get(0).getPay();

        for (Employee employee : employees) {
            if (employee.getPay() > highestPay) {
                highestPay = employee.getPay();
            }
        }

        return highestPay;
    }
}
