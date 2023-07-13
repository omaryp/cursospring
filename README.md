# Curso Spring
Desarrollo del curso Spring en OpenBootCamp, se subirán uno a uno de los ejemplos que se creen durante el curso.

beans -> objetos java normales que van a ser gestionados por spring(va a tener conocimiento de ellos), escanea toda la
aplicación y generar un contenedor con los objetos que se van creando para tenerlos disponibles cuando se necesiten.
Este contenedor de beans sirve para no crear instancias innecesarias y poder hacer el uso más eficiente de la memoria.

### Iniciando el contenedor
`ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");`

### Obteniendo objetos del contenedor de spring
`context.getBean("calculatorService")`

El alcance de un bean , puede ser singleton(una sola instancia) ó prototype(un objeto nuevo cada que se solicita al contenedor). El alcance por defecto es singleton

Se agrega `xmlns:context="http://www.springframework.org/schema/context" `en beans.xml para poder usar el contexto de spring.
y luego colocamos `<context:component-scan base-package="com.example"/>` para que spring scanee las clases y cree las instnacias en el contenedor

Además se debe colocar la anotacion `@Component` para que spring pueda identificar los beans a crear.

Es recomendable usar la inyección de depencias por constructor.

## SpringData

Acceso a datos 
    *JPA
        *hibernate
            *JBDC

La entidad se le coloca la anotación `@Entity`
A la clave primaria se le coloca la anotación `@Id` además de definirla como autoincrementable con 
`@GenerateValue(strategy=GenerationType.IDENTITY)`
Luego se crea una interface que extienda de  JPAReposotory pasandole la clase que se persistirá y tipo de dato del id.

## SpringBoot
La progrmación con java sea más amigable, más productiva.
Permite crear los proyectos de manera rápida y automatiza configuraciones por defectos.
Viene con un apache por defecto.
Dependencias starter para simplificar la construcción de la configuración.

https://start.spring.io

Para crear un servicio rest se utiliza el starter spring web, permite usar el patron MVC,
starter spring data jpa y h2 para el acceso a datos y el starter spring dev tools para mejorar la experiencia de programacion para despliegues automáticos entre otras cosas.

### @RestController 
Permite crear controladores de tipo rest que permite trabajar con json.

### @Controller
Se usa en spring mvc para enviar vistas html.

### @GetMapping,@PostMapping,@PutMapping,@DeleteMapping
Permite vincular un recurso por el método correspondiente, ejemplo :

    @GetMapping('/hola')

### @RequestMapping 
Permite vincular un recurso a nivel de clase, se coloca antes de definir la clase, ejemplo:

    
     @RequestMapping(/usuario)
     public class UsuarioController{...    
    

### @PathVariable
Permite definir un parámetro de un método como parámetro del recurso por get o delete. Se debe colocar
el mismo nombre tanto en el parámetro del recurso como el del método asociado a `GET` ó `DELETE`.
    
    @GetMapping('/{id}')
    public Book getBook(@PathVariable Long id){...}
    
### @RequestBody
Permite cargar el cuerpo(body) de la request y pasarlo al bean definidio como parámetro del método que 
recibe la solicitud.
    
    @PostMapping
    public Book createBook(@RequestBody Book book){...

### @RequestHeader
Permite obtner las cabeceras de la petición

### @Configuration
Se agrega a las clases que son de configuración, por ejemplo cuando se está configurando swagger

### @Bean
No indica que el bean a crear va a estar disponible en el contenedor de beans

## Swagger

### @ApiIgnore
no muestra un recurso en la documentación.

    @DeleteMapping("")
    @ApiIgnore
    public ResponseEntity<Book> deleteBooks(){
        bookRepository.deleteAll();
        // no content indica que el elemento se ha eliminado
        return ResponseEntity.noContent().build(); 
    }

### @ApiParam 
muestra una descripción en un parámetro de un recurso

### @ApiOperation
muestra una descripción en el recurso

***Uso de @ApiOperation y @ApiParam***

```java
...
@GetMapping("/{id}")
@ApiOperation("Buscar un libro por clave primaria , id long")
public ResponseEntity<Book> getBook(@ApiParam("Clave primaria tipo long") @PathVariable Long id){
    Optional<Book> optBook = bookRepository.findById(id);
    return optBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}
...
```

### @ApiModel
Esta anotación se utiliza para clasificar un componente de spring como un modelo de la aplicación

### @ApiModelProperty
Esta anotación se utiliza para clasificar una propiedad de componente de spring como una propiedad del modelo de la aplicación

***Uso de @ApiModel @ApiModelProperty***

```java
...
@Entity
@Table(name = "books")
@ApiModel("Clase Book para representar un libro.")
public class Book {
//atributos
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@ApiModelProperty("Clave ficticia autoincremental tipo long")
private Long id;
...
```
## Test con Spring

### @SpringBootTest
Anotación para indicar que se esta trabajando test en SpringBoot.

    @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
    public class HolaControllerTest{ ... }

Con `WebEnvironment.RANDOM_PORT` se indica que el puerto a utilixar en el test es aleatorio.

### @Test
Anotación para indicar a un método que es un test.

    ...
    @Test
    void saludarTest(){...}
    ...

### @BeforeEach
Anotación para indicar el método que se debe ejecutar antes de cada test.
    ...
    @BeforeEach
    void setUp(){...}
    ...

Para el caso de testear RestControllers se debe utilicar un objeto `TestRestTemplate` y `RestTemplateBuilder`, además con la anotación `@LocalServerPort` indicamos que se debe cargar un puerto.

    ...
    @LocalServerPort
    private int port
    ...

## Datos desde el properties.
Para cargar valores desde el archivo properties se usa la anotacion `@Value` y como parámetro se usa la clave colocada en el properties.

**Valor en el properties (application.properties)**
    
    app.message=Hola desde producción
    
**Como se carga en la aplicación** 
    
    ...
    @Value("${app.message}")
    String message;
    ...
    
Con la anotacion `@Value` se carga desde el properties y asigna ese valor en la varible utilizada.

Además dentro del archivo properties podemos indicar el ambiente en el que estamos trabajando con la clave

    spring.profiles.active=dev

Pero además se debe colocar el archivo properties con el sufijo -dev
    
    application-dev.properties

Agregando esto al properties podemos cargar varables de entorno del sistema dentro de la llaves colocamos el key de la variable.

    app.varexample=${USERNAME}