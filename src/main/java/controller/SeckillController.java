package controller;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import dto.Seckill;
import enums.SeckillStatusEnum;
import exception.RepectException;
import exception.SeckillCloseException;
import service.SeckillService;
import vo.Exposer;
import vo.SeckillResult;
import vo.executeResult;
@Controller
@RequestMapping("/seckill")
public class SeckillController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public String list(Model model) {
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
	}
	@RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId,Model model) {
		if(seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getOneSeckill(seckillId);
		if(seckill == null) {
			return "redirect:/seckill/list";
		}
		return "detail";
	}
	//ajax JSON
	@RequestMapping(value = "/{seckillId}/exposer",
			method = RequestMethod.POST,
			produces ="application/json;charset=UTF-8")
	@ResponseBody //返回值封装成json
	public SeckillResult<Exposer> /*TODO*/ exposer(Long seckillId) {
		SeckillResult<Exposer> rusult;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			rusult = new SeckillResult<Exposer>(true,exposer);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			rusult = new SeckillResult<Exposer>(false,e.getMessage());
		}
		return rusult;
	}
	@RequestMapping(value = "/{seckillId}/{md5}/execution",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<executeResult> execute(@PathVariable("seckillId")Long seckillId,@CookieValue(value="killPhone",required=false)Long userPhone,@PathVariable("userPhone")String md5){
		SeckillResult<executeResult> result;
		//springMVC验证信息 vaid
		if(userPhone == null) {
			return new SeckillResult<executeResult>(false,"未注册");
		}
		
		try {
			executeResult exe = seckillService.executeSeckill(seckillId, userPhone, md5);
			return new SeckillResult<executeResult>(true,exe);
		}catch(RepectException e) {
			executeResult exe = new executeResult(seckillId,SeckillStatusEnum.REPEAT_KILL);
			return new SeckillResult<executeResult>(false,exe);
		}catch(SeckillCloseException e) {
			executeResult exe = new executeResult(seckillId,SeckillStatusEnum.REPEAT_KILL);
			return new SeckillResult<executeResult>(false,exe);
		}
		catch(Exception e) {
			logger.error(e.getMessage(),e);
			executeResult exe = new executeResult(seckillId,SeckillStatusEnum.REPEAT_KILL);
			return new SeckillResult<executeResult>(false,exe);
		}
	}
	  @RequestMapping(value = "/time/now",method = RequestMethod.GET)
	  @ResponseBody
	public SeckillResult<Long> time(){
		Date now=new Date();
        return new SeckillResult<Long>(true,now.getTime());
	}
}
