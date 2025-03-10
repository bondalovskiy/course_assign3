import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CustomLoader extends ClassLoader {

    private final String classPath;

    private final Map<String, Class<?>> loadedClasses = new HashMap<>();


    public CustomLoader(ClassLoader parent, String classPath){
        super(parent);
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) {
        System.out.println("Loading class " + name );

        if (loadedClasses.containsKey(name)) {
            System.out.println("Class " + name + "was already loaded/ cached version returned");
            return loadedClasses.get(name);
        }

        try {
            String filePath = classPath + "/" + name.replace(".", "/") + ".class";
            System.out.println("PATH^" + filePath);
            byte[] classByte = Files.readAllBytes(Paths.get(filePath));

            Class<?> customClass = defineClass(name, classByte, 0, classByte.length);

            loadedClasses.put(name, customClass);

            return customClass;
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load " + name, e);
        }
    }
}