package dawuHomework.emp.service;

import java.util.List;

// 1. 關鍵修正：必須 import DAO 介面與實作類
import dawuHomework.emp.dao.EmpDAO;
import dawuHomework.emp.dao.EmpDAOImpl;
// 2. 關鍵修正：必須 import 實體類
import dawuHomework.emp.entity.Emp;
// 3. 關鍵修正：修正 Constants 的路徑
import static dawuHomework.util.Constants.PAGE_MAX_RESULT;

public class EmpServiceImpl implements EmpService {
	
	// 如果下面這行 new 報錯，通常是因為上面的 import 沒寫對
	private EmpDAO dao = new EmpDAOImpl();
	
	@Override
	public List<Emp> getAllEmps(int currentPage) {
		return dao.getAll(currentPage);
	}

	@Override
	public int getPageTotal() {
		long total = dao.getTotal();
		int pageQty = (int)(total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}
}