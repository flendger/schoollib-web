package org.educationfree.schoollibweb.controller;

import org.educationfree.schoollibweb.util.Error;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorsController implements ErrorController {

    @GetMapping("/error")
    public String renderErrorPage(HttpServletRequest httpRequest, Model model) {
        Error error = Error.getError(((int) httpRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)));

        model.addAttribute("errorCode", error.getErrorCode());
        model.addAttribute("errorMessage", error.getErrorMessage());

        return "error";
    }
}
