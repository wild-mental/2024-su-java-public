package stringandlogging;

import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

public class Log4JSample {
    static {
        try {
            LoggerContext myLog4JConfig = Configurator.initialize("myLog4JConfig", "/Users/kidsnote/Workspace/IdeaProjects/sample_java_basic_2024/log4j-config.xml");
            myLog4JConfig.initialize();
            System.out.println("logger "+myLog4JConfig.getName()+" initialized: "+myLog4JConfig.isInitialized());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static final Logger consoleLogger = LogManager.getLogger("Console");
    private static final Logger filelogger = LogManager.getLogger("File");

    public static void main (String[] args) {
        // to console
        consoleLogger.info("This is an SLF4J example with info level.", new RuntimeException("info log"));
        consoleLogger.error("This is an SLF4J example with error level.", new RuntimeException("Sample exception"));
        // to file
        filelogger.info("This is an SLF4J example with info level.", new RuntimeException("info log"));
        filelogger.error("This is an SLF4J example with error level.", new RuntimeException("Sample exception"));
        //
    }
}
