package com.slk.guidance.model.G_position;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class GPosition {
    @Id
    private Integer id;
    private Integer parentid;
    private Integer level;
    private String name;
    private String url;
    private String creatuser;
    private Date createtime;
}
