<%-- 
    Document   : filme_detalhe
    Created on : 26 de mai. de 2026, 19:50:25
    Author     : txxx4
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Filme" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Detalhes do Filme</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">
</head>

<body>

<div id="app" style="padding:24px">

<%
Filme filme = (Filme) request.getAttribute("filme");
%>

<h1>Detalhes do Filme</h1>

<% if(filme == null){ %>

<div class="empty">
    <i class="ti ti-movie-off"></i>
    Filme não encontrado.
</div>

<% } else { %>

<div class="form-card">

    <p><strong>ID:</strong> <%= filme.getId() %></p>

    <p><strong>Nome:</strong> <%= filme.getNome() %></p>

    <p><strong>Diretor:</strong> <%= filme.getDiretor() %></p>

    <p><strong>Ano:</strong> <%= filme.getAno_publicacao() %></p>

    <p><strong>Preço:</strong> R$ <%= filme.getPreco_aluguel() %></p>

    <p><strong>Status:</strong> <%= filme.getStatus() %></p>

</div>

<% } %>

<br>

<a href="index.html" class="btn-voltar">
    <i class="ti ti-arrow-left"></i> Voltar
</a>

</div>

</body>
</html>