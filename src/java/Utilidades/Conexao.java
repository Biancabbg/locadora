/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author txxx4
 */
public class Conexao {
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        //Verificar em seu computador
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/Locadora"; //Verificar em seu computador
        String USERNAME = "root"; //Verificar em seu computador
        String PASSWORD = ""; //Verificar em seu computador
        
        // O método forName carrega e inicia o driver passado por parâmetro
        Class.forName(DRIVER);
        // Estabelecendo a conexão
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
 