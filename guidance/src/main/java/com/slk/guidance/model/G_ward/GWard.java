package com.slk.guidance.model.G_ward;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class GWard {
    @Id
    private Integer id;
    private String wardname;
}
