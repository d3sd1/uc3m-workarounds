package configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    /* Lanzador del yaml */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      Config.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config.yml"), sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
