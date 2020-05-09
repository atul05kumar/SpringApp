# Spring Notes
### Source - O'Reily course - Spring Framework Essentials
+ Spring framework does not perform actual inversion of control. It is more of a historical thing. Actually it performs dependency injection.
+ `@Configuration` annotation on a class tells spring the class will provide the metadata required to provide the beans.
+ Spring also provides some built in library classes.
+ Spring helps in the decoupling of classes, by handling the dependencies.
+ Spring metadata can be configured using following three ways
    + Using a xml config file.
    + Using annotations as and when required.
    + Using a Java configuration file that uses `@Configuration` annotation. (Recommended).
+ Using the application context, we can get the count of beans created, or the beans' name itself.
+ `@Import(ConfigClassName.class)` can be used to import additional config class in the existing one.
+ `@ImportResource()` can be used to import non java resources such as a xml config file.



