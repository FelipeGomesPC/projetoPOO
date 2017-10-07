/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;

/**
 *
 * @author Felipe Gomes
 */
public interface Dao<T> {
    public T read(T obj);
    public boolean create(T obj);
    public boolean delete(T obj);
    public List<T> listAll();
    public boolean update(T obj);
}
