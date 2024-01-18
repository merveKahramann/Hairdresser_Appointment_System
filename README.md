# Kuaför Randevu Sistemi
## Projeyi Çalıştırma
1. Depoyu klonla
2. Projeyi IDE'nizde açın: IntelliJ IDEA (önerilen) veya Eclipse
    * IntelliJ IDEA kullanıyorsanız IDE'nin projeyi **Maven** olarak açtığından ve projeyi Spring Boot projesi olarak tanıdığından emin olun. Ayrıca, görünümlerin (gösterilecek gerçek web sayfaları) Spring Boot tarafından bulunabilmesi için projenin çalışma dizinini de değiştirmelisiniz.
3. 'KuaforRandevuSistemi' dizininde olduğunuzdan emin olun
4. 'application.properties' dosyasında veritabanı bağlantısını yapılandırın.
5.Projeyi çalıştırın ('KuaforRandevuSistemi.java'da 'main' yöntemini çalıştırarak)
6.Tarayıcınızda http://localhost:3306/ adresini açın!
   * yönetici olarak aşağıdaki kimlik bilgileri; aksi takdirde veritabanında manuel olarak bir yönetici kullanıcı oluşturmanız gerekir:
     * Username: `admin`
     * Password: `1234`
  


### Database

MySQL bu proje için veritabanı olarak kullanılabilir. Veritabanı bağlantısı, "application.properties" dosyasında aşağıdaki özellikler için uygun değerlerle yapılandırılabilir:

```properties
    db.url=jdbc:mysql://[ip address of db]:[port of db]/ecommjava?createDatabaseIfNotExist=true
    db.username=[username]
    db.password=[password, if any]
```

`Java.lang.IllegalArgumentException: "${db.driver}" değerindeki 'db.driver' yer tutucusu çözülemedi hatasıyla karşılaştıysanız, belki de `pom.xml'deki `mysql-connector-java` sürümünüzü değiştirmelisiniz. xml` dosyasını MySQL sürümünüze göre yeniden yüklemeyi unutmayın.

Bunu yaptıktan sonra veritabanında bazı temel veriler oluşturmalısınız. Bunu veritabanında `baseata.sql` betiğini çalıştırarak yapabilirsiniz. Bunu nasıl yapacağınızı öğrenmek için Google'a göz atın, çünkü bu, söz konusu veritabanına erişmek için hangi aracı kullandığınıza bağlıdır.

### Web Directories
Fotoğraf: https://photos.app.goo.gl/Rf2e3sjL13pX276d9


### Controller
- uç noktayı kontrol edin ve ayrıca görüntülemek için veri gönderin (ModelAndView yöntemini kullanıyoruz)
- ``` @GetMapping("login")
	public String adminlogin() {
		
		return "adminlogin";
	}```
- /login URL'sine her basıldığında, src->main->webapp-> adminlogin.jsp dosyası çalıştırılır
### Models
- verileri varlık ve aralarındaki ilişki olarak temsil eder.

### View
- denetleyiciden veri alın ve ön uçla gösterin.


## Spring Boot

Spring Boot hakkında her türlü bilgi için işte bazı yararlı bağlantılar!

### Reference Documentation
Daha fazla referans için lütfen aşağıdaki bölümleri göz önünde bulundurun:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
Aşağıdaki kılavuzlar bazı özelliklerin somut olarak nasıl kullanılacağını göstermektedir:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Sayfalarımızın Görüntüleri

https://photos.app.goo.gl/9b6BPQwjRCSHjwNs7

 
- Anasayfa: https://photos.app.goo.gl/xcP8tApZaebtDqpz5
  
  İndex sayfası müşteri navbar kısmını kullanarak istediği sayfaya geçiş yapabilir.Carouselden  salonumuzun resimlerini görebilir.
- Personel Sayfası: https://photos.app.goo.gl/qSuXxKoWhNo2YRED8

  Müşterilerin personellerimizi görebileceği sayfadır.

- Kullanıcı Giriş Sayfası: https://photos.app.goo.gl/udciUDLKiYmH5B5T9

  Müşteri giriş yapabilir eğer kayıt olmadıysa kayıt olabilir ya da navbar kısmını kullanıp istediği her hangi bir sayfaya geçiş yapabilir.
- Randevu Oluşturma Sayfası: https://photos.app.goo.gl/a9VFF9Ux58ZpfVa69

  Müşteri yaptıracağı işlemi, kuaförü, tarihi ve seansı seçip randevu oluşturabilir ya da randevularım buttonuna tıklayıp önceden oluşturduğu randevuları görebilir.
- Müşteri Paneli: https://photos.app.goo.gl/EptKC38Zc3WfFEN36

  Müşteri oluşturduğu randevularını bu sayfada görür eğer isterse randevu bilgilerini güncelleybilir ya da randevusunu silerek iptal edebilir.
- Admin ve Kuaför Giriş Sayfası: https://photos.app.goo.gl/DzBp96LvdkToPxsaA

  Admin ve kuaförler kendi panellerini görmek için bu sayfadan giriş yapabilirler.
- Kuaför Paneli: https://photos.app.goo.gl/KgajBeBcs4deZs8h6

  Giriş yapan kuaförlerin göreceği sayfa bu sayfadır. Kuaförler bu sayfadan bilgilerini güncelleyebilir, takvimden müsait oldukları günleri belirleyebilirler müşteriler de buna uygun randevu alabilirler ve gelen randevuları onaylayıp iptal edebilirler.
- Admin Paneli: https://photos.app.goo.gl/n15QffNHSpPD4BpL9

  Admin kuaförler buttonuna tıklayıp istediği kuaförün profilni, takvimini, randevularını görebilir. Kuaförün yaptığı her işlemi yapabilir ayrıca ekle buttonundan yeni kuaför de ekleyebilir.
