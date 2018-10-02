package exception;
/**
 * 重复秒杀异常
 * @author developerzzp
 * 编译器一行，运行期异常，Spring事务管理，回滚，运行期异常
 *
 */
public class RepectException extends SeckillException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RepectException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RepectException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
