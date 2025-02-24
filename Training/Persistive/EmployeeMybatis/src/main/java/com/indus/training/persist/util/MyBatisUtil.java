package com.indus.training.persist.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SqlSessionFactory: " + e.getMessage(), e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static void shutdown() {
        if (sqlSessionFactory != null) {
            // Closing any pooled connections if using a pooled data source
            PooledDataSource dataSource = (PooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            if (dataSource != null) {
                dataSource.forceCloseAll(); // Close all connections in the pool
            }
            sqlSessionFactory = null; // Clear the factory reference
        }
    }
}
