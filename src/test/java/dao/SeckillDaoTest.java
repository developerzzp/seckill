//package dao;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import dto.Seckill;
//
///*閰嶇疆Spring鍜孞uit鏁村悎,junit鍚姩鏃跺姞杞絊pringIoc*/
//@RunWith(SpringJUnit4ClassRunner.class)
////鍛婅瘔Jnit Spring 閰嶇疆鏂囦欢
//@ContextConfiguration({"classpath:spring/spring-dao.xml"})
//public class SeckillDaoTest {
////娉ㄥ叆瀹炵幇绫�
//	@Resource
//	private SeckillDao seckillDao;
//	@Test
//	public void testReduceNumber() {
//		long seckillId = 1000;
//		Date killTime = new Date();
//		int s = seckillDao.reduceNumber(seckillId, killTime);
//		System.out.println(s);	
//	}
//	@Test
//	public void testQueryById() {
//		long id=1001;
//		Seckill seckill = seckillDao.queryById(id);
//		System.out.println("鍋氭垜濂虫湅鍙嬪ソ鍚�");
//		System.out.println(seckill);
//		System.out.println("鍋氭垜濂虫湅鍙嬪ソ鍚�");
//		//fail("Not yet implemented");
//	}
//	@Test
//	public void testQueryAll() {
//		 List<Seckill>  seckills = seckillDao.queryAll();
//		 for(Seckill seckill:seckills) {
//			 System.out.println(seckill);
//			 System.out.println("鍋氭垜濂虫湅鍙嬪ソ涓嶅ソ");
//		 }
//		
//	}
//
//}
