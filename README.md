# generator
##定制化代码生成工具<br/>
自动生成Mybatis ORM文件步骤:
1) 修改jdbc配置:/conf/jdbc.properties
2) 修改模板配置(非必须):/conf/template.properties,可指定项目顶级package，存放生成文件的顶级路径
3) 生成文件:<br/>
a.生成所有表对应的javaBean,mapper,DAO文件运行该方法:<br/>
org.stathry.generator.MyBatisGeneratorTest.testSmartGeneratorWithDAO<br/>
b.生成所有表对应的javaBean,mapper运行该方法:<br/>
org.stathry.generator.MyBatisGeneratorTest.testSmartGenerator<br/>

指定表自动生成Mybatis ORM文件运行该方法:<br/>
org.stathry.generator.MyBatisGeneratorTest.testSmartGenerateByTables

一键生成Mybatis中的Mapper,POJO,DAO 带注释且可定制
如果你项目中的持久层用的是MyBatis,那么这么文章可能会帮你省掉以下繁琐的操作:

根据表结构手动编写POJO
编写Mapper映射文件
编写访问持久层的DAO
多个表以上步骤重复多次
所有这些繁琐的操作现在只需要改个jdbc配置即可一键帮你生成数据库中所有表的ORM文件或指定表的ORM文件，并且可以定制化。让你为所欲为！

先声明下我不是通过开源的mybatis-generator实现的，因为mybatis-generator生成的信息比较冗余或不是我想要的，如缺注释，

下面先讲我是如何实现自动根据表结构生成上述ORM文件的。然后会附上源代码在github的URL及如何使用。

以mysql为例，mysql服务会自带一个表information_schema用来存储所有表的信息，其中information_schema.tables存储所有表的基本信息，information_schema.columns存储所有表的所有字段信息。通过这两张表我可以查到我生成ORM文件所需的所有信息，包括表名、表注释、字段名、字段类型、字段注释等。
拿到这些信息再经过加工(如字段的下划线分割变成驼峰命名，jdbcType转化为java的数据类型等)，然后将加工后的信息载入freemaker上下文。
编写freemaker模板来定制ORM文件格式，然后结合freemaker上下文中的信息就可以一键生成所有表的ORM文件了。
