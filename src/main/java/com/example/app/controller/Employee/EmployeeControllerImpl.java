package com.example.app.controller.Employee;

import com.example.app.domain.Employee;
import com.example.app.service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeControllerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }

    @Override
    public String showEmployee(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("employees", employeeService.getEmployeeByName(name));
        return "list-employees";
    }

    @Override
    public String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @Override
    public String showAddEmployeePage(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @Override
    public String deleteEmployee(long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/list-employees";
    }

    @Override
    public String showUpdateEmployeePage(long id, ModelMap model) {
        Employee employee = employeeService.getEmployeeById(id).get();
        model.put("employee", employee);
        return "employee-update";
    }

    @Override
    public String updateEmployee(ModelMap model, Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "employee";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/list-employees";
    }

    @Override
    public String addEmployee(ModelMap model, Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "employee";
        }

        employee.setDate(new Date());
        employeeService.saveEmployee(employee);
        return "redirect:/list-employees";
    }

    @Override
    public String detailEmployee(ModelMap model, long id) {
        Employee employee = employeeService.getEmployeeById(id).get();
        model.put("employee", employee);
        return "employee-detail";
    }

}
