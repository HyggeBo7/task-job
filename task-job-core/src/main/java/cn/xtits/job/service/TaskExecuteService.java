package cn.xtits.job.service;

import cn.xtits.job.entity.TaskExecute;
import cn.xtits.job.entity.TaskExecuteExample;

import java.util.List;

/**
 * Created by Generator 2019-07-04 04:06:57
 */
public interface TaskExecuteService {

    TaskExecute insertTaskExecuteSynchronizeGenerate(Integer taskDetailId);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskExecute record);

    List<TaskExecute> listByExample(TaskExecuteExample example);

    TaskExecute getByPrimaryKey(Integer id);

    int updateByPrimaryKey(TaskExecute record);

    int updateByPrimaryKeySelective(TaskExecute record);

}