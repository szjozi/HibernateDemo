package com.sda.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Equipment {

    private int numOfSeats;
    private boolean winterTires;

}
