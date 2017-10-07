/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author Felipe Gomes
 */
public class UsuarioDaoArquivo {
    private File arquivo;

    public UsuarioDaoArquivo() throws IOException{
        arquivo = new File("Usuario.bin");
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
    }

    
    public Usuario read(String senha) throws IOException, ClassNotFoundException{
        List<Usuario> pessoass = listAll();
        
        for(Usuario p : pessoass){
            if(p.getSenha().equals(senha)) return p;
        }
        return null;
    }
    
   public boolean create(Usuario p) throws IOException, ClassNotFoundException{
        List<Usuario> pessoas = listAll();
        if (p.getNome() != null || p.getSenha() != null){
            pessoas.add(p);
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(pessoas);
        out.close();
        return true;
    }


    public boolean delete(Usuario p) throws IOException, ClassNotFoundException{
        List<Usuario> pessoas = listAll();
        
        pessoas.remove(p);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(pessoas);
        out.close();
        return true;
    }

  
    public boolean update(Usuario u) throws IOException, ClassNotFoundException{
        List<Usuario> pessoas = listAll();
        
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getSenha().equals(u.getSenha())){
                pessoas.set(i, u);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
                out.writeObject(pessoas);
                out.close();
                return true;
            }
        }
        return false;        
    }

    public List<Usuario> listAll() throws IOException, ClassNotFoundException{
        List<Usuario> pessoas;
        
        if(arquivo.length() > 0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            pessoas = (List) in.readObject();
            in.close();
        } else {
            pessoas = new ArrayList<>();
        }
        
        return pessoas;
    }

    
    public boolean buscar(String nome, String senha) throws IOException, ClassNotFoundException{
        List<Usuario> usuarios = listAll();
        
        for(Usuario usuario: usuarios){
            if(usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) 
                return true;
        }
        return false;
    }
        
}
