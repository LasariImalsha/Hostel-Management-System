package model.tm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentTM {
    private String id;
    private String name;
    private String dob;
    private String nic;
    private String address;
    private String phoneNo;
    private String email;

    public StudentTM(String sId, String name, String dob, String nic, String address, String phoneNo, String email) {
        this.setId(sId);
        this.setName(name);
        this.setDob(dob);
        this.setNic(nic);
        this.setAddress(address);
        this.setPhoneNo(phoneNo);
        this.setEmail(email);
    }
}
