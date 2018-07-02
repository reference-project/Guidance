package com.slk.guidance.mapper.G_nursinglevel;

import com.slk.guidance.model.G_nursinglevel.GNursinglevel;
import com.slk.guidance.framework.MyMapper;
import com.slk.guidance.model.G_nursinglevel.GNursinglevel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface GNursinglevelMapper extends MyMapper<GNursinglevel> {
    /**
     * 查询全部护理等级信息
     * @return
     */
    public List<GNursinglevel> selectNursingLevelAll();

    /**
     * 新增护理等级
     * @return
     */
    public int updateNursingLevel(GNursinglevel nursingLevel);

    /**
     * 新增护理等级
     * @return
     */
    public int insertNursingLevel(GNursinglevel nursingLevel);

    /**
     * 删除护理等级
     * @return
     */
    public int deleteNursingLevel(Integer id);

    /**
     * 根据病区查询护理等级
     * @return
     */
    public List<GNursinglevel> selectNursingLevelByWardId(Integer wardid);
}