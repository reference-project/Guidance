package com.slk.guidance.model.G_service;
import lombok.Data;
import javax.persistence.Id;

@Data
public class GService {
    @Id
    private Integer id;
    private String type;
    private String info;//详情
    private String notice;//须知
    private String remark;//备注
    private String url;
    private String createuser;
    private String createtime;
}
