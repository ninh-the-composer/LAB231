/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Menu;

/**
 *
 * @author sogor
 */
public interface IMenuDAO {
    public List<Menu> getMenus(int postAPage, int page) throws Exception;

    public int countMenus() throws Exception;

}
