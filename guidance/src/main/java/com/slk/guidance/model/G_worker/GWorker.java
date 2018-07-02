package com.slk.guidance.model.G_worker;

import lombok.Data;

import javax.persistence.Id;

@Data
public class GWorker {
    @Id
    private Integer id;
    private Integer wardid;
    private String workername;
    private String phone;

}
