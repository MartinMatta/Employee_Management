package com.example.app.controller.Employee;

import com.example.app.domain.Employee;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface EmployeeController {

    @InitBinder
    void initBinder(WebDataBinder binder);

    @RequestMapping(value = "/list-employees", method = RequestMethod.GET)
    String showEmployee(ModelMap model);

    String getLoggedInUserName(ModelMap model);

    @RequestMapping(value = "/add-employee", method = RequestMethod.GET)
    String showAddEmployeePage(ModelMap model);

    @RequestMapping(value = "/delete-employee", method = RequestMethod.GET)
    String deleteEmployee(@RequestParam long id);

    @RequestMapping(value = "/update-employee", method = RequestMethod.GET)
    String showUpdateEmployeePage(@RequestParam long id, ModelMap model);

    @RequestMapping(value = "/update-employee", method = RequestMethod.POST)
    String updateEmployee(ModelMap model, @Valid Employee employee, BindingResult result);

    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    String addEmployee(ModelMap model, @Valid Employee employee, BindingResult result);

}
