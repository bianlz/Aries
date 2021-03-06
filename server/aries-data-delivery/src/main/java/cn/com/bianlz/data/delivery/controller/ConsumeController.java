package cn.com.bianlz.data.delivery.controller;

import cn.com.bianlz.data.delivery.api.vo.Consume;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.service.ConsumeService;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cn.com.bianlz.data.delivery.api.vo.DataDeliveryApiProtocolCode;

import java.util.List;

/**
 * Created by bianlanzhou on 17/10/20.
 * Description
 */
@RestController
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;
    @GetMapping(value={"/consume/{uuid}/{day}","/consume/{uuid}"})
    public Result<Object> getConsume(@PathVariable(value = "day",required = false)String day,@PathVariable(value = "uuid")Long uuid){
        Result<Object> result = new Result<Object>();
        result.setCode(DataDeliveryApiProtocolCode.SUCCESS.getCode());
        result.setCode(DataDeliveryApiProtocolCode.SUCCESS.getMessage());
        try {
            if(day==null){
                result.setData(Unirest.get("http://data.delivery.com/data/consume/" + uuid).asString().getBody());
            }else{
                result.setData(consumeService.getConsume(day, uuid));
            }
        } catch (UnirestException e) {
            e.printStackTrace();
            result.setCode(DataDeliveryApiProtocolCode.FAIL.getCode());
            result.setMessage(DataDeliveryApiProtocolCode.FAIL.getMessage());
        }
        return result;
    }
}
