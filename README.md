# Curso Spring
Desarrollo del curso Spring en OpenBootCamp, se subirán uno a uno de los ejemplos que se creen durante el curso.

beans -> objetos java normales que van a ser gestionados por spring(va a tener conocimiento de ellos), escanea toda la
aplicación y generar un contenedor con los objetos que se van creando para tenerlos disponibles cuando se necesiten.
Este contenedor de beans sirve para no crear instancias innecesarias y poder hacer el uso más eficiente de la memoria.

#### Iniciando el contenedor
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

#### Obteniendo objetos del contenedor de spring
context.getBean("calculatorService")

El alcance de un bean , puede ser singleton(una sola instancia) ó prototype(un objeto nuevo cada que se solicita al contenedor). El alcance por defecto es singleton

Se agrega xmlns:context="http://www.springframework.org/schema/context" en beans.xml para poder usar el contexto de spring.
y luego colocamos <context:component-scan base-package="com.example"/> para que spring scanee las clases y cree las instnacias en el contenedor

Además se debe colocar la anotacion @Component para que spring pueda identificar los beans a crear.

Es recomendable usar la inyección de depencias por constructor.

# SpringData

Acceso a datos 
    *JPA
        *hibernate
            *JBDC

La entidad se le coloca la anotación @Entity
A la clave primaria se le coloca la anotación @Id además de definirla como autoincrementable con 
@GenerateValue(strategy=GenerationType.IDENTITY)
Luego se crea una interface que extienda de  JPAReposotory pasandole la clase que se persistirá y tipo de dato del id.
