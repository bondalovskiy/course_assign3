import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        System.out.println("custom class loader test");

        CustomLoader customLoader = new CustomLoader(Main.class.getClassLoader());

        Class<?> customClass = customLoader.loadClass("classes.Custom1");

        System.out.println("Loaded class name: " + customClass.getName());

        Object customClassInstance = customClass.newInstance();

        customClass.getMethod("printMessage").invoke(customClassInstance);
    }
}
