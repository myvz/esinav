package com.esinav.controller;




import com.esinav.ejb.entity.Kullanici;
import com.esinav.ejb.ifacade.KullaniciFacadeLocal;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Named
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private String password;
    private Kullanici kullanici;

    @EJB
    private KullaniciFacadeLocal kullaniciFacade;


    public LoginController() {
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void login(ActionEvent actionEvent) {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            String navigateString = "";
            // Checks if username and password are valid if not throws a ServletException
            if (kullanici==null)  request.login(username, password);
            kullanici=kullaniciFacade.findKullaniciByKullaniciAdi(username);
            // gets the user principle and navigates to the appropriate page
            Principal principal = request.getUserPrincipal();
            if (request.isUserInRole("admin")) {
                navigateString = "/admin/adminHome.xhtml";
            } else if (request.isUserInRole("teacher")) {
                navigateString = "/teacher/teacherHome.xhtml";
            } else if (request.isUserInRole("student")) {
                navigateString = "/student/studentHome.xhtml";
            }
            try {

                context.getExternalContext().redirect(request.getContextPath() + navigateString);
            } catch (IOException ex) {

                context.addMessage(null, new FacesMessage("Error!", "Exception occured"));
            }

        } catch (ServletException e) {

            context.addMessage(null, new FacesMessage("Error!", "Yanlış Kullanici Adı veya Şifre"));
        }
    }

    public void logout() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        kullanici=null;
        if (session != null) {
            session.invalidate();
        }
        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "/login.xhtml?faces-redirect=true");
    }

    public Kullanici getKullanici() {
        return kullanici;
    }
}