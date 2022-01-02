<%-- 
    Document   : listaCategorias
    Created on : 11 oct 2021, 8:28:54
    Author     : arrut
--%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista De Categorias</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Proyecto Base V3
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Lista de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ProductoServlet?accon=listaDeProductos">Lista de Productos</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="card border-primary">
                <div class="card-header tex-center">
                    Lista de Categor&iacute;as
                </div>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="CategoriaServlet?accion=nuevo" class="btn btn-outline-success">Crear Categoria</a>
                    </h4>
                    <h4 class="card-title">
                        <a href="CategoriaServlet?accion=graficar" class="btn btn-outline-primary" target="_blank">Mostrar Gráfica</a>
                    </h4>
                    <h4 class="card-title">
                        <a href="CategoriaServlet?accion=verReporte" class="btn btn-outline-danger" target="_blank">Reporte General</a>
                    </h4>
                    
                    <c:if test="{mensaje != null}">
                        <div class="alert-succes alert-dismissible fade show" role="alert">
                            <strong>${mensaje}</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-tabel="Close">
                            </button>
                        </div>
                    </c:if>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Clave Categoria</th>
                                <th>Nombre Categoria</th>
                                <th>Descripción Categoria</th>
                                <th>Elimina</th>
                                <th>Actualiza</th>
                                <th>Reporte</th>
                            </tr>
                        </thead>
                        <c:forEach var="dto" items="${listaDeCategorias}">
                            <tbody>
                                <tr>
                                    <td>
                                        <a href="CategoriaServlet?accion=ver&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-warning">
                                            <c:out value="${dto.entidad.idCategoria}"/>
                                        </a>                                
                                    </td>
                                    <td>
                                        <c:out value="${dto.entidad.nombreCategoria}"/>
                                    </td>
                                    <td>
                                        <c:out value="${dto.entidad.descripciónCategoria}"/>
                                    </td>
                                    <td>
                                        <a href="CategoriaServlet?accion=eliminar&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-danger">Eliminar</a>
                                    </td>
                                    <td>
                                        <a href="CategoriaServlet?accion=actualizar&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-success">Actualizar</a>                            
                                    </td>
                                    <td>
                                        <a href="" class="btn btn-outline-info">Reporte</a>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>


                </div>
            </div>

        </div>
    </body>
</html>
