package com.example.springmodule;
import org.springframework.web.bind.annotation.*;


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

    @ExceptionHandler(NameError.class) //а тут воно якби паше,коли дійсно не проходить 'валідацію',але замість того щоб виводити 'ерор' виводить дещо інше
    public String handlerInvalidName() {
        return "error";
    }
}


 class NameError extends RuntimeException {
}



