package core.model.services;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
/** 
*Service
*/
public class Service{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;

    private String name;
    private String imageUrl;
    private String description;
  
    @JsonIgnore
    @OneToMany(mappedBy = "service" ,cascade = CascadeType.ALL)
    private Set<Technician> technician = new HashSet<>();  

    public Service(String name, String imageUrl, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public void addTechnician(Technician technician) {
        this.technician.add(technician);
    }

    public void removeTechnician(Technician technician) {
        this.technician.remove(technician);
    }

}
