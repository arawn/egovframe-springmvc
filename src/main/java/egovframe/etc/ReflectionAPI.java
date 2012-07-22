package egovframe.etc;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import egovframe.model.Board;

public class ReflectionAPI {

    public static void main(String[] args) {
        Class<?> clazz = Board.class;
        
        out.println("class: " + clazz.getName());
        
        for(Field field : clazz.getDeclaredFields())
            out.println("filed: " + field.getName());
        
        for(Method method : clazz.getDeclaredMethods())
            out.println("method: " + method.getName());
    }
    
}
