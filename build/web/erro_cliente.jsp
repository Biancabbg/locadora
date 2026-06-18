<%-- 
    Document   : erro_cliente
    Created on : 26 de mai. de 2026, 21:36:27
    Author     : txxx4
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Erro</title>

<style>

body{
    font-family: Arial;
    background:#f4f4f4;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.card{
    background:white;
    padding:40px;
    width:500px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 0 15px rgba(0,0,0,0.15);
}

.erro{
    color:#e74c3c;
    font-size:70px;
}

.botao{
    display:inline-block;
    margin-top:20px;
    padding:10px 20px;
    background:#3498db;
    color:white;
    text-decoration:none;
    border-radius:8px;
}

</style>

</head>

<body>

<div class="card">

    <div class="erro">❌</div>

    <h1>Erro</h1>

    <p>
        <%= request.getAttribute("mensagem") %>
    </p>

    <a href="index.html" class="botao">
        Voltar
    </a>

</div>

</body>
</html>