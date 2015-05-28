package org.codesandtags;

import freemarker.template.TemplateException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by codesandtags on 27/05/2015.
 */
public class FreeMarkerExampleTest {

    @Test
    public void generateTemplateTest(){
        FreeMarkerExample example = new FreeMarkerExample();
        StringBuilder content = new StringBuilder("Hello ${user},")
                .append("\nthis is an example using FreeMarker. ")
                .append("\nThe list of names are :  ")
                .append("\n<#list names as name>  ")
                .append("\n  ${name_index + 1}. ${name} ")
                .append("\n</#list>  ");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("user", "Codes and Tags");
        parameters.put("names", new ArrayList<String>(Arrays.asList("Cocoman", "Juan", "Edwin")));

        try {
            example.setContentTemplate("exampleTemplate", content.toString());
            Writer out = new StringWriter();
            example.getTemplate().process(parameters, out);
            Assert.assertNotNull(out);
            System.out.println(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}