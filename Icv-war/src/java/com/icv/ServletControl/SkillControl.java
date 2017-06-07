/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import icv.Dao.Cv_Skill;
import icv.Dao.SkillBean;
import icv.Entity.Cv;
import icv.Entity.Cvmgmtskill;
import icv.Entity.Skill;
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
public class SkillControl extends HttpServlet {

    @EJB
    private SkillBean skillBean;

    @EJB
    private Cv_Skill cv_Skill;

    
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
        
        
        //delete skill
        if(request.getParameter("skillAction").equals("deleteSkill")){    // thực hiện yêu cầu xóa Skill
            
            String idskill = request.getParameter("idSkill");
            
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            
            cv_Skill.removeSkillCv(Short.valueOf(idskill), cv);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
            rd.forward(request, response);
        }
        
        //getList Skill name
        if(request.getParameter("skillAction").equals("getListSkill")){     // thực hiẹn yêu cầu nhận listskill
            
            List<Skill> lst = skillBean.retriveAllSkill();
            String HTML ="";
            for(int i =0; i< lst.size();i++){       // tạo view
                HTML+="<option value=\"" +lst.get(i).getName()+ "\">";
            }
            
            response.setContentType("text/plain");
            response.getWriter().write(HTML);
        }
        
        if(request.getParameter("skillAction").equals("getKeySkillViewpublic")){        // nhận dữ liệu Skill
            Cv cv = (Cv)request.getSession().getAttribute("cvview");
            List<Cvmgmtskill> lst = cv_Skill.retriveAllbyIdCv(cv.getIdCV());
            
            System.out.println(lst.size());
            String HTML ="";
            String HTMLlabel="";
            HTML +="<div class=\"row\">";
            HTML +="<p class=\"col-md-2 col-sm-2 col-md-offdet-1 col-sm-offset-1\"><em><strong>Key Skill</strong></em></p></div>";
            for(int i= 1; i <= lst.size(); i++){
                if(lst.get(i-1).getSkill().getIdkindskill().getNamekindskill().equals("Key")){
                    if(lst.get(i-1).getSkill().getIdkindskill().getNamekindshow().equals("progress")){
                        
                        HTML +="<div class=\"row\"><div class=\"col-md-8 col-sm-8 col-md-offset-1 col-sm-offset-1\">";
                        HTML +="<p id=\"Skillname\"><strong>"+ lst.get(i-1).getSkill().getName()+"</strong></p>";
                        HTML +="<div class=\"progress\"><div class=\" progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\""+ (lst.get(i-1).getSkill().getDegree()*20) +"\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+(lst.get(i-1).getSkill().getDegree()*20)+"%\" ></div></div>";
                        HTML +="</div>";
                        HTML +="<div class=\"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1\">";
                        HTML +="<p>" + lst.get(i-1).getPeriodTime()+ "</p>";
                        HTML +="<p><p>";         
                        HTML +="</div></div>";
                    }else{
                        HTMLlabel +="<div class =\"row\"><div class = \"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1\">"
                                    + "<span class=\"badge\">"+ lst.get(i-1).getSkill().getName()+"</span>"
                                    + "</div>";
                        HTMLlabel+="<div class=\"col-md-4 col-sm-4 col-md-offset-1 col-sm-offset-1 text-left\"><ul>";
                                    for(int j = 0 ; j < lst.get(i-1).getPeriodTime().split(";").length; j++){
                                        HTMLlabel+="<li>"
                                                + lst.get(i-1).getPeriodTime().split(";")[j]
                                                + "</li>";
                                    }
                        HTMLlabel+="</ul></div></div>";
                        
                    }
                    
                }
                
            }
            response.setContentType("text/plain");
            response.getWriter().write(HTML+HTMLlabel);
        }
        
        
        if(request.getParameter("skillAction").equals("getKeySkillView")){      // nhận dữ liệu skill
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            List<Cvmgmtskill> lst = cv_Skill.retriveAllbyIdCv(cv.getIdCV());
            
            System.out.println(lst.size());
            String HTML ="";
            String HTMLlabel="";
            HTML +="<div class=\"row\">";
            HTML +="<p class=\"col-md-2 col-sm-2 col-md-offdet-1 col-sm-offset-1\"><em><strong>Key Skill</strong></em></p></div>";
            for(int i= 1; i <= lst.size(); i++){
                if(lst.get(i-1).getSkill().getIdkindskill().getNamekindskill().equals("Key")){
                    if(lst.get(i-1).getSkill().getIdkindskill().getNamekindshow().equals("progress")){
                        
                        HTML +="<div class=\"row\"><div class=\"col-md-8 col-sm-8 col-md-offset-1 col-sm-offset-1\">";
                        HTML +="<p id=\"Skillname\"><strong>"+ lst.get(i-1).getSkill().getName()+"</strong></p>";
                        HTML +="<div class=\"progress\"><div class=\" progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\""+ (lst.get(i-1).getSkill().getDegree()*20) +"\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+(lst.get(i-1).getSkill().getDegree()*20)+"%\" ></div></div>";
                        HTML +="</div>";
                        HTML +="<div class=\"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1\">";
                        HTML +="<p>" + lst.get(i-1).getPeriodTime()+ "</p>";
                        HTML +="<p><a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\" data-target=\"#ModaleditSkill"+(i-1)+"\"><svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                                "<path d=\"M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z\"></path>\n" +
                                "</g></svg></a><p>";
                        HTML +="<div class=\"modal fade\" id=\"ModaleditSkill"+(i-1)+"\" role=\"dialog\">"
                                + "<div class=\"modal-dialog\">"
                                + "<div class=\"modal-content\">"
                                + "<div class=\"modal-header\">"
                                + "<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>"
                                + "<h4 class=\"modal-title\">Edit Skill </h4>"
                                + "</div>"
                                + "<div class=\"modal-body\">"
                                + "<form action=\"SkillControl?skillAction=editSkill&idSkill="+lst.get(i-1).getSkill().getIdSkill()+"\" method=\"Post\">"
                                + "<div class=\"row\">"     //row name skill
                                + "<div class=\"col-md-3 col-sm-3\">"
                                + "<p>Skill</p>"
                                + "</div>"
                                + "<div class=\"col-md-6 col-sm-6\">"
                                + "<input type=\"text\" name=\"nameSkill\" class=\"form-control\" placehoder=\" Skill Name\" autofocus value=\""+lst.get(i-1).getSkill().getName() +"\">"
                                + "</div>"
                                + "</div>"      //close name skill
                                + "<div class=\"row\">" //row degree skill 
                                + "<div class=\"col-md-3 col-sm-3\">"
                                + "<p>Degree</p>"
                                + "</div>"
                                + "<div class=\"col-md-6 col-sm-6 \">"
                                + "<span class=\"radio\"><label><input type=\"radio\" name=\"degree\" value=\"1\">1*</label></span>"
                                + "<span class=\"radio\"><label><input type=\"radio\" name=\"degree\" value=\"2\">2*</label></span>"
                                + "<span class=\"radio\"><label><input type=\"radio\" name=\"degree\" value=\"3\">3*</label></span>"
                                + "<span class=\"radio\"><label><input type=\"radio\" name=\"degree\" value=\"4\">4*</label></span>"
                                + "<span class=\"radio\"><label><input type=\"radio\" name=\"degree\" value=\"5\">5*</label></span>"
                                + "</div>"
                                + "</div>"  //close degree
                                + "<div class=\"row\">" //from year
                                + "<div class=\"col-md-3 col-sm-3\">"
                                + "<p>Since Year</p>"
                                + "</div>"
                                + "<div class=\"col-md-2 col-sm-2\">"
                                + "<input type=\"text\" class=\"form-control\" name=\"sinceYear\" autofocus value=\""+ lst.get(i-1).getPeriodTime()+"\" >"
                                + "</div>"
                                + "</div><hr/>" //close from year
                                + "<div class=\"row\">"
                                + "<div class=\"col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2 text-center\">"
                                + "<a type=\"button\" class=\"btn btn-block btn-danger\" href=\"SkillControl?skillAction=deleteSkill&idSkill="+lst.get(i-1).getSkill().getIdSkill()+"\">Delete</a>"
                                + "</div>"
                                + "<div class=\"col-md-2 col-sm-2 col-md-offset-4 col-sm-offset-4 text-center\">"
                                + "<input class=\"btn btn-block btn-primary\" type=\"submit\" value=\"Update\">"
                                + "</div>"
                                + "</div>"
                                + "</form>"
                                + "</div>"
                                + "<div class=\"modal-footer\">"
                                + "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" id=\"Update_skill\">Close</button>"
                                + "</div>"
                                + "</div>"
                                + "</div>"
                                + "</div>";           //create modal
                        HTML +="</div></div>";
                    }else{
                        HTMLlabel +="<div class =\"row\"><div class = \"col-md-2 col-sm-2 col-md-offset-1 col-sm-offset-1\">"
                                    + "<span class=\"badge\">"+ lst.get(i-1).getSkill().getName()+"</span>"
                                    + "</div>";
                        HTMLlabel+="<div class=\"col-md-4 col-sm-4 col-md-offset-1 col-sm-offset-1 text-left\"><ul>";
                                    for(int j = 0 ; j < lst.get(i-1).getPeriodTime().split(";").length; j++){
                                        HTMLlabel+="<li>"
                                                + lst.get(i-1).getPeriodTime().split(";")[j]
                                                + "</li>";
                                    }
                        HTMLlabel+="</ul></div>"
                                + "<div class=\"col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2\">"
                                + "<p><a href=\"#\" type=\"button\" data-toggle=\"modal\" data-toggle=\"tooltip\" data-placement=\"top\" title=\"Edit\" data-target=\"#ModaleditSkill"+(i-1)+"\"><svg viewBox=\"0 0 24 24\" width=\"24px\" height=\"24px\" x=\"0\" y=\"0\" preserveAspectRatio=\"xMinYMin meet\" class=\"artdeco-icon\"><g class=\"large-icon\" style=\"fill: currentColor\">\n" +
                                "<path d=\"M21.71,5L19,2.29a1,1,0,0,0-1.41,0L4,15.85,2,22l6.15-2L21.71,6.45A1,1,0,0,0,22,5.71,1,1,0,0,0,21.71,5ZM6.87,18.64l-1.5-1.5L15.92,6.57l1.5,1.5ZM18.09,7.41l-1.5-1.5,1.67-1.67,1.5,1.5Z\"></path>\n" +
                                "</g></svg></a><p>";
                        
                        HTMLlabel +="<div class=\"modal fade\" id=\"ModaleditSkill"+(i-1)+"\" role=\"dialog\">"
                                + "<div class=\"modal-dialog\">"
                                + "<div class=\"modal-content\">"
                                + "<div class=\"modal-header\">"
                                + "<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>"
                                + "<h4 class=\"modal-title\">Edit Skill </h4>"
                                + "</div>"
                                + "<div class=\"modal-body\">"
                                + "<form action=\"SkillControl?skillAction=editSkill&idSkill="+lst.get(i-1).getSkill().getIdSkill()+"\" method=\"Post\">"
                                + "<div class=\"row\">"     //row name skill
                                + "<div class=\"col-md-3 col-sm-3\">"
                                + "<p>Skill</p>"
                                + "</div>"
                                + "<div class=\"col-md-6 col-sm-6\">"
                                + "<input type=\"text\" name=\"nameSkill\" class=\"form-control\" placehoder=\" Skill Name\" autofocus value=\""+lst.get(i-1).getSkill().getName() +"\">"
                                + "</div>"
                                + "</div>"      //close name skill
                                + "<div class=\"row\">" //row point skill 
                                + "<div class=\"col-md-3 col-sm-3\">"
                                + "<p>Detail Skill</p>"
                                + "</div>"
                                + "<div class=\"col-md-6 col-sm-6 \">"
                                + "<input name=\"sinceYear\" type=\"text\" placehoder=\"Detail Skill( Ex: detail1;detail2;...)\" value=\""+lst.get(i-1).getPeriodTime()+"\" >"
                                + "</div>"
                                + "</div>"  //close degree
                                
                                + "<div class=\"row\">"
                                + "<div class=\"col-md-2 col-sm-2 col-md-offset-2 col-sm-offset-2 text-center\">"
                                + "<a type=\"button\" class=\"btn btn-block btn-danger\" href=\"SkillControl?skillAction=deleteSkill&idSkill="+lst.get(i-1).getSkill().getIdSkill()+"\">Delete</a>"
                                + "</div>"
                                + "<div class=\"col-md-2 col-sm-2 col-md-offset-4 col-sm-offset-4 text-center\">"
                                + "<input class=\"btn btn-block btn-primary\" type=\"submit\" value=\"Update\">"
                                + "</div>"
                                + "</div>"
                                + "</form>"
                                + "</div>"
                                + "<div class=\"modal-footer\">"
                                + "<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" id=\"Update_skill\">Close</button>"
                                + "</div>"
                                + "</div>"
                                + "</div>"
                                + "</div>";
                        
                        HTMLlabel += "</div>"
                                    + "</div>";
                       
                        
                    }
                    
                }
                
            }
            
            //System.out.println("HTml key label: "+ HTMLlabel);
            
            response.setContentType("text/plain");
            response.getWriter().write(HTML+HTMLlabel);
        }
        
        if(request.getParameter("skillAction").equals("getAnotherSkillView")){
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            System.out.println("go to get another skill!");
            List<Cvmgmtskill> lst = cv_Skill.retriveAllbyIdCv(cv.getIdCV());
            String HTML ="";
            HTML +="<hr/><div class=\"row\">";
            HTML +="<p class=\"col-md-2 col-sm-2 col-md-offdet-1 col-sm-offset-1\"><em><strong>Another Skill</strong></em></p></div> <div class=\"row\">";
            HTML+="<div class=\"row\"><p class=\"col-md-3 col-sm-3 col-sm-offset-1 col-md-offset-1\">You are also good at...</p><div class=\"row\"><p class=\"col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1\">";
            for(int i =0; i < lst.size() ;i++){
                if(lst.get(i).getSkill().getIdkindskill().getNamekindskill().equals("Another")){
                    HTML+="<span class=\"badge\">"+ lst.get(i).getSkill().getName()+"</span>";
                }
            }
            HTML+="</p></div></div></div>";
            System.out.println(HTML);
            response.setContentType("text/plain");
            response.getWriter().write(HTML);
        }
        if(request.getParameter("skillAction").equals("getAnotherSkillViewpublic")){
            Cv cv = (Cv)request.getSession().getAttribute("cvview");
            System.out.println("go to get another skill!");
            List<Cvmgmtskill> lst = cv_Skill.retriveAllbyIdCv(cv.getIdCV());
            String HTML ="";
            HTML +="<hr/><div class=\"row\">";
            HTML +="<p class=\"col-md-2 col-sm-2 col-md-offdet-1 col-sm-offset-1\"><em><strong>Another Skill</strong></em></p></div> <div class=\"row\">";
            HTML+="<div class=\"row\"><p class=\"col-md-3 col-sm-3 col-sm-offset-1 col-md-offset-1\">You are also good at...</p><div class=\"row\"><p class=\"col-md-10 col-sm-10 col-sm-offset-1 col-md-offset-1\">";
            for(int i =0; i < lst.size() ;i++){
                if(lst.get(i).getSkill().getIdkindskill().getNamekindskill().equals("Another")){
                    HTML+="<span class=\"badge\">"+ lst.get(i).getSkill().getName()+"</span>";
                }
            }
            HTML+="</p></div></div></div>";
            System.out.println(HTML);
            response.setContentType("text/plain");
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
        if(request.getParameter("skillAction").equals("newSkill")){
           Cv cv = (Cv)request.getSession().getAttribute("cv");
           String nameskill = request.getParameter("nameSkill");
           String nameKindSkill = request.getParameter("nameKindSkill");
           String degreeType ="";
           String degreeSkill="";
           String periodSkill="";
           String pointSkill="";
           if(nameKindSkill.equals("KeySkill")){
               degreeType = request.getParameter("namedegreetype");
               if(degreeType.equals("Degree")){
                   degreeSkill = request.getParameter("degreeSkill");
                   periodSkill = request.getParameter("yearSkill");
                   if(skillBean.getSkillbyDegreeAndnamekindskill(Short.valueOf(degreeSkill), nameskill, Short.valueOf("0"))==null){
                       cv_Skill.insertSkill(nameskill, Short.valueOf(degreeSkill), Short.valueOf("0"));
                   }
                   cv_Skill.insertMngmentSkill(nameskill, Short.valueOf(degreeSkill), cv, periodSkill, Short.valueOf("0"));
                   System.out.println("add success skill!"); 
               }
               else{
                   pointSkill = request.getParameter("pointSkill");
                   if(skillBean.getSkillbyDegreeAndnamekindskill(Short.valueOf("0"), nameskill, Short.valueOf("2"))==null){
                       cv_Skill.insertSkill(nameskill, Short.valueOf("0"), Short.valueOf("2"));
                   }
                   cv_Skill.insertMngmentSkill(nameskill, Short.valueOf("0"), cv, pointSkill, Short.valueOf("2"));
               }
           }
           else{
               if(skillBean.getSkillbyDegreeAndnamekindskill(Short.valueOf("0"), nameskill, Short.valueOf("1"))==null){
                   cv_Skill.insertSkill(nameskill, Short.valueOf("0"), Short.valueOf("1"));
               }
               cv_Skill.insertMngmentSkill(nameskill, Short.valueOf("0"), cv, null, Short.valueOf("1"));
           }
           
           RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
           rd.forward(request, response);
        }
        
        if(request.getParameter("skillAction").equals("editSkill")){
            String idSkill= request.getParameter("idSkill");
            String name = request.getParameter("nameSkill");
            String degree= request.getParameter("degree");
            String periodSkill=request.getParameter("sinceYear");
             Cv cv = (Cv)request.getSession().getAttribute("cv");
            Skill skill = skillBean.getSkill(Short.valueOf(idSkill));
                skill.setName(name);
                if(degree!=null)
                    skill.setDegree(Short.valueOf(degree));
                else{
                    skill.setDegree(Short.valueOf("0"));
                }
                skillBean.updateSkill(skill);
                Cvmgmtskill cvmg= cv_Skill.retrivebyIdCvandIdSkill(skill.getIdSkill(),cv.getIdCV());
                cvmg.setPeriodTime(periodSkill);
                cv_Skill.updatemnmmentSkill(cvmg);
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
