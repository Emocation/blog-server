package com.my.blog.serve.service;


import com.my.blog.serve.entity.MoodEssay;
import com.my.blog.serve.entity.MoodEssayExample;
import com.my.blog.serve.mapper.MoodEssayMapper;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class MoodEssayService {
    @Resource
    MoodEssayMapper moodEssayMapper;
    //随笔初始化
    public List<MoodEssay> selectByExample(){
        MoodEssayExample moodEssayExample =new MoodEssayExample();
        MoodEssayExample.Criteria criteria = moodEssayExample.createCriteria();
        String orderByClause = "pk_moodEssay DESC";
        moodEssayExample.setOrderByClause( orderByClause );
        return moodEssayMapper.selectByExample(moodEssayExample);
    }
    //随笔删除
    public void deleteByPrimaryKey(MoodEssay moodEssay){
        moodEssayMapper.deleteByPrimaryKey(moodEssay);
    }

    //随笔保存
    public void insertSelective (MoodEssay moodEssay){
        moodEssayMapper.insertSelective(moodEssay);
    }

}
