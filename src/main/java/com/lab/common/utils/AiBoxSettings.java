package com.lab.common.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * AIBoxSettings
 *
 * @author 丛有志
 * @date 2020/9/22 20:41
 * <p>
 * 版本        修改时间        作者        修改内容
 * V1.0        2020/9/22       丛有志        初始版本
 */
@Data
@Component
@ConfigurationProperties(prefix = "ai" )
public class AiBoxSettings {

    /**
     * 盒子配置信息
     */
    private List<Map<String, String>> box;

}
