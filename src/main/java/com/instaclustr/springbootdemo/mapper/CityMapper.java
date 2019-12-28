package com.instaclustr.springbootdemo.mapper;


import com.instaclustr.springbootdemo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityMapper {

    @Select("select name, state, country from test.city where state = #{state}")
    List<City> findByState(@Param("state") String state);

    @Select("select * from test.city")
    List<City> getAllCities();

}
