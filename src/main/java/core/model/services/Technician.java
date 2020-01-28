package core.model.services;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;;



@Getter
@Setter
@NoArgsConstructor
/** 
*Techniciian
*/
@Entity
public class Technician{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String firstName;
    private String lastName;
    private String address;
    private int contact;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="service_id")
    private Service service;

    public Technician(String firstName, String lastName, String address, int contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contact = contact;
    }



}