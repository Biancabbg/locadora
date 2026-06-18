/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package DAO;
 
import Model.Filme;
import Utilidades.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
public class FilmeDAO {
 
    public void cadastrarFilme(Filme filme) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        String SQL = "INSERT INTO filme(nome, diretor, ano_publicacao, preco_aluguel, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setString(1, filme.getNome());
        comando.setString(2, filme.getDiretor());
        comando.setString(3, filme.getAno_publicacao());
        comando.setDouble(4, filme.getPreco_aluguel());
        comando.setString(5, filme.getStatus());
        comando.execute();
        con.close();
    }
    public void deletarFilme(Filme filme) throws SQLException, ClassNotFoundException {

        Connection con = Conexao.getConexao();

        String SQL = "DELETE FROM filme WHERE id = ?";

        PreparedStatement comando = con.prepareStatement(SQL);

        comando.setInt(1, filme.getId());

        int linhasAfetadas = comando.executeUpdate();

        con.close();

        if (linhasAfetadas == 0) {

            throw new SQLException(
                "Filme com ID " + filme.getId() + " não encontrado."
            );

        }
    }
 
    public void atualizarFilme(Filme filme) throws SQLException, ClassNotFoundException {

      Connection con = Conexao.getConexao();

      String SQL = "UPDATE filme SET nome = ?, diretor = ?, ano_publicacao = ?, preco_aluguel = ?, status = ? WHERE id = ?";

      PreparedStatement comando = con.prepareStatement(SQL);

      comando.setString(1, filme.getNome());
      comando.setString(2, filme.getDiretor());
      comando.setString(3, filme.getAno_publicacao());
      comando.setDouble(4, filme.getPreco_aluguel());
      comando.setString(5, filme.getStatus());
      comando.setInt(6, filme.getId());

      int linhasAfetadas = comando.executeUpdate();

      con.close();

      if(linhasAfetadas == 0){
          throw new SQLException(
              "Filme com ID " + filme.getId() + " não encontrado."
          );
      }
  }
    public Filme consultarById(Filme filme) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String SQL = "SELECT * FROM filme WHERE id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, filme.getId());
        ResultSet rs = comando.executeQuery();
        Filme f = new Filme();
        if (rs.next()) {
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setDiretor(rs.getString("diretor"));
            f.setAno_publicacao(rs.getString("ano_publicacao"));
            f.setPreco_aluguel(rs.getDouble("preco_aluguel"));
            f.setStatus(rs.getString("status"));
        }
        con.close();
        return f;
    }
 
    public List<Filme> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String SQL = "SELECT * FROM filme";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet rs = comando.executeQuery();
        List<Filme> lista = new ArrayList<>();
        while (rs.next()) {
            Filme f = new Filme();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setDiretor(rs.getString("diretor"));
            f.setAno_publicacao(rs.getString("ano_publicacao"));
            f.setPreco_aluguel(rs.getDouble("preco_aluguel"));
            f.setStatus(rs.getString("status"));
            lista.add(f);
        }
        con.close();
        return lista;
    }
}
 





/*package DAO;

import Model.Filme;
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
 
public class FilmeDAO {
    
    public void cadastrarFilme(Filme filme) throws SQLException, ClassNotFoundException {
        
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into filme(nome, diretor , ano_publicacao, preco_aluguel, status) values(?,?,?,?,?)");
        comando.setString(1, filme.getNome() );
        comando.setString(2, filme.getDiretor());
        comando.setString(3, filme.getAno_publicacao());
        comando.setDouble(4, filme.getPreco_aluguel());
        comando.setString(5, filme.getStatus());
        comando.execute();
        con.close();
    }
    
    public void deletar(Filme filme) throws ClassNotFoundException, SQLException {
    Connection con = Conexao.getConexao();

    String SQL = "DELETE FROM filme WHERE id = ?";

    PreparedStatement comando = con.prepareStatement(SQL);
    comando.setString(1, filme.getNome());

    comando.execute();

    con.close();
    }
    
    
    public void atualizarFilme(Filme filme) throws SQLException, ClassNotFoundException {

    Connection con = Conexao.getConexao();

    String SQL = "UPDATE filme SET nome = ?, diretor = ?, ano_publicacao = ?, preco_aluguel = ?, status = ? WHERE id = ?";

    PreparedStatement comando = con.prepareStatement(SQL);

    comando.setString(1, filme.getNome());
    comando.setString(2, filme.getDiretor());
    comando.setString(3, filme.getAno_publicacao());
    comando.setDouble(4, filme.getPreco_aluguel());
    comando.setString(5, filme.getStatus());
    comando.setInt(6, filme.getId());

    comando.execute();

    con.close();
    }
    
    public Filme consultarById(Filme filme) throws ClassNotFoundException, SQLException {

    Connection con = Conexao.getConexao();

    String SQL = "SELECT * FROM filme WHERE id = ?";

    PreparedStatement comando = con.prepareStatement(SQL);
    comando.setInt(1, filme.getId());

    ResultSet rs = comando.executeQuery();

    Filme f = new Filme();

    if (rs.next()) {
        f.setId(rs.getInt("id"));
        f.setNome(rs.getString("nome"));
        f.setDiretor(rs.getString("diretor"));
        f.setAno_publicacao(rs.getString("ano_publicacao"));
        f.setPreco_aluguel(rs.getDouble("preco_aluguel"));
        f.setStatus(rs.getString("status"));
    }

    con.close();

    return f;
    }
    
    public List<Filme> consultarTodos() throws ClassNotFoundException, SQLException {

    Connection con = Conexao.getConexao();

    String SQL = "SELECT * FROM filme";

    PreparedStatement comando = con.prepareStatement(SQL);

    ResultSet rs = comando.executeQuery();

    List<Filme> listaFilmes = new ArrayList<>();

    while (rs.next()) {

        Filme f = new Filme();

        f.setId(rs.getInt("id"));
        f.setNome(rs.getString("nome"));
        f.setDiretor(rs.getString("diretor"));
        f.setAno_publicacao(rs.getString("ano_publicacao"));
        f.setPreco_aluguel(rs.getDouble("preco_aluguel"));
        f.setStatus(rs.getString("status"));

        listaFilmes.add(f);
    }

    con.close();

    return listaFilmes;
    }
}
    
    /*---------------------------------------------------------------------------------
    
    public void deletar(Livro livro) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String SQL = "delete from livro where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, livro.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizarLivro(Livro livro) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update livro set isbn = ?, titulo = ?, autor = ?, ano = ?, qtd = ? where id = ?");
        comando.setString(1, livro.getIsbn());
        comando.setString(2, livro.getTitulo());
        comando.setString(3, livro.getAutor());
        comando.setString(4, livro.getAno());
        comando.setInt(5, livro.getQtd());
        comando.setInt(6, livro.getId());
        comando.execute();
        con.close();
    }
    
    public Livro consultarById(Livro livro) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String SQL = "select * from livro where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, livro.getId());
        ResultSet rs = comando.executeQuery();
        Livro l = new Livro();
        if (rs.next()) {
            l.setId(rs.getInt("id"));
            l.setTitulo(rs.getString("titulo"));
            l.setAutor(rs.getString("autor"));
            l.setIsbn(rs.getString("isbn"));
            l.setAno(rs.getString("ano"));
            l.setQtd(rs.getInt("qtd"));
        }       
        con.close();
        return l;
    }
    
    public List<Livro> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        String SQL = "select * from livro";
        PreparedStatement comando = con.prepareStatement(SQL);        
        ResultSet rs = comando.executeQuery();        
        List<Livro> listalivro = new ArrayList<Livro>();
        //int cont = 0;
        while(rs.next()){
            Livro l = new Livro();
            l.setId(rs.getInt("id"));
            l.setTitulo(rs.getString("titulo"));
            l.setAutor(rs.getString("autor"));
            l.setIsbn(rs.getString("isbn"));
            l.setAno(rs.getString("ano"));
            l.setQtd(rs.getInt("qtd"));
            listalivro.add(l);
        }
        con.close();
        return listalivro;
    }
*/

