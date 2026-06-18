/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controler;

import DAO.FilmeDAO;
import Model.Filme;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;



 
@WebServlet(name = "Controlar_Filme", urlPatterns = {"/Controlar_Filme"})
public class Controlar_Filme extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
 
        String op = request.getParameter("op");
        FilmeDAO fdao = new FilmeDAO();
 
        try {
 
            // ── CADASTRAR ──────────────────────────────────────────────────
            if ("cadastrar_filme".equals(op)) {
                Filme filme = new Filme();
                filme.setNome(request.getParameter("nome"));
                filme.setDiretor(request.getParameter("diretor"));
                filme.setAno_publicacao(request.getParameter("ano_publicacao"));
                filme.setPreco_aluguel(Double.parseDouble(request.getParameter("preco_aluguel")));
                filme.setStatus(request.getParameter("status"));
 
                fdao.cadastrarFilme(filme);
                request.setAttribute("mensagem", "Filme cadastrado com sucesso!");
                request.setAttribute("tipo", "sucesso");
                request.getRequestDispatcher("cadastro_filme.jsp").forward(request, response);
 
            // ── ATUALIZAR ──────────────────────────────────────────────────
            } else if ("atualizar_filme".equals(op)) {

             Filme filme = new Filme();

             filme.setId(Integer.parseInt(request.getParameter("id")));
             filme.setNome(request.getParameter("nome"));
             filme.setDiretor(request.getParameter("diretor"));
             filme.setAno_publicacao(request.getParameter("ano_publicacao"));
             filme.setPreco_aluguel(
                 Double.parseDouble(request.getParameter("preco_aluguel"))
             );
             filme.setStatus(request.getParameter("status"));

             try {

                 fdao.atualizarFilme(filme);

                 request.getRequestDispatcher(
                     "atualizar_filme.jsp"
                 ).forward(request, response);

             } catch (SQLException ex) {

                 request.setAttribute(
                     "mensagem",
                     ex.getMessage()
                 );

                 request.getRequestDispatcher(
                     "erro_atualizar_filme.jsp"
                 ).forward(request, response);
             
}

            // ── DELETAR ────────────────────────────────────────────────────
            } else if ("deletar_filme".equals(op)) {
                Filme filme = new Filme();
                filme.setId(Integer.parseInt(request.getParameter("id")));
 
               try {

                        fdao.deletarFilme(filme);

                        request.getRequestDispatcher(
                            "deletar_filme.jsp"
                        ).forward(request, response);

                    } catch (SQLException ex) {

                        request.setAttribute(
                            "mensagem",
                            ex.getMessage()
                        );

                        request.getRequestDispatcher(
                            "erro_filme.jsp"
                        ).forward(request, response);

    }
 
            // ── CONSULTAR POR ID ───────────────────────────────────────────
            } else if ("consultar_id_filme".equals(op)) {
                Filme filme = new Filme();
                filme.setId(Integer.parseInt(request.getParameter("id")));
 
                Filme resultado = fdao.consultarById(filme);
                request.setAttribute("filme", resultado);
                request.getRequestDispatcher("filme_detalhe.jsp").forward(request, response);
 
            // ── CONSULTAR TODOS ────────────────────────────────────────────
            } else if ("consultar_todos_filmes".equals(op)) {
                List<Filme> lista = fdao.consultarTodos();
                request.setAttribute("listaFilmes", lista);
                request.getRequestDispatcher("filmes_lista.jsp").forward(request, response);
 
            // ── OP DESCONHECIDA ────────────────────────────────────────────
            } else {
                response.sendRedirect("index.html");
            }
 
        } catch (ClassNotFoundException | SQLException ex) {
            request.setAttribute("mensagem", "Erro no banco de dados: " + ex.getMessage());
            request.setAttribute("tipo", "erro");
            request.getRequestDispatcher("resultados.jsp").forward(request, response);
        } catch (NumberFormatException ex) {
            request.setAttribute("mensagem", "Dados inválidos: verifique os campos numéricos.");
            request.setAttribute("tipo", "erro");
            request.getRequestDispatcher("resultados.jsp").forward(request, response);
        }
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Controlador de Filmes";
    }
}



/**package Controller;

import DAO.FilmeDAO;
import Model.Filme;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author txxx4
 

@WebServlet(name = "Controlar_Filme", urlPatterns = {"/Controlar_Filme"})
public class Controlar_Filme extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String op = request.getParameter("op");
           
            FilmeDAO fdao = new FilmeDAO();
            Filme filme = new Filme();
            
            String nome = request.getParameter("nome");
            String diretor = request.getParameter("diretor");
            String ano_publicacao = request.getParameter("ano_publicao");
            double preco_aluguel = Double.parseDouble(request.getParameter("preco_aluguel"));
            String status = request.getParameter("status");
           
             filme.setNome(nome);
             filme.setDiretor(diretor);
             filme.setAno_publicacao(ano_publicacao);
             filme.setPreco_aluguel(preco_aluguel);
             filme.setStatus(status);
         
            
             try {
                    fdao.cadastrarFilme(filme);
                    System.out.println("Cadastrado com sucesso!!");
                    //request.setAttribute("message", msg);
                    //request.getRequestDispatcher("resultado.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    //request.setAttribute("message", msg);
                    //request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
            
            /* TODO output your page here. You may use following sample code. */
          /**  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlar_Filme</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlar_Filme at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
**/