package com.esst.ts.service.impl;

import com.esst.ts.dao.examUserdetailscoreMapper;
import com.esst.ts.model.examUserdetailscore;
import com.esst.ts.service.examUserdetailscoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class examUserdetailscoreServiceImpl implements examUserdetailscoreService {
    @Resource
    private examUserdetailscoreMapper examscore;
    @Override
    public boolean updatescore(examUserdetailscore score){
        examscore.updatescoremapper(score);
        return  false;
    }
}
