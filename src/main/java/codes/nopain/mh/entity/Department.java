package codes.nopain.mh.entity;

import codes.nopain.mh.database.Employee;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Department {
    private List<Employee> employeeList = new ArrayList<>();
    private List<Employee> highestPayList = new ArrayList<>();
}
