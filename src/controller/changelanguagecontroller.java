package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class changelanguagecontroller extends Action {

	@Override
	public ActionForward execute(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String lang=req.getParameter("lang");
		Locale locale=new Locale(lang);
		HttpSession session=req.getSession();
		session.setAttribute("org.apache.struts.action.LOCALE", locale);
		
		return am.findForward("langchanged");
	}
	
}
