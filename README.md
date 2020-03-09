# Springboot学习
## 社区项目实战

## 资料&工具

[Spring 文档](https://spring.io/guides)\
[Bootstrap 文档](https://v3.bootcss.com/)\
[es社区](https://elasticsearch.cn/)\
[Git OAuth](https://developer.github.com/apps/building-oauth-apps/)\
[Visual paradigm](https://www.visual-paradigm.com/cn/)\
[lombok](https://projectlombok.org/)

##脚本
```sql
CREATE CACHED TABLE "PUBLIC"."USER"(
    "ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_49AA732B_EF5A_4E6D_B45A_5E13C808D8E4" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_49AA732B_EF5A_4E6D_B45A_5E13C808D8E4",
    "ACCOUNT_ID" VARCHAR(100),
    "NAME" VARCHAR(50),
    "TOKEN" CHAR(36),
    "GMT_CREATE" BIGINT,
    "GMT_MODIFIED" BIGINT
)
```

```text
执行flyway
mvn flyway:migrate
执行mybatis generater
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```
