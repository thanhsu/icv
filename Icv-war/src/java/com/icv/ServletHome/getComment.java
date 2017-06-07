/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletHome;

import icv.Entity.Comment;
import icv.Dao.CommentBean;
import icv.Dao.CvBean;
import icv.Dao.ProfileBean;
import icv.Dao.User_cv;
import icv.Dao.followBean;
import icv.Entity.Cv;
import icv.Entity.Followcv;
import icv.Entity.Profile;
import icv.Entity.Storecv;
import icv.Entity.User;
import java.io.IOException;
import java.util.List;
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
public class getComment extends HttpServlet {

    @EJB
    private User_cv user_cv;

    @EJB
    private CvBean cvBean;

    @EJB
    private ProfileBean profileBean;

    @EJB
    private followBean followBean;

    @EJB
    private CommentBean commentBean;

    

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
        
        String action = request.getParameter("action");
        try{if(action.equals("getComment")){                // tạo view comment từ người dùng trả về cho client
            String html ="<div id=\"myCarousel \" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                        "<ol class=\"carousel-indicators\">\n" +
                        "<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                        "<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n" +
                        "<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n" +
                        "</ol>\n" +
                        "<div class=\"carousel-inner\">";
            List<Comment> lstComment = commentBean.getAllCommentbyAllow(Boolean.TRUE);
            int row= 0;
            int col= 0;
            
            if(lstComment.size()>0){
                row = lstComment.size()/3;
                col = lstComment.size() - row*3;
            
                if(row < 1){
                    html += "<div class=\"item active\">"
                            + "<div class=\"container\">"
                            + "<div class=\"row center-block\">";
                    for(int i=0; i < col; i++){
                        html+= "<div class=\"col-md-3 col-md-offset-1\" style=\"height:400px; background-color:#e6f2ff;\">"
                            + "<h3 style=\"text-align: center;\">"+profileBean.retriveProfileByIdUser(lstComment.get(i).getIdUser().getIdUser()).getFirstName()+" "+profileBean.retriveProfileByIdUser(lstComment.get(i).getIdUser().getIdUser()).getLastName()+"</h3>"
                            + "<p style=\"text-align: center;\">"+cvBean.retriveCVbyIdStore(user_cv.retriveStoreCvbyIdUser(lstComment.get(i).getIdUser().getIdUser())).getMore()+"</p><hr/>"
                            + "<p style=\"text-align: center;\"><img src=\"/Icv-war/ProfileControl?profileAction=getAvatar&id="+lstComment.get(i).getIdUser().getIdUser()+"\" style=\"width=100px; height: 80px; border-radius: 50%;\"></p>"
                            + "<p>"+lstComment.get(i).getContent()+"</p>"
                            + "</div>";
                    }
                    html +="</div></div></div>";
                }else{
                    if( row > 3){
                        row = 3;
                    }
                    for(int i = 0 ; i <= row ; i++){
                        if( i == (row)){
                            html += "<div class=\"item active\">"
                            + "<div class=\"container\">"
                            + "<div class=\"row center-block\">";
                            for(int j=0; j < col; j++){
                                html+= "<div class=\"col-md-3 col-md-offset-1\" style=\"height:400px; background-color:#e6f2ff;\">"
                                + "<h3 style=\"text-align: center;\">"+profileBean.retriveProfileByIdUser(lstComment.get(i*3 + j).getIdUser().getIdUser()).getFirstName()+" "+profileBean.retriveProfileByIdUser(lstComment.get(i*3 +j).getIdUser().getIdUser()).getLastName()+"</h3>"
                                + "<p style=\"text-align: center;\">"+cvBean.retriveCVbyIdStore(user_cv.retriveStoreCvbyIdUser(lstComment.get(i*3 +j).getIdUser().getIdUser())).getMore()+"</p><hr/>"
                                + "<p style=\"text-align: center;\"><img src=\"/Icv-war/ProfileControl?profileAction=getAvatar&id="+lstComment.get(i*3 +j).getIdUser().getIdUser()+"\" style=\"width=100px; height: 80px; border-radius: 50%;\"></p>"
                                + "<p>"+lstComment.get(i*3+j).getContent()+"</p>"
                                + "</div>";
                            }
                            html +="</div></div></div>";
                        }else{
                                html += "<div class=\"item\">"
                                    + "<div class=\"container\">"
                                    + "<div class=\"row center-block\">";
                                for(int j=0; j < 3; j++){
                                    html+= "<div class=\"col-md-3 col-md-offset-1\" style=\"height:400px; background-color:#e6f2ff;\">"
                                        + "<h3 style=\"text-align: center;\">"+profileBean.retriveProfileByIdUser(lstComment.get(i*3 +j).getIdUser().getIdUser()).getFirstName()+" "+profileBean.retriveProfileByIdUser(lstComment.get(i*3 + j).getIdUser().getIdUser()).getLastName()+"</h3>"
                                        + "<p style=\"text-align: center;\">"+cvBean.retriveCVbyIdStore(user_cv.retriveStoreCvbyIdUser(lstComment.get(i*3 +j).getIdUser().getIdUser())).getMore()+"</p><hr/>"
                                        + "<p style=\"text-align: center;\"><img src=\"/Icv-war/ProfileControl?profileAction=getAvatar&id="+lstComment.get(i*3 + j).getIdUser().getIdUser()+"\" style=\"width=100px; height: 80px; border-radius: 50%;\"></p>"
                                        + "<p>"+lstComment.get(i*3 + j).getContent()+"</p>"
                                        + "</div>";
                            }
                            html +="</div></div></div>";
                        }
                    }
                }
            }
           
            html+="</div></div>";
            System.out.println("comment" +html);
            
            response.setContentType("text/plain");
            response.getWriter().write(html);
        }}catch(Exception e){
            
            System.out.println("Không lấy dc comment");
            response.setContentType("text/plain");
                response.getWriter().write(" ");
        }
        try{
        if(request.getParameter("commentAction").equals("getPeopleView")){          // trả về view danh sách những người dùng đã xem profile tương ứng
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            
            
            List<Followcv> lst = followBean.retrivebyIdCv(cv.getIdCV());
            String html=" ";
            if(lst.size()<1){
                response.setContentType("text/plain");
                response.getWriter().write(html);
            }else{
                for(int i = lst.size()-1;i>=0;i--){
                    if(lst.size() - i < 4){
                        Profile profile = profileBean.retriveProfileByIdUser(lst.get(i).getFollowcvPK().getIdUser());
                     html+="<div class=\"col-md-2 col-sm-2\">"
                             + "<a href=\"view.jsp?id="+lst.get(i).getFollowcvPK().getIdUser()+"\"><img class=\"img-rounded\" src=\"ProfileControl?profileAction=getAvatar&id="+lst.get(i).getFollowcvPK().getIdUser()+"\" width=\"40\" height=\"40\"/></a>"
                             + "</div>";   
                     html+="<div class=\"col-md-10 col-sm-10 col-md-offset-0 col-sm-offset-0\">"
                             + "<p><strong>"+profile.getFirstName()+" "+profile.getLastName()+"</strong></p>"
                             + "<p>"+profile.getEmail()+"</p>"
                             + "</div><hr>";
                    }
                }
                response.setContentType("text/plain");
                response.getWriter().write(html);
            }
            
        }}catch(Exception e){
              response.setContentType("text/plain");
                response.getWriter().write(" ");
        }
        
        try{
        if(request.getParameter("commentAction").equals("getPeopleViewpublic")){                // lấy danh sách người dùng đã xem cho profile view
            Cv cv = (Cv)request.getSession().getAttribute("cvview");
            
            
            List<Followcv> lst = followBean.retrivebyIdCv(cv.getIdCV());
            String html=" ";
            if(lst.size()<1){
                response.setContentType("text/plain");
                response.getWriter().write(html);
            }else{
                for(int i = lst.size()-1;i>=0;i--){
                    if(lst.size() - i < 4){
                        Profile profile = profileBean.retriveProfileByIdUser(lst.get(i).getFollowcvPK().getIdUser());
                     html+="<div class=\"col-md-2 col-sm-2\">"
                             + "<a href=\"view.jsp?id="+lst.get(i).getFollowcvPK().getIdUser()+"\"><img class=\"img-rounded\" src=\"ProfileControl?profileAction=getAvatar&id="+lst.get(i).getFollowcvPK().getIdUser()+"\" width=\"40\" height=\"40\"/></a>"
                             + "</div>";   
                     html+="<div class=\"col-md-10 col-sm-10 col-md-offset-0 col-sm-offset-0\">"
                             + "<p><strong>"+profile.getFirstName()+" "+profile.getLastName()+"</strong></p>"
                             + "<p>"+profile.getEmail()+"</p>"
                             + "</div><hr>";
                    }
                }
                response.setContentType("text/plain");
                System.out.println(html);
                response.getWriter().write(html);
            }
            
        }}catch(Exception e){
              response.setContentType("text/plain");
                response.getWriter().write(" ");
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
        
        if(request.getParameter("commentAction").equals("newComment")){     // thực hiện thêm mới comment
            String commentOpinion = request.getParameter("commentOpinion");
            
            User usr = (User)request.getSession().getAttribute("User");
            if(usr==null){
                String Laspath = "/getComment?commentAction=newComment";
                request.setAttribute("lastPath", Laspath);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
            }
            else{
                Comment cmt= new Comment();
                cmt.setAllow(Boolean.TRUE);
                cmt.setContent(commentOpinion);
                cmt.setIdUser(usr);
                
                commentBean.newComment(cmt);
                
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/User.jsp");
                rd.forward(request, response);
            }
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
