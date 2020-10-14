<p align="center">
  <a href="https://github.com/osalien/njfu_osalien_com">
     <img alt="njfu logo" src="http://oss.osalien.com/njfu.jpg">
  </a>
</p>
<p align="center">
  Everyone can develop projects independently, quickly and efficiently！
</p>

<p align="center">  
  <a href="https://github.com/osalien/njfu_osalien_com/">
    <img alt="spring-boot-plus version" src="https://img.shields.io/badge/spring--boot--plus-2.0-blue">
  </a>
  <a href="https://github.com/spring-projects/spring-boot">
    <img alt="spring boot version" src="https://img.shields.io/badge/spring%20boot-2.2.5.RELEASE-brightgreen">
  </a>
  <a href="https://www.apache.org/licenses/LICENSE-2.0">
    <img alt="code style" src="https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square">
  </a>
</p>

## 目标
> 每个人都可以独立、快速、高效地开发项目！

#### [GITHUB](https://github.com/osalien/njfu_osalien_com)

#### [osalien.com](http://osalien.com)

### 主要特性
- 集成spring boot 常用开发组件集、公共配置、AOP日志等
- Maven多模块架构
- 集成mybatis plus快速dao操作
- 快速生成后台代码: entity/param/vo/controller/service/mapper/xml
- 集成Swagger/Knife4j，可自动生成api文档
- 集成jwt、shiro权限控制
- 集成Redis缓存
- 集成HikariCP连接池，JDBC性能和慢查询检测
- 集成spring boot admin，实时检测项目运行情况
- 使用assembly maven插件进行不同环境打包部署,包含启动、重启命令，配置文件提取到外部config目录

## 项目结构
```text
  njfu-osalien-com
    ├── admin               SpringBootAdmin Server模块
    ├── bootstrap           njfu-osalien-com 启动模块
    ├── config              配置模块
    ├── distribution        打包模块
    ├── docs                文档目录
    ├── example             示例模块，自己的业务可新建多个模块处理
    ├── framework           框架核心模块
    ├── generator           代码生成模块
    ├── scheduled           任务调度模块
    └── system              系统模块
```

### 项目环境 
中间件 | 版本 |  备注
-|-|-
JDK | 1.8+ | JDK1.8及以上 |
MySQL | 5.7+ | 5.7及以上 |
Redis | 3.2+ |  |

### 技术选型 
技术 | 版本 |  备注
-|-|-
Spring Boot | 2.2.0.RELEASE | 最新发布稳定版 |
Spring Framework | 5.2.0.RELEASE | 最新发布稳定版 |
Spring Boot Admin| 2.2.2 | 管理和监控SpringBoot应用程序 |
Mybatis | 3.5.3 | 持久层框架 |
Mybatis Plus | 3.3.1 | mybatis增强框架 |
HikariCP | 3.4.2 | 数据源 |
Fastjson | 1.2.67 | JSON处理工具集 |
Swagger2 | 2.9.2 | api文档生成工具 |
Knife4j | 2.0.2 | api文档生成工具 |
commons-lang3 | 3.9 | 常用工具包 |
commons-io | 2.6 | IO工具包 |
commons-codec | 1.14 | 加密解密等工具包 |
commons-collections4 | 4.4 | 集合工具包 |
reflections | 0.9.9 | 反射工具包 |
hibernate-validator | 6.0.18.Final | 后台参数校验注解 |
Shiro | 1.5.1 | 权限控制 |
JWT | 3.10.1 | JSON WEB TOKEN |
hutool-all | 5.2.4 | 常用工具集 |
lombok | 1.18.12 | 注解生成Java Bean等工具 |
mapstruct | 1.3.1.Final | 对象属性复制工具 |

### 项目链路图
![项目调用链路图](http://oss.osalien.com/link-diagram.jpg)

## 快速开始
### 克隆 spring-boot-plus
```bash
git clone https://github.com/osalien/njfu_osalien_com.git
cd njfu_osalien_com
```

### Maven 构建
> 默认使用dev环境,对应配置文件：application-dev.yml

```bash
mvn clean package -Pdev
```


## 5分钟完成增删改查

### 1. 创建数据库表
```sql
-- ----------------------------
-- Table structure for foo_bar
-- ----------------------------
DROP TABLE IF EXISTS `foo_bar`;
CREATE TABLE `foo_bar`
(
    `id`            bigint(20)  NOT NULL COMMENT '主键',
    `name`          varchar(20) NOT NULL COMMENT '名称',
    `foo`           varchar(20)          DEFAULT NULL COMMENT 'Foo',
    `bar`           varchar(20) NOT NULL COMMENT 'Bar',
    `remark`        varchar(200)         DEFAULT NULL COMMENT '备注',
    `state`         int(11)     NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
    `version`       int(11)     NOT NULL DEFAULT '0' COMMENT '版本',
    `create_time`   timestamp   NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   timestamp   NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='FooBar';

-- ----------------------------
-- Records of foo_bar
-- ----------------------------
INSERT INTO foo_bar (id, name, foo, bar, remark, state, version, create_time, update_time) 
    VALUES (1, 'FooBar', 'foo', 'bar', 'remark...', 1, 0, '2019-11-01 14:05:14', null);
INSERT INTO foo_bar (id, name, foo, bar, remark, state, version, create_time, update_time) 
    VALUES (2, 'HelloWorld', 'hello', 'world', null, 1, 0, '2019-11-01 14:05:14', null);

```


### 2.使用代码生成器生成增删改查代码
> 代码生成入口类，在generator模块中

```text
njfu_osalien_com/generator/src/main/java/com/osalien/njfu/generator/CodingLabGenerator.java
```

```java
/**
 * njfu_osalien_com代码生成器入口类
 *
* @author Coding实验室
* @date 2019-10-22
**/
@Component
public class CodingLabGenerator {

 /**
  * Generator Code
  * @param args
  */
 public static void main(String[] args) {
     GeneratorProperties generatorProperties = new GeneratorProperties();

     // Common configuration
     generatorProperties
             .setMavenModuleName("example")
             .setParentPackage("com.example")
             .setModuleName("foobar")
             .setAuthor("Coding实验室")
             .setFileOverride(true);

     // generator Table
     generatorProperties.addTable("foo_bar","id");

     // DataSourceConfig
     generatorProperties.getDataSourceConfig()
             .setDbType(DbType.MYSQL)
             .setUsername("root")
             .setPassword("root")
             .setDriverName("com.mysql.jdbc.Driver")
             .setUrl("jdbc:mysql://localhost:3306/njfu_osalien_com?useUnicode=true&characterEncoding=UTF-8&useSSL=false");

     // GeneratorConfig
     generatorProperties.getGeneratorConfig()
             .setGeneratorStrategy(GeneratorStrategy.SINGLE)
             .setGeneratorEntity(true)
             .setGeneratorController(true)
             .setGeneratorService(true)
             .setGeneratorServiceImpl(true)
             .setGeneratorMapper(true)
             .setGeneratorMapperXml(true)
             .setGeneratorPageParam(true)
             .setGeneratorQueryVo(true)
             .setRequiresPermissions(true)
             .setPageListOrder(true)
             .setParamValidation(true)
             .setSwaggerTags(true)
             .setOperationLog(true);

     // GlobalConfig
     generatorProperties.getMybatisPlusGeneratorConfig().getGlobalConfig()
             .setOpen(true)
             .setSwagger2(true)
             .setIdType(IdType.AUTO)
             .setDateType(DateType.ONLY_DATE);

     // StrategyConfig
     generatorProperties.getMybatisPlusGeneratorConfig().getStrategyConfig()
             .setNaming(NamingStrategy.underline_to_camel)
             .setColumnNaming(NamingStrategy.underline_to_camel)
             .setEntityLombokModel(true)
             .setRestControllerStyle(true)
             .setControllerMappingHyphenStyle(true)
             .setVersionFieldName(GeneratorConstant.VERSION)
             .setLogicDeleteFieldName(GeneratorConstant.DELETED);

     // Code Generator 
     CodeGenerator codeGenerator = new CodeGenerator();
     codeGenerator.generator(generatorProperties);
 }
}
```

#### Code Generator Templates
> 使用Velocity模版生成代码，可自定义修改代码生成模版

```text
njfu_osalien_com/generator/src/main/resources
```

```text
└── templates
    ├── controller.java.vm      控制器代码生成模版
    ├── entity.java.vm          实体类代码生成模版
    ├── mapper.java.vm          mapper代码生成模版
    ├── mapper.xml.vm           mapper xml 代码生成模版
    ├── pageParam.java.vm       分页参数代码生成模版
    ├── queryVo.java.vm         查询结果代码生成模版
    ├── service.java.vm         服务接口代码生成模版
    └── serviceImpl.java.vm     服务实现代码生成模版
```

#### 生成的代码结构

```text
└── src
    └── main
        ├── java
        │   └── com
        │       └── example
        │           └── foobar
        │               ├── controller
        │               │   └── FooBarController.java
        │               ├── entity
        │               │   └── FooBar.java
        │               ├── mapper
        │               │   └── FooBarMapper.java
        │               ├── param
        │               │   └── FooBarPageParam.java
        │               ├── service
        │               │   ├── FooBarService.java
        │               │   └── impl
        │               │       └── FooBarServiceImpl.java
        │               └── vo
        │                   └── FooBarQueryVo.java
        └── resources
            └── mapper
                └── foobar
                    └── FooBarMapper.xml
```

### 3. 启动SpringBootAdmin
> SpringBootAdmin Server启动类，在admin模块中  [http://localhost:8000](http://localhost:8000)

```text
njfu_osalien_com/admin/src/main/java/com/osalien/njfu/admin/CodingLabAdminApplication
```

```java
/**
 * Spring Boot Admin Bootstrap Main Class
 *
 * @author Coding实验室
 * @date 2020/3/20
 **/
@Slf4j
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@SpringBootApplication
public class CodingLabAdminApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CodingLabAdminApplication.class, args);
        ConfigurableEnvironment environment = context.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        log.info("SpringBootAdmin: http://localhost:" + serverPort);
    }

}
```

### 4. 启动项目
> 项目入口类，在bootstrap模块中  [http://localhost:8888](http://localhost:8888)

```text
njfu_osalien_com/bootstrap/src/main/java/com/osalien/njfu/CodingLabApplication.java
```

```java
/**
 * njfu_osalien_com Project Main Class
 *
 * @author Coding实验室
 * @since 2018-11-08
 */
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@EnableConfigurationProperties
@ServletComponentScan
@MapperScan({"com.osalien.njfu.**.mapper", "com.example.**.mapper"})
@SpringBootApplication(scanBasePackages = {"com.osalien.njfu", "com.example"})
public class CodingLabApplication {

    public static void main(String[] args) {
        // Run spring-boot-plus
        ConfigurableApplicationContext context = SpringApplication.run(CodingLabApplication.class, args);
        // Print Project Info
        PrintApplicationInfo.print(context);
        // Print Project Tip
        PrintApplicationInfo.printTip(context);
    }

}
```

### 5. 访问项目Swagger文档
[http://localhost:8888/api/swagger-ui.html](http://localhost:8888/api/swagger-ui.html)

### 6. 访问Knife4j文档
[http://localhost:8888/api/doc.html](http://localhost:8888/api/doc.html)

## njfu-osalien-com-vue 前端项目
### [GITHUB-REPO](https://github.com/osalien/njfu_osalien_com_vue)
### [VUE演示地址](http://njfu.osalien.com)

## 联系
微信公众号 Coding实验室

<img alt="Coding实验室" src="http://oss.osalien.com/CodingLab.jpg" height="248" width="248">

## 赞赏
请作者喝杯奶茶~
                          
<img alt="Coding实验室" src="http://oss.osalien.com/money.jpg" height="248" width="248">

## License
njfu-osalien-com is under the Apache 2.0 license. 
