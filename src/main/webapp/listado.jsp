<%@ page import="pageNumber.*, java.util.*" %>
<%@ page import="com.codoacodo.modelo.Orador" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Java Team 11 Final</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.4.2/css/fontawesome.min.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css">
        <link rel="stylesheet" type="text/css" href="assest/styles/style.css">

    </head>

    <body>

        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2><b>Oradores</b></h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addOradorModal" class="btn btn-success" data-bs-toggle="modal"><i
                                        class="material-icons">add_circle</i> <span>Agregar Orador</span></a>
                                <a href="#multiDeleteOradorModal" class="btn btn-danger multBorrar " data-bs-toggle="modal"><i
                                        class="material-icons" title="multBorrar">remove_circle</i> <span>Borrar</span></a>
                            </div>
                        </div>
                    </div>
                    <table id="dtBasicExample" class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="selectAll">
                                        <label for="selectAll"></label>
                                    </span>
                                </th>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Email</th>
                                <th>Tema</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="orador" items="${listado}" varStatus="i"> 
                                <tr>
                                    <td>
                                       <span class="custom-checkbox">
                                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                            <label for="checkbox1"></label>
                                        </span>
                                    </td>
                                    <td class="id"> ${orador.id}</td>
                                    <td class="nombre"> ${orador.nombre}</td>
                                    <td class="apellido"> ${orador.apellido}</td>
                                    <td class="email"> ${orador.email}</td>
                                    <td class="tema"> ${orador.tema}</td>


                                    <td>
                                        <a href="#editOradorModal" class="editbtn edit" data-bs-toggle="modal"><i class="material-icons"
                                                                                                                  data-bs-toggle="tooltip" title="Editar">&#xE254;</i></a>
                                        <a href="#deleteOradorModal" class="deleteBtn delete" data-bs-toggle="modal"><i
                                                class="material-icons" data-bs-toggle="tooltip" title="Borrar">&#xE872;</i></a>

                                        <input type="hidden" name="id" id="id" value="${orador.id}">
                                    </td>
                                </tr>


                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div id="addOradorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post"
                          action="${pageContext.request.contextPath}/orador?action=add">
                        <div class="modal-header">
                            <h4 class="modal-title">Agregar Orador</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input name="nombre" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Apellido</label>
                                <input name="apellido" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input name="email" type="email" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Tema</label>
                                <textarea name="tema" class="form-control" required></textarea>
                            </div>

                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-success" value="Agregar">
                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div id="editOradorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post"
                          action="${pageContext.request.contextPath}/orador?action=update">
                        <div class="modal-header">
                            <h4 class="modal-title">Editar Orador</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">

                            <input type="hidden" name="id" id="id">

                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" required  id="nombre" name="nombre">
                            </div>
                            <div class="form-group">
                                <label>Apellido</label>
                                <input type="text" class="form-control" required id="apellido" name="apellido">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" required id="email" name="email">
                            </div>
                            <div class="form-group">
                                <label>Tema</label>
                                <textarea class="form-control" required id="tema" name="tema"></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-info" value="Guardar">

                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="deleteOradorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form method="post"
                          action="${pageContext.request.contextPath}/orador?action=delete">
                        <div class="modal-header">
                            <h4 class="modal-title">Borrar Orador</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                        </div>
                        <div class="modal-body">
                            <p>Esta seguro de borrar estos registros?</p>
                            <p class="text-warning"><small>Esta action no se puede volver a atras.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-danger" data-bs-dismiss="modal" value="Borrar">
                            <input type="hidden" name="id" id="id">

                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div id="multiDeleteOradorModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">
                            <h4 class="modal-title">Borrar Oradores</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                        </div>
                        <div class="modal-body">
                            <p>Esta seguro de borrar estos registros?</p>
                            <p class="text-warning"><small>Esta action no se puede volver a atras.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-secondary" data-bs-dismiss="modal" value="Cancelar">
                            <input type="submit" class="btn btn-danger" data-bs-dismiss="modal" value="Borrar">
                            <input type="hidden" name="id" id="id">

                        </div>
                    </form>
                </div>
            </div>
        </div>                        



        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>

        <script src="assest/Js/script.js" ></script>

    </body>

</html>