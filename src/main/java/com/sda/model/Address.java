package com.sda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String street;

    @Column(length = 10)
    private String postCode;

    @Column(length = 10)
    private String houseNo;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;
}
