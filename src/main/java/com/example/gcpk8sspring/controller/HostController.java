package com.example.gcpk8sspring.controller;

import com.example.gcpk8sspring.model.Host;
import com.example.gcpk8sspring.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HostController {
    @Autowired
    HostService hostService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Host getCurrentHostInfo() {
        return hostService.getCurrentHostInfo();
    }

    @RequestMapping(value = "/host", method = RequestMethod.POST)
    public Host addHost() {
        return hostService.addCurrentHost();
    }

    @RequestMapping(value = "/host/all", method = RequestMethod.GET)
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }
}
