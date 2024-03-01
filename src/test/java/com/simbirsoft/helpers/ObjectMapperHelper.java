package com.simbirsoft.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ObjectMapperHelper {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static void writeValue(String pathFile, Object value) {
    try {
      objectMapper.writeValue(new File(pathFile), value);
    } catch (Exception exc) {
      System.out.println("Value writing error " + exc);
    }
  }

  public static Object readValue(String pathFile, Class valueClass) {
    try {
      return objectMapper.readValue(new File(pathFile), valueClass);
    } catch (Exception exc) {
      System.out.println("Value reading error " + exc);
    }
    return new Object();
  }

}
