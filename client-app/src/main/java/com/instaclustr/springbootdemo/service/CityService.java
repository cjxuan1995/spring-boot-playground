package com.instaclustr.springbootdemo.service;

import com.instaclustr.springbootdemo.domain.City;
import com.instaclustr.springbootdemo.mapper.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private static final Logger logger = LoggerFactory.getLogger(CityService.class);
    private CityMapper cityMapper;

    @Autowired
    public CityService(final CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public List<City> getCitiesByState(String state){
        logger.info("Getting cities by state");
        return cityMapper.findByState(state);
    }
}
