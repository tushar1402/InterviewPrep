package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class City{
    @Id
    private int id;
    private String name;

    @OneToMany
    private List<Theatre> theatreList;

}
