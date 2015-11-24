
package com.fpmislata.bancoapi.presentacion.json;

/**
 *
 * @author alumno
 */
public interface JsonTransformer {
    String toJson(Object object);
    <T> T toObject(String json, Class<T> clazz);
}
