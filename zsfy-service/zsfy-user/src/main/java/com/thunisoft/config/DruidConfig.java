package com.thunisoft.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Autowired
    private DruidConfigProp druidConfigProp;

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 白名单
        // servletRegistrationBean.addInitParameter("allow", "192.168.2.25,127.0.0.1");
        // IP黑名单(共同存在时，deny优先于allow)
        // servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", druidConfigProp.getLoginUsername());
        servletRegistrationBean.addInitParameter("loginPassword", druidConfigProp.getLoginPassword());
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        servletRegistrationBean.addInitParameter("logSlowSql", druidConfigProp.getLogSlowSql());
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(druidConfigProp.getUrl());
        datasource.setUsername(druidConfigProp.getUsername());
        datasource.setPassword(druidConfigProp.getPassword());
        datasource.setDriverClassName(druidConfigProp.getDriverClassName());
        datasource.setInitialSize(druidConfigProp.getInitialSize());
        datasource.setMinIdle(druidConfigProp.getMinIdle());
        datasource.setMaxActive(druidConfigProp.getMaxActive());
        //datasource.setDbType(type);
        datasource.setMaxWait(druidConfigProp.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(druidConfigProp.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(druidConfigProp.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(druidConfigProp.getValidationQuery());
        datasource.setTestWhileIdle(druidConfigProp.isTestWhileIdle());
        datasource.setTestOnBorrow(druidConfigProp.isTestOnBorrow());
        datasource.setTestOnReturn(druidConfigProp.isTestOnReturn());
        try {
            datasource.setFilters(druidConfigProp.getFilters());
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }
}
