//package dao;
//
//import javax.annotation.Resource;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//@RunWith(SpringJUnit4ClassRunner.class)
////告诉Jnit Spring 配置文件
//@ContextConfiguration({"classpath:spring/spring-dao.xml"})
//public class SuccessKilledDaoTest {
//	@Resource
//	private SuccessKilledDao successKilledDao;
//	@Test
//	public void testInsertSuccessKill() {
//		long seckillId = 1000;
//		long userPhone = 18487;
//		int n = successKilledDao.insertSuccessKill(seckillId, userPhone);
//		System.out.println(n);
//	}
//	/*@Test
//	public void testQueryByIdWithSuccessKill() {
//		long seckillId = 1000;
//		List<SuccessKilled> seckills = successKilledDao.queryByIdWithSuccessKill(seckillId);
//		for(SuccessKilled successKilled:seckills) {
//			System.out.println(successKilled);
//			
//		}
//	}*/
//
//}
