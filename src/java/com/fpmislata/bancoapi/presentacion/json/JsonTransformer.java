
package com.fpmislata.bancoapi.presentacion.json;


public interface JsonTransformer {
    String toJson(Object object);
    <T> T toObject(String json, Class<T> clazz);
}
