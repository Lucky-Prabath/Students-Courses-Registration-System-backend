package lk.ijse.dep.web.institute.listner;

import lk.ijse.dep.web.institute.util.JPAUtil;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-01
 **/
@WebListener
public class ContextListener implements ServletContextListener {

    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener(){}

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Class.forName("lk.ijse.dep.web.institute.AppInitializer");
        } catch (ClassNotFoundException e) {
            logger.error("Failed to load spring container");
        }

        Properties prop = new Properties();
        try {
            logger.info("Session factory has initialized");
            sce.getServletContext().setAttribute("emf", JPAUtil.getEntityManagerFactory());

            String logFilePath;
            if (prop.getProperty("app.log_dir") != null) {
                logFilePath = prop.getProperty("app.log_dir") + "/back-end.log";
            } else {
                logFilePath = System.getProperty("catalina.home") + "/logs/back-end.log";
            }
            FileHandler fileHandler = new FileHandler(logFilePath, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.INFO);
            Logger.getLogger("").addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JPAUtil.getEntityManagerFactory().close();
        logger.info("Session factory has closed");
    }
}
