package com.my.blog.serve.service;

import com.my.blog.serve.entity.MessageBoard;
import com.my.blog.serve.entity.MessageBoardExample;
import com.my.blog.serve.mapper.MessageBoardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageBoardService {
    @Resource
    MessageBoardMapper messageBoardMapper;

    //访客留言
    public void insertSelective (MessageBoard messageBoard){
        messageBoardMapper.insertSelective(messageBoard);
    }

    //留言板初始化
    public List<MessageBoard> selectByExample(){
        MessageBoardExample messageBoardExample = new MessageBoardExample();
        MessageBoardExample.Criteria criteria = messageBoardExample.createCriteria();
        String orderByClause = "pk_MessageBoard DESC";
        messageBoardExample.setOrderByClause( orderByClause );
        return messageBoardMapper.selectByExample(messageBoardExample);
    }

    //博主删除留言
    public void deleteByPrimaryKey(MessageBoard messageBoard){
        messageBoardMapper.deleteByPrimaryKey(messageBoard);
    }
    //博主回复
    public void updateByPrimaryKeySelective (MessageBoard messageBoard){
        messageBoardMapper.updateByPrimaryKeySelective(messageBoard);
    }

}
