/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO {
    public void cadastraUsuario(Usuario objUsuario){
        try {
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            stmt = conexao.prepareStatement("INSERT INTO USUARIOS(USER_NAME,EMAIL,SENHA)VALUES(?,?,?)");
            stmt.setString(1, objUsuario.getUserName());
            stmt.setString(2, objUsuario.getEmail());
            stmt.setString(3, objUsuario.getSenha());
            
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("CADASTRO DE USUARIO:"+e);
        }
    }
}
