/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUL;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import icv.Entity.Cv;
import icv.Entity.Cvmgmteducation;
import icv.Entity.Cvmgmtskill;

import icv.Entity.Experiences;
import icv.Entity.Profile;
import icv.Entity.Skill;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xhtmlrenderer.pdf.ITextRenderer;


public class CreateCv {
    String htmlcssbody="";
    String htmlbody="";
    Profile profile;
    Cv cv;
    List<Cvmgmteducation> lstEducation;
    List<Skill> lstSkill;
    List<Skill> lstAnortherSkill;
    List<Cvmgmtskill> lststoreSkill;
    List<Experiences> lstExperiences;
    String[] lstactivity;
    String[] lstPrize;
    int kindCv;
    String path;
    String link;
    
    public CreateCv(List<Cvmgmteducation> lstedu,List<Cvmgmtskill> lststoreskill , List<Skill> lstKeyskill, List<Skill> anotherSkill, List<Experiences> lstExper,Profile profile, Cv cv,  int kindcv , String contextpath, String link){
        this.lststoreSkill = lststoreskill;
        this.link = link;
        this.path =contextpath;
        this.htmlcssbody="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//E\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
                    + "<head>"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
                    + "<style>"
                + 
                "p{"
                + "line-height:100%;"
                + "}"
                
                + "body{"
                + "font-family: Arial Unicode MS, Helvetica, Arial, sans-serif;"
                + "background-size:cover;\n" +
"			-webkit-background-size: cover;\n" +
"			-o-background-size: cover;\n" +
"			-ms-background-size: cover;\n" +
"			-moz-background-size: cover;"
                + ""
                + "line-height:100%;"
                + "font-size:medium;}"
                +
                " \n" +
                "\n" +
                ".container_12 {\n" +
                "margin-left: auto ;\n" +
                "margin-right: auto;"
                 +
                "width: 960px;\n" +
                "height: auto;"
                + "float: bottom;\n" +
                "}\n" +
                "\n" +
                ".grid_1,\n" +
                ".grid_2,\n" +
                ".grid_3,\n" +
                ".grid_4,\n" +
                ".grid_5,\n" +
                ".grid_6,\n" +
                ".grid_7,\n" +
                ".grid_8,\n" +
                ".grid_9,\n" +
                ".grid_10,\n" +
                ".grid_11,\n" +
                ".grid_12 {\n" +
                "display: inline;\n" +
                "float: left;\n" +
                "margin-left: 10px;\n" +
                "margin-right: 10px;\n" +
                "}\n" +
                "\n" +
                ".push_1, .pull_1,\n" +
                ".push_2, .pull_2,\n" +
                ".push_3, .pull_3,\n" +
                ".push_4, .pull_4,\n" +
                ".push_5, .pull_5,\n" +
                ".push_6, .pull_6,\n" +
                ".push_7, .pull_7,\n" +
                ".push_8, .pull_8,\n" +
                ".push_9, .pull_9,\n" +
                ".push_10, .pull_10,\n" +
                ".push_11, .pull_11 {\n" +
                "position: relative;\n" +
                "}\n" +
                "\n" +
                "\n" +
                ".alpha {\n" +
                "margin-left: 0;\n" +
                "}\n" +
                "\n" +
                ".omega {\n" +
                "margin-right: 0;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_1 {\n" +
                "width: 60px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_2 {\n" +
                "width: 140px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_3 {\n" +
                "width: 220px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_4 {\n" +
                "width: 300px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_5 {\n" +
                "width: 380px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_6 {\n" +
                "width: 460px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_7 {\n" +
                "width: 540px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_8 {\n" +
                "width: 620px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_9 {\n" +
                "width: 700px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_10 {\n" +
                "width: 780px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_11 {\n" +
                "width: 860px;\n" +
                "}\n" +
                "\n" +
                ".container_12 .grid_12 {\n" +
                "width: 940px;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "            .container_12 .prefix_1 {\n" +
                "              padding-left: 80px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_2 {\n" +
                "              padding-left: 160px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_3 {\n" +
                "              padding-left: 240px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_4 {\n" +
                "              padding-left: 320px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_5 {\n" +
                "              padding-left: 400px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_6 {\n" +
                "              padding-left: 480px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_7 {\n" +
                "              padding-left: 560px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_8 {\n" +
                "              padding-left: 640px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_9 {\n" +
                "              padding-left: 720px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_10 {\n" +
                "              padding-left: 800px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .prefix_11 {\n" +
                "              padding-left: 880px;\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "            .container_12 .suffix_1 {\n" +
                "              padding-right: 80px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_2 {\n" +
                "              padding-right: 160px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_3 {\n" +
                "              padding-right: 240px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_4 {\n" +
                "              padding-right: 320px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_5 {\n" +
                "              padding-right: 400px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_6 {\n" +
                "              padding-right: 480px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_7 {\n" +
                "              padding-right: 560px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_8 {\n" +
                "              padding-right: 640px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_9 {\n" +
                "              padding-right: 720px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_10 {\n" +
                "              padding-right: 800px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .suffix_11 {\n" +
                "              padding-right: 880px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_1 {\n" +
                "              left: 80px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_2 {\n" +
                "              left: 160px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_3 {\n" +
                "              left: 240px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_4 {\n" +
                "              left: 320px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_5 {\n" +
                "              left: 400px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_6 {\n" +
                "              left: 480px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_7 {\n" +
                "              left: 560px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_8 {\n" +
                "              left: 640px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_9 {\n" +
                "              left: 720px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_10 {\n" +
                "              left: 800px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .push_11 {\n" +
                "              left: 880px;\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "            .container_12 .pull_1 {\n" +
                "              left: -80px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_2 {\n" +
                "              left: -160px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_3 {\n" +
                "              left: -240px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_4 {\n" +
                "              left: -320px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_5 {\n" +
                "              left: -400px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_6 {\n" +
                "              left: -480px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_7 {\n" +
                "              left: -560px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_8 {\n" +
                "              left: -640px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_9 {\n" +
                "              left: -720px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_10 {\n" +
                "              left: -800px;\n" +
                "            }\n" +
                "\n" +
                "            .container_12 .pull_11 {\n" +
                "              left: -880px;\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "            .clear {\n" +
                "              clear: both;\n" +
                "              display: block;\n" +
                "              overflow: hidden;\n" +
                "              visibility: hidden;\n" +
                "              width: 0;\n" +
                "              height: 0;\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "            .clearfix:before,\n" +
                "            .clearfix:after {\n" +
                "              content: '\\0020';\n" +
                "              display: block;\n" +
                "              overflow: hidden;\n" +
                "              visibility: hidden;\n" +
                "              width: 0;\n" +
                "              height: 0;\n" +
                "            }\n" +
                "\n" +
                "            .clearfix:after {\n" +
                "              clear: both;\n" +
                "            }\n" +
                "            .clearfix {\n" +
                "              zoom: 1;\n" +
                "            }\n" +
                "            \n"

                + ".bg-success{"
                + "background-size:cover;\n" +
                    "-webkit-background-size: cover;\n" +
                    "-o-background-size: cover;\n" +
                    "-ms-background-size: cover;\n" +
                    "-moz-background-size: cover;"
                + "background-color: #0086b3 repeat-y ;"
                + "}"
                + ".progress{"
                + "background-color: #bbb;"
                + "width:180px;"
                + "height:14px;"
                + "border-radius:8px;"
                + "margin: 3px auto;"
                + "}"
                + ".progress-bar{"
                + "background-color:#00cc00;"
                + "width:195px;"
                + "height:13px;"
                + "border-radius:2px;"
                + "}"
                + ".progress-color1{"
                + "background-color: red;"
                + "}"
                + ".background-grey{"
                + "margin-left:-25px;"
                + "background-color: #CDC9C9;\n" +
                "background-repeat: repeat-y;\n" +
                "background-attachment: fixed;\n" +
                "background-position: left;"
                + "width:100%;"
                + "height:100%; "
                + "}"
                + ".progress-color2{"
                + "background-color: #00CC00;"
                + "}"
                + ".progress-color3{"
                + "background-color: #FFFF66;"
                + "}"
                + ".progress-color4{"
                + "background-color: #FF99FF;"
                + "}"
                + ".progress-color-x{"
                + "background-color: #6495ED;"
                + "}"
                + ".center-block{"
                + "text-align:center;"
                + "}"
                + ".box-shadow{\n" +
                "  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);\n" +
                "}"
                + ".circle {\n" +
                    "	border-radius: 50%;\n" +
                    "	width: 250px;\n" +
                    "	height: 250px; \n" +
                    "	" +
                "}"
                + "h3{"
                + "color: #33adff;"
                + "}"
                + "table, th, td {\n" +
                "    border: 0px solid black;\n" +
                "}"
                
                + "</style></head>"
                    //put some class here
                ;
        
        
        htmlbody="";
        this.lstEducation =lstedu;
        this.lstSkill =lstKeyskill;
        this.lstAnortherSkill = anotherSkill;
        this.lstExperiences = lstExper;
        this.kindCv = kindcv;
        this.cv =cv;
        this.profile = profile;
        lstactivity = cv.getActivity().split(";");
        lstPrize = cv.getPrize().split(";");
    }
    
    public ITextRenderer createDocument(){
        ITextRenderer doc = new ITextRenderer();
        try {
            doc.getFontResolver().addFont("C:\\Windows\\Fonts\\ARIALUNI.TTF",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException ex) {
           // Logger.getLogger(CreateCv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(CreateCv.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(kindCv == 1){
            String html="";
            html += htmlcssbody;
            html +=""
                    + ""
                    + "<body>";
            html += "<div class=\"container_12\">"
                    + "<div class=\"grid_3\">"
                        + "<p class=\"text-center\"><h2>" + profile.getFirstName() +" "+profile.getLastName() +"</h2></p>"           //User name
                        + "<img class=\"circle\" src =\""+profile.getIdUser().getIdUser().toString()+".jpg"+"\" width=\"220px;\" height=\"275px;\" ></img>"
                        + "<div class=\"bg-success box-shadow\" style=\"background-color: #0086b3; padding-left: 5px; padding-bottom:10px;\" >"
                        + "<p style=\"text-align:left; padding-top:0px; color:#bbb;\" >Day of Birth</p>"
                        + "<p style=\"text-align:left; padding-top:-2px; margin-left:10px;color: #000000\">"+profile.getBirthday()+"</p>"
                        + "<p style=\"text-align:left; color:#bbb;\" >Sex</p>"
                        + "<p style=\"text-align:left; padding-top:0px; margin-left:10px; color: #000000\">"+profile.getSex()+"</p>"
                        + "<p style=\"text-align:left; padding-top:-2px; color:#bbb;\" >Email</p>"
                        + "<p style=\"text-align:left; padding-top:0px; margin-left:10px; color: #000000\">"+profile.getEmail()+"</p>"
                        + "<p style=\"text-align:left; padding-top:-2px; color:#bbb;\" >Phone Number</p>"
                        + "<p style=\"text-align:left; padding-top:0px; margin-left:10px; color: #000000\">"+profile.getPhone()+"</p>"
                        + "<p style=\"text-align:left; padding-top:-2px; color:#bbb;\" >Website</p>"
                        + "<label style=\"margin-left:10px; color:; font-size: 60%;\" ><a style=\"color: #9400D3;\" href=\""+cv.getReferences()+"\"></a>"+cv.getReferences()+"</label>"
                    + "<hr/>"
                    + "<p class=\"progress-red\" style=\"margin-left:15px; color: #39CC00;\">SKILL</p>";
            if(lstSkill.size()>0){
                    String html1 ="";
                    String html2="";
                for(int i =0; i< lstSkill.size();i++){
                    
                    if(lstSkill.get(i).getIdkindskill().getNamekindshow().equals("progress")){
                        html1 += "\n<p style=\"color:#000000;\" >"+lstSkill.get(i).getName()+"</p>";
                        html1 += "<div class=\"progress\">"
                                + "<p class=\"progress-bar progress-color"+i+"\" role=\"progressbar\" aria-valuenow=\""+lstSkill.get(i).getDegree()*20+"\"  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+lstSkill.get(i).getDegree()*20+"%;\">"
                                + "</p>"
                            + "</div>";
                    }else{
                        html2 += "<p style=\"text-align:left; color:white;\" >"+lstSkill.get(i).getName()+"</p>";
                        html2 += "<p style=\"text-align:left; color:#bbb;\">"
                                + "</p>";
                    }
                    
                }
                
                html += html1+html2;
            }
            if(lstAnortherSkill.size() > 0){
                html += "<div><p style=\"text-align:left; color:#bbb;\" ><strong>I also good at</strong></p>";
                for(int i=0; i <lstAnortherSkill.size();i++){
                    html += "<label style=\"text-align:left; margin-left:3px; color:#F0F8FF;\" >"+lstAnortherSkill.get(i).getName()+"; </label>";
                }
            }
            html+="...</div></div>"
                    + "</div>";  // close introduce
            //main content
            html += "<div class=\"grid_6\">"
                    +"<div class=\"\" style=\"text-align:left;\">"
                        + "<p><h2>"+ cv.getMore()+"</h2></p>"           //career
                    + "</div><hr/>"
                    + "<div>"
                    + "<table style=\"width:100%;\">"
                    + "<tr>"
                    + "<td style=\"width:25%;\"><em>Description</em></td>"
                    + "<td style=\"\"> <label>"+profile.getDescription()+"</label></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td style=\"width:25%;\"><em>Target Job</em></td>"
                    + "<td>"+cv.getTargetJob()+"</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td style=\"width:25%;\"><em>Hobbit</em></td>"
                    + "<td>"+cv.getHobbit()+"</td>"
                    + "</tr>"
                    + "</table>"
                    + "</div><hr/>"
                    + "<div>"
                    + "<p style=\"padding-left:20px;\"><h3><strong>Experiences Work</strong></h3></p>";       //experiences work
                    
                    for(int i=0; i< lstExperiences.size();i++){
                        html +="<div><table style=\"width:100%\">"
                                + "<tr>"
                                + "<td style=\"width:50%; font-weight: bold;\">"+lstExperiences.get(i).getSpecialized().getName()+" </td>"
                                + "<th style=\"width:10%\"></th>"
                                + "<td style=\"width:30%\"><em>For "+lstExperiences.get(i).getYear()+" Year</em></td>"
                                + "</tr>"
                                + "</table>"
                                + "<p style=\"margin-left:10px;\">"+lstExperiences.get(i).getDescription()+"</p>"
                                + "</div>";
                    }
                    
            
                    html += "<hr/></div>"
                            + "<div>"
                            + "<p style=\"margin-left:20px;\"><h3><strong>Education</strong></h3></p>";
                    for(int i=0; i< lstEducation.size();i++){
                        
                        html +="<div><table style=\"width:100%\">"
                                + "<tr>"
                                + "<th style=\"width:50%  font-weight: bold;\">"+lstEducation.get(i).getEducation().getTitile()+"</th>"
                                + "<th style=\"width:10%\"></th>"
                                + "<th style=\"width:30%\">"+lstEducation.get(i).getPeriodTime()+"</th>"
                                + "</tr>"
                                + "</table>"
                                + "<p style=\"margin-left:10px;\">"+lstEducation.get(i).getEducation().getDetail()+"</p>"
                                + "</div>";
                    }
                            html+= "<hr/></div>"
                                    + "<div>"
                                    + "<p style=\"margin-left:20px;\"><h3><strong>Activity</strong></h3></p>"
                                    + "<ul>";
                    for(int i=0 ;i < lstactivity.length;i++ ){
                        html+="<li>"+lstactivity[i]+"</li>";
                    }
                    html += "</ul></div>"
                            + "<div><p style=\"margin-left:20px;\"><h3>Prize</h3></p>"
                            + "<ul>";
                    for(int i=0;i<lstPrize.length ;i++){
                        html+="<li>"+lstPrize[i]+"</li>";
                    }
                    
                        html+= "</ul>"
                                + "</div>"
                                + "</div>";  //close main content
            
                html+= "</div>";
                html+="\n</body>\n";
                html+= "</html>";
                
                System.out.println(html);
                //html="<html><head><style>body{color:red;}</style></head><body>PTS</body></html>";
                //System.out.print(html);
             //SharedContext sharedContext = doc.getSharedContext();
             //sharedContext.setPrint(true);
             //sharedContext.setInteractive(false);
             //sharedContext.setReplacedElementFactory(new ProfileImageReplacedElementFactory());
             //sharedContext.getTextRenderer().setSmoothingThreshold(0);
             doc.setDocumentFromString(html, "file:///"+path+"/");
            
             //doc.setPDFVersion(Character.MAX_VALUE);
             
             return doc;
        }
        
        if(kindCv == 2){
            String html="";
            html += htmlcssbody;
            html += "\n<body>\n";
            html += "<div class=\"center-block\" style=\"margin-bottom:10px;\"><strong>CURRICULUM VITEA</strong></div><hr/>"; 
            html += "<div class=\"container_12\">";
            html += "<div class=\"grid_3\">"
                    + "<img src =\""+profile.getIdUser().getIdUser().toString()+".jpg"+"\" width=\"220px;\" height=\"295px;\" ></img>"                //your avatar
                    + "</div>";
            html += "<div class=\"grid_6 push_1\">"
                    + "<h2 class=\"center-block\" style=\"color: #1E90FF; margin-left=50px;\">"+profile.getFirstName() +" "+profile.getLastName()+"</h2>"                    //info
                    + "<h3 class=\"center-block\" style=\"color: #1E90FF;\"><u>"+cv.getMore()+"</u></h3>"
                    + "<p><strong>Date of Birth: </strong>"+profile.getBirthday()+"</p>"
                    + "<p><strong>Address: </strong>"+profile.getIdAddress().getAddress()+"</p>"
                    + "<p><strong>Gender: </strong>"+profile.getSex()+"</p>"
                    + "<p><strong>Telephone: </strong>"+profile.getPhone()+"</p>"
                    + "<p><strong>Email: </strong><a>"+profile.getEmail()+"</a></p>"
                    + "<p><strong>Website: </strong> "+cv.getReferences()+"</p>"
                    + "</div>"; 
            html += "</div><br/>";   //close intro
            html += "<div class=\"container_12\" style=\"margin-top:-10px;\">";     // summary
            html +="<p class=\"grid_12\"><img src=\"tick.jpg\" width=\"24px\" height=\"24px\"></img><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong><u>SUMARY&#09;&#09;&#09;&#09;&#09;&#09;&#09; </u></strong></label></p>";
            html += "<p class=\"grid_12\" style=\"margin-top:-10px; margin-left:10px;\">"+profile.getDescription()
                    + "<table width=\"900px\">"
                    + "<tr><th width=\"100px\"></th><th width=\"790px\"></th></tr>"
                    + "<tr><td>My Target Job: </td><td>"+cv.getTargetJob()+"</td></tr>"
                   
                    + "</table>"
                    + "</p>"
                    + "</div><hr/>";                       // close sumary
            html += "<div class=\"container_12\" style=\"margin-top:-30px;\">"; //education
            html +="<div class=\"grid_12\"><img src=\"tick.jpg\" width=\"24px\" height=\"24px\"></img><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong><u>EDUCATION&#09;&#09;&#09;&#09;&#09;&#09;&#09; </u></strong></label></div>";
            html += "<div class=\"grid_12\" style=\"margin-top:-10px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"700px\">"
                    + "<tr><th width=\"400px\"></th><th width=\"100px\"></th></tr>";
            for(int i=0;i<lstEducation.size();i++){
                
                html+="<tr><td><ul><li>"+lstEducation.get(i).getEducation().getTitile()+"</li><br/><ul><dd>"+lstEducation.get(i).getEducation().getDetail()+"</dd></ul></ul></td><td>"+lstEducation.get(i).getPeriodTime()+"</td></tr><hr/>";
            }
            html += "</table>"
                    + "</div>"
                    + "</div>";     //close education
            html += "<div class=\"container_12\" style=\"margin-top:-30px;\">"; //Skill
            html +="<div class=\"grid_12\"><img src=\"tick.jpg\" width=\"24px\" height=\"24px\"></img><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong><u>PROFESSIONAL SKILL&#09;&#09;&#09;&#09;&#09;&#09;&#09; </u></strong></label></div>";
            html += "<div class=\"grid_12\" style=\"margin-top:10px; margin-left:10px;padding-right:10px; float:bottom;\">"
                    + "<table width=\"960px\">"
                    + "<tr><th width=\"300px\"></th><th width=\"300px\"></th><th width=\"360px\"></th></tr>";
            String html1="";
            String html2="";
            for(int i=0;i<lstSkill.size();i++){
                if(lstSkill.get(i).getIdkindskill().getNamekindshow().equals("progress")){
                    html1 += "<tr><td colspan=\"2\"><dl>"+lstSkill.get(i).getName().toUpperCase()+"<dt>";
                    for(int j=0;j<lstSkill.get(i).getDegree();j++){
                        html1 += "<img src=\"star1.jpg\" width=\"15px\" height=\"15px\" ></img>";
                    }
                    for(int j =0;j < (5 - lstSkill.get(i).getDegree());j++){
                        html1 += "<img src=\"star2.jpg\" width=\"15px\" height=\"15px\"></img>";
                    }
                    html1 += "</dt></dl></td></tr>";
                
                }            
            }
            
            for(int i=0;i< lststoreSkill.size();i++){
                if(lststoreSkill.get(i).getSkill().getIdkindskill().getIdkindskill().toString().equals("2")){
                   html2+="<tr><td colspan=\"2\"><dt>"+lststoreSkill.get(i).getSkill().getName()+"</dt>"; 
                   for(int j =0 ;j < lststoreSkill.get(i).getPeriodTime().split(";").length;j++){
                        html2 += "<dd>"+  lststoreSkill.get(i).getPeriodTime().split(";")[j]+"</dd>";
                   }
                   html2+="</td></tr>";
                
                }
            }
            
            
            String html3 ="<p><em>I also good at </em>";
            for(int i=0;i<lstAnortherSkill.size();i++){
                html3+="<label>"+lstAnortherSkill.get(i).getName()+", </label>";
            }
            html3+="...</p>";
            
            html += "<tr>"
                    + "<td>"
                    + "<table style=\"margin-top:-10px; margin-bottom:-10px;\">"
                    + "<tr><th width=\"200px;\"></th><th width=\"100px;\"></th></tr>"
                    + html1
                    + "</table>"
                
                    + "</td>"
                    + "<td>"
                    + "<table>"
                    + "<tr><th width=\"50px\"></th><th width=\"150px;\"></th><th width=\"100px;\"></th></tr>"
                    + html2
                    + "</table>"
                    + "</td><td></td>"
                    + "</tr>"
                    + "<tr><td colspan=\"2\">"
                    + html3
                    + "</td></tr>"; 
            html += "</table>"
                    + "</div></div>";     // close skill
            
            html += "<div class=\"container_12\" style=\"margin-top:-10px;\">"; //Experiences
            html +="<div class=\"grid_12\"><img src=\"tick.jpg\" width=\"24px\" height=\"24px\"></img><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong><u>EXPERIENCES&#09;&#09;&#09;&#09;&#09;&#09;&#09; </u></strong></label></div>";
            html += "<div class=\"grid_12\" style=\"margin-top:-10px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"700px\">"
                    + "<tr><th width=\"400px\"></th><th width=\"100px\"></th></tr>";
            for(int i=0;i<lstExperiences.size();i++){
                html+="<tr style=\"padding-top:-10px;\"><td><ul><li>"+lstExperiences.get(i).getSpecialized().getName()+"</li><br/><ul><dd>"+lstExperiences.get(i).getDescription()+"</dd></ul></ul></td><td>"+lstExperiences.get(i).getYear()+"(Year )</td></tr>";
            }
            html += "</table>"
                    + "</div>"
                    + "</div>"; //close experiences
             html += "<div class=\"container_12\" style=\"margin-top:-10px;\">"; //activity
            html +="<div class=\"grid_12\"><img src=\"tick.jpg\" width=\"24px\" height=\"24px\"></img><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong><u>ACTIVITY&#09;&#09;&#09;&#09;&#09;&#09;&#09; </u></strong></label></div>";
            html += "<div class=\"grid_12\" style=\"margin-top:-10px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"700px\">"
                    + "<tr><th width=\"400px\"></th><th width=\"100px\"></th></tr>";
            for(int i=0;i<lstactivity.length;i++){
                html+="<tr><td><ul><li>"+lstactivity[i]+"</li><br/><ul><dd>"+"</dd></ul></ul></td><td>"+"(Year )</td></tr><hr/>";
            }
            html += "</table>"
                    + "</div>"
                    + "</div>";
            
             html += "<div class=\"container_12\" style=\"margin-top:-10px;\">"; //Prize
            html +="<div class=\"grid_12\"><img src=\"tick.jpg\" width=\"24px\" height=\"24px\"></img><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong><u>PRIZE&#09;&#09;&#09;&#09;&#09;&#09;&#09; </u></strong></label></div>";
            html += "<div class=\"grid_12\" style=\"margin-top:-10px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"700px\">"
                    + "<tr><th width=\"400px\"></th><th width=\"100px\"></th></tr>";
            for(int i=0;i<lstPrize.length;i++){
                html+="<tr><td><ul><li>"+lstPrize[i]+"</li><br/><ul><dd>"+"</dd></ul></ul></td><td>"+"(Year )</td></tr><hr/>";
            }
            html += "</table>"
                    + "</div>"
                    + "</div>";
            
            
            html+="\n</body>\n";
            html+= "</html>";
                
                //html="<html><head><style>body{color:red;}</style></head><body>PTS</body></html>";
                System.out.print(html);
             //SharedContext sharedContext = doc.getSharedContext();
             //sharedContext.setPrint(true);
             //sharedContext.setInteractive(false);
             //sharedContext.setReplacedElementFactory(new ProfileImageReplacedElementFactory());
             //sharedContext.getTextRenderer().setSmoothingThreshold(0);
             doc.setDocumentFromString(html, "file:///"+path+"/");
            
             //doc.setPDFVersion(Character.MAX_VALUE);
             
             return doc;
        }
        
        if(kindCv == 3){
            String html="";
            String html2="";
            
            html += htmlcssbody;
            html += "\n<body>\n";
            html += "<div class=\"center-block\" style=\"margin-bottom:10px;\"><strong>CURRICULUM VITEA</strong></div><hr/>"; 
            html += "<div class=\"container_12\">";
            html += "<div class=\"grid_3 clearfix background-grey\" style=\"height:900px;\">"
                    + "<h2 class=\"center-block\" style=\"color: #000000; margin-left=50px;\">"+profile.getFirstName() +" "+profile.getLastName()+"</h2>"
                    + "<h3 class=\"center-block\" style=\"color: #008080;\"><u>"+cv.getMore()+"</u></h3>"
                    + "<p class=\"center-block\"><img src =\""+profile.getIdUser().getIdUser().toString()+".jpg"+"\" width=\"150px;\" height=\"150px;\" ></img></p>"                //your avatar
                    + "<p style=\"font-size:12px; padding-left:5px; margin-left:25px;\"><strong>Decription </strong>"+profile.getDescription()+"</p>"
                    + "<p style=\"font-size:12px; padding-left:5px; margin-left:25px;\"><strong>Target Job </strong>"+cv.getTargetJob()+"</p>"
                    + "<p style=\"font-size:12px; padding-left:5px; margin-left:25px;\"><strong>Hobbit </strong>"+cv.getHobbit()+"</p>"
                    + "<p class=\"center-block\" style=\"font-size:12px; padding-left:3px; margin-top:30px; color: #008080;\"><strong></strong>"+profile.getPhone()+"</p>"
                    + "<p class=\"center-block\" style=\"font-size:12px; padding-left:3px; \"><strong></strong><a>"+profile.getEmail()+"</a></p>"
                    + "<p class=\"center-block\" style=\"font-size:12px; margin-left:5px; padding-left=3px; padding-right:3px; margin-bottom:0px; color: #1E90FF;\"><strong></strong><a target=\"_blank\" style=\"color: #000000; font-size:60%\" href=\""+cv.getReferences()+"\">"+cv.getReferences()+"</a></p>"
                    + "</div>";
            html += "<div class=\"grid_6 push_1\">";
            
            html += "<div style=\"margin-top:10px; border-bottom: #bbb dotted 1px;\">"; //Experience
            html +="<div><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong>EXPERIENCES WORKING&#09;&#09;&#09;&#09;&#09;&#09;&#09;</strong></label></div>";
            html += "<div style=\"margin-top:-10px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"450px\" style=\"margin-bottom:-10px;\">"
                    + "<tr><th width=\"180px\"></th><th width=\"50px\"></th></tr>";
            for(int i=0;i<lstExperiences.size();i++){
                html+="<tr style=\"margin-bottom: -10px; \"><td><ul><li style=\"color:#008080; \">"+lstExperiences.get(i).getSpecialized().getName()+"</li><br/><ul><dd>"+lstExperiences.get(i).getDescription()+"</dd></ul></ul></td><td>"+lstExperiences.get(i).getYear()+"(Year)</td></tr>";
            }
            html += "</table>"
                    + "</div>"
                    + "</div>";     //close Experiences
            
            html += "<div style=\"margin-top:10px; border-bottom: #bbb dotted 1px;\">"; //education
            html +="<div><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong>EDUCATION&#09;&#09;&#09;&#09;&#09;&#09;&#09;</strong></label></div>";
            html += "<div style=\"margin-top:-10px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"450px\">"
                    + "<tr><th width=\"180px\"></th><th width=\"50px\"></th></tr>";
            for(int i=0;i<lstEducation.size();i++){
                html+="<tr style=\"margin-top: -10px;\"><td><ul><li style=\"color:#008080; \">"+lstEducation.get(i).getEducation().getTitile()+"</li><br/><ul><dd>"+lstEducation.get(i).getEducation().getDetail()+"</dd></ul></ul></td><td>"+lstEducation.get(i).getPeriodTime()+"</td></tr>";
            }
            html += "</table>"
                    + "</div>"
                    + "</div>";     //close education
            
            html += "<div style=\"margin-top:10px; border-bottom: #bbb dotted 1px;\">"; //Skills
            html +="<div><label style=\"font-size:20px; color:#1E90FF; margin-left:5px;\"><strong>SKILLS&#09;&#09;&#09;&#09;&#09;&#09;&#09; </strong></label></div>";
            html += "<div style=\"margin-top:-8px; margin-left:10px;padding-right:10px;\">"
                    + "<table width=\"450px\">"
                    + "<tr><th width=\"\"></th><th width=\"\"></th></tr>";
           
            String html1="";
            
            for(int i=0;i<lstSkill.size();i++){
                if(lstSkill.get(i).getIdkindskill().getNamekindshow().equals("progress")){
                    html1 += "<tr style=\"margin-bottom:-10px; margin-top:-20px;color: #008080; text-align:right;\"><td>"+lstSkill.get(i).getName().toUpperCase()+"</td><td>";
                    html1 += "<p class=\"progress\" style=\"line-height:50%; margin-bottom:-10px;\">"
                                + "<p class=\"progress-bar progress-color-x\" role=\"progressbar\" aria-valuenow=\""+lstSkill.get(i).getDegree()*20+"\"  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:"+lstSkill.get(i).getDegree()*20+"%;\">"
                                + "</p>"
                                + "</p>";
                    html1 += "</td></tr>";   
                   
                }            
            }
            
            for(int i=0;i< lststoreSkill.size();i++){
                if(lststoreSkill.get(i).getSkill().getIdkindskill().getIdkindskill().toString().equals("2")){
                   html2+="<tr><td colspan=\"2\"><dt style=\"color: #008080;\">"+lststoreSkill.get(i).getSkill().getName()+"</dt>"; 
                   for(int j =0 ;j < lststoreSkill.get(i).getPeriodTime().split(";").length;j++){
                        html2 += "<dd>"+  lststoreSkill.get(i).getPeriodTime().split(";")[j]+"</dd>";
                   }
                   html2+="</td></tr>";
                
                }
            }
            
            
            
            html += html1;
            html += "</table>"
                    + "<table width=\"450px\">"
                    + "<tr><th width=\"180px\"></th><th width=\"50px\"></th></tr>"
                    + html2
                    + "</table>"
                    + "</div>"
                    + "</div>"
                    + "<div>"
                    + "<p style=\"margin-left:20px;\"><h3><strong>Activity</strong></h3></p>"
                    + "<ul>";
            for(int i=0 ;i < lstactivity.length;i++ ){
                html+="<li>"+lstactivity[i]+"</li>";
            }
            html += "</ul></div>"
                    + "<div><p style=\"margin-left:20px;\"><h3>Prize</h3></p>"
                    + "<ul>";
            for(int i=0;i<lstPrize.length ;i++){
                html+="<li>"+lstPrize[i]+"</li>";
            }
                    
                        html+= "</ul>"
                                + "</div>";     
            
            
            
            
            html += "</div></div>";   //close main
                                 
            
            
            html+="\n</body>\n";
            html+= "</html>";
                
                //html="<html><head><style>body{color:red;}</style></head><body>PTS</body></html>";
                System.out.println(html);
               
             //SharedContext sharedContext = doc.getSharedContext();
             //sharedContext.setPrint(true);
             //sharedContext.setInteractive(false);
             //sharedContext.setReplacedElementFactory(new ProfileImageReplacedElementFactory());
             //sharedContext.getTextRenderer().setSmoothingThreshold(0);
             doc.setDocumentFromString(html, "file:///"+path+"/");
            
             //doc.setPDFVersion(Character.MAX_VALUE);
             
             return doc;
        }
        
        
        return doc;
    }
    
    
    
    
}
