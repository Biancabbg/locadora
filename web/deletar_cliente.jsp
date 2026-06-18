<%-- 
    Document   : deletar_cliente
    Created on : 26 de mai. de 2026, 20:22:52
    Author     : txxx4
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Locadora</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">

<style>

body{
    margin:0;
    font-family: Arial, sans-serif;
    background:#f4f6f9;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.card{
    width:500px;
    background:white;
    border-radius:20px;
    padding:40px;
    text-align:center;
    box-shadow:0 5px 20px rgba(0,0,0,0.15);
}

.icone{
    font-size:90px;
    color:#27ae60;
}

h1{
    color:#2c3e50;
    margin-top:15px;
}

.mensagem{
    font-size:18px;
    color:#555;
    margin:20px 0;
}

.botao{
    display:inline-block;
    padding:12px 30px;
    background:#3498db;
    color:white;
    text-decoration:none;
    border-radius:10px;
    transition:0.3s;
}

.botao:hover{
    background:#2980b9;
}

</style>

</head>

<body>

<%
String mensagem = (String) request.getAttribute("mensagem");

if(mensagem == null){
    mensagem = "Operação realizada com sucesso!";
}
%>

<div class="card">

    <div class="icone">
        <i class="ti ti-circle-check"></i>
    </div>

    <h1>Sucesso!</h1>

    <div class="mensagem">
        <%= mensagem %>
    </div>

    <a href="index.html" class="botao">
        Voltar ao Sistema
    </a>

</div>

</body>
</html>