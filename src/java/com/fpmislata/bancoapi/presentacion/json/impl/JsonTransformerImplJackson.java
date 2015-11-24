
package com.fpmislata.bancoapi.presentacion.json.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpmislata.bancoapi.presentacion.json.JsonTransformer;
import java.io.IOException;


public class JsonTransformerImplJackson implements JsonTransformer {

    @Override
    public String toJson(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
        
        return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        
    }

    @Override
    public Object toObject(String json, Class clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
 
            return objectMapper.readValue(json, clazz);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
