package edu.school21;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class Program {
    private static final Class user = User.class;
    private static final Class car = Car.class;
    private static Object object;
    private static Class selectedClass = Program.class;
    private static final int fieldsCount = selectedClass.getDeclaredFields().length;
    private static int methodsCount = selectedClass.getDeclaredMethods().length;
    private static final String DELIMITER = "---------------------";

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.print("Classes:\n" + "User\nCar\n" + DELIMITER + "\nEnter class name:\n  ");
        while (selectedClass.getName().equals("edu.school21.".concat("Program"))) {
            selectedClass = selectedClass();

        }
        aboutClass();
        classConstructor();
        changeField();
        callMethod();
    }

    private static void aboutClass() {
        System.out.println("fields :");
        Field[] fields = selectedClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("    " + field.getType().getSimpleName() + " " + field.getName());
        }
        System.out.println("methods:");
        Method[] methods = selectedClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder stringTypes = new StringBuilder();
            Type[] types = method.getParameterTypes();
            for (Type type : types) {
                if (type.getTypeName().startsWith("java.lang")) {
                    stringTypes.append(type.getTypeName().substring(10));
                } else {
                    stringTypes.append(type.getTypeName());
                }
                stringTypes.append(" ");
            }
            if (stringTypes.length() > 0) {
                stringTypes.setCharAt(stringTypes.length() - 1, ')');
            } else {
                stringTypes.append(")");
            }
            System.out.println("    " + method.getReturnType().getSimpleName() + " " + method.getName() + "(" + stringTypes);
        }
    }

    private static void classConstructor() {
        System.out.println(DELIMITER);
        System.out.println("Let's create an object.");
        try {
            Scanner scanner = new Scanner(System.in);
            object = selectedClass.newInstance();
            for (Field field : selectedClass.getDeclaredFields()) {
                Object value = null;
                while (value == null) {
                    value = convertValue(field.getType().getSimpleName(), scanner.nextLine());
                    field.setAccessible(true);
                    try {
                        field.set(object, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Object created: " + object);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void changeField() throws IllegalAccessException {
        System.out.println(DELIMITER);
        if (fieldsCount < 1) {
            System.out.println("The object has no fields");
            return;
        }
        System.out.println("Enter name of the field for changing:");
        Scanner scanner = new Scanner(System.in);
        String fieldName = scanner.next();
        Field field = Arrays.stream(selectedClass.getDeclaredFields())
                .filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
        if (field == null) {
            System.err.println("Field not found");
            return;
        }
        scanner.nextLine();

        Object value = null;
        while (value == null) {
            System.out.println("Enter " + field.getType().getSimpleName() + " value");
            value = convertValue(field.getType().getSimpleName(), scanner.nextLine());
            field.setAccessible(true);
            try {
                field.set(object, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Object updated: " + object);
    }

    private static void callMethod() {
        System.out.println(DELIMITER);
        if (methodsCount < 1) {
            System.err.println("The object has no methods");
            return;
        }
        System.out.println("Enter name of the method for call:");
        Scanner scanner = new Scanner(System.in);
        String methodName = scanner.next();

        Method method = Arrays.stream(selectedClass.getDeclaredMethods())
                .filter(m -> m.getName().equals(methodName))
                .findFirst()
                .orElse(null);
        if (method == null) {
            System.err.println("Method not found");
            return;
        }
        scanner.nextLine();

        Parameter[] parameters = method.getParameters();
        Object[] arguments = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            String typeName = parameters[i].getType().getSimpleName();
            while (arguments[i] == null) {
                System.out.println("Enter " + typeName + " value");
                arguments[i] = convertValue(typeName, scanner.nextLine());
            }
        }

        Object res = null;
        try {
            method.setAccessible(true);
            res = method.invoke(object, arguments);
        } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (!(method.getReturnType().getSimpleName().equals("void"))) {
            System.out.println("Method returned: ");
            System.out.println(res);
        }

    }

    private static Object convertValue(String typeName, String value) {
        try {
            switch (typeName) {
                case "Integer":
                    return (Integer.parseInt(value));
                case "Long":
                    return (Long.parseLong(value));
                case "String":
                    return (value);
                case "Double":
                    return (Double.parseDouble(value));
                case "Float":
                    return (Float.parseFloat(value));
                case "Short":
                    return (Short.parseShort(value));
                case "Boolean":
                    return (Boolean.parseBoolean(value));
                default:
                    return (null);
            }
        } catch (Exception e) {
            System.err.println("Unknown type");
            return (null);
        }
    }

    private static Class selectedClass() {
        Class selectedClass = Program.class;
        Scanner scanner = new Scanner(System.in);
        String className = "edu.school21.".concat(scanner.nextLine());
        if (className.equals(user.getName())) {
            selectedClass = user;
        } else if (className.equals(car.getName())) {
            selectedClass = car;
        } else {
            System.err.println("Class not found");
        }
        return (selectedClass);
    }
}
