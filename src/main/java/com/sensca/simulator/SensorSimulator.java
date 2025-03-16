package com.sensca.simulator;

import com.alibaba.fastjson.JSONObject;
import com.sensca.pojo.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @Author: liyuelian
 * @Date: 2025/3/16 00:09
 * @Description: 生成模拟的传感器数据
 **/
@Component
public class SensorSimulator {
    //topic
    private static final String TOPIC = "sensor-data";
    private static final Random random = new Random();

    private final KafkaTemplate<String, String> kafkaTemplate;

    // 构造器注入
    @Autowired
    public SensorSimulator(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    /**
     * 生成模拟的传感器数据
     */
    @Scheduled(fixedRate = 2000) // 每2秒生成一次
    public void generateData() {
        SensorData sensorData = new SensorData();
        //设备名称
        sensorData.setDeviceId("DEV" + String.format("%03d", random.nextInt(100)));
        //获取时间
        sensorData.setDateTime(LocalDateTime.now());
        //温度，使用高斯分布更真实
        sensorData.setTemperature(20 + random.nextGaussian() * 5);
        //湿度
        sensorData.setHumidity(40 + random.nextFloat() * 30);
        String dataMsg = JSONObject.toJSONString(sensorData);
        //发送kafka数据
        kafkaTemplate.send(TOPIC, dataMsg);
    }


}
