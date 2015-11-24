
package com.fpmislata.bancoapi.presentacion.security.impl;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.security.Authorization;
import com.fpmislata.bancoapi.presentacion.security.WebSession;
import com.fpmislata.bancoapi.presentacion.security.WebSessionProvider;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author alumno
 */
public class FilterImplSecurity implements Filter {
    
    @Autowired
    WebSessionProvider webSessionProvider;
    
    @Autowired
    Authorization authorization;
    
    FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                System.out.println("Inicio");
                
//                HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//                
//                WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(httpServletRequest.getServletContext());
//                AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
//                autowireCapableBeanFactory.autowireBean(this);
//                
//                WebSession webSession = webSessionProvider.getWebSession(httpServletRequest, httpServletResponse);
//                Usuario usuario = null;
//                if(webSession != null) {
//                    webSession.getUsuario();
//                }
//                
//                if (authorization.isAutorizedURL(usuario, httpServletRequest.getRequestURI())) {
//                    System.out.println("USUARIO REGISTRADO");
                    filterChain.doFilter(servletRequest, servletResponse);
//                } else {
//                    httpServletResponse.setStatus(403);
//                    System.out.println("TIENES QUE LOGUEARTE BIEN");
//                }
                
                System.out.println("Final");
    }

    @Override
    public void destroy() {

    }
    
}
