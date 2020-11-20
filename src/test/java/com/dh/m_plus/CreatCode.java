package com.dh.m_plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

/**
 * @Auther:D-hao
 * @Date:2020/11/16-11-16-20:55
 * @Description:com.dh.m_plus
 */
public class CreatCode {
    public static void main(String[] args) {
        //配置代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setAuthor("dh")
                .setOutputDir(projectPath+"/src/main/java")//设置输出路径
                .setFileOverride(true)//设置文件覆盖
                .setIdType(IdType.AUTO)//设置主键生成策略
                .setServiceName("%sService")//service接口的名称,去Service的I前缀
                .setBaseResultMap(true)//基本结果集合
                .setBaseColumnList(true)//设置基本的列
                .setControllerName("%sController");
        //配置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver").setUrl("jdbc:mysql://localhost:3306/xueshen?serverTimezone=UTC")
                .setUsername("root").setPassword("1234").setDbType(DbType.MYSQL);


        // 自动填充配置( setTableFillList(tableFills) )gmt_create,gmt_modified
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//设置全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略
                .setLogicDeleteFieldName("deleted") //设置逻辑删除
                .setTableFillList(tableFills)    // 自动填充配置
                .setVersionFieldName("version"); // 乐观锁
        // .setEntityLombokModel(true);  自动lombok；
        //.setTablePrefix("tbl_")//设置表名前缀
        //.setInclude("blog_tags","course","links","sys_settings","user_record","user_say" )设置要映射的表名
        //strategy.setControllerMappingHyphenStyle(true);  localhost:8080/hello_id_2（注意名字）

        //包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.dh.m_plus").setMapper("mapper")
                .setService("service").setController("controller")
                .setEntity("bean").
                setXml("mapper");

        autoGenerator.setGlobalConfig(globalConfig).setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig).setPackageInfo(packageConfig);

        //执行
        autoGenerator.execute();
    }
}
