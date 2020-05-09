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
`@Autowired` follows auto-wiring by type first, which means this only works if there is exactly one class of that type.
We can solve this problem by defining a `@Qualifier("beanName)` next to `@Autowired`, which tells spring exactly which implementation to choose.
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

