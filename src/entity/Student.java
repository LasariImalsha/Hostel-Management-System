package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Student implements SuperEntity{
    @Id
    private String id;
    private String name;
    private String dob;
    private String nic;
    private String address;
    private String phoneNo;
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Detail> details;

    public Student(String id, String name, String dob, String nic, String address, String phoneNo, String email) {
        this.setId(id);
        this.setName(name);
        this.setDob(dob);
        this.setNic(nic);
        this.setAddress(address);
        this.setPhoneNo(phoneNo);
        this.setEmail(email);
    }
}
