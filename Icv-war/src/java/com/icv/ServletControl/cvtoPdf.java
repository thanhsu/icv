/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import BUL.CreateCv;
import com.lowagie.text.DocumentException;
import icv.Dao.Cv_Skill;
import icv.Dao.Education_Cv;
import icv.Dao.ExperiencesBean;
import icv.Dao.SkillBean;
import icv.Dao.StoreImageBean;
import icv.Entity.Cv;
import icv.Entity.Cvmgmteducation;
import icv.Entity.Cvmgmtskill;
import icv.Entity.Experiences;
import icv.Entity.Profile;
import icv.Entity.Skill;
import icv.Entity.Storeimage;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author duyng
 */
public class cvtoPdf extends HttpServlet {

    @EJB
    private StoreImageBean storeImageBean;

    @EJB
    private Cv_Skill cv_Skill;

    @EJB
    private ExperiencesBean experiencesBean;

    @EJB
    private Education_Cv education_Cv;

    @EJB
    private SkillBean skillBean;

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
        
        if(request.getParameter("pdfAction").equals("getPDF")){         // nhận yêu cầu tạo file PDF
                String idkind= request.getParameter("idKindCv");        // nhận id của mẫu file PDF cần tạo
                int id = Integer.parseInt(idkind);          
                Cv cv = (Cv)request.getSession().getAttribute("cv");        
                Profile profile = (Profile)request.getSession().getAttribute("Profile");
                List<Cvmgmteducation> lstedu = education_Cv.retriveAllbyIdCV(cv.getIdCV());     // lấy danh sách education tương ứng
                List<Cvmgmtskill> lst = cv_Skill.retriveAllbyIdCv(cv.getIdCV());        //lấy danh sách skill
                List<Skill> lstKeyskill = new ArrayList<>();            
                List<Skill> anotherSkill = new ArrayList<>();
                for(int i = 0 ; i < lst.size();i++){
                    if(lst.get(i).getSkill().getIdkindskill().getNamekindskill().equals("Another")){        // tạo danh sách another skill
                        anotherSkill.add(lst.get(i).getSkill());    
                    }else{
                        lstKeyskill.add(lst.get(i).getSkill());     // tạo danh sách key skill
                    }
                }
                List<Experiences> lstExper = experiencesBean.retriveAllExperiencesbyIdUser(profile.getIdUser().getIdUser());        // lấy danh sách experiences
               
                Storeimage storeimg = storeImageBean.retriveByIdUser(profile.getIdUser().getIdUser());  // nhận dữ liệu avatar
                if(storeimg==null){
                    storeimg = storeImageBean.retriveByIdImage(Short.valueOf("0"));         // nếu không có hình ảnh thì chọn hình ảnh mặc định
                }
                byte[] imgdata = storeimg.getImagevalue();
                
                InputStream input = new ByteArrayInputStream(imgdata);
                
                BufferedImage buffer = ImageIO.read(input);
                OutputStream output = response.getOutputStream();
                String image = getServletContext().getRealPath("/image")+"/"+profile.getIdUser().getIdUser().toString()+".jpg";     // chuyển đổi file ảnh về dạng jpg và lưu vào thư mục image trong hệ thống
                
                ImageIO.write(buffer, "jpg", new File(image));
                
                image= getServletContext().getRealPath("/image");
                String link;
                link = request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ProfileControl?";
                
                CreateCv createcv = new CreateCv(lstedu, lst,lstKeyskill, anotherSkill, lstExper, profile, cv, id , image,link);        //gọi hàm khởi tạo cv document
               
                
                ITextRenderer render= createcv.createDocument();        // khởi tạo đối tượng itextrenderer
                    
                FileOutputStream os = null;
                os = new FileOutputStream(cv.getIdCV().toString()+".pdf");
                render.layout();
            try {
                response.setContentType("text/html;charset=UTF-8");     // truyen du lieu về client
                response.addHeader("header", "CV");
                response.setContentType("application/pdf");
                render.createPDF(response.getOutputStream());
            } catch (DocumentException ex) {
                Logger.getLogger(cvtoPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
