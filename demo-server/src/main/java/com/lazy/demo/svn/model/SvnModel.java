package com.lazy.demo.svn.model;

import org.tmatesoft.svn.core.io.SVNRepository;

/***
 * Description: 
 *
 * @author: xieweili
 * @since: 2017年1月17日	
 * @version: $Revision$ $Date$ $LastChangedBy$
 *
 */
public class SvnModel {

    private String svnRoot;
    private String userName;
    private String password;
    private SVNRepository repository;
    public String getSvnRoot() {
        return svnRoot;
    }
    public void setSvnRoot(String svnRoot) {
        this.svnRoot = svnRoot;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public SVNRepository getRepository() {
        return repository;
    }
    public void setRepository(SVNRepository repository) {
        this.repository = repository;
    }
    
}

	