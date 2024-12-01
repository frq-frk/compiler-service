package com.compiler.processors;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProcessorFactory {
	private static final String PROCESSOR_CONFIGURATION = "processors";
    private static Hashtable<String, String> processorMappings = new Hashtable<String, String>();
    
    static {
        try {
            loadProcessorMappings();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GenericProcessor getGenericProcessor(String language) {
        String className = processorMappings.get(language);
 
        GenericProcessor processor = null;
 
        try {
            if( className!=null) {
                Class<?> cls = Class.forName(className);
                processor = (GenericProcessor)cls.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return processor;
    }
    
	private static void loadProcessorMappings() {
		ResourceBundle rb = ResourceBundle.getBundle(PROCESSOR_CONFIGURATION, Locale.getDefault());
        for (Enumeration<String> e = rb.getKeys(); e.hasMoreElements();) {
            String key = e.nextElement();
            processorMappings.put(key, rb.getString(key));
        }
	}
}
