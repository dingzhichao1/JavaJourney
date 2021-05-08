###Spring
####Spring Framework
#####轻量级 一站式 开源框架 减耦合
#####核心：IOC  AOP
######IOC、DI

#####核心接口
######BeanFactory  Bean的注册和加载



######ApplicationContext
######ApplicationContext
######ApplicationContext

####Spring Boot
#####简化应用和服务的创建、开发和部署 简化配置 内置服务器
#####核心思想：约定大于配置
#####Spring-Boot-Dependencies 管理依赖的版本,建立起SpringBoot版本与其它依赖的版本关系

#####Spring Data
######数据访问和操作
#####Spring Cloud
######一站式微服务解决框架
#####Spring Security




####Spring加载的逻辑
    核心的逻辑在AbstractBeanFactory 的doGetBean
    1、处理获取BeanName,主要处理FactoryBeanPrifix &  区分获取BeanFactory还是获取对象
    2、检查单例缓存中是否有对象
    3、