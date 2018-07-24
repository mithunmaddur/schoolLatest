package com.school.service.util;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Utility class to fetch the properties' values from property file
 * 
 * @Author
 * @Date: 22-Jun-2018
 * @Time: 10:58:03 am
 * @Version: 1.0
 *
 */
public final class Properties extends PropertyPlaceholderConfigurer {
  

  // Property key for propsExported
  private static java.util.Properties propsExported = new java.util.Properties();

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.core.io.support.PropertiesLoaderSupport#mergeProperties
   * ()
   */
  protected java.util.Properties mergeProperties() throws IOException {
      propsExported = super.mergeProperties();
      return propsExported;
  }
  
  public static  void mergeProperties(java.util.Properties properties) throws IOException {
    propsExported = properties;
}

  /**
   * Get the value of given key from the property file
   * 
   * @param key
   * @return
   */
  public static  String getProperty(final String key) {
      String value = propsExported.getProperty(key);
      return value;
  }
}
