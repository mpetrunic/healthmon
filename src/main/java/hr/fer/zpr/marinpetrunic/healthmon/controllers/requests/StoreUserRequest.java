package hr.fer.zpr.marinpetrunic.healthmon.controllers.requests;

import hr.fer.zpr.marinpetrunic.healthmon.controllers.validation.Unique;
import hr.fer.zpr.marinpetrunic.healthmon.models.LocationModel;
import hr.fer.zpr.marinpetrunic.healthmon.models.UserModel;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author MarinPetrunic
 */
public class StoreUserRequest {

    @NotNull
    @Size(min = 3, max = 40)
    @Unique(column = "username", table = "user")
    private String username;

    @NotNull
    @Size(min = 3, max = 40)
    private String name;

    @NotNull
    @Size(min = 3, max = 40)
    private String surname;

    @NotNull
    @Size(min = 6, max = 50)
    private String password;

    @NotNull
    @Email
    @Unique(column = "email", table = "user")
    private String email;

    @NotNull
    @Size(min = 1, max = 40)
    private String city;

    @NotNull
    @Min(-90)
    @Max(90)
    private Double lat;

    @NotNull
    @Min(-180)
    @Max(180)
    private Double lon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public UserModel toUserModel() {
        UserModel user = new UserModel();
        user.setEmail(email);
        LocationModel location = new LocationModel();
        location.setCityName(city);
        location.setLat(lat);
        location.setLon(lon);
        user.setLocation(location);
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }
}
