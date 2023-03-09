package com.example.springmodule;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import x1.lib1;

import java.util.ArrayList;

@RestController
public class HelloController {
    String nameall;
    @GetMapping("/greeting")
    public String greeting(@RequestParam("name") String name) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Vika");
        strings.add("Nazar");
        strings.add("Vlad");
        strings.add("Andea");


        if (!isValidNameFormat(name)) {
            throw new InvalidNameFormatException();
        }

        if (!strings.contains(name)) {
            return "Ім'я не знайдено у списку";
        }

        ArrayList<Character> charName = new ArrayList<>();
        for (char c : x1.lib1.charSearchInString(name)) {
            charName.add(c);
        }

        return "Привіт, " + name + "! Символи в імені: " + charName;
    }


    private boolean isValidNameFormat(String name) {
        char firstChar = name.charAt(0);
        if (!Character.isUpperCase(firstChar)) {
            return false;
        }
        for (int i = 1; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }

    @ControllerAdvice
    public class NameFormatAdvice {

        @ExceptionHandler(InvalidNameFormatException.class)
        public String handleInvalidNameFormat() {
            return "error";
        }
    }
    @GetMapping("/error")
    public String errPage(){
        return "error";
    }



    // Виняток для помилок у форматуванні імені
    public class InvalidNameFormatException extends RuntimeException {
    }

}



