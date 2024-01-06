package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre{

    @Id
    private int id;
    private String name;

    private String address;

    @ManyToOne
    private City city;

    @OneToMany
    private List<Auditorium> auditoriumList;
}
