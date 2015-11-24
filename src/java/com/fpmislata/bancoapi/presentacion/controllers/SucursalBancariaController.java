
package com.fpmislata.bancoapi.presentacion.controllers;

import com.fpmislata.banco.business.domain.SucursalBancaria;
import com.fpmislata.banco.business.service.SucursalBancariaService;
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
 * @author Jaime
 */
@Controller
public class SucursalBancariaController {
    
    @Autowired
    SucursalBancariaService sucursalBancariaService;
    
    @Autowired
    JsonTransformer jsonTransformer;
    
    @RequestMapping(value = "/sucursalBancaria/{idSucursalBancaria}", method=RequestMethod.GET, produces = "application/json")
    public void read(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idSucursalBancaria") int idSucursalBancaria) {
        try {
            SucursalBancaria sucursalBancaria = sucursalBancariaService.get(idSucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/sucursalBancaria", method=RequestMethod.GET, produces = "application/json")
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            List<SucursalBancaria> sucursalesBancarias = sucursalBancariaService.findAll();
            String jsonSalida = jsonTransformer.toJson(sucursalesBancarias);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/sucursalBancaria", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            SucursalBancaria sucursalBancaria = (SucursalBancaria)jsonTransformer.toObject(jsonEntrada, SucursalBancaria.class);
            sucursalBancariaService.insert(sucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);
             
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/sucursalBancaria", method=RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public void put(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        try {
            SucursalBancaria sucursalBancaria = (SucursalBancaria)jsonTransformer.toObject(jsonEntrada, SucursalBancaria.class);
            sucursalBancariaService.update(sucursalBancaria);
            String jsonSalida = jsonTransformer.toJson(sucursalBancaria);
             
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().println(jsonSalida);
            
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/sucursalBancaria/{idSucursalBancaria}", method=RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable("idSucursalBancaria") int idSucursalBancaria, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            sucursalBancariaService.delete(idSucursalBancaria);
         
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    
}
