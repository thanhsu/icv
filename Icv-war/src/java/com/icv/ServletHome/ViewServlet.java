/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletHome;

import icv.Dao.CvBean;
import icv.Dao.ProfileBean;
import icv.Dao.UserBean;
import icv.Dao.User_cv;
import icv.Entity.Cv;
import icv.Entity.Profile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duyng
 */
public class ViewServlet extends HttpServlet {

    @EJB
    private UserBean userBean;

    @EJB
    private User_cv user_cv;

    @EJB
    private CvBean cvBean;

    @EJB
    private ProfileBean profileBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        if(request.getParameter("viewAction").equals("search")){        //thực hiện truy vấn tìm kiếm
            String inputSearch = request.getParameter("searchValue");
            try{
            String resultbyName="";
            
            String resultByCareer="";
            HttpSession sesion = request.getSession();
            
            List<Profile> lstProfilebyName;
            lstProfilebyName = profileBean.searchByName(inputSearch);       // danh sách tìm kiếm trên tên ng dùng
            List<Cv> lstCvbyCareer;
            
            lstCvbyCareer = cvBean.searchbyCareer(inputSearch);
            
            if(lstProfilebyName!=null){
                for(int i =0 ;i < lstProfilebyName.size();i++){
                    resultbyName +="<div class=\"row\">"
                            + "<div class=\"col-md-1 col-sm-1\">"
                            + "<a href=\"view.jsp?id="+lstProfilebyName.get(i).getIdUser().getIdUser()+"\"><img src=\"ProfileControl?profileAction=getAvatar&id="+lstProfilebyName.get(i).getIdUser().getIdUser()+"\" width=\"30px\" height=\"30px\" ></a>"                        //avatar
                            + "</div>"
                            + "<div class=\"col-md-9 col-sm-9\">"
                            + "<p><strong>"+lstProfilebyName.get(i).getFirstName() +" "+ lstProfilebyName.get(i).getLastName()+"</strong></p>"
                            + "<p>"+ (cvBean.retriveCVbyIdStore(user_cv.retriveStoreCvbyIdUser(lstProfilebyName.get(i).getIdUser().getIdUser()))).getMore()+"</p>"
                            + "</div>"
                            + "</div><hr/>";
                    
                    
                }
            
            }
            else{
                resultbyName="<p style=\"text-alaign:center;\">No Data</p>";
            }
            
            if(lstCvbyCareer!=null){
                for(int i =0 ;i < lstCvbyCareer.size();i++){
                    resultByCareer +="<div class=\"row\">"
                            + "<div class=\"col-md-1 col-sm-1\">"
                            + "<a href=\"view.jsp?id="+lstCvbyCareer.get(i).getIdStore().getIdUser().getIdUser()+"\"><img src=\"ProfileControl?profileAction=getAvatar&id="+lstCvbyCareer.get(i).getIdStore().getIdUser().getIdUser()+"\" width=\"30px\" height=\"30px\" ></a>"                        //avatar
                            + "</div>"
                            + "<div class=\"col-md-9 col-sm-9\">"
                            + "<p><strong>"+(profileBean.retriveProfileByIdUser(lstCvbyCareer.get(i).getIdStore().getIdUser().getIdUser())).getFirstName() +" "+ (profileBean.retriveProfileByIdUser(lstCvbyCareer.get(i).getIdStore().getIdUser().getIdUser())).getLastName()+"</strong></p>"
                            + "<p>"+ lstCvbyCareer.get(i).getMore() +"</p>"
                            + "</div>"
                            + "</div><hr/>";
                    
                    
                }
            
            }
            else{
                resultByCareer="<p style=\"text-alaign:center;\">No Data</p>";
            }
            
            
           
            sesion.setAttribute("resultbyName", resultbyName);
            sesion.setAttribute("resultbyCareer", resultByCareer);
            }catch(Exception e){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("resultbyName", " ");
                sesion.setAttribute("resultbyCareer", " ");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/index.jsp");
            rd.forward(request, response);
        }
        
        if(request.getParameter("viewAction").equals("backHome")){          // chuyển tiếp đến trang chủ
            if(request.getSession().getAttribute("User")!=null){
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/User.jsp");
                rd.forward(request, response);
            }else{
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        }
        
        if(request.getParameter("viewAction").equals("admin")){
            HttpSession session = request.getSession();
            
            session.setAttribute("totalUser", userBean.retriveAll().size());
            
            return;
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
