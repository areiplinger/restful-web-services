package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.omg.CORBA.Object;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean(){

        SomeBean someBean = new SomeBean("value1", "value2", "value3");

/*        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1","field2");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filters);*/

        MappingJacksonValue mapping = filteredBeans(someBean, "field1", "field2");

        return mapping;
    }

    //field2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean(){

        List<SomeBean> beanList = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value1.2", "value2.2", "value3.2"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field2","field3");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(beanList);

        mapping.setFilters(filters);

//        MappingJacksonValue mapping = filteredBeans(beanList ,"field1", "field2");

        return mapping;
    }

    public MappingJacksonValue filteredBeans(SomeBean someBean, String filter1, String filter2){

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept(filter1, filter2);

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filters);

        return mapping;
    }
}
