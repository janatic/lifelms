package com.liferay.lms.asset;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import com.liferay.lms.model.LearningActivity;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

public class TestAssetRenderer extends BaseAssetRenderer {

	private LearningActivity _learningactivity;
	public TestAssetRenderer (LearningActivity learningactivity) {
		_learningactivity = learningactivity;
		}
		public long getClassPK() {
		return _learningactivity.getActId();
		}
		public long getGroupId() {
		return _learningactivity.getGroupId();
		}
		public String getSummary() { 
		return _learningactivity.getDescription();
		} 
		public String getTitle() { 
		return _learningactivity.getTitle(); 
		} 
		public long getUserId() {
		return _learningactivity.getUserId();
		}
		public String getUuid() {
		return _learningactivity.getUuid();
		}
		public String render(RenderRequest request, RenderResponse response,
		String template)
		throws Exception {
			if (template.equals(TEMPLATE_FULL_CONTENT)) {
				request.setAttribute("learningactivity", _learningactivity);
				
				return "/html/test/" + template + ".jsp";
				}
				else {
				return null;
				}
				
				
			}
			public PortletURL getURLEdit(
					LiferayPortletRequest liferayPortletRequest,
					LiferayPortletResponse liferayPortletResponse) throws Exception 
			{

				
				 HttpServletRequest request =
				            liferayPortletRequest.getHttpServletRequest();

				 ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				            WebKeys.THEME_DISPLAY);
				     
				 PortletURL portletURL= 
				  PortletURLFactoryUtil.create(request,"lmsactivitieslist_WAR_liferaylmsportlet",
						  getControlPanelPlid(themeDisplay), PortletRequest.RENDER_PHASE);
				           portletURL.setParameter("mvcPath", "/html/lmsactivitieslist/test/edit.jsp");
				          portletURL.setParameter(
									"actId",Long.toString( _learningactivity.getActId()));
				     			
					return portletURL;
			}
			@Override
			public String getURLViewInContext(
					LiferayPortletRequest liferayPortletRequest,
					LiferayPortletResponse liferayPortletResponse,
					String noSuchEntryRedirect) throws Exception {
				// TODO Auto-generated method stub
				PortletURL viewPortletURL = liferayPortletResponse.createRenderURL("execactivity_WAR_liferaylmsportlet");
	            viewPortletURL.setWindowState(LiferayWindowState.MAXIMIZED);
				viewPortletURL.setParameter(
					"jspPage", "/html/execactivity/test/view.jsp");
				viewPortletURL.setParameter(
					"actId",Long.toString( _learningactivity.getActId()));
			

				return viewPortletURL.toString();
			}
			@Override
			public String getViewInContextMessage() {
				// TODO Auto-generated method stub
				
				return "Exec test";
			}
			@Override
			public boolean hasEditPermission(PermissionChecker permissionChecker)
					throws PortalException, SystemException {
				// TODO Auto-generated method stub
				if(permissionChecker.hasPermission(this.getGroupId(), LearningActivity.class.getName(), this.getClassPK(),
						ActionKeys.UPDATE))
				{
				return true;
				}
				else
				{
					return false;
				}
			}
			//@Override
			public String getSummary(Locale arg0) {
				
				return getSummary();
			}
			//@Override
			public String getTitle(Locale arg0) {
				// TODO Auto-generated method stub
				return getTitle();
			}
   
	

}
