package dao;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dto.Seckill;

/*配置Spring和Juit整合,junit启动时加载SpringIoc*/
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Jnit Spring 配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
//注入实现类
	@Resource
	private SeckillDao seckillDao;
	@Test
	public void testReduceNumber() {
		long seckillId = 1000;
		Date killTime = new Date();
		int s = seckillDao.reduceNumber(seckillId, killTime);
		System.out.println(s);	
	}
	@Test
	public void testQueryById() {
		long id=1001;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println("做我女朋友好吗");
		System.out.println(seckill);
		System.out.println("做我女朋友好吗");
		//fail("Not yet implemented");
	}
	@Test
	public void testQueryAll() {
		 List<Seckill>  seckills = seckillDao.queryAll();
		 for(Seckill seckill:seckills) {
			 System.out.println(seckill);
			 System.out.println("做我女朋友好不好");
		 }
		
	}

}
