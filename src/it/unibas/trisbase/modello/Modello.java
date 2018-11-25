package it.unibas.trisbase.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {
    
    private Map<String, Object> mappaBean = new HashMap<>();
    
    public void putBean(String chiave, Object bean) {
        this.mappaBean.put(chiave, bean);
    }
    
    public Object getBean(String chiave) {
        return this.mappaBean.get(chiave);
    }
    
}
