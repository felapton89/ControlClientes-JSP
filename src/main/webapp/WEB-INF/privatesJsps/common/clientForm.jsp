<div class="form-group">
    <label for="nombre">Nombre</label>
    <input type="text" class="form-control" name="nombre" id="nombre" required value="${client.nombre}">
    <div class="invalid-feedback">
        Por favor coloca un nombre.
    </div>
</div>
<div class="form-group">
    <label for="apellido">Apellido</label>
    <input type="text" class="form-control" name="apellido" id="apellido" required value="${client.apellido}">
    <div class="invalid-feedback">
        Por favor coloca un apellido.
    </div>
</div>
<div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" name="email" id="email" required value="${client.email}">
    <div class="invalid-feedback">
        Por favor coloca un email.
    </div>
</div>
<div class="form-group">
    <label for="telefono">Telefono</label>
    <input type="tel" class="form-control" name="telefono" id="telefono" required value="${client.telefono}">
    <div class="invalid-feedback">
        Por favor coloca un telefono.
    </div>
</div>
<div class="form-group">
    <label for="saldo">Saldo</label>
    <input type="number" step="any" class="form-control" name="saldo" id="saldo" required value="${client.saldo}">
    <div class="invalid-feedback">
        Por favor coloca un saldo.
    </div>
</div>