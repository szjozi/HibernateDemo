package com.sda.model;

import com.sda.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "person")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    @ToString.Exclude
    @OneToMany(mappedBy = "person")
    private Set<Address> addresses;

    @ToString.Exclude
    @ManyToMany(mappedBy = "people")
    private Set<Car> cars;
}
