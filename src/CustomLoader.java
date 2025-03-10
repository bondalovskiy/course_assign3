public class CustomLoader extends ClassLoader {

    public CustomLoader(ClassLoader parent){
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name)throws ClassNotFoundException{

        System.out.println("Loading class " + name);

        return super.loadClass(name);
    }
}