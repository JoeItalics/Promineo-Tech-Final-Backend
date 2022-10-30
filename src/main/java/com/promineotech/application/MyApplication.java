package com.promineotech.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;



@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class MyApplication {
  
  public static void main(String[] args) {    
    SpringApplication.run(MyApplication.class);        
          
}
}