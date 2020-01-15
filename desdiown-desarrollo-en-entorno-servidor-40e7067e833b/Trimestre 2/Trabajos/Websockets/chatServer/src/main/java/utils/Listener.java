package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ConfigDatabase.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config/database.yml"), sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }
}
