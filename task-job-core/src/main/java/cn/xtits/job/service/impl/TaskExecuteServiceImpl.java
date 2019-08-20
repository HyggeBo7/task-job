package cn.xtits.job.service.impl;

import cn.xtits.job.dto.TaskDetailDto;
import cn.xtits.job.entity.TaskExecute;
import cn.xtits.job.entity.TaskExecuteExample;
import cn.xtits.job.enums.TaskExecuteStatusEnums;
import cn.xtits.job.enums.TaskStatusEnums;
import cn.xtits.job.mapper.base.TaskDetailMapper;
import cn.xtits.job.mapper.base.TaskExecuteMapper;
import cn.xtits.job.service.TaskExecuteService;
import cn.xtits.job.util.DateUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Generator on 2019-07-04 04:06:57
 */
@Service
public class TaskExecuteServiceImpl implements TaskExecuteService {

    @Resource
    private TaskExecuteMapper taskExecuteMapper;

    @Resource
    private TaskDetailMapper taskDetailMapper;

    private final Object insertLock = new Object();

    @Override
    public TaskExecute insertTaskExecuteSynchronizeGenerate(Integer taskDetailId) {
        TaskDetailDto serverTaskDetail = taskDetailMapper.getTaskDetailExt(taskDetailId);
        if (!TaskStatusEnums.EXECUTING.value.equals(serverTaskDetail.getTaskStatus())) {
            return null;
        }
        TaskExecute taskExecute = new TaskExecute();
        taskExecute.setStatus(TaskExecuteStatusEnums.INIT.value);
        taskExecute.setTaskId(serverTaskDetail.getTaskId());
        taskExecute.setTaskDetailId(serverTaskDetail.getId());
        taskExecute.setLocationId(serverTaskDetail.getLocationId());
        taskExecute.setLocationName(serverTaskDetail.getLocationName());
        taskExecute.setTaskType(serverTaskDetail.getTaskType());
        taskExecute.setTaskBillCode(serverTaskDetail.getTaskBillCode());
        taskExecute.setManagerId(serverTaskDetail.getManagerId());
        taskExecute.setManager(serverTaskDetail.getManager());
        taskExecute.setDeleteFlag(false);
        taskExecute.setMakeBillMan("自动生成:" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        synchronized (insertLock) {
            taskExecute.setBillNo(getNextBillNo());
            taskExecuteMapper.insertSelective(taskExecute);
        }
        return taskExecute;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return taskExecuteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TaskExecute record) {
        return taskExecuteMapper.insertSelective(record);
    }

    @Override
    public List<TaskExecute> listByExample(TaskExecuteExample example) {
        PageHelper.startPage(example.getPageIndex().intValue(), example.getPageSize().intValue());
        Page page = (Page) taskExecuteMapper.selectByExample(example);
        example.setCount((int) page.getTotal());
        return page.toPageInfo().getList();
    }

    @Override
    public TaskExecute getByPrimaryKey(Integer id) {
        return taskExecuteMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(TaskExecute record) {
        return taskExecuteMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(TaskExecute record) {
        return taskExecuteMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * 获取下一个 序号
     *
     * @return 前缀@年月日@序号-
     */
    private String getNextBillNo() {
        String codeNoLike = "TE" + DateUtil.getTimeToString("yyyyMMdd");
        TaskExecuteExample taskExecuteExample = new TaskExecuteExample();
        taskExecuteExample.setPageSize(1);
        taskExecuteExample.setOrderByClause("Id Desc");
        TaskExecuteExample.Criteria taskExecuteExampleCriteria = taskExecuteExample.createCriteria();
        taskExecuteExampleCriteria.andBillNoLike(codeNoLike + "%");
        List<TaskExecute> taskExecuteList = listByExample(taskExecuteExample);
        long num = 1;
        if (taskExecuteList.size() > 0) {
            String codeNo = taskExecuteList.get(0).getBillNo();
            String substring = codeNo.substring(codeNoLike.length());
            num = Long.parseLong(substring) + 1;
        }
        String format = String.format("%03d", num);
        return codeNoLike + format;
    }

}