# 说明
商品模块

## 模块说明
1. Types模块 \
对外暴露的Domain Primitives的模块，无状态，纯POJO \
Types，Domain模块都属于无外部依赖的纯POJO，基本上都可以100%的被单元测试覆盖。
3. Domain模块 \
核心业务逻辑集中第，包含有状态的Entity，领域服务Domain Service，以及各种外部依赖的接口类。如：Repository,ACL,中间件等
4. Application模块 \
主要包含Application Service和一些相关的类，依赖Domain模块，不依赖其他框架
5. Infrastructure模块 \
包含了Persistence、Messaging、External等模块。比如：Persistence模块包含数据库DAO的实现，包含Data Object、ORM Mapper、Entity到DO的转化类等。Persistence模块要依赖具体的ORM类库，比如MyBatis。如果需要用Spring-Mybatis提供的注解方案，则需要依赖Spring。
6. Web模块 \
Web模块包含Controller等相关代码。如果用SpringMVC则需要依赖Spring。
7. Start模块 \
Start模块是SpringBoot的启动类。
通常应用的集成测试写在start里。当其他模块的单元测试都能100%覆盖后，集成测试用来验证整体链路的真实性。
