/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import icv.Dao.CvBean;
import icv.Entity.Cv;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyng
 */
public class ActivityControl extends HttpServlet {

    @EJB
    private CvBean cvBean;

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
        
       
        if(request.getParameter("activityAction").equals("getViewpublic")){      // nhận request yêu cầu nhận activity tương ứng với      
            Cv cv = (Cv)request.getSession().getAttribute("cvview");        // nhận cv từ cvview 
            String HTML ="";        
            String activity = cv.getActivity();         // nhận dữ liệu activity từ cv
            String prize = cv.getPrize();               //nhận dữ liệu prize từ cv
            
            String[] lstactivity = activity.split(";");     // tạo mảng danh sách activity
            String[] lstprize = prize.split(";");       // tạo mảng danh sách prize
            
            if(lstactivity.length > 0){             // thực hiện tạo view activity trả về client
                HTML +="<div class=\"row\">";
                HTML +="<div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">";
                HTML +="<svg enable-background=\"new 0 0 24 24\" id=\"Layer_1\" version=\"1.0\" viewBox=\"0 0 24 24\" xml:space=\"preserve\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><circle cx=\"12\" cy=\"4\" r=\"2\"/><path d=\"M5.8,10.7c-0.1-0.2,0-0.5,0.2-0.6l5.5-2.2l-0.4-0.9l-6,2.3c-0.8,0.3-1.2,1.2-0.9,2l0.2,0.6c0.3,0.8,1.2,1.2,2,0.9l0,0  c0.2-0.1,0.3-0.3,0.2-0.4L5.8,10.7z\"/><path d=\"M4,8.6l2.6-1.1C6.4,3.5,9,2.4,9,2.4S4.8,3.4,4,8.6z\"/><path d=\"M14,14l0.2,1.8c0.1,0.6-0.1,1.3-0.3,1.8L11.5,22h2.3l2.6-5l0.5-4.4l-1.4-4.5l1.7-0.7c0.3-0.1,0.5-0.5,0.4-0.9  c-0.8-2.5-2.1-3.9-3.5-4.5c0.3,0.1,0.8,1,0.8,2c0,0,0,0.1,0,0.1c0.7,0.7,1.1,1.6,1.1,2l-2.6,1c0,0,0,0-0.1,0l-0.6,0.2  c-0.7,0.3-1,1.1-0.8,1.7L14,14z\"/><polygon points=\"20.7,22 17.6,13.7 17.1,17.4 18.8,22 \"/></svg>";                
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7 \">";
                HTML +="<h4>Activity</h4>";
                HTML +="<ul>";
                for(int i =0 ;i < lstactivity.length;i++){
                    HTML +="<li>"+ lstactivity[i]+"</li>";
                }
                HTML +="</ul>";
                HTML +="</div><div class=\"col-md-2 col-sm-2 col-md-offset-0 col-sm-offset-0 text-right\">"
                        
                        + "</div></div>";
            }
            if(lstprize.length > 0){        // thực hiện tạo view prize trả về cho client
                HTML +="<div class=\"row\">";
                HTML +="<div class=\"col-md-2 col-sm-2 col-md-offset-0 col-sm-offset-0 text-right\">";
                HTML +="<svg height=\"32px\" version=\"1.1\" viewBox=\"0 0 32 32\" width=\"32px\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><title/><desc/><defs/><g fill=\"none\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" stroke-width=\"1\"><g fill=\"#929292\" id=\"icon-34-award\"><path d=\"M16.0072233,19.9999807 L11.6014826,31.4773277 L9.87584513,27.6014826 L6,29.32712 L10.3529754,17.9872315 C8.32301176,16.3370448 7.02605283,13.8199829 7.02605283,11 C7.02605283,6.02943725 11.0554901,2 16.0260528,2 C20.9966156,2 25.0260528,6.02943725 25.0260528,11 C25.0260528,13.8199829 23.7290939,16.3370448 21.6991303,17.9872315 L26.0521057,29.32712 L22.1762605,27.6014826 L20.4506231,31.4773277 L16.0448824,19.9999807 C16.0386073,19.9999936 16.0323308,20 16.0260528,20 C16.0197748,20 16.0134983,19.9999936 16.0072233,19.9999807 L16.0072233,19.9999807 L16.0072233,19.9999807 Z M14.9600512,19.937529 L11.527983,28.8783724 L10.3775581,26.2944757 L7.79366132,27.4449006 L11.1916968,18.5927156 C12.3050465,19.3030744 13.5850946,19.7752756 14.9600512,19.937529 L14.9600512,19.937529 L14.9600512,19.937529 Z M20.8604089,18.5927156 L24.2584443,27.4449006 L21.6745476,26.2944757 L20.5241226,28.8783724 L17.0920544,19.937529 C18.467011,19.7752756 19.7470592,19.3030744 20.8604089,18.5927156 L20.8604089,18.5927156 L20.8604089,18.5927156 Z M16.0260528,19 C20.4443308,19 24.0260528,15.418278 24.0260528,11 C24.0260528,6.581722 20.4443308,3 16.0260528,3 C11.6077748,3 8.02605283,6.581722 8.02605283,11 C8.02605283,15.418278 11.6077748,19 16.0260528,19 L16.0260528,19 Z M16.0260528,13.6923077 L12.5260528,16 L14.0260528,12 L11.0260528,10 L14.5260528,10 L16.0260528,6 L17.5260528,10 L21.0260528,10 L18.0260528,12 L19.5260528,16 L16.0260528,13.6923077 L16.0260528,13.6923077 Z\" id=\"award\"/></g></g></svg>";
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7\">";
                HTML +="<h4>Prize</h4>";
                HTML +="<ul>";
                for(int i =0 ;i < lstprize.length;i++){
                    HTML +="<li>"+ lstprize[i]+"</li>";
                }
                HTML +="</ul>";
                HTML +="</div><div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">"
                        + "</div></div>";
            }
            response.setContentType("text/plain");      // truyền dữ liệu về cho người dùng
            response.getWriter().write(HTML);   
            
        }
        
        if(request.getParameter("activityAction").equals("getView")){   // nhận yêu cầu xem activity từ người dùng
             Cv cv = (Cv)request.getSession().getAttribute("cv");       // lấy dữ liệu cv đã truyền
            String HTML ="";
            String activity = cv.getActivity();
            String prize = cv.getPrize();
            
            String[] lstactivity = activity.split(";");
            String[] lstprize = prize.split(";");
            
            if(lstactivity.length > 0){     // tạo view activity
                HTML +="<div class=\"row\">";
                HTML +="<div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">";
                HTML +="<svg enable-background=\"new 0 0 24 24\" id=\"Layer_1\" version=\"1.0\" viewBox=\"0 0 24 24\" xml:space=\"preserve\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><circle cx=\"12\" cy=\"4\" r=\"2\"/><path d=\"M5.8,10.7c-0.1-0.2,0-0.5,0.2-0.6l5.5-2.2l-0.4-0.9l-6,2.3c-0.8,0.3-1.2,1.2-0.9,2l0.2,0.6c0.3,0.8,1.2,1.2,2,0.9l0,0  c0.2-0.1,0.3-0.3,0.2-0.4L5.8,10.7z\"/><path d=\"M4,8.6l2.6-1.1C6.4,3.5,9,2.4,9,2.4S4.8,3.4,4,8.6z\"/><path d=\"M14,14l0.2,1.8c0.1,0.6-0.1,1.3-0.3,1.8L11.5,22h2.3l2.6-5l0.5-4.4l-1.4-4.5l1.7-0.7c0.3-0.1,0.5-0.5,0.4-0.9  c-0.8-2.5-2.1-3.9-3.5-4.5c0.3,0.1,0.8,1,0.8,2c0,0,0,0.1,0,0.1c0.7,0.7,1.1,1.6,1.1,2l-2.6,1c0,0,0,0-0.1,0l-0.6,0.2  c-0.7,0.3-1,1.1-0.8,1.7L14,14z\"/><polygon points=\"20.7,22 17.6,13.7 17.1,17.4 18.8,22 \"/></svg>";                
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7 \">";
                HTML +="<h4>Activity</h4>";
                HTML +="<ul>";
                for(int i =0 ;i < lstactivity.length;i++){
                    HTML +="<li>"+ lstactivity[i]+"</li>";
                }
                HTML +="</ul>";
                HTML +="</div><div class=\"col-md-2 col-sm-2 col-md-offset-0 col-sm-offset-0 text-right\">"
                        + "<p><a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\"  data-placement=\"top\" title=\"Add New Activity\" data-target=\"#ModalnewActivity\">"
                        + "<svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                            "<path d=\"M21,13H13v8H11V13H3V11h8V3h2v8h8v2Z\"></path>\n" +
                        "</g></svg>"
                        + "</a>"
                        + "<a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\"  data-placement=\"top\" title=\"Edit Activity\" data-target=\"#ModaleditActivity\">"
                        + "<svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                            "<path d=\"M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z\"></path>\n" +
                            "</g></svg>"                //add edit activity
                        + "</a></p>"
                        + "</div></div>";
            }
            if(lstprize.length > 0){        //tạo view prize
                HTML +="<div class=\"row\">";
                HTML +="<div class=\"col-md-2 col-sm-2 col-md-offset-0 col-sm-offset-0 text-right\">";
                HTML +="<svg height=\"32px\" version=\"1.1\" viewBox=\"0 0 32 32\" width=\"32px\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:sketch=\"http://www.bohemiancoding.com/sketch/ns\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><title/><desc/><defs/><g fill=\"none\" fill-rule=\"evenodd\" id=\"Page-1\" stroke=\"none\" stroke-width=\"1\"><g fill=\"#929292\" id=\"icon-34-award\"><path d=\"M16.0072233,19.9999807 L11.6014826,31.4773277 L9.87584513,27.6014826 L6,29.32712 L10.3529754,17.9872315 C8.32301176,16.3370448 7.02605283,13.8199829 7.02605283,11 C7.02605283,6.02943725 11.0554901,2 16.0260528,2 C20.9966156,2 25.0260528,6.02943725 25.0260528,11 C25.0260528,13.8199829 23.7290939,16.3370448 21.6991303,17.9872315 L26.0521057,29.32712 L22.1762605,27.6014826 L20.4506231,31.4773277 L16.0448824,19.9999807 C16.0386073,19.9999936 16.0323308,20 16.0260528,20 C16.0197748,20 16.0134983,19.9999936 16.0072233,19.9999807 L16.0072233,19.9999807 L16.0072233,19.9999807 Z M14.9600512,19.937529 L11.527983,28.8783724 L10.3775581,26.2944757 L7.79366132,27.4449006 L11.1916968,18.5927156 C12.3050465,19.3030744 13.5850946,19.7752756 14.9600512,19.937529 L14.9600512,19.937529 L14.9600512,19.937529 Z M20.8604089,18.5927156 L24.2584443,27.4449006 L21.6745476,26.2944757 L20.5241226,28.8783724 L17.0920544,19.937529 C18.467011,19.7752756 19.7470592,19.3030744 20.8604089,18.5927156 L20.8604089,18.5927156 L20.8604089,18.5927156 Z M16.0260528,19 C20.4443308,19 24.0260528,15.418278 24.0260528,11 C24.0260528,6.581722 20.4443308,3 16.0260528,3 C11.6077748,3 8.02605283,6.581722 8.02605283,11 C8.02605283,15.418278 11.6077748,19 16.0260528,19 L16.0260528,19 Z M16.0260528,13.6923077 L12.5260528,16 L14.0260528,12 L11.0260528,10 L14.5260528,10 L16.0260528,6 L17.5260528,10 L21.0260528,10 L18.0260528,12 L19.5260528,16 L16.0260528,13.6923077 L16.0260528,13.6923077 Z\" id=\"award\"/></g></g></svg>";
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7\">";
                HTML +="<h4>Prize</h4>";
                HTML +="<ul>";
                for(int i =0 ;i < lstprize.length;i++){
                    HTML +="<li>"+ lstprize[i]+"</li>";
                }
                HTML +="</ul>";
                HTML +="</div><div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">"
                        + "<p><a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\"  data-placement=\"top\" title=\"Add New Prize\" data-target=\"#ModalnewPrize\">"
                        + "<svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                        "<path d=\"M21,13H13v8H11V13H3V11h8V3h2v8h8v2Z\"></path>\n" +
                        "</g></svg></a>"
                        + "<a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\"  data-placement=\"top\" title=\"Edit Prize\" data-target=\"#ModaleditPrize\">"
                        + "<svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                            "<path d=\"M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z\"></path>\n" +
                            "</g></svg>"
                        + "</a>"            //edit prize
                        + "</p></div></div>";
            }
            response.setContentType("text/plain");
            response.getWriter().write(HTML);
            
        }
        
        if(request.getParameter("activityAction").equals("getActivityModal")){
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            String activity = cv.getActivity();
            String[] lstactivity = activity.split(";");
            String HTML="<form action =\"ActivityControl?activityAction=updateActivity\" method=\"Post\"><table class=\"table\">";
            HTML +="<thead><tr><th>Active</th><th>NameActivity</th></tr></thead><tbody>";
            for(int i =0 ;i < lstactivity.length ;i++){
                HTML +="<tr>"
                        + "<td>"
                        + "<input type=\"checkbox\" checked name=\"activityList\" value=\""+ lstactivity[i]+"\">"
                        + "</td>"
                        + "<td>"
                        + lstactivity[i]
                        + "</td>"
                        + "</tr>";
            }
            HTML+="</tbody></table>"
                    + "<input type=\"submit\" class=\"btn btn-block btn-primary\" value=\"Update\">"
                    + "</form>";
            response.setContentType("text/plain");
            response.getWriter().write(HTML);
        }
        if(request.getParameter("activityAction").equals("getPrizeModal")){
             Cv cv = (Cv)request.getSession().getAttribute("cv");
            String prize = cv.getPrize();
            String[] lstprize = prize.split(";");
            String HTML="<form action =\""+request.getContextPath()+"/ActivityControl?activityAction=updatePrize\" method=\"Post\"><table class=\"table\">";
            HTML +="<thead><tr><th>Active</th><th>NamePrize</th></tr></thead><tbody>";
            for(int i =0 ;i < lstprize.length ;i++){
                HTML +="<tr>"
                        + "<td>"
                        + "<input type=\"checkbox\" checked name=\"prizeList\" value=\""+ lstprize[i]+"\">"
                        + "</td>"
                        + "<td>"
                        + lstprize[i]
                        + "</td>"
                        + "</tr>";
            }
            HTML+="</tbody></table>"
                    + "<input type=\"submit\" class=\"btn btn-block btn-primary\" value=\"Update\">"
                    + "</form>";
            response.setContentType("text/plain");
            response.getWriter().write(HTML);
        }
        
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
        
        if(request.getParameter("activityAction").equals("newActivity")){ // nhận yêu câu tạo mới một activity
            String NewActivity = request.getParameter("activityName");      // nhận dữ liệu truyền về      
            Cv cv =(Cv)request.getSession().getAttribute("cv");         //nhận dữ liệu cv trên session
            
            String Activity = cv.getActivity();         
            Activity += ";"+NewActivity;            // thêm thông tin activity trên cv đã tìm thấy
            cv.setActivity(Activity);
            cvBean.UpdateCv(cv);            // thực hiện update trên cơ sở dữ liệu
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");       // chuyển tiếp thông tin về cho người dùng
            rd.forward(request, response);
        }
        
        if(request.getParameter("activityAction").equals("newPrize")){      //nhận yêu cầu thêm mói prize
            String NewPrize = request.getParameter("prizeName");        // nhận dữ liệu prize đã nhận vào
            Cv cv =(Cv)request.getSession().getAttribute("cv");     // nhận dữ liệu cv từ session
            
            String Prize = cv.getPrize();       
            Prize += ";"+NewPrize;      // cập nhật prizze
            cv.setPrize(Prize); 
            cvBean.UpdateCv(cv);        // cập nhận cv với prize mới
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");       // chuyển tiếp thông tin về cho người dùng tại trang quản lý Profile
            rd.forward(request, response);
        }
        
        if(request.getParameter("activityAction").equals("updatePrize")){         // thực hiẹn update prize
            String[] lstprize = request.getParameterValues("prizeList");
            Cv cv =(Cv)request.getSession().getAttribute("cv");
            String prize = "";
            if(lstprize!=null){
                for(int i=0; i<lstprize.length;i++){
                    prize+= lstprize[i];
                    if(i != lstprize.length-1){
                        prize +=";";
                    }
                }
            }
            cv.setPrize(prize);
            cvBean.UpdateCv(cv);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
            rd.forward(request, response);
        }
        
        if(request.getParameter("activityAction").equals("updateActivity")){        // thực hiện update activity
            String[] lstactivity= request.getParameterValues("activityList");
            Cv cv =(Cv)request.getSession().getAttribute("cv");
            
            String activity ="";
            if(lstactivity!=null){
                for(int i =0; i< lstactivity.length;i++){
                    activity+= lstactivity[i] ;
                    if(i != lstactivity.length -1){
                        activity+=";";
                    }
                }
            }
            cv.setActivity(activity);
            cvBean.UpdateCv(cv);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
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
