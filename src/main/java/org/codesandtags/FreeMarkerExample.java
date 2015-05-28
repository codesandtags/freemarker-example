package org.codesandtags;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;

/**
 * Clase de ejemplo utilizando FreeMarker para obtener
 * un Template procesado a partir de una cadena de texto
 *
 * Created by codesandtags on 27/05/2015.
 */
public class FreeMarkerExample {

    private Configuration configuration;
    private Template template;

    public FreeMarkerExample(){
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.US);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public void setContentTemplate(String name, String content){
        try {
            template = new Template(name, new StringReader(content), getConfiguration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
