/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

/**
 *
 * @author txxx4
 */import DAO.ClienteDAO;
import Model.Cliente;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
 


 
@WebServlet(name = "Controlar_Cliente", urlPatterns = {"/Controlar_Cliente"})
public class Controlar_Cliente extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
 
        String op = request.getParameter("op");
        ClienteDAO cdao = new ClienteDAO();
 
        try {
 
            // ── CADASTRAR ──────────────────────────────────────────────────
            if ("cadastrar_cliente".equals(op)) {
                Cliente cliente = new Cliente();
                cliente.setNome(request.getParameter("nome"));
                cliente.setTelefone(request.getParameter("telefone"));
                cliente.setEmail(request.getParameter("email"));
                cliente.setData_reserva(request.getParameter("data_reserva"));
                cliente.setData_devolucao(request.getParameter("data_devolucao"));
                cliente.setNome_filme(request.getParameter("nome_filme"));
                cdao.cadastrarCliente(cliente);
                request.setAttribute("mensagem", "Cliente cadastrado com sucesso!");
                request.setAttribute("tipo", "sucesso");
                request.getRequestDispatcher("cadastro_cliente.jsp").forward(request, response);
 
            // ── ATUALIZAR ──────────────────────────────────────────────────
                } else if ("atualizar_cliente".equals(op)) {

                 Cliente cliente = new Cliente();

                 cliente.setId(
                     Integer.parseInt(request.getParameter("id"))
                 );

                 cliente.setNome(
                     request.getParameter("nome")
                 );

                 cliente.setTelefone(
                     request.getParameter("telefone")
                 );

                 cliente.setEmail(
                     request.getParameter("email")
                 );

                 cliente.setData_reserva(
                     request.getParameter("data_reserva")
                 );

                 cliente.setData_devolucao(
                     request.getParameter("data_devolucao")
                 );
                 cliente.setNome_filme(
                    request.getParameter("nome_filme")
                 );
                 try {

                     cdao.atualizarCliente(cliente);

                     request.getRequestDispatcher(
                         "atualizar_cliente.jsp"
                     ).forward(request, response);

                 } catch(SQLException ex){

                     request.setAttribute(
                         "mensagem",
                         ex.getMessage()
                     );

                     request.getRequestDispatcher(
                         "erro_atualizar_cliente.jsp"
                     ).forward(request, response);
                 }

                 

            } else if ("deletar_cliente".equals(op)) {

                 Cliente cliente = new Cliente();

                 cliente.setId(Integer.parseInt(request.getParameter("id")));

            try {

                    cdao.deletarCliente(cliente);

                    request.getRequestDispatcher(
                        "deletar_cliente.jsp"
                    ).forward(request, response);

                } catch (SQLException ex) {

                    request.setAttribute(
                        "mensagem",
                        ex.getMessage()
                    );

                request.getRequestDispatcher(
                    "erro_cliente.jsp"
                ).forward(request, response);
            }

            

                // ── CONSULTAR POR ID ───────────────────────────────────────────
            } else if ("consultar_id_cliente".equals(op)) {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(request.getParameter("id")));
 
                Cliente resultado = cdao.consultarById(cliente);
                request.setAttribute("cliente", resultado);
                request.getRequestDispatcher("cliente_detalhe.jsp").forward(request, response);
 
            // ── CONSULTAR TODOS ────────────────────────────────────────────
            } else if ("consultar_todos_clientes".equals(op)) {
                List<Cliente> lista = cdao.consultarTodos();
                request.setAttribute("listaClientes", lista);
                request.getRequestDispatcher("clientes_lista.jsp").forward(request, response);
 
            // ── OP DESCONHECIDA ────────────────────────────────────────────
            } else {
                response.sendRedirect("index.html");
            }
 
        } catch (ClassNotFoundException | SQLException ex) {
            
                ex.printStackTrace();
                
            request.setAttribute("mensagem", "Erro no banco de dados: " + ex.getMessage());
            request.setAttribute("tipo", "erro");
            request.getRequestDispatcher("resultados.jsp").forward(request, response);
            
        } catch (NumberFormatException ex) {
                ex.printStackTrace();
                
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
        return "Controlador de Clientes";
    }
}

