
package com.fpmislata.bancoapi.presentacion.controllers;

import com.fpmislata.banco.business.domain.Rol;
import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.bancoapi.presentacion.security.WebSession;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method=RequestMethod.GET, produces = "application/json")
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            HttpSession httpSession = httpServletRequest.getSession();
            
            Usuario usuario = new Usuario(1, "jaime", "admin", Rol.administrador);
            WebSession webSession = new WebSession(usuario, new Date());
            
            httpSession.setAttribute("webSession", webSession);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
}
