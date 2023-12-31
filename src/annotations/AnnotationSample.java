package annotations;

import annotations.annotations.UserAnnotation;
import annotations.annotations.StringLengthCheckAnnotation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


public class AnnotationSample {
    // @UserAnnotation(idx = 0, name = "")  // '@UserAnnotation' not applicable to constructor
//    public Annotated(){}

    public static void main(String[] args) {
        System.out.println("------------------------------------------");
        Method[] methods = AnnotationSample.class.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println("---method---");
            UserAnnotation anno = method.getAnnotation(UserAnnotation.class);
            if (anno!=null && anno.annotationType()!=null) {
                System.out.printf("method %s is annotated as %s \n", method.getName(), anno.annotationType().getName());
                System.out.printf("idx is %d, name is %s\n", anno.idx(), anno.name());
            } else {
                System.out.printf("no annotation on method %s\n", method.getName());
            }
            System.out.println("---param---");
            Parameter[] params = method.getParameters();
            for (Parameter param:params) {
                StringLengthCheckAnnotation paramAnno = param.getAnnotation(StringLengthCheckAnnotation.class);
                if (paramAnno!=null) {
                    System.out.printf("param %s is annotated with %s\n", param, paramAnno.annotationType().getName());
                    System.out.printf("min is %d, max is %d\n", paramAnno.min(), paramAnno.max());
                } else {
                    System.out.printf("param %s is not annotated.\n", param);
                }
            }
            System.out.println("------------------------------------------");
        }
        annotatedMethod("validate this!", 1);
    }
    @UserAnnotation(idx = 0, name = "anonymous")
    public static void annotatedMethod(@StringLengthCheckAnnotation(min = 1, max = 10) String validateThisString, int noAnnoParam) {
        System.out.println(validateThisString);  // Validation logic is not implemented
        System.out.println(noAnnoParam);  // check for nothing
    }
}
