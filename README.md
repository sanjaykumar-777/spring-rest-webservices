# spring-rest-webservices

Basics:
 
1.how are our requests handled?
messagedispatcherservlet
Auto Configuration - DispatcherServletAutoConfiguration

2.How does a HelloWorldBean object got converted into a json?
@ResponseBody + JacksonHttpMessageConverters

3.Who is configuring error mapping?
Auto configuration(ErrorMvcAutoConfiguration)

4.How are all jars available(Spring,Spring MVC, Jackson,Tomcat)?
spring-starter-projects and Auto configurations
