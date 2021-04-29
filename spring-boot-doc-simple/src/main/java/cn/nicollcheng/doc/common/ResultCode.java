package cn.nicollcheng.doc.common;

public enum  ResultCode implements Code{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    CHAT_USER_NOT_ONLINE(405, "用户不在线"),
    ILLEGAL_IP_ACCESS(406, "非法IP访问"),
    ILLEGAL_FILE(407, "非法文件"),
    UPLOAD_FAILED(408, "上传失败");
	
	private long code;
	private String message;

	private ResultCode(long code, String message) {
		this.code = code;
		this.message = message;
	}

	public long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
