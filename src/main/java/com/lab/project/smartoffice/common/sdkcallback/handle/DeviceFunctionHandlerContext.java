package com.lab.project.smartoffice.common.sdkcallback.handle;

import com.lab.framework.aspectj.lang.annotation.Log;
import com.lab.project.smartoffice.common.sdkcallback.annotation.DeviceFunctionAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈宽
 * @create 2021-10-15 15:18
 * @description
 */
@Slf4j
@Data
@Component
@AllArgsConstructor
public class DeviceFunctionHandlerContext implements ApplicationContextAware {

    ApplicationContext applicationContext;

    private static final  Map<String, Class> BEAN_HASH_MAP = new HashMap<>(10);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(DeviceFunctionAnnotation.class);
        if (beans != null && beans.size() > 0){
            for(Object bean: beans.values()){
                String value = bean.getClass().getAnnotation(DeviceFunctionAnnotation.class).value();
                BEAN_HASH_MAP.put(value, bean.getClass());

            }
        }
    }

    public AbstractDeviceTypeHandler getHandlerInstance(String type){
        Class instance = BEAN_HASH_MAP.get(type);
        if (instance == null){
            log.error("未找到对应的业务接口：{}",type);
        }
        return (AbstractDeviceTypeHandler) applicationContext.getBean(instance);
    }
}
