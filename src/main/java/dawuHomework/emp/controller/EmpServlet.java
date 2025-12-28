package dawuHomework.emp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import dawuHomework.emp.dao.EmpDAO;
import dawuHomework.emp.dao.EmpDAOImpl;
import dawuHomework.emp.entity.Emp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/emp/emp.do")
// 設定上傳限制為 5MB
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class EmpServlet extends HttpServlet {

	private EmpDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new EmpDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// --- Action: 顯示圖片 (給 <img> 標籤呼叫) ---
		if ("getPic".equals(action)) {
			Integer empno = Integer.valueOf(req.getParameter("empno"));
			Emp emp = dao.getById(empno);
			if (emp != null && emp.getAttachment() != null) {
				res.setContentType("image/jpeg"); // 根據照片格式設定
				res.getOutputStream().write(emp.getAttachment());
			}
			return;
		}

		// --- Action: 查詢全部 ---
		if ("getAll".equals(action) || action == null) {
			List<Emp> list = dao.getAll();
			req.setAttribute("empList", list);
			RequestDispatcher successView = req.getRequestDispatcher("/emp/listAllEmps.jsp");
			successView.forward(req, res);
			return;
		}

		// --- Action: 取得單筆準備修改 ---
		if ("getOne_For_Update".equals(action)) {
			Integer empno = Integer.valueOf(req.getParameter("empno"));
			Emp emp = dao.getById(empno);
			req.setAttribute("emp", emp);
			RequestDispatcher successView = req.getRequestDispatcher("/emp/update_emp_input.jsp");
			successView.forward(req, res);
			return;
		}

		// --- Action: 執行修改 (Update) ---
		if ("update".equals(action)) {
			try {
				Integer empno = Integer.valueOf(req.getParameter("empno"));
				String[] jobs = req.getParameterValues("job");
				String job = (jobs != null) ? String.join(",", jobs) : "";
				String ename = req.getParameter("ename");

				Emp emp = dao.getById(empno);
				emp.setJob(job);
				emp.setEname(ename);

				// 修改時若有重新選照片
				Part part = req.getPart("up_file");
				if (part != null && part.getSize() > 0) {
					try (InputStream in = part.getInputStream()) {
						emp.setAttachment(in.readAllBytes());
					}
				}

				dao.update(emp);
				req.getRequestDispatcher("/emp/success.jsp").forward(req, res);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// --- Action: 執行新增 (Insert) ---
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			try {
				Integer comm = Integer.valueOf(req.getParameter("comm"));
				Integer sal = Integer.valueOf(req.getParameter("sal"));
				String[] jobs = req.getParameterValues("job");
				String job = (jobs != null) ? String.join(",", jobs) : "";
				String ename = req.getParameter("ename");

				// 處理圖片上傳
				Part part = req.getPart("up_file");
				byte[] attachment = null;
				if (part != null && part.getSize() > 0) {
					try (InputStream in = part.getInputStream()) {
						attachment = in.readAllBytes();
					}
				}

				Emp emp = new Emp();
				emp.setComm(comm);
				emp.setSal(sal);
				emp.setJob(job);
				emp.setEname(ename);
				emp.setAttachment(attachment);

				emp.setTargetMemberNo(0);
				emp.setResponse("尚未回覆");
				emp.setAdmNo(1);
				emp.setPriority("中");

				dao.insert(emp);
				req.getRequestDispatcher("/emp/success.jsp").forward(req, res);
				return;

			} catch (Exception e) {
				e.printStackTrace();
				errorMsgs.add("提交失敗: " + e.getMessage());
				req.getRequestDispatcher("/dawuHomework.jsp").forward(req, res);
			}
		}
	}
}