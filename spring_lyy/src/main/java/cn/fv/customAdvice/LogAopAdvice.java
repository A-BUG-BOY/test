package cn.fv.customAdvice;

import cn.fv.annotation.LogAnno;
import cn.fv.pojo.Logtable;
import cn.fv.service.LogTableService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAopAdvice {
    @Autowired
    private LogTableService logTableService;

    /**
     * 环绕通知记录日志通过注解匹配到需要增加日志功能的方法
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(cn.fv.annotation.LogAnno)")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        System.out.println("日志开启");
        //获取方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //获取方法名
        Method method = methodSignature.getMethod();
        //获取注解签名
        LogAnno logAnno =  method.getAnnotation(LogAnno.class);
        //获取操作类型
        //System.out.println(logAnno.operateType());

        //返回目标对象
        Object target = pjp.getTarget();
        System.out.println(target);


        //创建日志对象
        Logtable logtable = new Logtable();
        logtable.setOperatetype("增加");
        logtable.setOperateor("lyy");
        Object result = null;
        try {
             result =  pjp.proceed();
            logtable.setOperateresult("正常");// 设置操作结果
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logtable.setOperateresult("失败");
        }finally {
            logtable.setOperatedate(new Date());// 设置操作日期
            logTableService.addLog(logtable);// 添加日志记录
        }
        System.out.println("日志关闭");
        return result;
    }
}
