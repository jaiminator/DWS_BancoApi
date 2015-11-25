
package com.fpmislata.bancoapi.presentacion.controllers;

import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco.business.service.UsuarioService;
import com.fpmislata.bancoapi.presentacion.json.JsonTransformer;
import com.fpmislata.banco.security.Authorization;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    JsonTransformer jsonTransformer;
    
    @RequestMapping(value = "/usuario/{idUsuario}", method=RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idUsuario") int idUsuario) {
        try {
            Usuario usuario = usuarioService.get(idUsuario);
            String jsonSalida = jsonTransformer.toJson(usuario);
            
            if (usuario != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @RequestMapping(value = "/usuario", method=RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<Usuario> usuarios = usuarioService.findAll();
            String jsonSalida = jsonTransformer.toJson(usuarios);
            
            if (usuarios != null) {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.setContentType("application/json; charset=UTF-8");
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @RequestMapping(value = "/usuario", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            Usuario usuario = (Usuario)jsonTransformer.toObject(jsonEntrada, Usuario.class);
            usuarioService.insert(usuario);
            String jsonSalida = jsonTransformer.toJson(usuario);
             
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @RequestMapping(value = "/usuario", method=RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void put(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            Usuario usuario = (Usuario)jsonTransformer.toObject(jsonEntrada, Usuario.class);
            usuarioService.update(usuario);
            String jsonSalida = jsonTransformer.toJson(usuario);
             
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @RequestMapping(value = "/usuario/{idUsuario}", method=RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable("idUsuario") int idUsuario, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            usuarioService.delete(idUsuario);
         
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    
    
}
