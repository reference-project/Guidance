package com.slk.guidance.service;

import com.slk.guidance.framework.util.FileUtil;
import com.slk.guidance.mapper.G_service.GServiceMapper;
import com.slk.guidance.model.G_service.GService;
import com.slk.guidance.model.G_service.GServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class G_SServiceImpl {
    @Autowired
    private GServiceMapper mapper;

    public List<GService> selectServiceAll(){
        return mapper.selectServiceAll();
    }

    public GService selectServiceById(Integer id){
        GService g=new GService();
        g.setId(id);
        return mapper.selectOne(g);
    }

    public boolean updateService(GServiceCustom serviceCustom){
        boolean flag=false;
        int count=0;
        if(serviceCustom.getFiles().getSize()>0){
            System.out.println(serviceCustom.getFiles().getSize());
            MultipartFile file = serviceCustom.getFiles();
            serviceCustom.setUrl(FileUtil.FileImgUp(file, "guidance/serviceInfo"));
        }else{
            GService g=selectServiceById(serviceCustom.getId());
            if(g.getUrl()!=null &&!"".equals(g.getUrl())){
                serviceCustom.setUrl(g.getUrl());
            }
        }
        if(serviceCustom.getId()!=null&&!"".equals(serviceCustom.getId())){
            count=mapper.updateByPrimaryKey(serviceCustom);

        }else{
            count=mapper.insert(serviceCustom);
        }
        if(count>0){
            flag=true;
        }
        return flag;
    }

}
