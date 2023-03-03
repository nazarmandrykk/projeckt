package com.example.springmodule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import x1.lib1;

import java.util.ArrayList;

@RestController
public class HelloController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Vika");
        strings.add("Nazar");
        strings.add("Vlad");
        strings.add("Andea");

        if (!strings.contains(name)) {
            return "Імя немає у списку ";
        }


        ArrayList charName = new ArrayList<>();

        if(name.equals("Nazar")) {
            for (char c : name.toCharArray()) {
                charName.add(c);
            }
        }else return "Це не наше імя";

        return "Привіт, " + name + " char :  " + charName.toString() ;
    }
}
