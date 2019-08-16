package cn.xtits.job.mapper;

import cn.xtits.job.dto.TaskDetailDto;

import java.util.List;
import java.util.Map;

/**
 * Created by  on 2019-07-04 04:06:57
 */

public interface TaskDetailExtMapper {

    List<TaskDetailDto> listTaskDetailAll(Map<String, Object> map);

}
