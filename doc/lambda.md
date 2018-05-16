functional interface

``` java
public interface Consumer<T> {
    // 消费Ｔ
    void accpet(T t);

    // 将当前的Consumer与Consumer after组合，新的Consumer将按顺序执行
    default Consumer<T> andThen(Consumer<? super T> after);
}
```

``` java
public interface Supplier<T> {
  　// 生产Ｔ　
    T get();

}
``` 

``` java
public interface Function<T,R> {
  // T生产R
  R apply(T t);

}
```
[FunctionCase](../src/main/java/lambda/FunctionCase.java)