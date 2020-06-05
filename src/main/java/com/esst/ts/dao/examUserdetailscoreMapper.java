package com.esst.ts.dao;

import com.esst.ts.model.examUserdetailscore;
import com.esst.ts.model.examUserdetailscoreWithBLOBs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;

public interface examUserdetailscoreMapper {
    int deleteByPrimaryKey(Integer userdetailscoreid);

    int insert(examUserdetailscoreWithBLOBs record);

    int insertSelective(examUserdetailscoreWithBLOBs record);

    examUserdetailscoreWithBLOBs selectByPrimaryKey(Integer userdetailscoreid);

    int updateByPrimaryKeySelective(examUserdetailscoreWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(examUserdetailscoreWithBLOBs record);

    int updateByPrimaryKey(examUserdetailscore record);

    /*
    学员端上传成绩
    */
    @Insert("Insert into exam_userdetailscore (UDS_UserID) value (1)")
    @ResultMap("BaseResultMap")
    boolean updatescoremapper(examUserdetailscore rescord);
}