package com.uoolo.jumota.common.util;

import org.apache.commons.lang3.Validate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @Author: WuChao
 * @Description: 工具类@静态方法调用service中的函数
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext.
 * https://blog.csdn.net/handsome_le/article/details/80846404
 * @Date: Create in 18:58 2021/3/24
 */
@Slf4j
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        if (log.isDebugEnabled()) {
            log.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        }
        applicationContext = null;
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
    }

    /**
     * 发布事件
     *
     * @param event
     */
    public static void publishEvent(ApplicationEvent event) {
        if (applicationContext == null) {
            return;
        }
        applicationContext.publishEvent(event);
    }

    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy() {
        SpringContextHolder.clearHolder();
    }
}
