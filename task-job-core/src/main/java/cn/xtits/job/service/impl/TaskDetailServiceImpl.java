package cn.xtits.job.service.impl;

import cn.xtits.job.dto.TaskDetailDto;
import cn.xtits.job.entity.TaskDetail;
import cn.xtits.job.entity.TaskDetailExample;
import cn.xtits.job.mapper.base.TaskDetailMapper;
import cn.xtits.job.service.TaskDetailService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Generator on 2019-07-04 04:06:57
 */
@Service
public class TaskDetailServiceImpl implements TaskDetailService {

    @Resource
    private TaskDetailMapper taskDetailMapper;

    @Override
    public List<TaskDetailDto> listTaskDetailAll(Map<String, Object> map) {
        return taskDetailMapper.listTaskDetailAll(map);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TaskDetail record) {
        return taskDetailMapper.insertSelective(record);
    }

    @Override
    public List<TaskDetail> listByExample(TaskDetailExample example) {
        PageHelper.startPage(example.getPageIndex().intValue(), example.getPageSize().intValue());
        Page page = (Page) taskDetailMapper.selectByExample(example);
        example.setCount((int) page.getTotal());
        return page.toPageInfo().getList();
    }

    @Override
    public TaskDetail getByPrimaryKey(Integer id) {
        return taskDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(TaskDetail record) {
        return taskDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TaskDetail record) {
        return taskDetailMapper.updateByPrimaryKeySelective(record);
    }


}