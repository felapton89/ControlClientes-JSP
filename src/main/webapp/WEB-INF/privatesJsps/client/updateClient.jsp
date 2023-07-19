<html>
    <head>
        <jsp:include page="../common/head.jsp"/>
        <title>Editar Cliente</title>
    </head>

    <body class="bg-light">

        <!--Header-->
        <jsp:include page="/WEB-INF/privatesJsps/common/header.jsp"/>

        <!--Se agrega form porque en el navbar hay un btn submit-->
        <form action="${pageContext.request.contextPath}/ServletControlador?action=update&idClient=${client.idCliente}"
              method="POST" class="was-validated">

            <!--Navbar Editar Cliente-->
            <jsp:include page="/WEB-INF/privatesJsps/common/navbarEdit.jsp"/>

            <!--Formulario Editar Cliente-->
            <jsp:include page="/WEB-INF/privatesJsps/client/updateClientForm.jsp"/>
        </form>

        <!--Footer-->
        <jsp:include page="/WEB-INF/privatesJsps/common/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
                crossorigin="anonymous"></script>
    </body>

</html>