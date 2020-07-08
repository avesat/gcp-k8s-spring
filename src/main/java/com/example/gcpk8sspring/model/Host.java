package com.example.gcpk8sspring.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "host")
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ipAddress;
    private String hostName;
    private Timestamp timestamp;
}
