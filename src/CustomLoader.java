import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomLoader extends ClassLoader {

    private final String classPath;

    public CustomLoader(ClassLoader parent, String classPath){
        super(parent);
        this.classPath = classPath;
    }

    @Override
    public Class<?> findClass(String name) {
        System.out.println("Loading class " + name);

        try {
            String filePath = classPath + "/" + name.replace(".", "/") + ".class";
            System.out.println("PATH^" + filePath);
            byte[] classByte = Files.readAllBytes(Paths.get(filePath));

            return defineClass(name, classByte, 0, classByte.length);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load " + name, e);
        }
    }
}