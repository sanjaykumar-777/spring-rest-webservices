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

Request Methods for REST Api

1.GET - Retrieve details of a resource.
2.POST - Create a new resource.
3.PUT - Update an existing resource.
4.PATCH - Update part of a resource.
5.DELETE - Delete a resource.

OpenApi and Swagger specification for the rest api's

OpenApi url - http://localhost:8080/v3/api-docs
swaggerUi - http://localhost:8080/swagger-ui/index.html

Internationalization i18 for Rest Api
MessageSource
Locale
Accept-language
message.properties
