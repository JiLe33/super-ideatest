package generator.domain.VO;

import lombok.Data;

@Data
public class live {
    String status;

    public live(String status) {
        this.status = status;
    }
}
