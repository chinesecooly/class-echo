package com.chinesecooly;


import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author eric.ning
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final StringBuilder ECHO_CLASS = new StringBuilder();

    public static void main(String[] args) {
        analyseRowType(String.class.getName())
                .map(Main::analyseModifier);
        LOGGER.info(ECHO_CLASS.toString());
    }

    private static Optional<String> analyseRowType(String fullClassName) {
        try {
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(fullClassName);
            if (clazz.isAnnotation()) {
                append("@interface");
                append(clazz.getSimpleName());
            }else if (clazz.isEnum()){
                append("enum");
                append(clazz.getSimpleName());
            }else if (clazz.isPrimitive()){
                append(clazz.getSimpleName());
                return Optional.empty();
            }else if (clazz.isArray()){
                append(clazz.getSimpleName());
                return Optional.empty();
            }else if (clazz.isInterface()){
                append("interface");
                append(clazz.getSimpleName());
            }else {
                append("class");
                append(clazz.getSimpleName());
            }
        } catch (ClassNotFoundException e) {
            LOGGER.info(e.getMessage());
        }
        return Optional.ofNullable(fullClassName);
    }

    private static StringBuilder analyseAnnotation() {
        return ECHO_CLASS;
    }

    private static Optional<String> analyseModifier(String fullClassName) {
        return Optional.of(fullClassName);
    }

    private static StringBuilder analyseSuperClass() {
        return ECHO_CLASS;
    }

    private static StringBuilder analyseSuperInterface() {
        return ECHO_CLASS;
    }

    private static StringBuilder analyseTypeParameter() {
        return ECHO_CLASS;
    }

    private static StringBuilder analyseField() {
        return ECHO_CLASS;
    }

    private static StringBuilder analyseConstructor() {
        return ECHO_CLASS;
    }

    private static StringBuilder analyseMethod() {
        return ECHO_CLASS;
    }

    private static void append(String content){
        ECHO_CLASS.append(content);
        ECHO_CLASS.append(" ");
    }
}
