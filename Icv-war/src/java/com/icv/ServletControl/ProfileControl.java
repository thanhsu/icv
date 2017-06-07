/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;


import icv.Dao.AddressBean;
import icv.Dao.CvBean;
import icv.Dao.Education_Cv;
import icv.Dao.ProfileBean;
import icv.Dao.StoreImageBean;
import icv.Dao.UserBean;
import icv.Dao.User_cv;
import icv.Dao.followBean;
import icv.Entity.Address;
import icv.Entity.Cv;

import icv.Entity.Followcv;
import icv.Entity.Profile;

import icv.Entity.Storecv;
import icv.Entity.Storeimage;
import icv.Entity.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

/**
 *
 * @author duyng
 */
public class ProfileControl extends HttpServlet {

    @EJB
    private AddressBean addressBean;

    @EJB
    private StoreImageBean storeImageBean;

    @EJB
    private Education_Cv education_Cv;

    @EJB
    private User_cv user_cv;

    @EJB
    private followBean followBean;

    @EJB
    private CvBean cvBean;

    @EJB
    private ProfileBean profileBean;

    @EJB
    private UserBean userBean;
    
    
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
        //response.sendRedirect("/index.jsp");
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
            request.setCharacterEncoding("UTF-8");
            
            if(request.getParameter("profileAction").equals("userhome")){       // thực hiện yêu cầu chuyên tiếp về trang User
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/User.jsp");
                rd.forward(request, response);
            }
            
            if(request.getParameter("profileAction").equals("redirecttoPublicProfile")){        // thcự hiện chuyển tiếp về trang profilepublic
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/icv/profilepublic.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(request.getParameter("profileAction").equals("view")){       // thực hiện yêu cầu tạo view thông tin profile
               try{
                    String id = request.getParameter("id");     //idUser

                    User user = userBean.getUserbyId(Short.valueOf(id));

                    Storecv store = user_cv.retriveStoreCvbyIdUser(Short.valueOf(id));
                    Cv cv = cvBean.retriveCVbyIdStore(store);
                    Profile profile = profileBean.retriveProfileByIdUser(user.getIdUser());
                     HttpSession session = request.getSession(true);
                    try{
                        Followcv follow = followBean.retrivebyIdUserIdCv(((User)request.getSession().getAttribute("User")).getIdUser(), cv.getIdCV());
                        if(follow == null){
                            session.setAttribute("ratingProfilepublic", 0);
                        }else{
                            session.setAttribute("ratingProfilepublic", follow.getRating());
                        }
                        
                    }catch(Exception e){
                        }
                    session.setAttribute("userview", user);
                    session.setAttribute("cvview", cv);
                    session.setAttribute("profileview", profile);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/icv/profilepublic.jsp");
                    rd.forward(request, response);}
               catch(Exception e){
                    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                    rd.forward(request, response);
               }
               return;
            }
            
            if(request.getParameter("profileAction").equals("managerProfile")){     // thực hiện yêu cầu chuyển tiếp về trang Profile
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(request.getParameter("profileAction").equals("getView")){        // thực hiện yêu cầu tạo view và cchuyển tiếp về trang profile public
                try{
                    String id = request.getParameter("id");     // nhận iduser của profile cần tạo view

                    User user = userBean.getUserbyId(Short.valueOf(id));

                    Storecv store = user_cv.retriveStoreCvbyIdUser(Short.valueOf(id));      // tìm kiểm storecv
                    Cv cv = cvBean.retriveCVbyIdStore(store);       // tìm kiếm cv
                    Profile profile = profileBean.retriveProfileByIdUser(user.getIdUser());     // tìm kiếm profile
                     HttpSession session = request.getSession(true);        // tạo mới session 
                    try{            //tạo thông tin follow tương ứng với cv
                        Followcv follow = followBean.retrivebyIdUserIdCv(((User)request.getSession().getAttribute("User")).getIdUser(), cv.getIdCV());
                        if(follow == null){        // kiểm tra và gửi dữ liệu lên session
                            session.setAttribute("ratingProfilepublic", 0);              
                        }else{
                            session.setAttribute("ratingProfilepublic", follow.getRating());
                        }
                        
                    }catch(Exception e){
                        }
                    session.setAttribute("userview", user);     // gửi dữ liệu lên session
                    session.setAttribute("cvview", cv);
                    session.setAttribute("profileview", profile);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/icv/profilepublic.jsp");
                    rd.forward(request, response);}
               catch(Exception e){
                    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");      // trả về trang error nếu không tìm thấy dữ liệu
                    rd.forward(request, response);
               }
               return;
            }
            
            if(request.getParameter("profileAction").equals("getRating")){          //thực hiện yêu cầu get rating
                int rating = (int)request.getSession().getAttribute("ratingProfile");  
                int follow =(int)request.getSession().getAttribute("totalFollow");
                String HTML = "<input disabled id=\"rating\"  value=\""+rating+"\" class=\"rating rating-load\" data-size=\"sm\">";
                HTML+="<p>Follow by "+follow+"( user)<p>";
                
                response.setContentType("text/plain");      // gửi dữ liệu que response
                response.getWriter().write(HTML);
   
            }            
            if(request.getParameter("profileAction").equals("getVideoIntroduce")){      // nhận link introduce
                Cv cv = (Cv)request.getSession().getAttribute("cv");                    // nhận thông tin cv trên session
                String HTML ="";
                if(cv.getVideoLink()!=null && !cv.getVideoLink().equals("")){           // kiểm tra và tạo view tương ứng
                    HTML +="<h4>Video Introduce</h4>";
                    HTML +="<iframe width=\"350\" height=\"197\" src=\"" + cv.getVideoLink() +"\" frameborder=\"0\" allowfullscreen></iframe>";
                }
                else{
                    HTML="<p></p>";
                }
                response.setContentType("text/plain");
                response.getWriter().write(HTML);

            }
            if(request.getParameter("profileAction").equals("getVideoIntroducepublic")){        // nhận video cho yêu cầu xem trang profile public
                Cv cv = (Cv)request.getSession().getAttribute("cvview");
                String HTML ="";
                if(cv.getVideoLink()!=null && !cv.getVideoLink().equals("")){
                    HTML +="<h4>Video Introduce</h4>";
                    HTML +="<iframe width=\"350\" height=\"197\" src=\"" + cv.getVideoLink() +"\" frameborder=\"0\" allowfullscreen></iframe>";
                }
                else{
                    HTML="<p></p>";
                }
                response.setContentType("text/plain");
                response.getWriter().write(HTML);

            }
            
            if(request.getParameter("profileAction").equals("getAvatar")){              // thực hiện yêu cầu nhận hình ảnh từ client
                String id = request.getParameter("id");                                 // nhận id ảnh tương ứng
                
                Storeimage storeimg = storeImageBean.retriveByIdUser(Short.valueOf(id));    // tìm hình ảnh với id tương ứng trong cơ sở dư liệu
                if(storeimg==null){
                    storeimg = storeImageBean.retriveByIdImage(Short.valueOf("0"));     // nếu không tìm thấy hình ảnh thực hiện gán hình ảnh mặc định
                }
                
                byte[] imgdata = storeimg.getImagevalue();              // 
                
                //InputStream input = new ByteArrayInputStream(imgdata);
                
                OutputStream output = response.getOutputStream();
                
                response.setContentType("image/gif");       // truyền dữ liệu hình ảnh về cho người dùng
                output.write(imgdata);                    
            }
            
            if(request.getParameter("profileAction").equals("getImage")){       // nhận hình ảnh với tên trong thư mục image của server
                String id = request.getParameter("id");
                
                Storeimage storeimg = storeImageBean.retriveByIdUser(Short.valueOf(id));
                
                byte[] imgdata = storeimg.getImagevalue();
                
                InputStream input = new ByteArrayInputStream(imgdata);
                
                BufferedImage buffer = ImageIO.read(input);
                OutputStream output = response.getOutputStream();

                ImageIO.write(buffer, "png", new File(getServletContext().getRealPath("/image")+"/"+id+".png"));
                
                
                response.setContentType("image/gif");
                output.write(imgdata);
                    
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
       
        HttpSession session = request.getSession();
        
        
        if(request.getParameter("profileAction").equals("setRating")){      // thực hiện gửi rating
            User user = (User)session.getAttribute("User");
            
            User userv = (User)session.getAttribute("userview");        // tìm kiếm và kiểm tra thông tin userview
            Profile profilev= (Profile)session.getAttribute("profileview");
            Cv cvv = (Cv)session.getAttribute("cvview");
            String lastPath = "/WEB-INF/redirect.jsp?id="+userv.getIdUser().toString();
            if(user==null){         // kiểm tra thông tin đăng nhập
                session.setAttribute("lastPath", lastPath);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
            }else{
                String rating = request.getParameter("inputRating");
                Followcv follow= followBean.retrivebyIdUserIdCv(user.getIdUser(), cvv.getIdCV());
                if(follow != null){
                    followBean.deleteRating(follow);
                    
                    Float f = Float.parseFloat(rating);
                    int i = Math.round(f);
                    follow.setRating(Short.parseShort(String.valueOf(i)));
                    
                    followBean.newFollowcv(follow.getFollowcvPK().getIdUser(),follow.getFollowcvPK().getIdcv(), follow.getRating());
                    //followBean.updateRating(cvv.getIdCV(), user.getIdUser(), Short.parseShort(String.valueOf(i)));
                }else{                    //follow = new Followcv(cvv.getIdCV(), user.getIdUser());
                    try{
                        Float f = Float.parseFloat(rating);
                        int i = Math.round(f);
                       followBean.newFollowcv(user.getIdUser(),cvv.getIdCV() , Short.parseShort(String.valueOf(i)));
                    }catch(Exception e){}
                }
                
                try{
                        Followcv follow1 = followBean.retrivebyIdUserIdCv(((User)request.getSession().getAttribute("User")).getIdUser(), cvv.getIdCV());
                        if(follow == null){
                            session.setAttribute("ratingProfilepublic", 0);
                        }else{
                            session.setAttribute("ratingProfilepublic", follow1.getRating());
                        }
                        
                    }catch(Exception e){


                        }
                
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/icv/profilepublic.jsp");      
                rd.forward(request, response);
            }
            
            
        }
        
        
        if(request.getParameter("profileAction").equals("changeAvatar")){       // thực hiện yêu cầu thay đổi avatar
            User user = (User)session.getAttribute("User");
            Profile profile= (Profile)session.getAttribute("Profile");
            Storeimage storeImage;      
            InputStream input = null;
            Part filePart = request.getPart("inputAvatar");     // nhận dữ liệu từ client
            if(filePart !=null){
                input = filePart.getInputStream();
            }
            try{
                storeImage = new Storeimage();      // khởi tạo đối tượng image
                storeImage.setIdUser(user);
                storeImage.setNote("Avatar of "+profile.getLastName());     
                storeImage.setTypeImage(Short.valueOf("0"));
                byte[] image = IOUtils.toByteArray(input);
                storeImage.setImagevalue(image);
                if(storeImageBean.retriveByIdUser(user.getIdUser()) == null){       // kiểm tra và cập nhật thông tin image cho người dùng
                    storeImageBean.persistNewImage(storeImage);
                   
                }else{
                    storeImage.setIdImage(storeImageBean.retriveByIdUser(user.getIdUser()).getIdImage());  
                    
                    storeImageBean.updateNewImage(storeImage);      //thêm mới image vào cơ sở dữ liệu
                }
                
            }catch(Exception e){
            
            }
        
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
            rd.forward(request, response);
        }
        
        if(request.getParameter("profileAction").equals("updateProfile")){          // thực hiện yêu cầu cập nhật thông tin profile
          
            User user = (User)session.getAttribute("User");         // nhận đối tượng User từ session
            Profile profile= (Profile)session.getAttribute("Profile");      // nhận đối tượng profile từ session
            
            String firstName= request.getParameter("FirstName");
            String lastName = request.getParameter("LastName");
            String email = request.getParameter("Email");
            String address = request.getParameter("Address");
            String sex = request.getParameter("Sex");
            
            String phone = request.getParameter("Phone");
            String birthday = request.getParameter("Birthday");
          
            String Career = request.getParameter("Career");
            Date date;
            if(!birthday.equals("")){
                date = new Date();
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                } catch (ParseException ex) {
                    Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
                    date = null;
                }
                profile.setBirthday(date);
            }
            if(sex.equals("true")){
                profile.setSex(Boolean.TRUE);
            }
            else{
                profile.setSex(Boolean.FALSE);
            }
            if(!address.equals("")){
                addressBean.InsertAddress(address);
                Address add = addressBean.retriveAddressbyAddress(address);
                profile.setIdAddress(add);
            }
            
            profile.setFirstName(firstName);
            profile.setLastName(lastName);
            profile.setEmail(email);
            profile.setPhone(phone);
            
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            cv.setMore(Career);
            cvBean.UpdateCv(cv);        // thực hiện cập nhật
            
            if(profileBean.updateProfile(profile)){     // thực hiệp cập nhật
                System.out.println("update Profile OK!");
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
            rd.forward(request, response);
        }
        if(request.getParameter("profileAction").equals("updateIntroduce")){        // nhận yêu cầu update Introduce
            String targetjob = request.getParameter("TargetJob");
            String hope= request.getParameter("Hope");
            String hobbit = request.getParameter("Hobbit");
            String description = request.getParameter("Description");
            
            User user = (User)session.getAttribute("User");
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            Profile profile= (Profile)session.getAttribute("Profile");
            
            profile.setHope(hope);
            profile.setDescription(description);
            cv.setHobbit(hobbit);
            cv.setTargetJob(targetjob);
            
            cvBean.UpdateCv(cv);        
            if(profileBean.updateProfile(profile)){     // thực hiện cập nhật 
                System.out.println("updateProfileSuccess!");
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
            rd.forward(request, response);
        }
        
        if(request.getParameter("profileAction").equals("updateVideo")){            // thực hiện cập nhật link youtube giới thiệu 
            Cv cv = (Cv)request.getSession().getAttribute("cv");
            String link = request.getParameter("inputVideoLink");
            if(link.equals("")){            // kiểm tra link nhập vào
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
                rd.forward(request, response);
            }else{
                if(link.startsWith("https://www.youtube.com")){     //kiểm tra format link youtube
                    String name= link.split("v=")[1];
                    name = "https://www.youtube.com/embed/"+name;
                    cv.setVideoLink(name);
                    cvBean.UpdateCv(cv);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
                    rd.forward(request, response);
                }else{
                    if(link.startsWith("<iframe")){     
                        String name=link.split("\"")[5];
                        cv.setVideoLink(name);
                        cvBean.UpdateCv(cv);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Timeline/Profile.jsp");
                        rd.forward(request, response);
                    }
                }
            }
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
