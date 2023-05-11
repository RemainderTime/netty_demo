package cn.xf.im.constants;

/**
 * @Description:
 * @ClassName: CommondConstant
 * @Author: xiongfeng
 * @Date: 2023/5/11 15:28
 * @Version: 1.0
 */
public class ImConstant {

	public static final String AppId = "appId";

	public static  final String UserId = "userId";

	public static final String ClientType = "clientType";

	public static final String Imei = " imei";

	public static final String ReadTime = "readTime";


	public static class CommandConstant{
		public static final  int LOGIN = 9000;

		public static final  int LOGOUT = 9001;

		public static final  int PING = 9002;

	}

	public static  class SessionConstant{
		public static final String USER_SESSION = ":userSession:";
	}

	public static  class UserStatusConstant{

		public static final Integer ONLINE = 1;

		public static final Integer OFFLINE = 2;



	}





}
