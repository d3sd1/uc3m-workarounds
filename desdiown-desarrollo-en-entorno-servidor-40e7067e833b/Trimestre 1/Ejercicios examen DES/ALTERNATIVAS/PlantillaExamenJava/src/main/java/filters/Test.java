package filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "Test", urlPatterns =
{
    "/Test"
})
public class Test implements Filter
{

    /*
    * Función para filtrar la petición
    */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        
        doBeforeProcessing(request, response);
        
        Throwable problem = null;
        try
        {
            /*
                EL CÓDIGO PARA EL FILTRO VA AQUÍ.
            
                * Para continuar la ejecución si todo está OK:
                    chain.doFilter(request, response);
                * Para enviar página personalizada (comúnmente error):
                    request.getRequestDispatcher("PAGE.jsp").forward(request, response);
                * Mostrar errores del filtro en ejecución:
                    t.printStackTrace();
            */
            chain.doFilter(request, response);
        }
        catch (IOException | ServletException t)
        {
            problem = t;
        }
        
        doAfterProcessing(request, response);

        if (problem != null)
        {
            if (problem instanceof ServletException)
            {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException)
            {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }
    
    /*
    * Función para la ejecución antes del filtrado
    */
    private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException
    {
        
    }    
    
    /*
    * Función para la ejecución tras el filtrado
    */
    private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException
    {
        
    }

    /*
    * Funciones internas del filtro
    */
    private FilterConfig filterConfig = null;
    
    public Test()
    {
        
    }
    
    public FilterConfig getFilterConfig()
    {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig)
    {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy()
    {        
    }

    @Override
    public void init(FilterConfig filterConfig)
    {        
        this.filterConfig = filterConfig;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Test(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response)
    {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals(""))
        {
            try
            {
                response.setContentType("text/html");
                try (PrintStream ps = new PrintStream(response.getOutputStream()); PrintWriter pw = new PrintWriter(ps))
                {
                    pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N
                    
                    // PENDING! Localize this for next official release
                    pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                    pw.print(stackTrace);
                    pw.print("</pre></body>\n</html>"); //NOI18N
                }
                response.getOutputStream().close();
            }
            catch (IOException ex)
            {
            }
        }
        else
        {
            try
            {
                try (PrintStream ps = new PrintStream(response.getOutputStream()))
                {
                    t.printStackTrace(ps);
                }
                response.getOutputStream().close();
            }
            catch (IOException ex)
            {
            }
        }
    }
    
    public static String getStackTrace(Throwable t)
    {
        String stackTrace = null;
        try
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        }
        catch (IOException ex)
        {
        }
        return stackTrace;
    }
    
    public void log(String msg)
    {
        filterConfig.getServletContext().log(msg);        
    }
    
}
