package com.example.gcpk8sspring.service;

import com.example.gcpk8sspring.model.Host;
import com.example.gcpk8sspring.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HostService {
    @Autowired
    private HostRepository hostRepository;

    public List<Host> getAllHosts() {
        return StreamSupport.stream(hostRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    public Host addCurrentHost() {
        return hostRepository.save(getCurrentHostInfo());
    }

    public Host getCurrentHostInfo() {
        String ip;
        String hostname;

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostname = inetAddress.getHostName();
            ip = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            hostname = "unknown hostname";
            ip = "";
        }

        return Host.builder()
                .ipAddress(ip)
                .hostName(hostname)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
