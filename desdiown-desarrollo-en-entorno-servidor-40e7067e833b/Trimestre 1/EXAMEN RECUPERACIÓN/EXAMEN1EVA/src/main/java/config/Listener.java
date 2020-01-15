package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        /* Las configuraciones están separadas porque no quería liarla con el ArrayList, HashMap & Company. */
        Config.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config.yml"), sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }
}
