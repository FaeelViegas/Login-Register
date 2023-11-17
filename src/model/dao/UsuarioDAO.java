/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Usuario> leitura(){
        List<Usuario> usuarios = new ArrayList<>();
        try {
            Connection conexao = Conexao.connect();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conexao.prepareStatement("SELECT * FROM USUARIOS");
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario objUsuario = new Usuario();
                objUsuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                objUsuario.setUserName(rs.getString("USER_NAME"));
                objUsuario.setEmail(rs.getString("EMAIL"));
                objUsuario.setSenha(rs.getString("SENHA"));
                usuarios.add(objUsuario);
            }
            rs.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Lista Usuarios:"+e);
        }
        return usuarios;
    }
}
