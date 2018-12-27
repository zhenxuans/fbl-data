package me.robbie.fbl.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

	@Value("${fbl.data.theadpool.corepoolsize}")
	private int corePoolSize;
	
	@Value("${fbl.data.theadpool.maxpoolsize}")
    private int maxPoolSize;
	
	@Value("${fbl.data.theadpool.queuecapacity}")
    private int queueCapacity;

	@Value("mybatis-config.xml")
    private String mybatisConfigFile;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }

    @Bean
    public SqlSession getDbSession() throws IOException {
        InputStream in = Resources.getResourceAsStream(mybatisConfigFile);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        return session;
    }
}
