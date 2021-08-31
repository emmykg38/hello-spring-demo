package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }


    // Handles requests of the form /hello?name=LaunchCode
    //added parameter model of type/class Model
    //created variable greeting, which is used by hello.html template to display the text
    /*added Model.addAttribute in order to implement the parameter, and named it variable = "greeting"
        and then next to it, added the parameter greeting which is the object which contains the value
        that the variable should have*/
    //returned "hello", with hello referring to the hello in the hello template(hello.html)
    //local variable (greeting) must match up with the second parameter in the addAttribute method
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }


   // Handles requests of the form /hello/LaunchCode
    //because it's the same view, we can use the same template
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Emily");
        names.add("Valerie");
        names.add("Krystal");
        names.add("Melanie");
        names.add("Mike");
        names.add("Ted");
        model.addAttribute("names", names);
        return "hello-list";
    }



}
