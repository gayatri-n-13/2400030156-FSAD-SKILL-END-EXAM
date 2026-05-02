package com.klef.fsad.exam;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String status;
    private String date;
    private String location;

    // Constructors
    public Movie() {}

    public Movie(String name, String status, String date, String location) {
        this.name = name;
        this.status = status;
        this.date = date;
        this.location = location;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}