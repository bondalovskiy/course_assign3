import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        System.out.println("custom class loader test");

        String classPath = "D:/uni/course/couse_assing3_custom_classes";

        CustomLoader customLoader = new CustomLoader(Main.class.getClassLoader(), classPath);

        Class<?> customClass = customLoader.findClass("Custom1");
        Class<?> customClass1 = customLoader.findClass("Custom1");
        System.out.println("Loaded class name: " + customClass.getName());

        Object customClassInstance = customClass.getDeclaredConstructor().newInstance();
        customClass.getMethod("printMessage").invoke(customClassInstance);

    }
}
