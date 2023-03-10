package com.example.springmodule;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;

@RestController
@Api(description = "testAPI")
public class HelloController {
    String nameall;
    @GetMapping("/greeting")
    @ApiOperation("FinalMethod")
    public String greeting(@RequestParam("name") String name) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Vika");
        strings.add("Nazar");
        strings.add("Vlad");
        strings.add("Andea");


        if (!ValidNameOrNot(name)) {
            throw new NameError(); //тут ми створюєм нову помилку
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

    @ApiOperation("CheckValid")
    private boolean ValidNameOrNot(String name) {
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
}

@ControllerAdvice
 class NameFormatAdvice {

    @ExceptionHandler(NameError.class)
    @ApiOperation("ErrorMethod")
    public ModelAndView handleException(NameError ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

      /*

    @ExceptionHandler(NameError.class)
    public String handleException(NameError ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

     */
}
 class NameError extends RuntimeException {
}



