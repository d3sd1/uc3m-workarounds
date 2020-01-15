package yml;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener
{

    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        /* Las configuraciones están separadas porque no quería liarla con el ArrayList, HashMap & Company. */
        ConfigDatabase.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config/database.yml"), sce.getServletContext());
        ConfigGeneral.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config/general.yml"), sce.getServletContext());
        ConfigMail.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config/mail.yml"), sce.getServletContext());
        ConfigSecurity.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/config/security.yml"), sce.getServletContext());
        Language.getInstance(sce.getServletContext().getResourceAsStream("/WEB-INF/langs/es.yml"), sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {

    }
}
