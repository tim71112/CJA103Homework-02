package dawuHomework.filter;

import java.io.IOException;
import org.hibernate.SessionFactory;
import dawuHomework.util.HibernateUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "*.do", "*.jsp" }) // 攔截所有 Servlet 與 JSP
public class OpenSessionInViewFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			factory.getCurrentSession().beginTransaction(); // 開始交易
			chain.doFilter(request, response);
			factory.getCurrentSession().getTransaction().commit(); // 提交交易
		} catch (Exception e) {
			if (factory.getCurrentSession().getTransaction().isActive()) {
				factory.getCurrentSession().getTransaction().rollback(); // 出錯就回滾
			}
			e.printStackTrace();
			chain.doFilter(request, response);
		}
	}
}