/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import icv.Dao.StoriesBean;
import icv.Entity.Stories;
import icv.Entity.User;
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
public class PublicControl extends HttpServlet {

    @EJB
    private StoriesBean storiesBean;

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
       
        try{
        if(request.getParameter("redirect").equals("admin")){           // thực hiện chuyển tiếp về trang admin
            User user= (User)(request.getSession().getAttribute("User")); 
            
            if(user==null){             
                String lastPath="PublicControl?redirect=admin";
                HttpSession session = request.getSession();
                session.setAttribute("lastPath", lastPath);
                RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
            }else{
                if(user.getUserGroupId().getId().equals(Short.valueOf("1"))){
                    RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
                    rd.forward(request, response);
                    return;
                }else{
                    String lastPath="PublicControl?redirect=admin";
                    HttpSession session = request.getSession();
                    session.setAttribute("lastPath", lastPath);
                    RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                    
                    rd.forward(request, response);
                }
                
                
            }
            
            RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin/admin.jsp");
            rd.forward(request, response);
            return;
        }}catch(Exception e){
        }
        
        
        try{
            if(request.getParameter("publicAction").equals("changeAccess")){
                String id= request.getParameter("id");
                storiesBean.ChangeAccess(Short.valueOf(id));
                RequestDispatcher rd = request.getRequestDispatcher("PublicControl?redirect=managerStories");
                rd.forward(request, response);
            }
        }catch(Exception e){}
        
        try{
        if(request.getParameter("redirect").equals("managerStories")){      //thực hiện chuyên trang đến trang manager Stories
            String html="";
            List<Stories> lst = storiesBean.retriveallStories();
            String serverName = request.getServerName();
             int port = request.getServerPort();
            if(lst.size()>1){
                for(int i = 0 ; i < lst.size(); i++){
                    html +="<tr>"
                            + "<td></td>"
                            + "<td>"+lst.get(i).getTitle()+"</td>"
                            + "<td>"+lst.get(i).getDatepost()+"</td>"
                            + "<td>"+lst.get(i).getSignment()+"</td>"
                            + "<td>"+lst.get(i).getAccess().toString()+"</td>"
                            + "<td><a href=\"http://"+serverName+":"+port+"/Icv-war/PublicControl?publicAction=changeAccess&id="+lst.get(i).getIdStories()+"\">Change Access</a></td>"
                            + "</tr>";
                }
                
            }
            
            System.out.println(lst.size() + html);
            HttpSession session = request.getSession();
            session.setAttribute("ListAllStories", html);
            
            RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin/StoriesControl.jsp");
            rd.forward(request, response);
            return;
        }
        }catch(Exception e){}
        
        try{
        if(request.getParameter("redirect").equals("managerUserOpinion")){      // thực hiện chuyển trang
            RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin/OpinionControl.jsp");
            rd.forward(request, response);
            return;
        }}catch(Exception e){}
        
        try{
        if(request.getAttribute("totalUser").toString().equals("get")){         // thực hiện yêu cầu nhận số người dùng online ở thời điểm hiện thời
            int activess= SessionCounter.getActiveSessions();
            response.setContentType("text/plain");
            response.getWriter().write("Online User: "+activess);
            System.out.println(activess);
            return;
        }}catch(Exception e){}
        
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
