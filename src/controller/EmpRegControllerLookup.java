package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.activation.ActivationDataFlavor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import Beans.EmpRegFormBean;
import Emp_reg_DAO.EmpRegDAO;

public class EmpRegControllerLookup extends LookupDispatchAction {
	


	@Override
	protected HashMap<String,Object> getKeyMethodMap(){
		HashMap<String,Object> m=new HashMap<>();
		m.put("save","empsave");
		m.put("update","empupdate");
		m.put("delete", "empdelete");
		m.put("find", "empfind");
		return m;
	}

	public ActionForward empsave(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		EmpRegFormBean EmpRF=(EmpRegFormBean) form;
		
		EmpRegDAO empda=new EmpRegDAO();
		int i=empda.save(EmpRF.getId(), EmpRF.getName(), EmpRF.getEmail(), EmpRF.getAddress());
		if(i!=0)
			return mapping.findForward("success"); 
		else
			return mapping.findForward("failure");
	}
	
	public ActionForward empupdate(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
				EmpRegFormBean EmpRF=(EmpRegFormBean) form;
				EmpRegDAO empda=new EmpRegDAO();
				boolean b=empda.update(EmpRF.getId(), EmpRF.getName(), EmpRF.getEmail(), EmpRF.getAddress());
				if(b==true)
					return mapping.findForward("success");
				else
					return mapping.findForward("failure");				
			}
	
	public ActionForward empdelete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
		EmpRegFormBean emregbean=(EmpRegFormBean) form;
		EmpRegDAO emdao=new EmpRegDAO();
		int i=emdao.delete(emregbean.getId());
		if(i!=0)
		    return mapping.findForward("deleted");
		else
			return mapping.findForward("notdeleted");

	}
	
	public ActionForward empfind(ActionMapping am,ActionForm af,HttpServletRequest req,HttpServletResponse res)throws Exception{
		
		EmpRegFormBean emp=(EmpRegFormBean) af;
		EmpRegDAO empdao=new EmpRegDAO();
		
		ArrayList<HashMap<String,Object>> emplist;
		emplist=(ArrayList<HashMap<String,Object>>) empdao.find(emp.getId());
		
		System.out.println(emplist.getClass().getName());
		
		if(!emplist.isEmpty() && !emplist.equals(null)){
		System.out.println("With type casting :"+emplist);
		System.out.println(emplist.getClass().getName());
		req.setAttribute("empList", emplist);
		System.out.println(req.getAttribute("empList"));
		 return am.findForward("founded");
		}else{
			return am.findForward("failure");
		}
				
	}
	

}
