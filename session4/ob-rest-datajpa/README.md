## Spring boot

Proyecto Spring Boot con las dependencias / starters:

*H2
*Spring data JPA
*Spring Web
*Spring Tools

Aplicación API REST con acceso a base de datos H2 para persistir los datos.

El acceso se puede realizar desde Postma o Navegador.

Aplicación orientada a una biblioteca

### Elementos a crear

1. Entidad Book
2. BookRepository
    el @Repository en algunos casos es opcional
3. BookController

Para el caso de swagger2 escompatible con versiones anteriores a la 3 de spring boot y además se debe tener en cuenta que se usa antes de la version 3 el paquete javax para posteriores es jakarta
