### Regex

#### 字符匹配

| 关键字| 含义               |    
|---   |---                 |
|.     | 匹配任意字符,除换行符 |
|\w    | 匹配字母、数字、下划线（不包括汉字、日语）| 
|\s    | 匹配空符(space)|
|\d    | 匹配数字|
|\n    | 匹配换行|
|[xy]  | 匹配x或y字符|

#### 位置匹配

|关键字|含义     |
|--   |--       |
|\b   | 匹配单词的开始或结束位置（没有匹配某个字符,只是位置） |
|^    | 匹配字符串的开始|
|$    | 匹配字符串的结束|

#### 重复匹配

|关键字| 含义     |
|--   |---       |
|*    | 匹配0或n次|
|+    | 匹配1或n次|
|?    | 匹配0或1次|
|{n}  | 重复n次|
|{n,} | 重复>＝n次｜
|{n,m}| 重复n到m次|

#### 反匹配

|关键字| 含义     |
|--   |---       |
|\W|匹配除了\w能匹配的字符|
|\S|匹配除了\s能匹配的字符|
|\D|匹配除了\d能匹配的字符|
|\B|匹配除了\b能匹配的位置|
|[^x]|匹配除了x以外的字符|
|[^abc]|匹配除了abc以外的字符|


#### 懒惰匹配

|关键字| 含义     |
|--   |---       |
|*?|任意次数,尽可能少|
|+?|1或n次,尽可能少|
|??|0或1次,尽可能少|
|{n,m}|n或m次,尽可能少|
|{n,}|n次以上,尽可能少|

#### 转义符
对于关键字,需要使用``\``进行转义

### Group

#### 例子1
需求：将下面句子中``词尾含有!的单词``全部查找出来　　
```
Core support for dependency injection! transaction management! web applications! data access! messaging! testing and more.
```

在JAVA中,``Matcher的group()``函数,能够将符合正则表达式的字符串返回。可以使用``group``方法,解决上述例子的需求。


``` java 

// \w+!
String regex = "\\w+!" 

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);

List<String> result = new ArrayList<>();
while(matcher.find()) {
    result.add(matcher.group());
}

System.out.println(result);

```

输出结果：
```
injection!
management!
applications!
access!
messaging!
```

#### 例子2
需求：将例子1的需求改动,要求查找``词尾含有!的单词``,但是单词输出时必须不带'!'
比如``injection!``符合要求,但是输出时必须是``injection``
  
这里可以通过正则表达式的组来解决。在正则表达式将``()``包围的内容称为一个组,组用数字进行编号,0代表整个正则表达式。

比如``(\d{4})-(\d{2}-(\d\d))``,该表达式大致可以匹配日期。  
若用该表达式匹配``2018-05-18``,可以完全匹配。但是匹配的同时,想获取年份、月份、日期等信息,就可以利用组。


| 组别     | 表达式 | 匹配内容  |    
|---      |---     |---   |  
|组(0)    |(\d{4})-(\d{2})-(\d{2})| 2018-05-18|
|组(1)    |(\d{4}) |                2018 |
|组(2) 　　|(\d{2}) |                 05 |
|组(3)    |(\d{2}) |                 18|

Matcher的group()就是组的概念,group()默认匹配获取组(0)的值,即整个正则表达式。
Matcher的group(int index),可用来匹配相应组的（index即组的编号）


``` java 

// \w+!
String regex = "(\\w+)!" 

Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);

List<String> result = new ArrayList<>();
while(matcher.find()) {
    result.add(matcher.group(1));
}

System.out.println(result);

```
说明：将我们需要的信息设置一个组``(\w+)``,其他的照旧得正则表达式``(\w+)!``,提出该组信息``matcher.group(1)``

``` java

text.replaceAll("(\\w+)!", "$1");

```
如果仅仅将文本中带!的词尾的单词,去掉！的话,可以采用以上的方法。``$1``代表正则表达式中的分组1
```
在Atom或IDEA等编辑器中,使用正则表达式查找替换时,也可以使用$1
```