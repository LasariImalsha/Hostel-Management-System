package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Detail implements SuperEntity {

    @Id
    private String detailId;
    @CreationTimestamp
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    public Detail(String detailId, Date date, Room room, Student student) {
        this.setDetailId(detailId);
        this.setDate(date);
        this.setRoom(room);
        this.setStudent(student);
    }
}
