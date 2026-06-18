<%-- 
    Document   : filmes_lista
    Created on : 26 de mai. de 2026, 19:33:47
    Author     : txxx4
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Model.Filme" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Locadora — Filmes</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@500;700&family=DM+Sans:wght@400;500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/dist/tabler-icons.min.css">
  <link rel="stylesheet" href="style.css">
  <style>
    .page-header {
      display: flex; align-items: center; gap: 12px;
      margin-bottom: 1.5rem; padding-bottom: 1rem;
      border-bottom: 1px solid rgba(0,0,0,.1);
    }
    .page-header h1 { font-family: 'Playfair Display', serif; font-size: 1.6rem; font-weight: 500; }
    .page-header p  { font-size: 13px; color: #6b7280; margin-top: 2px; }
    table { width: 100%; border-collapse: collapse; font-size: 14px; }
    thead th {
      text-align: left; padding: 10px 14px;
      background: #f8f9fb; font-weight: 500; font-size: 12px;
      color: #6b7280; text-transform: uppercase; letter-spacing: .5px;
      border-bottom: 1px solid rgba(0,0,0,.08);
    }
    tbody tr { border-bottom: 1px solid rgba(0,0,0,.06); transition: background .1s; }
    tbody tr:hover { background: #fafbfc; }
    tbody td { padding: 11px 14px; color: #1a1a2e; vertical-align: middle; }
    .badge-status {
      display: inline-block; padding: 3px 10px;
      border-radius: 99px; font-size: 12px; font-weight: 500;
    }
    .disponivel   { background: #dcfce7; color: #15803d; }
    .indisponivel { background: #fee2e2; color: #b91c1c; }
    .empty { text-align: center; padding: 3rem; color: #9ca3af; font-size: 15px; }
    .empty i { font-size: 40px; display: block; margin-bottom: 12px; opacity: .4; }
    .btn-voltar {
      display: inline-flex; align-items: center; gap: 8px;
      padding: 9px 18px; background: #e94560; color: #fff;
      border: none; border-radius: 8px; font-size: 14px;
      font-family: 'DM Sans', sans-serif; font-weight: 500;
      cursor: pointer; text-decoration: none; transition: opacity .15s;
    }
    .btn-voltar:hover { opacity: .88; }
  </style>
</head>
<body>
<div id="app" style="padding:24px 16px 48px">
  <div class="page-header">
    <div>
      <h1>Filmes Cadastrados</h1>
      <p>Acervo completo da locadora</p>
    </div>
    <a href="index.html" class="btn-voltar" style="margin-left:auto">
      <i class="ti ti-arrow-left" aria-hidden="true"></i> Voltar
    </a>
  </div>

  <div class="form-card" style="padding:0;overflow:hidden">
    <%
      List<Filme> lista = (List<Filme>) request.getAttribute("listaFilmes");
      if (lista == null || lista.isEmpty()) {
    %>
      <div class="empty">
        <i class="ti ti-movie-off" aria-hidden="true"></i>
        Nenhum filme cadastrado ainda.
      </div>
    <%
      } else {
    %>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Diretor</th>
            <th>Ano</th>
            <th>Preço</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
        <%
          for (Filme f : lista) {
            String statusClass = "Disponível".equals(f.getStatus()) ? "disponivel" : "indisponivel";
        %>
          <tr>
            <td><strong><%= f.getId() %></strong></td>
            <td><%= f.getNome() %></td>
            <td><%= f.getDiretor() %></td>
            <td><%= f.getAno_publicacao() %></td>
            <td>R$ <%= String.format("%.2f", f.getPreco_aluguel()) %></td>
            <td><span class="badge-status <%= statusClass %>"><%= f.getStatus() %></span></td>
          </tr>
        <%
          }
        %>
        </tbody>
      </table>
    <% } %>
  </div>
</div>
</body>
</html>
