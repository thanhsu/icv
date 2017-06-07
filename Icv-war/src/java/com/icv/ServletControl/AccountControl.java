/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import icv.Dao.AddressBean;
import icv.Dao.CvBean;
import icv.Dao.Education_Cv;
import icv.Dao.GroupBean;
import icv.Dao.ProfileBean;
import icv.Dao.UserBean;
import icv.Dao.User_cv;
import icv.Dao.followBean;
import icv.Entity.Address;
import icv.Entity.Cv;

import icv.Entity.Followcv;

import icv.Entity.Profile;
import icv.Entity.Storecv;
import icv.Entity.User;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.ejb.EJB;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AccountControl extends HttpServlet {

    @EJB
    private followBean followBean;

    @EJB
    private UserBean userBean;

    @EJB
    private Education_Cv education_Cv;

    @EJB
    private User_cv user_cv;

    @EJB
    private CvBean cvBean;

    @EJB
    private ProfileBean profileBean;

    @EJB
    private AddressBean addressBean;

    @EJB
    private GroupBean groupBean;

    
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
        request.setCharacterEncoding("UTF-8");
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
        String action = request.getParameter("accountAction");      //nhận giá trị parameter gửi về từ client
        
        if(action.equals("register")){          //chuyển đến trang register
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp");
            rd.forward(request, response); 
            return;
        }
        
        if((request.getParameter("accountAction")).equals("Logout")){       // thực hiện đăng xuất khỏi hệ thống
           
            HttpSession session = request.getSession();
            if(session != null){
                session.invalidate();
            }
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");      // chuyển đến trang chủ
            rd.forward(request, response);
        }
        if((request.getParameter("accountAction")).equals("managerAccount")){
           
            HttpSession session = request.getSession();
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccountSetting.jsp");     
            rd.forward(request, response);
        }
        
        if((request.getParameter("accountAction")).equals("forgotPassword")){
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/forgotPassword.jsp");
            rd.forward(request, response);
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
            throws ServletException, IOException  {
        
        String action = request.getParameter("accountAction");
        try{
        if(action.equals("rating")){            // thực hiện đánh giá cv
            if((User)request.getSession().getAttribute("User")== null){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
            }
            else{
                String rating = request.getParameter("rating");
                followBean.newFollowcv(((User)request.getSession().getAttribute("User")).getIdUser(), ((Cv)request.getSession().getAttribute("cvview")).getIdCV(), Short.valueOf(rating));
                response.setContentType("text/plain");
                response.getWriter().write(rating);
            }
             processRequest(request, response);
            return;
        }}catch(Exception e){
           
        }
        
        try{
        if(action.equals("login")){
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            String lastPath = (String)request.getSession().getAttribute("lastPath");
            
            User user;
            if(username == null || password == null){       //kiểm tra rỗng
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(userBean.getUserbyUsernameAndPassword(username, password) != null){    // kiểm tra đăng nhập trong hệ thống
                
                
                user = userBean.getUserbyUsernameAndPassword(username, password);       // nhận đối tượng User đã đăng nhập
                
                HttpSession session = request.getSession(false);        // khai báo phiên làm việc
                if(session!=null){
                    session.invalidate();               // hủy phiên làm việc cũ
                }
                
                session = request.getSession(true); // khia báo mới phiên làm việc
                Profile profile;
                profile = profileBean.retriveProfileByIdUser(user.getIdUser());     // nhận đối tượng Profile tương ứng với User đã đăng nhập
                
                Storecv storecv;
                storecv = user_cv.retriveStoreCvbyIdUser(user.getIdUser());     // nhận đối tượng storeCv
                
                
                Cv cv;
                cv = cvBean.retriveCVbyIdStore(storecv);            // nhận đối tượng cv 
                
                List<Followcv> lstFollow = followBean.retrivebyIdCv(cv.getIdCV());     // nhận danh sách ngươì dùng đã rating với cv 
                
                if(lstFollow==null){
                    int i =0;
                    session.setAttribute("ratingProfile",i);
                    session.setAttribute("totalFollow", i);
                }else{
                    int total =0;
                    for(int i =0 ; i< lstFollow.size();i++){
                        total+=lstFollow.get(i).getRating();
                    }
                    if(lstFollow.size()<=0){
                        session.setAttribute("ratingProfile",0);
                    }else{
                        session.setAttribute("ratingProfile",total/lstFollow.size());
                    }
                    session.setAttribute("totalFollow", lstFollow.size());
                }
                    //sent data to client
                session.setAttribute("listfollow", lstFollow);      // gửi dữ liệu list Follow về client
                session.setAttribute("Profile", profile);       // gưi thông tin profile
                session.setAttribute("User", user);     // gửi thông tin User
                session.setAttribute("cv", cv);     // gửi thông tin cv
  
                RequestDispatcher rd; 
                
                
                if(lastPath!= null){

                    rd = request.getRequestDispatcher(lastPath);
                    response.sendRedirect(lastPath);
                }
                else{
                    if(user.getUserGroupId().getId().toString().equals("1")){
                        rd = request.getRequestDispatcher("/WEB-INF/admin/StoriesControl.jsp");
                    }else{
                        rd = request.getRequestDispatcher("/WEB-INF/User.jsp");
                    }
                }
                rd.forward(request, response);
            }
            else{
                HttpSession session = request.getSession();
                session.setAttribute("errorLogin_", "Username or Password not correct! Please try againt!");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);   
            }  
             processRequest(request, response);
            return;
        }}catch(Exception e){
        
        }
        
        try{
        if(action.equals("checkandregister")){                  // go to user
                String FirsrName = request.getParameter("inputFirstName");  // nhận fistname    
                String LastName = request.getParameter("inputLastName");    // nhận lastname
                String UserName = request.getParameter("inputUserName");    // nhận username
                String Password = request.getParameter("inputPassword");    // nhận password

                if(userBean.getUserbyUsernameAndPassword(UserName, Password)==null){        // kiểm tra tồn tại username và password chưa 

                String Specialized = "";            
                String Degree = "";
                String EmailAddress = request.getParameter("inputEmail");       // nhận email đăng ký
                String PhoneNumber = "";
                String Country = "";
                String City = "";
                String District = "";
                Date date = new Date();
                User user = new User();
                user.setIdUser(null);
                user.setLastUpdate(null);
                user.setPassword(Password);
                user.setUserName(UserName);

                userBean.insertNewUser(UserName,Password,groupBean.retriveUserGroupById(Short.valueOf("2")));  // tạo mới 1 record trong bản User

                addressBean.InsertAddress(District +" "+ City +" "+ Country);       // tạo mới 1 đối tượng address
                
                user = userBean.getUserbyUsernameAndPassword(UserName, Password);       // nhận dữ liệu user từ bảng User trong cơ sở dữ liệu

                Address add = addressBean.retriveAddressbyAddress(District +" "+ City +" "+ Country);       // nhận dữ liệu từ bảng address

                profileBean.insertProfile(user, add, FirsrName, LastName, date, PhoneNumber, EmailAddress, "","", "");      // tạo mới một record trong bảng profile tương ứng cho người dùng
                
                user_cv.insertStoreCv(user);    //tạo mới record storecv
                String path=""; // link đến profile public của người dùng tương ứng
                path=request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/view.jsp?id="+user.getIdUser().toString();
                cvBean.newRegisterCv(user, user_cv.retriveStoreCvbyIdUser(user.getIdUser()),path);          // tạo mới record trong bảng cv
                
                HttpSession session = request.getSession(false);        // tạo mới session
                if(session!=null){
                    session.invalidate();
                }
                session = request.getSession(true);     
                session.setAttribute("errorLogin_", "Your Account was Register Success! Loggin Here!"); // chuyển về trang đăng nhập sau khi đăng ký thành công!
                //session.setAttribute("RegisterFailure", "Your Username in use. Please change and register againt.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
            }else
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("RegisterFailure", "Your Username in use. Please change and register againt.");        // tên đăng nhập không hợp lệ chuyển về trang đăng ký 
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Register.jsp");
                rd.forward(request, response);
                response.setContentType("text/plain");
                response.getWriter().write("Failed! Please try with another Username!");
            }
             return;
                
        }}catch(Exception e){
            
        }
        
        
        if(action.equals("ChangePassword")){            //sử lý đổi mật khẩu
            String password = request.getParameter("lastPassword");     // mật khẩu cũ
            String newPass = request.getParameter("NewPassword");       // mật khẩu mới
            String newPass2 = request.getParameter("NewPassword2");     // mật khẩu mới
            
            User user = (User)request.getSession().getAttribute("User");      // nhận dữ liệu User 
            
            if(user.getPassword().equals(password)){            // kiểm tra mật khẩu cũ
                    user.setPassword(newPass);                  // thực hiện cập nhật mật khẩu
                    userBean.updateUser(user);
            }
            HttpSession session = request.getSession(false);    // nhận session
            if(session!=null){                  // kiểm tra và cập nhật session
                session.invalidate();
            }
            session = request.getSession(true);
                session.setAttribute("errorLogin_", "Please Loggin with new Password");     // chuyển về trang đăng nhập lại
            
                        
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Login/failure.jsp");
            rd.forward(request, response);
            
        }
        if(action.equals("resetPassword")){             // thực hiện reset mật khẩu 
            String username= request.getParameter("usernamereset");
            String email = request.getParameter("emailreset");
            
          
            //request.setAttribute("usernamereset", username);
            
            User usr = userBean.getUserbyUsername(username);        //thực hiện kiểm tra tồn tại tên đăng nhập tương ứng hay không
            Profile pro = profileBean.retriveProfileByIdUser(usr.getIdUser());  //thực hiện tìm kiếm profile tương ứng
            
            if(pro.getEmail().equals(email)){       //kiểm tra email reset
                
                Properties props = new Properties();
               // props.setProperty("mail.smtp.host", "smtp.gmail.com");
                
                props.put("mail.smtp.host", "smtp.gmail.com");    // setup properties cho đối tượng email
                props.put("mail.smtp.socketFactory.port", "465");    
                props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
                props.put("mail.smtp.auth", "true");    
                props.put("mail.smtp.port", "587");
//                Session sesion = Session.getInstance(props, new Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication(){
//                        return new PasswordAuthentication("connect.icv@gmail.com", "62016303");
//                    }
//                });
                Session sesion = Session.getInstance(props, new Authenticator() {       //khai báo đối tượng sesion 
                    protected PasswordAuthentication gePasswordAuthentication(){
                        return new PasswordAuthentication("connect.icv@gmail.com", "62016303");
                    }
                });
                
                String code="";     // tạo mã code reset password
                Random rdom = new Random();
                for(int i =0;i<6;i++){
                    int n = rdom.nextInt(10) + 0;
                    code += n;
                }
                
                HttpSession session = request.getSession(true);
                session.setAttribute("codereset", code);            //
                session.setAttribute("usernamereset", username);
                try{
                    MimeMessage message = new MimeMessage(sesion);
                    //message.setFrom(new InternetAddress("connect.icv@gmail.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(pro.getEmail()));
                    message.setSubject("Reset Password");
                    message.setText("Your code is "+code);
                    System.out.println(pro.getEmail());
                    //System.out.println("Your Code" + code);
                    Transport.send(message);
                }catch(Exception e){
                
                }
                
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/verify.jsp");
                rd.forward(request, response);
            }
            else{           // reset không thành công
                //HttpSession session = request.getSession(true);
                request.setAttribute("errorReset", "Your Username and your Email not match! Please try again.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/forgotPassword.jsp");
                rd.forward(request, response);
            }
        }
        
        if(action.equals("verifyReset")){       // kiểm tra mã code reset
            String codeconfirm = request.getParameter("codeReset");
            String code = (String)request.getSession().getAttribute("codereset");
        
            if(codeconfirm.equals(code)){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/newPassword.jsp");
                rd.forward(request, response);
            }
            else{
                 request.setAttribute("errorVerify", "Your Code not match! Please try again.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/verify.jsp");
                rd.forward(request, response);
            }
        }
        if(action.equals("newPassword")){       // tạo mới mật khẩu
            String password=request.getParameter("newPasswordReset");
            String password1 = request.getParameter("newPasswordReset1");
        
            if(password.equals(password1)){
                System.out.println(request.getSession().getAttribute("usernamereset"));
                System.out.println(password);
                User user = userBean.getUserbyUsername((String)request.getSession().getAttribute("usernamereset"));
                
                user.setPassword(password);
                userBean.updateUser(user);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/Login/failure.jsp");
                rd.forward(request, response);
            }
            else{
                 request.setAttribute("errorNewpassword", "Your Password not match! Please try again.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/newPassword.jsp");
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
    }
}
