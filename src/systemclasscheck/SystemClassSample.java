package systemclasscheck;

public class SystemClassSample {
    public static void main(String[] args) {
        // Get Java version
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);

        // Get Java home directory
        String javaHome = System.getProperty("java.home");
        System.out.println("Java Home: " + javaHome);

        // Get Operating System name
        String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);

        // Get User's home directory
        String userHome = System.getProperty("user.home");
        System.out.println("User's Home Directory: " + userHome);

        // Get a custom property (if set)
        String customProperty = System.getProperty("custom.property", "Default Value");
        System.out.println("Custom Property: " + customProperty);
    }
}
