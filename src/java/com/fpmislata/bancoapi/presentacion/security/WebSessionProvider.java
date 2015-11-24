
package com.fpmislata.bancoapi.presentacion.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author alumno
 */
public interface WebSessionProvider {
    WebSession getWebSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}
