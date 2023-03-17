package com.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String carNumber;
    @ManyToOne
    @JoinColumn(name = "carType_id", nullable = false, referencedColumnName = "id")
    private CarType carType;
    private String busCompanyName;
    @ManyToOne
    @JoinColumn(name = "departurePoint_id", nullable = false, referencedColumnName = "id")
    private DeparturePoint departurePoint;
    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false, referencedColumnName = "id")
    private Destination destination;
    private String phoneNumber;
    private String email;
    private String departure;
    private String arrival;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }


    public String getBusCompanyName() {
        return busCompanyName;
    }

    public void setBusCompanyName(String busCompanyName) {
        this.busCompanyName = busCompanyName;
    }

    public DeparturePoint getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(DeparturePoint departurePoint) {
        this.departurePoint = departurePoint;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
}
