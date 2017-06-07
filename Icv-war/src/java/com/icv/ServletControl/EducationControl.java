/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;


import icv.Dao.EducationBean;
import icv.Dao.Education_Cv;
import icv.Entity.Cv;
import icv.Entity.Cvmgmteducation;
import icv.Entity.Education;
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
public class EducationControl extends HttpServlet {

    @EJB
    private Education_Cv education_Cv;

    //EducationBean educationBean = lookupEducationBeanBean();
    
    @EJB
    private EducationBean educationBean;
    


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
        //System.out.println("go to Delete Education!");
        
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
        
        if(request.getParameter("educationAction").equals("getListCareer")){        // nhận danh sachs career từ database để đổ vào combo box trên client
            List<Education> lst = educationBean.retriveAll();           // lấy tất cả dữ liệu trong bảng education
            String HTML="";
            for(int i =0 ; i<lst.size();i++){       // tạo view tương ứng
                HTML+= "<option value=\""+ lst.get(i).getDetail()+"\">";
            }
            response.setContentType("text/plain");      // trả về dữ liệu
            response.getWriter().write(HTML);
        }
        if(request.getParameter("educationAction").equals("getListSchool")){        //nhận danh sách school từ bảng education
            List<Education> lst = educationBean.retriveAll();
            String HTML="";
            for(int i =0 ; i<lst.size();i++){           // tạo view
                HTML+= "<option value=\""+ lst.get(i).getTitile()+"\">";        
            }
            response.setContentType("text/plain");      // trả về dữ liệu
            response.getWriter().write(HTML);
        }
        
        if(request.getParameter("educationAction").equals("deleteEducation")){      // thực hiện xóa education
            String idEducation = request.getParameter("idEducation");               // nhận ideducation cần xóa       
            
            Cv cv = (Cv)request.getSession().getAttribute("cv");                    // nhận thông tin cv trên session
            
            if(education_Cv.removeEducationCvmgtEducation(cv.getIdCV(), Short.valueOf(idEducation))){       // thực hiện xóa dữ liệu
                System.out.println("Delete Education ok!");
            }
            else{
                System.out.println("Delete Failed!");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");  // chuyển tiếp dữ liệu
            rd.forward(request, response);
        }
        
        //System.out.print("Goto education servlet");
        
        if(request.getParameter("educationAction").equals("getViewpublic")){        // tạo dữ liệu Education tương ứng với cvview trên session
            Cv cv = (Cv)request.getSession().getAttribute("cvview");
            
            //Collection<Cvmgmteducation> lst = cv.getCvmgmteducationCollection();
            List<Cvmgmteducation> lst = education_Cv.retriveAllbyIdCV(cv.getIdCV());        // nhận danh sachs dữ liệu
            
            String HTML ="";
            
            for(int i = 1; i<= lst.size();i++){     // tạo view truyền về cho người dùng
                HTML +="<div class= \"row\">";
                HTML +="<div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">";
                HTML +="<img style=\"-webkit-user-select: none\" style=\" width:40px; height: 40px;\"  src=\"http://icons.iconarchive.com/icons/icons8/windows-8/24/Science-University-icon.png\">";
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7 \">";
                HTML += "<p>"+ lst.get(i-1).getEducation().getTitile() +"</p>";
                HTML +="<label>"+lst.get(i-1).getEducation().getDetail()+"</label><hr/>";
                HTML += "</div>";
                HTML +=" <div class=\"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1 \">";
                HTML += "<p>"+ lst.get(i-1).getPeriodTime()+"</p>";
                HTML += "</div>";
                HTML +="</div></div>";
            }
            
                response.setContentType("text/plain");      // trả về dữ liệu cho người dùng
                response.getWriter().write(HTML);
            }

        if(request.getParameter("educationAction").equals("getView")){      // yêu cầu nhận dữ liệu tương ứng với cv trên session
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            
            List<Cvmgmteducation> lst = education_Cv.retriveAllbyIdCV(cv.getIdCV());        // danh sách education tương ứng
            
            String HTML ="";
            String x= request.getContextPath();
            
            for(int i = 1; i<= lst.size();i++){                 // tạo view
                HTML +="<div class= \"row\">";
                HTML +="<div class=\"col-md-1 col-sm-1 col-md-offset-1 col-sm-offset-1 text-right\">";
                HTML +="<img style=\"-webkit-user-select: none\" style=\" width:40px; height: 40px;\"  src=\"http://icons.iconarchive.com/icons/icons8/windows-8/24/Science-University-icon.png\">";
                HTML +="</div>";
                HTML +="<div class=\"col-md-7 col-sm-7 \">";
                HTML += "<p>"+ lst.get(i-1).getEducation().getTitile() +"</p>";
                HTML +="<label>"+lst.get(i-1).getEducation().getDetail()+"</label><hr/>";
                HTML += "</div>";
                HTML +=" <div class=\"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1 \">";
                HTML += "<p>"+ lst.get(i-1).getPeriodTime()+"</p>";
                HTML +="<p>"+"<a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\"  data-placement=\"top\" title=\"Edit\" data-target=\"#ModaleditEducation"+(i-1)+"\" id=\"editEducation"+(i-1)+"\" ><svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                        "<path d=\"M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z\"></path>\n" +
                        "</g></svg>"+"</a></p>"
                        + "<div class=\"modal fade\" id=\"ModaleditEducation"+(i-1)+"\" role=\"dialog\">"
                        +"<div class=\"modal-dialog\">"
                        + "<div class=\"modal-content\">"
                        + "<div class=\"modal-header\">"
                        + "<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>"
                        + "<h4 class=\"modal-title\">Edit Education </h4>"
                        + "</div>"
                        + "<div class=\"modal-body\" id=\"modal_body_editEducation"+(i-1)+"\">"
                        + "<form action =\"EducationControl?educationAction=editEducation&idEducation="+lst.get(i-1).getEducation().getIdEducation()+"\" method=\"Post\">"
                        + "<div class=\"row\" id=\"newSchool\">"
                        + "<div class=\"col-md-3 col-sm-3\">"
                        + "<p>School<p>"
                        + "</div>"
                        + "<div class=\"col-md-6 col-sm-6\">"
                        + "<input type=\"text\" name=\"school\" class=\"form-control\" list=\"l\" placeholder=\"School Name\" autofocus value=\""+lst.get(i-1).getEducation().getTitile()+"\">"
                        + "</div>"
                        + "</div>"
                        + "<div class=\"row\" id=\"newFieldStudy\">"
                        + "<div class=\"col-md-3 col-sm-3\">"
                        + "<p>Field of study<p>"
                        + "</div>\n" +
                        "<div class=\"col-md-6 col-sm-6\">\n" +
                        "<input type=\"text\" class=\"form-control\" name=\"FieldofStudy\" placeholder=\"Field of study\" autofocus value=\""+lst.get(i-1).getEducation().getDetail()+"\">\n" +
                        "</div>"
                        + "</div>"
                        + "<div class=\"row\" id=\"newTimePeriod\">\n" +
                        "<div class=\"col-md-3 col-sm-3\">\n" +
                        "<p>Time Period<p>\n" +
                        "</div>\n" +
                        "<div class=\"col-md-2 col-sm-2\">\n" +
                        "<input type=\"text\" class=\"form-control\" name=\"FromYear\" placeholder=\"Year\"  autofocus value=\""+lst.get(i-1).getPeriodTime().split("-")[0]+"\">\n" +
                        "</div>\n" +
                        "<div class=\"col-md-1 col-sm-1 text-center\">\n" +
                        "<p>To</p>\n" +
                        "</div>\n" +
                        "<div class=\"col-md-2 col-sm-2\">\n" +
                        "<input type=\"text\" class=\"form-control\" name=\"ToYear\" placeholder=\"Year\"  autofocus value=\""+lst.get(i-1).getPeriodTime().split("-")[1]+"\">\n" +
                        "</div>\n" +
                        "</div><hr/>"
                        + "<div class=\"row\">"
                        + "<div class=\"col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2 text-center\">"
                        + "<a type=\"button\" class=\"btn btn-block btn-danger\" href=\"EducationControl?educationAction=deleteEducation&idEducation="+lst.get(i-1).getEducation().getIdEducation()+" \">Delete</a>"
                        + "</div>"
                        + "<div class=\"col-md-2 col-sm-2 col-md-offset-4 col-sm-offset-4 text-center\">"
                        + "<input class=\" btn btn-block btn-primary \" type=\"submit\" value=\"Update\"/>"
                        + "</div>"
                        + "</form>"
                        + "</div>"
                        + "<div class=\"modal-footer\">"
                        + "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" id=\"Update_education\">Close</button>"
                        + "</div></div></div></div>"
                        + "</div>";
                HTML +="</div></div>";
            }
            System.out.println(HTML);
            
            response.setContentType("text/plain");          // trả view về cho người dùng
            response.getWriter().write(HTML);
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
        if(request.getParameter("educationAction").equals("newEducation")){         // thực thien yêu cầu thêm mới 1 đối tượng education
            //Education education = new Education();
            String title = request.getParameter("school");          // nhận tên school
            String detail = request.getParameter("FieldofStudy");   // nhận fieldofstudy
            String period = request.getParameter("FromYear")+" - "+request.getParameter("ToYear");  // nhận time period
            
            if(educationBean.retriveEducationByTitleAndDetail(title, detail)== null){       // kiêm tra tên trường và fieldofstudy có tồn tại hay không
                education_Cv.insertEducation(title,detail,"null");      //nếu không tồn tại thì tạo mới
            }
            Cv cv = (Cv)request.getSession().getAttribute("cv");        //
            if(education_Cv.insertMgmtEducation(title, detail, period,"null", cv)){    // thực hiện thêm mới education cho cv tương ứng trên session
                
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");       // chuyển tiếp dữ liệu về trang quản lý profile
            rd.forward(request, response);
            
            
        }
        if(request.getParameter("educationAction").equals("editEducation")){            // thay đổi thông tin education 
            String ideducation = request.getParameter("idEducation");
             String title = request.getParameter("school");
            String detail = request.getParameter("FieldofStudy");
             Cv cv = (Cv)request.getSession().getAttribute("cv");
            String period = request.getParameter("FromYear")+" - "+request.getParameter("ToYear");
            education_Cv.updateEducation(title, detail, "null", period, cv, ideducation);           // thực hiện update
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
