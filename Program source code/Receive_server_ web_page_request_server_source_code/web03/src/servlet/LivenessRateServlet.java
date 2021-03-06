package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handle.LivenessHandler;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LivenessRateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] Arr=LivenessHandler.GetLivenessRate();
		JSONArray ja = JSONArray.fromObject(Arr);
		JSONObject jo=new JSONObject();
		jo.put("Rate", ja);
		System.out.println(jo);
		resp.getOutputStream().write(jo.toString().getBytes());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
