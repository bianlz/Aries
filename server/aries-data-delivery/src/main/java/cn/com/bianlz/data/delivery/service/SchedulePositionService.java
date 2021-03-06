package cn.com.bianlz.data.delivery.service;

import cn.com.bianlz.data.delivery.api.vo.Position;
import cn.com.bianlz.data.delivery.api.vo.SchedulePosition;

import java.util.List;
import java.util.Map;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
public interface SchedulePositionService {
    List<Position> getById(Long uuid);

    List<Map<String,Object>> getPositionInfo(String day,List<String> apps);
}
