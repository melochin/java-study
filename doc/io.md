
## 文件
**File.list()**:列出目录下的所有文件  
**File.list(FilenameFilter)**:根据条件进行过滤，可用lambda  

设计模式
策略模式
list方法提供了基本功能，可以提供FilenameFilter来决定list的行为

## 流

InputStream && OutputStream

Reader && Writer

InpuStreamReader && OutputStreamWriter


## 序列化
**序列化**：在某些情况下需要将**对象持久化**，可以将对象转换为文件保存在硬盘上，这一转换过程称为**序列化**  


### Serializable 
对象要想具有序列化的能力，必须实现``Serializable``接口，该接口无任何方法。用于标记对象是否具有序列化能力。  
由``ObjectOutputStream``和``ObjectInputStream``对象序列化和反序列化，大致调用代码如下([详细请见](../src/main/java/io/stream/Serialization.java))

**序列化**
``` java
ObjectOutputStream output = new ObjectOutputStream(outputStream);
output.writeObject(obj);
```
**反序列化**
``` java
ObjectInputStream input = new ObjectInputStream(inputStream);
input.readObject(obj);
```

### Externalizable
有时序列化或反序列化时需要对指定字段特殊处理（如不允许字段序列化）  
``Externalizable``该接口提供了序列化或反序列化时自订的功能

``` java
// 序列化处理　需要序列化的字段，通过out.write
void writeExternal(ObjectOutput out)
 
// 反序列化处理　需要反序列化的字段，通过in.read
// 该方法调用之前，会调用默认构造函数
void readExternal(ObjectInput in)　
```


注意：  
1.``Externalizable``不会自动序列化（反序列化）对象字段，需要在``writeExternal``和
``readExternal``手动指定字段。并且必须要有默认的构造函数，才能反序列化。
2.``Serializable``会自动序列化（反序列化）对象字段

### transient
对象序列化后，本应该对外隐藏的字段数据，都可以在文件中查阅到。某些环境下，需要保护隐私数据，此类字段数据不应该序列化。　　
``Externalizable``可以自由选择需要序列化的字段，同时利用``transient``可以让``Serializable``选择性序列化字段

```java
class User implements Serializable {
	
	private String name;
	
	// transient　标记的字段不会被序列化
	private transient String password;
	
}
```

