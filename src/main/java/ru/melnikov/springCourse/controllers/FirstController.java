package ru.melnikov.springCourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    /*@GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surName = request.getParameter("surname");

        System.out.println("Hello, " + name + " and " + surName);
        return "first/hello";
    }*/
    // 2-й способ получения параметров из реквеста если нужны только параметры, этот способ более короткий
    @GetMapping("/hello")
    public String helloPage(@RequestParam("name") String name,
                            @RequestParam("surname") String surName) {

        System.out.println("Hello, " + name + " " + surName);
        return "first/hello";
    }
    @GetMapping("/calc")
    public String calc(@RequestParam("a") int a, @RequestParam("b") int b,
                       @RequestParam("action") String action, Model model) {
        int result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        model.addAttribute("result", "Answer = " + result);

        return "first/calc";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodBye";
    }
}
