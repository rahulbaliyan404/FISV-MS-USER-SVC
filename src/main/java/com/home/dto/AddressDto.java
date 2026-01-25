package com.home.dto;

import com.home.enumeration.AddressType;

public class AddressDto {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private AddressType addressType;

    private UserDto userDto;

    public AddressDto() {
    }

    public AddressDto(Long id, String street, String city, String state, String pincode, AddressType addressType, UserDto userDto) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.addressType = addressType;
        this.userDto = userDto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
