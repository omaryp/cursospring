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

Se agrega xmlns:context="http://www.springframework.org/schema/context" en beans.xml para poder usar el contexto de spring.
y luego colocamos `<context:component-scan base-package="com.example"/>` para que spring scanee las clases y cree las instnacias en el contenedor

Además se debe colocar la anotacion `@Component` para que spring pueda identificar los beans a crear.

Es recomendable usar la inyección de depencias por constructor.

## SpringData

Acceso a datos 
    *JPA
        *hibernate
            *JBDC

La entidad se le coloca la anotación `@Entity`
A la clave primaria se le coloca la anotación @Id además de definirla como autoincrementable con 
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
el mismo nombre tanto en el parámetro del recurso como el del método asociado a GET ó DELETE.
    
    @GetMapping('/{id}')
    public Book getBook(@PathVariable Long id){...}
    
### @RequestBody
Permite cargar el cuerpo(body) de la request y pasarlo al bean definidio como parámetro del método que 
recibe la solicitud.
    
    @PostMapping
    public Book createBook(@RequestBody Book book){...

### @RequestHeader
Permite obtner las cabeceras de la petición


