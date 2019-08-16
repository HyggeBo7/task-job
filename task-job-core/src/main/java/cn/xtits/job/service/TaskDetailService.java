package cn.xtits.job.service;


import cn.xtits.job.dto.TaskDetailDto;
import cn.xtits.job.entity.TaskDetail;
import cn.xtits.job.entity.TaskDetailExample;

import java.util.List;
import java.util.Map;

/**
 * Created by Generator 2019-07-04 04:06:57
 */
public interface TaskDetailService {

    List<TaskDetailDto> listTaskDetailAll(Map<String, Object> map);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskDetail record);

    List<TaskDetail> listByExample(TaskDetailExample example);

    TaskDetail getByPrimaryKey(Integer id);

    int updateByPrimaryKey(TaskDetail record);

    int updateByPrimaryKeySelective(TaskDetail record);

}