<%-- 
    Document   : clientes_lista
    Created on : 26 de mai. de 2026, 19:35:58
    Author     : txxx4
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Model.Cliente" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Locadora — Clientes</title>
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
    table { width: 100%; min-width: 1400px; border-collapse: collapse; font-size: 13px; table-layout: auto; }
    thead th {
      text-align: left; padding: 10px 14px;
      background: #f8f9fb; font-weight: 500; font-size: 12px;
      color: #6b7280; text-transform: uppercase; letter-spacing: .5px;
      border-bottom: 1px solid rgba(0,0,0,.08);
    }
    tbody tr { border-bottom: 1px solid rgba(0,0,0,.06); transition: background .1s; }
    tbody tr:hover { background: #fafbfc; }
    tbody td { padding: 11px 14px; color: #1a1a2e; vertical-align: middle; word-break: break-word; }
    .avatar {
      width: 34px; height: 34px; border-radius: 50%;
      background: rgba(37,145,184,.15); color: #2591b8;
      display: inline-flex; align-items: center; justify-content: center;
      font-size: 12px; font-weight: 500; margin-right: 8px; vertical-align: middle;
    }
    .empty { text-align: center; padding: 3rem; color: #9ca3af; font-size: 15px; }
    .empty i { font-size: 40px; display: block; margin-bottom: 12px; opacity: .4; }
    .btn-voltar {
      display: inline-flex; align-items: center; gap: 8px;
      padding: 9px 18px; background: #2591b8; color: #fff;
      border: none; border-radius: 8px; font-size: 14px;
      font-family: 'DM Sans', sans-serif; font-weight: 500;
      cursor: pointer; text-decoration: none; transition: opacity .15s;
    }
    .btn-voltar:hover { opacity: .88; }
    .btn-seta {
    width: 32px;
    height: 32px;
    padding: 0;
    font-size: 14px;
    border: none;
    border-radius: 6px;
    background: #2591b8;
    color: white;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
}

.btn-seta:hover {
    opacity: 0.88;
}
    .form-card::-webkit-scrollbar {
        height: 10px;
    }

    .form-card::-webkit-scrollbar-thumb {
        background: #2591b8;
        border-radius: 5px;
    }

    .form-card::-webkit-scrollbar-track {
        background: #e5e7eb;
    }
  </style>
</head>
<body>
<div id="app" style="padding:24px 16px 48px; max-width:1400px !important; width:95%;">
  <div class="page-header">
    <div>
         <h1>Clientes Cadastrados</h1>
        <p>Membros da locadora</p>
  </div>

  <div style="display:flex; gap:6px; margin-left:10px;">
    <button type="button" class="btn-seta" onclick="scrollTable(-300)">
      ←
    </button>

    <button type="button" class="btn-seta" onclick="scrollTable(300)">
      →
    </button>
  </div>

  <a href="index.html" class="btn-voltar" style="margin-left:auto">
    <i class="ti ti-arrow-left"></i> Voltar
  </a>
  </div>

  <div class="form-card" style="padding:0;overflow:hidden">
    <%
      List<Cliente> lista = (List<Cliente>) request.getAttribute("listaClientes");
      if (lista == null || lista.isEmpty()) {
    %>
      <div class="empty">
        <i class="ti ti-user-off" aria-hidden="true"></i>
        Nenhum cliente cadastrado ainda.
      </div>
    <%
      } else {
    %>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>E-mail</th>
            <th>Reserva</th>
            <th>Devolução</th>
             <th>Filme</th>
          </tr>
        </thead>
        <tbody>
        <%
          for (Cliente c : lista) {
            String iniciais = "";
            if (c.getNome() != null && !c.getNome().isEmpty()) {
              String[] partes = c.getNome().trim().split("\\s+");
              iniciais += partes[0].charAt(0);
              if (partes.length > 1) iniciais += partes[partes.length - 1].charAt(0);
            }
        %>
          <tr>
            <td><strong><%= c.getId() %></strong></td>
            <td>
              <span class="avatar"><%= iniciais.toUpperCase() %></span>
              <%= c.getNome() %>
            </td>
            <td><%= c.getTelefone() %></td>
            <td><%= c.getEmail() %></td>
            <td><%= c.getData_reserva() %></td>
            <td><%= c.getData_devolucao() %></td>
            <td><%= c.getNome_filme() %></td>
          </tr>
        <%
          }
        %>
        </tbody>
      </table>
    <% } %>
  </div>
</div>
  <script>
function scrollTable(valor) {
    document.querySelector('.form-card').scrollBy({
        left: valor,
        behavior: 'smooth'
    });
}
</script>
</body>
</html>
