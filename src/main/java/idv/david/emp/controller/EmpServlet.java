package idv.david.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import idv.david.emp.entity.Emp;
import idv.david.emp.service.EmpService;
import idv.david.emp.service.EmpServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emp/emp.do")
public class EmpServlet extends HttpServlet {
	// 一個 servlet 實體對應一個 service 實體
	private EmpService empService;

	@Override
	public void init() throws ServletException {
		empService = new EmpServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
		case "getAll":
			forwardPath = getAllEmps(req, res);
			break;
		case "compositeQuery":
			forwardPath = getCompositeEmpsQuery(req, res);
			break;
		default:
			forwardPath = "/index.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAllEmps(HttpServletRequest req, HttpServletResponse res) {
		String page = req.getParameter("page");
		int currentPage = (page == null) ? 1 : Integer.parseInt(page);

		List<Emp> empList = empService.getAllEmps(currentPage);

		if (req.getSession().getAttribute("empPageQty") == null) {
			int empPageQty = empService.getPageTotal();
			req.getSession().setAttribute("empPageQty", empPageQty);
		}

		req.setAttribute("empList", empList);
		req.setAttribute("currentPage", currentPage);

		return "/emp/listAllEmps.jsp";
	}

	private String getCompositeEmpsQuery(HttpServletRequest req, HttpServletResponse res) {
		Map<String, String[]> map = req.getParameterMap();

		if (map != null) {
			List<Emp> empList = empService.getEmpsByCompositeQuery(map);
			req.setAttribute("empList", empList);
		} else {
			return "/index.jsp";
		}
		return "/emp/listCompositeQueryEmps.jsp";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
