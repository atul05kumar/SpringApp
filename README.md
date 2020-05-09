# Spring Notes
## Source - O'Reily course - Spring Framework Essentials
+ Spring framework does not perform actual inversion of control. It is more of a historical thing. Actually it performs dependency injection.
+ `@Configuration` annotation on a class tells spring the class will provide the metadata required to provide the beans.
+ Spring also provides some built in library classes.
+ Spring helps in the decoupling of classes, by handling the dependencies.
### Java Based Configuration
+ Spring metadata can be configured using following three ways
    + Using a xml config file.
    + Using annotations as and when required.
    + Using a Java configuration file that uses `@Configuration` annotation. (Recommended).
+ Using the application context, we can get the count of beans created, or the beans' name itself.
+ `@Import(ConfigClassName.class)` can be used to import additional config class in the existing one.
+ `@ImportResource()` can be used to import non java resources such as a xml config file.

### Annotation Configuration
+ `@Autowired` annotation can be used to configure a bean, does not matter where it is defined.
    + `@Autowired` follows auto-wiring by type first, which means this only works if there is exactly one class of that type.
    + We can solve this problem by defining a `@Qualifier("beanName)` next to `@Autowired`, which tells spring exactly which implementation to choose.
    + Another way to do this is to auto-wiring all possible beans in a collection like `Set` or `List`, this way all available implementations are loaded in the collection.

+ Another better way is to use `@ComponentScan(basePackages = "com.atul")` at a class level. 
This will perform a component scan for all the classes inside `com.atul` package which have `@Component` on top of them. 
By Default the identification name for a bean is class name with first letter in lower case. 
This behaviour can be overridden by providing the bean name in the params of `@Component`.
+ It is a good practice to create sub-packages for the beans we want the component scan to find,
this makes scan faster.  For Example, if only `com` is defined in the component scan, then entire project including all the dependencies is going to get scanned,
which will slow this down at the startup.
+ Another approach is to use Java Standard annotation called `@Resource` which is included in javax,
to configure the bean, in this case the lookup of bean happens by name of variable  
For Example:  
```java
@Configuration
public class AppConfig {
    @Resource
    private Team home;
}
``` 
will look for a class with name `Home` to configure the bean.
###  The classic XML Configuration Approach
+ One of the limitations of the Annotations approach is that you need to own the source code, as you cannot add annotations on the classes you do not own.
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```
+ Here, `xmlns` stands for XML namespace, declares the namespace for a xml tag.
The line starting with `xsi:schemaLocation` tells to validate the xml against the schema defined by `http://www.springframework.org/schema/beans/spring-beans.xsd`
    + There can be multiple schemas defined in the `schemaLocation` tag in the pairs of namespace and actual schema `xsd` file.
+ A bean can be defined by using following xml syntax.  
`<bean id="home" class="com.atul.Home" />`
+ All prperties inside a bean can be defined by using `<property/>` tag inside a bean.
`<property name="myTeam" ref="home" />`
+ Note that `ref` can be used to refer to other beans, however `value` is used for primitive or String.
+ The component scan can be enabled in xml file using `<context:component-scan base-package="com.atul"/>`
### Constructor and Setter Injection
+ A bean can be prepared by either constructor or by using setter methods. If the bean has to be immutable, 
and it does not make sense to use the bean without having some members set, then use the constructor method, other wise setters can be used.

### Bean Scopes
+ By default, all spring managed beans are singletons! defined by `@Scope("singleton")` which we do not need to write explicitly.
+ Default scope can be changed from singleton to prototype by putting @Scope("prototype") next to the `@Bean` annotation.
+ There are other scopes as well, and we can if we want define our own custom scopes.
+ Another important thing is that we cannot instantiate abstract classes using spring. To use them, we need to provide the factory method to get their instance.
    + If the factory method lies in another class, then that bean also need to be instantiated and refered back by using `factory-bean`.

