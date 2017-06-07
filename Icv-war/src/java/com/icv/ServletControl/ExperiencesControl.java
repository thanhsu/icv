/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import icv.Dao.ExperiencesBean;
import icv.Dao.SpecializedBean;
import icv.Entity.Experiences;
import icv.Entity.Specialized;
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
public class ExperiencesControl extends HttpServlet {

    @EJB
    private SpecializedBean specializedBean;

    @EJB
    private ExperiencesBean experiencesBean;
    

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
        
        //get list Company
        if(request.getParameter("experiencesAction").equals("getListCompany")){     // thực hiện nhận danh sách company
            List<Specialized> lst = specializedBean.retriveAllSpecialized();
            String HTML="";
            for(int i =0; i<lst.size();i++){            // tạo view
                HTML+="<option value=\""+ lst.get(i).getName()+"\">";
            }
            response.setContentType("text/plain");      // trả về cho người dùng
            response.getWriter().write(HTML);
        }
        
        //delete Experiences
        if(request.getParameter("experiencesAction").equals("deleteExperiences")){     // thực hiên yêu cầu xóa experiences
            User user = (User)request.getSession().getAttribute("User");        
            String idSpec = request.getParameter("idSpec");
            
            experiencesBean.removeExperiences(user.getIdUser(), Short.valueOf(idSpec));     // do remove
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");       // chuyển tiếp về trang quản lý profile
            rd.forward(request, response);
            
        }
        
        //get view public
        
        if(request.getParameter("experiencesAction").equals("getViewpublic")){      // thực hiện tạo view cho trang profile online được yêu cầu
            User user = (User)request.getSession().getAttribute("userview");        // nhận tham số truyền vào
           
            List<Experiences> lst = experiencesBean.retriveAllExperiencesbyIdUser(user.getIdUser());
            
            String HTML="";
            
            for(int i= 1; i <= lst.size();i++ ){        // thực hiên tạo view
                HTML +="<div class=\"row\">";
                HTML +="<div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">";
                HTML +="<img src=\"http://static-images.talentegg.ca/briefcase.png\" alt=\"\" style=\" width:40px; height: 40px;\">";
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7 \">";
                HTML +="<p>"+ lst.get(i-1).getSpecialized().getName()+"</p>";
                HTML +="<label>"+lst.get(i-1).getDescription()+"</label>";
                HTML +="<hr/></div>";
                HTML +="<div class=\"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1\">";
                HTML +="<p>"+lst.get(i-1).getYear()+"( Year) </p>"
                        + "</div></div>";
            }
            
            response.setContentType("text/plain");      // truyền dữ liệu về cho người dùng
            response.getWriter().write(HTML);
        } 
        
        
        
        //get View
        if(request.getParameter("experiencesAction").equals("getView")){        // thực hiện yêu cầu tạo view cho người dùng
            User user = (User)request.getSession().getAttribute("User");
            
            List<Experiences> lst = experiencesBean.retriveAllExperiencesbyIdUser(user.getIdUser());
            
            String HTML="";
            
            for(int i= 1; i <= lst.size();i++ ){            // thực hiện tạo view cho người dùng
                HTML +="<div class=\"row\">";
                HTML +="<div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">";
                HTML +="<img src=\"http://static-images.talentegg.ca/briefcase.png\" alt=\"\" style=\" width:40px; height: 40px;\">";
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7 \">";
                HTML +="<p>"+ lst.get(i-1).getSpecialized().getName()+"</p>";
                HTML +="<label>"+lst.get(i-1).getDescription()+"</label>";
                HTML +="<hr/></div>";
                HTML +="<div class=\"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1\">";
                HTML +="<p>"+lst.get(i-1).getYear()+"( Year) </p>"
                        + "<a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\"  data-placement=\"top\" title=\"Edit Experiences\" data-target=\"#ModaleditExperiences"+ lst.get(i-1).getSpecialized().getIdSpecialized()+"\">"
                        + "<svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                            "<path d=\"M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z\"></path>\n" +
                            "</g></svg>"
                        + "</a>"
                        + ""
                        + "</div></div>"
                        + "<div class=\"modal fade\" id=\"ModaleditExperiences"+ lst.get(i-1).getSpecialized().getIdSpecialized()+"\" role=\"dialog\">"
                        + "<div class=\"modal-dialog\">"
                        + "<div class=\"modal-content\">"
                        + "<div class=\"modal-header\">"
                        + "<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>"
                        + "<h4 class=\"modal-title\">Edit Experiences</h4>"
                        + "</div>"
                        + "<div class=\"modal-body\">"
                        + "<form action =\"ExperiencesControl?experiencesAction=editExperience&idSpecialized="+lst.get(i-1).getSpecialized().getIdSpecialized()+"\" method=\"Post\">"
                        + "<div class=\"row\"><div class =\"col-md-3 col-sm-3\">"
                        + "<p>Company/Project</p>"
                        + "</div>"
                        + "<div class=\"col-md-6 col-sm-6\">"
                        + "<input class=\"form-control\" type=\"text\" name=\"companyExperiences\"  autofocus placeholder=\"Company\" value=\""+ lst.get(i-1).getSpecialized().getName()+"\">"                       
                        + "</div></div>"
                        + "<div class=\"row\"><div class=\"col-md-3 col-sm-3\">"
                        + "<p>Description</p>"
                        + "</div>"
                        + "<div class=\"col-md-6 col-sm-6\">"
                        + "<input class=\"form-control\" placeholder=\"Description( regency, project,...)\" autofocus name=\"descriptionExperiences\" value=\""+lst.get(i-1).getDescription()+"\">"
                        + "</div></div>"
                        + "<div class=\"row\"><div class=\"col-md-3 col-sm-3\">"
                        + "<p>Working Period</p>"
                        + "</div>"
                        + "<div class=\"col-md-6 col-sm-6\">"
                        + "<input type=\"number\" class=\"form-control\" name=\"periodExperiences\" placeholder=\"Working Period\" autofocus value=\""+ lst.get(i-1).getYear()+"\">"
                        + "</div>"
                        + "</div><hr/>"
                        + "<div class=\"row\"><div class=\"col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2 text-center\">"
                        + "<a type=\"button\" class=\" btn btn-block- btn-danger\" href=\"ExperiencesControl?experiencesAction=deleteExperiences&idSpec="+lst.get(i-1).getSpecialized().getIdSpecialized()+"\">Delete</a></div>"
                        + "<div class=\"col-md-2 col-sm-2 col-md-offset-4 col-sm-offset-4 text-center\">"
                        + "<input class=\" btn btn-block btn-primary\" type=\"submit\" value=\"Save\"></div></div>"
                        + "</form>"
                        + "</div>"
                        + "<div class=\"modal-footer\">"
                        
                        + "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" id=\"Save_experiences\">Close</button>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "</div>"
                        + "";
            }
            
            response.setContentType("text/plain");      // truyền dữ liệu về client
            response.getWriter().write(HTML);
        }   
        
        //processRequest(request, response);
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
        if(request.getParameter("experiencesAction").equals("newExperiences")){     //thực hiện yêu cầu thêm mới experiences
            String companyName= request.getParameter("companyExperiences");     
            String decription = request.getParameter("descriptionExperiences");
            String period = request.getParameter("periodExperiences");
            if(period.equals("")){
                period ="0";
            }
            User user = (User)request.getSession().getAttribute("User");
            Specialized spec = specializedBean.getSpecializedByName(companyName);       // kiểm tra thông tin company có tồn tại hay không
            if(spec == null){           // nếu không tồn tại thực hiện tạo mới và thêm
                spec = new Specialized(null, companyName);
                specializedBean.persistNewSpecialized(spec);
                spec = specializedBean.getSpecializedByName(companyName);
                experiencesBean.insertNewExperiences(Short.valueOf(period), decription, user, spec);
            }
            else{       // nếu đã tồn tại tiếp hành thêm
                experiencesBean.insertNewExperiences(Short.valueOf(period), decription, user, spec);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");       //chuyển tiếp thông tin về trang quản lý profile
            rd.forward(request, response);
            
        }
        
        if(request.getParameter("experiencesAction").equals("editExperience")){     // thực hiện yêu cầu edit experiences
            String companyName = request.getParameter("companyExperiences");        // nhận dữ liệu truyền về
            String decription = request.getParameter("descriptionExperiences");
            String period = request.getParameter("periodExperiences");
            String idSpec = request.getParameter("idSpecialized");
            User user = (User)request.getSession().getAttribute("User");
            Specialized spec = specializedBean.getSpecializedById(Short.valueOf(idSpec));       // tìm kiếm thông tin company tương ứng với dữ liệu truyền về
            spec.setName(companyName);
            specializedBean.updateSpecialized(spec);        // thực hiện update thông tin company
            
            Experiences exper = experiencesBean.retriveExperiencesbyIdUserIdSpec(user.getIdUser(), spec.getIdSpecialized());        // thực hiện update Cv_Experiences
            exper.setDescription(decription);
            exper.setYear(Short.valueOf(period));
            experiencesBean.updateExperiences(exper);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");       //chuyển tiếp trang về
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
