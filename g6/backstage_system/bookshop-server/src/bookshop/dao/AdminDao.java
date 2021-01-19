package bookshop.dao;

import bookshop.entity.Admin;

public interface AdminDao {

    Admin adminLogin(String user,String password) throws Exception;
    
}
