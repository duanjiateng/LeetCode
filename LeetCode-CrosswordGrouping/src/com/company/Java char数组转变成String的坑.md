## Java char数组转变成String的坑

### 	1.概括

​	虽然`toString()`和`String.valueOf()`都是将非String类型转化成String类型，但是`char[]`或者说数组不能使用`toString()`方法转化成字符串．

```java
char[] cc = new char[]{'d','j','t'};
System.out.println(cc);
System.out.println(cc.toString());
System.out.println(String.valueOf(cc));
```

​	结果：

```
djt
[C@5b1d2887
djt
```

### 	2.不能使用toString()的原因：

​	在Java中，所有类都是继承`object`类，而`toString()`则是该类的一个方法，所以所有类被创建时都有这样一个方法．

#### 	`toString()`的作用

​	Java的输出用的函数`println()`是不接受对象的直接输出，只接受字符串或者数字的输出．所以当`println()`检测出输出对象是一个对象时，它会自动调用该对象中的`toString()`方法，输出结果为［类型＠哈希值］．

​	`Object`类的`toString()`源码如下：

```java
public String toString() {
        return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode());
    }

```

​	而数组类并没有对此方法重写，仅仅是重载为类的静态方法．所以，数组直接使用`toString()`方法的结果也是［类型＠哈希值］．

### 	3.数组转字符串的正确写法

#### 	1.使用Arrays

```java
char[] chars = new char[]{'d','j','t'};
System.out.println(Arrays.toString(chars));
//结果：[d, j, t]

```

​	但是这种方法是带格式的．

#### 	2.直接在构造String时转换	

```java
char[] chars = new char[]{'d','j','t'};
String str = new String(chars);
System.out.println(str);
//结果：djt
```

#### 	3.调用String类的方法转换

```java
char[] chars = new char[]{'d','j','t'};   System.out.println(String.valueOf(chars));
//结果：djt
```

