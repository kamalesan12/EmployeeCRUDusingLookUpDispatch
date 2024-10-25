package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import Beans.EmpRegFormBean;
import Emp_reg_DAO.EmpRegDAO;

public class EmpRegControllerDisp extends DispatchAction {
	

	public ActionForward save(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		EmpRegFormBean emregFB=(EmpRegFormBean) af;
		EmpRegDAO emdao=new EmpRegDAO();
		int i=emdao.save(emregFB.getId(), emregFB.getName(),emregFB.getEmail(),emregFB.getAddress());
		if(i!=0)
			return am.findForward("success");
		else 
			return am.findForward("failure"); 
	}
	
	public ActionForward update(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		EmpRegFormBean emregFB=(EmpRegFormBean) af;
		EmpRegDAO emdao=new EmpRegDAO();
		boolean i=emdao.update(emregFB.getId(), emregFB.getName(),emregFB.getEmail(),emregFB.getAddress());
		if(i==true)
			return am.findForward("success");
		else 
			return am.findForward("failure"); 
	}
	
	public ActionForward delete(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		EmpRegFormBean emregbean=(EmpRegFormBean) af;
		EmpRegDAO emdao=new EmpRegDAO();
		int i=emdao.delete(emregbean.getId());
		if(i!=0)
		    return am.findForward("deleted");
		else
			return am.findForward("notdeleted");
	}


}
