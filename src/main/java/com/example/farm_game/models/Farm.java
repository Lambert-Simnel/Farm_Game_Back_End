package com.example.farm_game.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int funds;

    @Column
    private int date;

    @JsonIgnoreProperties({"farms"})
    @OneToMany(mappedBy = "farm")
    private List<Field> fields;

    public Farm(Long id, String name, int funds, int date, List<Field> fields) {
        this.id = id;
        this.name = name;
        this.funds = funds;
        this.date = date;
        this.fields = fields;
    }

    public Farm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }

    public void deleteField(int fieldId){
        this.fields.remove(fieldId);
    }
}
