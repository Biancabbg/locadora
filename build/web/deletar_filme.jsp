<%-- 
    Document   : deletar_filme
    Created on : 26 de mai. de 2026, 20:28:27
    Author     : txxx4
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Filme Excluído</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">

<style>

body{
    margin:0;
    padding:0;
    font-family: Arial, sans-serif;
    background:#f4f6f9;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.card{
    background:white;
    width:500px;
    padding:40px;
    border-radius:20px;
    text-align:center;
    box-shadow:0 4px 15px rgba(0,0,0,0.15);
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
    margin-bottom:30px;
}

.botao{
    display:inline-block;
    padding:12px 25px;
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

<div class="card">

    <div class="icone">
        <i class="ti ti-trash"></i>
    </div>

    <h1>Filme Excluído</h1>

    <p>
        O filme foi removido do catálogo da locadora com sucesso.
    </p>

    <a href="index.html" class="botao">
        Voltar ao Sistema
    </a>

</div>

</body>
</html>
