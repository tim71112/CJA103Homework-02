package dawuHomework.listener;

import dawuHomework.util.HibernateUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InitializerListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 伺服器啟動時，預先初始化 Hibernate SessionFactory
		HibernateUtil.getSessionFactory();
		System.out.println("Hibernate SessionFactory 已初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 伺服器關閉時，關閉資源
		HibernateUtil.shutdown();
		System.out.println("Hibernate SessionFactory 已關閉");
	}
}