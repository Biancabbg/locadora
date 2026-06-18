/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package DAO;
 
import Model.Cliente;
import Utilidades.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class ClienteDAO {
 
    public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        String SQL = "INSERT INTO cliente(nome, telefone, email, data_reserva, data_devolucao, nome_filme) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, cliente.getNome());
        comando.setString(2, cliente.getTelefone());
        comando.setString(3, cliente.getEmail());
        comando.setString(4, cliente.getData_reserva());
        comando.setString(5, cliente.getData_devolucao());
        comando.setString (6, cliente.getNome_filme());
        comando.execute();
        con.close();
    }
 
public void deletarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "DELETE FROM cliente WHERE id = ?";

    PreparedStatement comando = con.prepareStatement(SQL);

    comando.setInt(1, cliente.getId());

    int linhasAfetadas = comando.executeUpdate();

    con.close();

    if (linhasAfetadas == 0) {
        throw new SQLException(
            "Cliente com ID " + cliente.getId() + " não encontrado."
        );
    }
}
    public void atualizarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConexao();

        String SQL = "UPDATE cliente SET nome = ?, telefone = ?, email = ?, data_reserva = ?, data_devolucao = ? , nome_filme = ? WHERE id = ?";

        PreparedStatement comando = con.prepareStatement(SQL);

        comando.setString(1, cliente.getNome());
        comando.setString(2, cliente.getTelefone());
        comando.setString(3, cliente.getEmail());
        comando.setString(4, cliente.getData_reserva());
        comando.setString(5, cliente.getData_devolucao());
        comando.setString (6, cliente.getNome_filme());
        comando.setInt(7, cliente.getId());

        int linhasAfetadas = comando.executeUpdate();

        con.close();

        if(linhasAfetadas == 0){
            throw new SQLException(
                "Cliente com ID " + cliente.getId() + " não encontrado."
            );
        }
    }
 
    public Cliente consultarById(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String SQL = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, cliente.getId());
        ResultSet rs = comando.executeQuery();
        Cliente c = new Cliente();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setData_reserva(rs.getString("data_reserva"));
            c.setData_devolucao(rs.getString("data_devolucao"));
            c.setNome_filme(rs.getString("nome_filme"));
        }
        con.close();
        return c;
    }
 
    public List<Cliente> consultarTodos() throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        String SQL = "SELECT * FROM cliente";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();
        List<Cliente> lista = new ArrayList<>();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            c.setData_reserva(rs.getString("data_reserva"));
            c.setData_devolucao(rs.getString("data_devolucao"));
            c.setNome_filme(rs.getString("nome_filme"));
            
            lista.add(c);
        }
        con.close();
        return lista;
    }
}
/**package DAO;


import Model.Cliente;
import Utilidades.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author txxx4
 
public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "INSERT INTO cliente(nome, telefone, email, data_reserva, data_devolucao) VALUES (?, ?, ?, ?, ?)";

    PreparedStatement comando = con.prepareStatement(SQL);

    comando.setString(1, cliente.getNome());
    comando.setInt(2, cliente.getTelefone());
    comando.setString(3, cliente.getEmail());
    comando.setString(4, cliente.getData_reserva());
    comando.setString(5, cliente.getData_devolucao());

    comando.execute();

    con.close();
    
    }
    
    public void deletarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "DELETE FROM cliente WHERE nome = ?";

    PreparedStatement comando = con.prepareStatement(SQL);

    comando.setString(1, cliente.getNome());

    comando.execute();

    con.close();
    }
    
    public void atualizarCliente(Cliente cliente) throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "UPDATE cliente SET telefone = ?, email = ?, data_reserva = ?, data_devolucao = ? WHERE nome = ?";

    PreparedStatement comando = con.prepareStatement(SQL);

    comando.setInt(1, cliente.getTelefone());
    comando.setString(2, cliente.getEmail());
    comando.setString(3, cliente.getData_reserva());
    comando.setString(4, cliente.getData_devolucao());
    comando.setString(5, cliente.getNome());

    comando.execute();

    con.close();
    }
    
    public Cliente consultarByNome(Cliente cliente) throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "SELECT * FROM cliente WHERE nome = ?";

    PreparedStatement comando = con.prepareStatement(SQL);

    comando.setString(1, cliente.getNome());

    ResultSet rs = comando.executeQuery();

    Cliente c = new Cliente();

    if(rs.next()) {
        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getInt("telefone"));
        c.setEmail(rs.getString("email"));
        c.setData_reserva(rs.getString("data_reserva"));
        c.setData_devolucao(rs.getString("data_devolucao"));
    }

    con.close();

    return c;
    }
    
    public List<Cliente> consultarTodos() throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "SELECT * FROM cliente";

    PreparedStatement comando = con.prepareStatement(SQL);

    ResultSet rs = comando.executeQuery();

    List<Cliente> listaClientes = new ArrayList<>();

    while(rs.next()) {

        Cliente c = new Cliente();

        c.setNome(rs.getString("nome"));
        c.setTelefone(rs.getInt("telefone"));
        c.setEmail(rs.getString("email"));
        c.setData_reserva(rs.getString("data_reserva"));
        c.setData_devolucao(rs.getString("data_devolucao"));

        listaClientes.add(c);
    }

    con.close();

    return listaClientes;
    }
}
**/