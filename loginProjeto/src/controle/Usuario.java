package controle;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe Gomes
 */
public class Usuario  implements Serializable{
    private String nome;
    private String senha;

    public Usuario(String nome, String senha){
        if (nome != null || senha != null){
            this.nome = nome;
            this.senha = senha;
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", senha=" + senha + '}';
    }
    
    
    
}
