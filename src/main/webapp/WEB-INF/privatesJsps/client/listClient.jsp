<!--JavaServer Pages Standard Tag Library-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Libreria para dar formato-->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_AR"/>

<section id="clients">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <div class="table-responsive" style="height: 340px; overflow-y: scroll;">
                        <table class="table table-striped">
                            <thead class="table-warning">
                                <tr>
                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>Email</th>
                                    <th>Telefono</th>
                                    <th>Saldo</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody class="overflow-auto">
                                <!--Iteramos cada elemento de la lista de clientes-->
                                <c:forEach var="cliente" items="${clientes}">
                                    <tr>
                                        <td>${cliente.idCliente}</td>
                                        <td>${cliente.nombre} ${cliente.apellido}</td>
                                        <td>${cliente.email}</td>
                                        <td>${cliente.telefono}</td>
                                        <td>
                                            <fmt:formatNumber value="${cliente.saldo}" type="currency"/>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/ServletControlador?action=edit&idClient=${cliente.idCliente}"
                                            class="btn btn-outline-success">
                                                <i class="fas fa-solid fa-user-pen"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" onclick="confirmDelete(${cliente.idCliente});"
                                               class="btn btn-outline-danger">
                                                <i class="fas fa-solid fa-user-slash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!--Inicio Tarjeta totales-->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-solid fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>
            <!--Fin Tarjeta totales-->
        </div>
    </div>
</section>

<!--Agregar cliente MODAL-->
<jsp:include page="/WEB-INF/privatesJsps/client/addClient.jsp"/>

<script>
    function confirmDelete(idClient) {
        if (confirm('Se va a eliminar el cliente con ID: ' + idClient)) {
            window.location.href = '${pageContext.request.contextPath}/ServletControlador?action=delete&idClient=' + idClient;
        } else {
            return false;
        }
    }
</script>