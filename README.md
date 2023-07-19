# ControlClientes
### Aplicación Web de Gestión de Clientes

ControlClientes es una aplicación web desarrollada en Java con tecnologías JSP y Java EE que permite gestionar clientes de manera sencilla y eficiente. La aplicación utiliza una base de datos H2 en memoria y cuenta con funcionalidades para agregar, editar, eliminar y visualizar clientes.

## Características principales:
- **GestióN de Clientes:** Agrega, edita y elimina clientes con sus respectivos datos, como nombre, apellido, email, teléfono y saldo.
- **Visualización de Datos:** Lista todos los clientes disponibles con una tabla interactiva que permite desplazarse fácilmente y ver los detalles de cada cliente.
- **Total de Clientes y Saldo:** Muestra en tiempo real el total de clientes registrados y el saldo total de todos los clientes.
- **Confirmación de Eliminación:** Cuando se intenta eliminar un cliente, se mostrará un popup que le preguntará al usuario si realmente desea eliminar al cliente antes de proceder con la acción.

#### Requisitos:
- Java 8 o superior
- Apache Maven
- Navegador web

#### **Instrucciones de Uso:**
- Clone este repositorio en su máquina local.
- Ejecute la aplicación utilizando Maven y Tomcat o cualquier otro servidor de aplicaciones.
- Acceda a la página de inicio de ControlClientes desde su navegador web.
- Utilice las funcionalidades de gestión de clientes para agregar, editar y eliminar clientes según sea necesario.

> Notas:
La aplicación utiliza la base de datos H2 en memoria, lo que significa que los datos se restablecerán cada vez que la aplicación se inicie nuevamente.
La aplicación se ha construido utilizando tecnologías JSP, Java EE y Bootstrap para un diseño moderno y responsivo, y FontAwesome para agregar íconos elegantes.