package com.zchuber.mybatissourcedeepdiving;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;


@Intercepts({
        @Signature(type= StatementHandler.class,method="query",args={Statement.class, ResultHandler.class}),
        @Signature(type= StatementHandler.class,method="update",args={Statement.class}),
        @Signature(type= StatementHandler.class,method="batch",args={Statement.class})
})
public class SlowSqlInteceptor implements Interceptor {

    private Integer limitSecond;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long beginTimeMillis=System.currentTimeMillis();
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        try{
            return invocation.proceed();
        }finally{
            long endTimeMills = System.currentTimeMillis();
            long conTimeMills = endTimeMills - beginTimeMillis;
            if (conTimeMills > limitSecond * 1000) {
                BoundSql boundSql = statementHandler.getBoundSql();
                String sql = getFormatSql(boundSql);
                System.out.println("SQL语句【"+sql+"】，执行耗时："+conTimeMills+"ms");
            }
        }
    }

    private String getFormatSql(BoundSql boundSql) {
        return boundSql.getSql();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        String limitSecondStr = (String) properties.get("limitSeconds");
        this.limitSecond=Integer.parseInt(limitSecondStr);
    }
}
