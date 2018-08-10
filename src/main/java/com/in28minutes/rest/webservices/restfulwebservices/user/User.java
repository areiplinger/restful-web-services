package com.in28minutes.rest.webservices.restfulwebservices.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All details for users")
public class User {

    private Integer id;

    @Size(min = 2, message="Name field should contain at least 2 characters.")
    private String name;

    @Past(message="Birthdate should be a past date")
    @ApiModelProperty(notes = "Birthdate cannot be in the future")
    private Date birth_date;

    protected User(){}

    public User(Integer id, String name, Date birth_date) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
