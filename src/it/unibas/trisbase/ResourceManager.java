package it.unibas.trisbase;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceManager {
    
    private static final Logger logger = LoggerFactory.getLogger(ResourceManager.class);
    
    private ResourceBundle stringsBundle;

    public ResourceManager() {
        this.stringsBundle = ResourceBundle.getBundle("res.Strings", Locale.getDefault());
    }

    public String getStringaFromBundle(String chiave) {
        return this.stringsBundle.getString(chiave);
    }
    
    public ImageIcon caricaImmagine(String path) {
        return new ImageIcon(ResourceManager.class.getResource(path));
    }
    
    public BufferedInputStream caricaAudio(String path) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(ResourceManager.class.getResourceAsStream(path));
        return bufferedInputStream;
    }
    
}
