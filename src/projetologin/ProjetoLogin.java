/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetologin;
import com.formdev.flatlaf.FlatLightLaf;
import telas.TelaLogin;
/**
 *
 * @author Usuario
 */
public class ProjetoLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
    
}
