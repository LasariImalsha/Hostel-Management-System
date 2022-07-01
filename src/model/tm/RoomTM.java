package model.tm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RoomTM {
    private String roomId;
    private String roomType;
    private String durations;
    private Double keyMoney;
    private Double status;

    public RoomTM(String id, String name, String duration, Double keyMoney,Double status) {
        this.setRoomId(id);
        this.setRoomType(name);
        this.setDurations(duration);
        this.setKeyMoney(keyMoney);
        this.setStatus(status);
    }
}
