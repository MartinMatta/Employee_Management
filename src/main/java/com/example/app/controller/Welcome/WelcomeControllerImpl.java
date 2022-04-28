package com.example.app.controller.Welcome;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class WelcomeControllerImpl implements WelcomeController {

    @Override
    public String showWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUserName());
        return "welcome";
    }

    @Override
    public String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

}
