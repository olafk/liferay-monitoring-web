package com.liferay.sales.monitoring.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletContext;
import com.liferay.portal.kernel.util.HtmlUtil;

import java.io.IOException;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

public class MonitoringFilter implements RenderFilter {
	public static final Log log = LogFactoryUtil.getLog(MonitoringFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
		LiferayPortletContext portletContext = (LiferayPortletContext) filterConfig.getPortletContext();
		context = HtmlUtil.escape(portletContext.getPortlet().getPortletId());
		log.debug("Filter Init " + context);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(RenderRequest request, RenderResponse response, FilterChain chain)
			throws IOException, PortletException {
		Date start = new Date();
		chain.doFilter(request, response);
		Date finished = new Date();
		long elapsed = finished.getTime() - start.getTime();

		response.getWriter().append("<span class=\"stopwatch\">" + elapsed + " ms render time</span>");
		log.info(elapsed + " milliseconds in " + context);
	}

	private String context;
}
