package cn.com.bianlz.service;

import cn.com.bianlz.vo.Schedule;

import java.util.Collection;
import java.util.List;

/**
 * Created by bianlanzhou on 17/10/13.
 * Description
 */
public interface ScheduleService {
    void saveSchedule(Collection<Schedule> collection)throws Exception;
    List<Schedule> getScheduleByDay(String day);
}
