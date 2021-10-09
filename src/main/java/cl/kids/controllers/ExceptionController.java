package cl.kids.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println(e);
    }
}
