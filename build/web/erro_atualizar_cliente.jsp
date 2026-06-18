<%-- 
    Document   : erro_atualizar_cliente
    Created on : 26 de mai. de 2026, 21:52:38
    Author     : txxx4
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Erro ao Atualizar Cliente</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">

<style>

body{
    margin:0;
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:#f4f6f9;
    font-family:Arial, sans-serif;
}

.card{
    width:550px;
    background:white;
    padding:40px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 5px 20px rgba(0,0,0,.15);
}

.icone{
    font-size:90px;
    color:#e74c3c;
    margin-bottom:20px;
}

h1{
    color:#2c3e50;
    margin-bottom:15px;
}

p{
    color:#555;
    font-size:18px;
    margin:20px 0;
}

.botao{
    display:inline-block;
    padding:12px 25px;
    background:#3498db;
    color:white;
    text-decoration:none;
    border-radius:10px;
    margin-top:15px;
    transition:0.3s;
}

.botao:hover{
    background:#2980b9;
}

</style>

</head>

<body>

<div class="card">

    <div class="icone">
        <i class="ti ti-user-x"></i>
    </div>

    <h1>Cliente Não Encontrado</h1>

    <p>
        <%= request.getAttribute("mensagem") %>
    </p>

    <a href="index.html" class="botao">
        Voltar ao Sistema
    </a>

</div>

</body>
</html>
