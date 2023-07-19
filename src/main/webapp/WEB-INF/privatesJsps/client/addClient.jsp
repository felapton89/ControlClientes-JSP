<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">

        <div class="modal-content">

            <!--MODAL HEADER-->
            <div class="modal-header p-3 mb-2 bg-success-subtle text-emphasis-success">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?action=insert" method="POST" class="was-validated" >

                <!--MODAL BODY-->
                <div class="modal-body">
                    <jsp:include page="../common/clientForm.jsp"/>
                </div>

                <!--MODAL FOOTER-->
                <div class="modal-footer">
                    <button class="btn btn-outline-success" type="submit">
                        <i class="fas fa-regular fa-square-check"></i>
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
