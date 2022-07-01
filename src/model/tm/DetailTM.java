package model.tm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class DetailTM {
    private String id;
    private Date date;
    private String room;
    private String student;

    public DetailTM(String id, Date date, String room, String student) {
        this.setId(id);
        this.setDate(date);
        this.setRoom(room);
        this.setStudent(student);
    }
}
