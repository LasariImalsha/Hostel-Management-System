package dto;

import entity.Room;
import entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class DetailDTO {
    private String detailId;
    private Date date;
    private Room room;
    private Student student;


    public DetailDTO(String detailId, Date date, Room room, Student student) {
        this.setDetailId(detailId);
        this.setDate(date);
        this.setRoom(room);
        this.setStudent(student);
    }
}
