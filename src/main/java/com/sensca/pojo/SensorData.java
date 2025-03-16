package com.sensca.pojo;

import java.time.LocalDateTime;

/**
 * @Author: liyuelian
 * @Date: 2025/3/16 00:11
 * @Description:
 **/
public class SensorData {
    /**
     * 设备id
     */
    private String deviceId;
    /**
     * 时间戳
     */
    private LocalDateTime dateTime;
    /**
     * 温度
     */
    private double temperature;
    /**
     * 湿度
     */
    private double humidity;

    public SensorData() {
    }

    public SensorData(String deviceId, LocalDateTime dateTime, double temperature, double humidity) {
        this.deviceId = deviceId;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
