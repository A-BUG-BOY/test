package cn.fv.annotation;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts(
        value = {
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class }) }
)
public class CountSqlTime implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // sqlId为mapper文件中定义的id，例如：com.**.dao.**Mapper.selectByPrimaryKey
        String sqlId = mappedStatement.getId();
        ParameterMap parameterMap = mappedStatement.getParameterMap();
        BoundSql boundSql = mappedStatement.getBoundSql(parameterMap.getParameterMappings());
        String sql = boundSql.getSql();
        //System.out.println(sql);
        // 开始时间
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } catch (Exception e) {
            System.out.println(sqlId + "执行失败！" + e);
            return null;
        } finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("SQL"+"["+sql+"]"+"CountTime:"+time+"ms");
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("计算sql时间");
    }
}
