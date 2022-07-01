package dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private String id;
    private String type;
    private String duration;
    private Double keyMoney;
    private Double status;

    public RoomDTO(String id, String type, String duration, Double keyMoney,Double status) {
        this.setId(id);
        this.setType(type);
        this.setDuration(duration);
        this.setKeyMoney(keyMoney);
        this.setStatus(status);
    }
}
