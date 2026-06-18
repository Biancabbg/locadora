<%-- 
    Document   : resultados
    Created on : 26 de mai. de 2026, 19:37:22
    Author     : txxx4
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Locadora — Resultado</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500;700&family=DM+Sans:wght@400;500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">
  <link rel="stylesheet" href="style.css">
  <style>
    .result-card {
      max-width: 480px;
      margin: 80px auto;
      background: #fff;
      border: 1px solid rgba(0,0,0,.1);
      border-radius: 14px;
      padding: 2.5rem 2rem;
      text-align: center;
      box-shadow: 0 2px 12px rgba(0,0,0,.08);
    }
    .result-icon { font-size: 52px; margin-bottom: 1rem; display: block; }
    .result-icon.sucesso { color: #16a34a; }
    .result-icon.erro    { color: #dc2626; }
    .result-card h2 {
      font-family: 'Playfair Display', serif;
      font-size: 1.5rem;
      margin-bottom: .5rem;
    }
    .result-card p { color: #6b7280; font-size: 15px; margin-bottom: 1.5rem; }
    .btn-voltar {
      display: inline-flex;
      align-items: center;
      gap: 8px;
      padding: 10px 24px;
      background: #e94560;
      color: #fff;
      border: none;
      border-radius: 8px;
      font-size: 15px;
      font-family: 'DM Sans', sans-serif;
      font-weight: 500;
      cursor: pointer;
      text-decoration: none;
      transition: opacity .15s;
    }
    .btn-voltar:hover { opacity: .88; }
  </style>
</head>
<body>
  <%
    String tipo     = (String) request.getAttribute("tipo");
    String mensagem = (String) request.getAttribute("mensagem");
    boolean sucesso = "sucesso".equals(tipo);
  %>
  <div class="result-card">
    <i class="ti <%= sucesso ? "ti-circle-check result-icon sucesso" : "ti-circle-x result-icon erro" %>" aria-hidden="true"></i>
    <h2><%= sucesso ? "Operação realizada!" : "Ocorreu um erro" %></h2>
    <p><%= mensagem != null ? mensagem : "Sem detalhes disponíveis." %></p>
    <a href="index.html" class="btn-voltar">
      <i class="ti ti-home" aria-hidden="true"></i> Voltar ao início
    </a>
  </div>
</body>
</html>
