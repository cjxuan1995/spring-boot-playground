package com.instaclustr.springbootdemo.controller;


import com.instaclustr.springbootdemo.config.InstaclustrConfig;
import com.instaclustr.springbootdemo.domain.City;
import com.instaclustr.springbootdemo.mapper.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class CityListController {
    private CityMapper cityMapper;
    private InstaclustrConfig config;

    private static final Logger logger = LoggerFactory.getLogger(CityListController.class);

    @Autowired
    public CityListController(final CityMapper cityMapper, final InstaclustrConfig config) {
        this.cityMapper = cityMapper;
        this.config = config;
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public List<City> getCitiesByState(@RequestParam String state, Principal user){
        System.out.println(config.getCustomConfig());
        logger.info("Get cities by state request received. Requested state: " + state + " user: " + user.getName());
        return cityMapper.findByState(state);
    }

    @RequestMapping("/heartbeat")
    public Map<String, String> heartbeat() {
        return Collections.singletonMap("name", "Spring boot demo app");
    }

    @RequestMapping("/")
    public String home(Principal user) {
        return "Hello " + user.getName();
    }
}
