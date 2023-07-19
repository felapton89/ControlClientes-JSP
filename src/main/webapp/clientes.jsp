<html>
    <head>
        <jsp:include page="./WEB-INF/privatesJsps/common/head.jsp"/>
        <title>Control de Clientes</title>
    </head>

    <body class="bg-light">

        <!--Header-->
        <jsp:include page="/WEB-INF/privatesJsps/common/header.jsp"/>

        <!--Navbar Buttons-->
        <jsp:include page="/WEB-INF/privatesJsps/common/navbar.jsp"/>

        <!--Listado Clientes-->
        <jsp:include page="/WEB-INF/privatesJsps/client/listClient.jsp"/>

        <!--Footer-->
        <jsp:include page="/WEB-INF/privatesJsps/common/footer.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    </body>

</html>
