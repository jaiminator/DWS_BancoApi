
package com.fpmislata.bancoapi.presentacion.controllers;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.bancoapi.presentacion.json.JsonTransformer;
import java.util.List;
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
public class EntidadBancariaController {
    
    @Autowired
    EntidadBancariaService entidadBancariaService;
    
    @Autowired
    JsonTransformer jsonTransformer;
    
    @RequestMapping(value = "/entidadBancaria/{idEntidadBancaria}", method=RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEntidadBancaria") int idEntidadBancaria) {
        try {
            EntidadBancaria entidadBancaria = entidadBancariaService.get(idEntidadBancaria);
            String jsonSalida = jsonTransformer.toJson(entidadBancaria);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/entidadBancaria", method=RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<EntidadBancaria> entiadadesBancarias = entidadBancariaService.findAll();
            String jsonSalida = jsonTransformer.toJson(entiadadesBancarias);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/entidadBancaria", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            EntidadBancaria entidadBancaria = (EntidadBancaria)jsonTransformer.toObject(jsonEntrada, EntidadBancaria.class);
            entidadBancariaService.insert(entidadBancaria);
            String jsonSalida = jsonTransformer.toJson(entidadBancaria);
             
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/entidadBancaria", method=RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void put(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            EntidadBancaria entidadBancaria = (EntidadBancaria)jsonTransformer.toObject(jsonEntrada, EntidadBancaria.class);
            entidadBancariaService.update(entidadBancaria);
            String jsonSalida = jsonTransformer.toJson(entidadBancaria);
             
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/entidadBancaria/{idEntidadBancaria}", method=RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable("idEntidadBancaria") int idEntidadBancaria, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            entidadBancariaService.delete(idEntidadBancaria);
         
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
