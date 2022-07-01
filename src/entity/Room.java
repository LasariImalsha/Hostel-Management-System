package entity;

import com.sun.istack.NotNull;
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
public class Room implements SuperEntity {

    @Id
    @NotNull
    private String roomId;
    private String roomType;
    private String duration;
    private double keyMoney;
    private double status;

    @OneToMany(mappedBy = "room")
    private List<Detail> details;

    public Room(String roomId, String roomType, String duration, Double keyMoney,Double status) {
        this.setRoomId(roomId);
        this.setRoomType(roomType);
        this.setDuration(duration);
        this.setKeyMoney(keyMoney);
        this.setStatus(status);
    }
}
