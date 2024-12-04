package org.example.models.address;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String city;
    private String district;
    private String state;
    private String country;
    private String pinCode;
}
