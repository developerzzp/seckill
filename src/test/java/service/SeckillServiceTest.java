//package service;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import dto.Seckill;
//import vo.Exposer;
//
//@RunWith(SpringJUnit4ClassRunner.class)
////告诉Jnit Spring 配置文件
//@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
//public class SeckillServiceTest {
//	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	private SeckillService seckillService;
//	@Test
//	public void testGetSeckillList() {
//		List<Seckill> seckills = seckillService.getSeckillList();
//		for(Seckill seckill:seckills) {
//			System.out.println(seckill);
//		}
//	}
//	@Test
//	public void testGetOneSeckill() {
//		Seckill seckills = seckillService.getOneSeckill(1000);
//		System.out.println(seckills);
//	}
//	@Test
//	public void testExportSeckillUrl() {
//		long id = 1000;
//		Exposer exposer = seckillService.exportSeckillUrl(id);
//		System.out.println(exposer.toString());
//		
//	}
//	@Test
//	public void testExecuteSeckill() {
//		long seckillId = 1000;
//		long userPhone = 12434;
//		String md5 ="8a7f20b292c9363e700b742cbc7fd317";
//		seckillService.executeSeckill(seckillId, userPhone, md5);
//	}
//
//}
