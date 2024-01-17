# Kuaför Randevu Sistemi
## Projeyi Çalıştırma

1. Clone the repository
2. Open the project in your IDE: IntelliJ IDEA (recommended) or Eclipse
    * If you are using IntelliJ IDEA, make sure the IDE opens project as **Maven** and recognizes the project as a Spring Boot project. Also, you must change the working directory of the project so that the views (the actual web pages to be shown) are found by Spring Boot
3. Make sure you are in the `Hairdressser_Appointment_System` directory
4. Configure the database connection in `application.properties` file 
5. Run the project (by running the `main` method in `KuaforRandevuSistemiAplication.java`)
6. Open http://localhost:3306/ in your browser!
   * If you ran the [`basedata.sql`](https://github.com/jaygajera17/E-commerce-project-springBoot/blob/master2/JtProject/basedata.sql)script on the database, you can log in with the following credentials as admin; otherwise you'll have to manually create an admin user in the database:
     * Username: `admin`
     * Password: `1234`
  



### Database

MySQL can be used as the database for this project. The database connection can be configured in the `application.properties` file, with the appropriate values for the following properties:
(you'd better use another username not root)
```properties
    db.url=jdbc:mysql://[ip address of db]:[port of db]/ecommjava?createDatabaseIfNotExist=true
    db.username=[username]
    db.password=[password, if any]
```

if you met the error `java.lang.IllegalArgumentException: Could not resolve placeholder 'db.driver' in value "${db.driver}"`, maybe you should change your `mysql-connector-java` version in `pom.xml` file according to your mysql version, don't forget to reload your Maven project.

Having done that, you must create some base data in the database. You can do that by running the `basedata.sql` script on the database. Check out Google for how to do that, because it depends on what tool you are using to access said database. 

### Web Directories
Fotoğraf: https://photos.app.goo.gl/Rf2e3sjL13pX276d9


### Controller
- control the endpoint and also send data to view( we use ModelAndView method)
- ``` @GetMapping("login")
	public String adminlogin() {
		
		return "adminlogin";
	}```
- whenever /login url is hit , src->main->webapp-> adminlogin.jsp file execute
### Models
- represent data as entity and relationship among them.

### View
- receive data from controller and show with frontend.


## Spring Boot

For any information about Spring Boot, here are some useful links!

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

###Sayfalarımızın Görüntüleri
https://photos.app.goo.gl/9b6BPQwjRCSHjwNs7
 
 -Anasayfa: https://photos.app.goo.gl/xcP8tApZaebtDqpz5
 -Personel Sayfası: https://photos.app.goo.gl/xcP8tApZaebtDqpz5
 -Randevu Oluşturma Sayfası: https://photos.app.goo.gl/a9VFF9Ux58ZpfVa69
 -Kullanıcı Giriş Sayfası: https://photos.app.goo.gl/udciUDLKiYmH5B5T9
 -Admin Sayfası: https://photos.app.goo.gl/n15QffNHSpPD4BpL9
 -Kuaför Paneli: https://photos.app.goo.gl/KgajBeBcs4deZs8h6
 -Müşteri Paneli: https://photos.app.goo.gl/EptKC38Zc3WfFEN36
 -Admin ve Kuaför Giriş Sayfası: https://photos.app.goo.gl/DzBp96LvdkToPxsaA
