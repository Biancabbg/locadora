<%-- 
    Document   : cliente_detalhe
    Created on : 26 de mai. de 2026, 19:50:12
    Author     : txxx4
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Cliente" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Detalhes do Cliente</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">
</head>

<body>

<div id="app" style="padding:24px">

<%
Cliente cliente = (Cliente) request.getAttribute("cliente");
%>

<h1>Detalhes do Cliente</h1>

<% if(cliente == null){ %>

<div class="empty">
    <i class="ti ti-user-off"></i>
    Cliente não encontrado.
</div>

<% } else { %>

<div class="form-card">

    <p><strong>ID:</strong> <%= cliente.getId() %></p>

    <p><strong>Nome:</strong> <%= cliente.getNome() %></p>

    <p><strong>Telefone:</strong> <%= cliente.getTelefone() %></p>

    <p><strong>E-mail:</strong> <%= cliente.getEmail() %></p>

    <p><strong>Data Reserva:</strong> <%= cliente.getData_reserva() %></p>

    <p><strong>Data Devolução:</strong> <%= cliente.getData_devolucao() %></p>
    
    <p><strong>Filme:</strong> <%= cliente.getNome_filme() %></p>

</div>

<% } %>

<br>

<a href="index.html" class="btn-voltar">
    <i class="ti ti-arrow-left"></i> Voltar
</a>

</div>

</body>
</html>
