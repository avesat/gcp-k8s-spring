package com.example.gcpk8sspring.repository;

import com.example.gcpk8sspring.model.Host;
import org.springframework.data.repository.CrudRepository;

public interface HostRepository extends CrudRepository<Host, Long> {
}
