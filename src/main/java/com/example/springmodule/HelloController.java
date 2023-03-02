package com.example.springmodule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import x1.lib1;

import java.util.ArrayList;

@RestController
public class HelloController {
    void showHello(){
        System.out.println("hello");
    }
    @GetMapping("/")
    public ArrayList<Character> index(Model model ) {
        model.addAttribute("title","hello");
        ArrayList a1 = new ArrayList<>();
        a1.add("Nazar");
        ArrayList<Character> newchar2 = new ArrayList<>();
        newchar2 = lib1.charSearch(a1);
        return newchar2;
    }
}
