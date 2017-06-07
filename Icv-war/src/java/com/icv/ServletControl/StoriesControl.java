/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import icv.Dao.StoriesBean;
import icv.Entity.Stories;
import java.io.IOException;

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
public class StoriesControl extends HttpServlet {

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
            
         if(request.getParameter("storiesAction").equals("getView")){       // nhận thông tin bào đăng
             String id= request.getParameter("id");
                
             Stories stories = storiesBean.retriveById(Short.valueOf(id));  
             System.out.println( "Storis" +stories.getTitle());
             HttpSession session = request.getSession(true);
             session.setAttribute("Stories", stories);
             
             RequestDispatcher rd  = request.getRequestDispatcher("/Stories/index.jsp");
             rd.forward(request, response);
             return;
         }
         if(request.getParameter("storiesAction").equals("getMenu")){
             System.out.println("get menu");
             String html="";
             List<Stories> lst = storiesBean.retriveAllAccess();
             System.out.println(lst.size());
             if(lst == null){
                 html = "Don't have anything!";
                 response.setContentType("text/plain");
                 response.getWriter().write(html);
                 processRequest(request, response);
                 return;
             }
             String svg ="<svg style=\"text-alaign:center;\" width='196px' height='196px' xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 100 100\" preserveAspectRatio=\"xMidYMid\" class=\"uil-default\"><rect x=\"0\" y=\"0\" width=\"100\" height=\"100\" fill=\"none\" class=\"bk\"></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(0 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-1s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(30 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.9166666666666666s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(60 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.8333333333333334s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(90 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.75s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(120 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.6666666666666666s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(150 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.5833333333333334s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(180 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.5s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(210 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.4166666666666667s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(240 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.3333333333333333s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(270 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.25s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(300 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.16666666666666666s' repeatCount='indefinite'/></rect><rect  x='46.5' y='40' width='7' height='20' rx='5' ry='5' fill='#00b2ff' transform='rotate(330 50 50) translate(0 -30)'>  <animate attributeName='opacity' from='1' to='0' dur='1s' begin='-0.08333333333333333s' repeatCount='indefinite'/></rect></svg>";
             String serverName = request.getServerName();
             int port = request.getServerPort();
             for(int i= 0;i < lst.size(); i++){
                 if(i > 8){
                    response.setContentType("text/plain");
                 response.getWriter().write(html);
                 processRequest(request, response);
                 return;
                 }else{
                 html +="<div class=\"col-md-3 col-sm-3 col-md-offset-1 col-sm-offset-1 color-background box-shadow \">";
                 html +="<a href=\"http://"+serverName+":"+port+"/Icv-war/StoriesControl?storiesAction=getView&id="+lst.get(i).getIdStories()+"\">"+svg+"</a>";
                 html +="<p>"+lst.get(i).getTitle()+"</p>"
                         + "<p>"+lst.get(i).getDatepost()+"</p>"
                         + "</div>";
                 }
             }
             System.out.println(html);
                 response.setContentType("text/plain");
                 response.getWriter().write(html);
                 processRequest(request, response);
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
        
        
        if(request.getParameter("storiesAction").equals("newStories")){
            String title= request.getParameter("storiestitle");
            String signment = request.getParameter("storissignment");
            String date = request.getParameter("storiesdate");
            String textcontent = request.getParameter("storiescontent");
            
            Stories stories = new Stories();
            stories.setTitle(title);
            stories.setDatepost(date);
            stories.setSignment(signment);
            stories.setAccess(Boolean.FALSE);
            stories.setContent(textcontent);
           
            storiesBean.persistnewStories(stories);
            
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin/StoriesControl.jsp");
            rd.forward(request, response);
                   
        }
        
        
        
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
