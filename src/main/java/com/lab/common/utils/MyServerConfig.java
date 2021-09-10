package com.lab.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 服务器路径读取工具类
 *
 * @author wangyanlei
 * @date 2020年11月15日
 */
@Component
@Slf4j
public class MyServerConfig implements ApplicationListener<WebServerInitializedEvent> {

    /**
     * 服务器端口
     */
    private int serverPort;

    /**
     * 获取路径url
     */
    public String getUrl() {
        // 定义ip地址
        InetAddress address = null;
        try {
            // 设置ip地址
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // 日志
            log.error("获取路径url失败:" , e);
        }
        // 返回结果
        return "http://" + address.getHostAddress() + ":" + this.serverPort;
    }

    /**
     * 设置ApplicationEvent
     *
     * @param event 时间
     */
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        // 获取端口
        this.serverPort = event.getWebServer().getPort();
    }
}
