package com.abdul.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class SpringConfigExample {

//    If key is missed in the property file, then
//    to display default value.
    @Value("${state.name:DefaultState-Karnataka}")
    private String stateName;

//    To inject the value for the key from the application property file
//    Spring reads and display as LIST for the values present in the property file
    @Value("${city.names}")
    private List<String> cityNameOfCapitals;

//    Spring reads and display as MAP for the values present in the property file
    @Value("#{${area.pin.code}}")
    public Map<String,String> arePinCodes;

    @GetMapping("/config")
    public List<String> dispConfigBehaviour(){

        System.out.println("Running the DispConfigBehaviour() method");

        return Arrays.asList(
                "returning from DispConfig-Method",
                "fetching state name from property file "+ stateName,
                "cityNameOfCapitals ,"+cityNameOfCapitals
                );
    }

    @GetMapping("/configMap")
    public Map<String,String> dispMapConfigBehaviour(){
        return arePinCodes;
    }


}
