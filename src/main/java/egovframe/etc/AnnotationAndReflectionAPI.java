package egovframe.etc;

import static java.lang.System.out;

import org.springframework.stereotype.Controller;

public class AnnotationAndReflectionAPI {
    
    public static void main(String[] args) {
        Class<?> clazz = EgovController.class;
        
        String value = clazz.getAnnotation(Controller.class).value();
        
        out.println("Controller Name: " + value);
    }
    
    @Controller("egovCtrl")
    class EgovController { }
    
}
