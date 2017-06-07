/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icv.ServletControl;

import java.awt.Event;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author duyng
 */
public class SessionCounter implements HttpSessionListener{

    private static int activeSessions = 0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
        activeSessions++;
        HttpSession session = se.getSession();
        session.setAttribute("totalUserOnline", activeSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se){
       if(activeSessions > 0)
            activeSessions--;
       HttpSession session = se.getSession();
       session.setAttribute("totalUserOnline", activeSessions);
    }
    
    public static int getActiveSessions(){
        return activeSessions;
    }
    
    
}
