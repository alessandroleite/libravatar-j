package libravatarj;

public enum LibravatarDefaultImage {

	DEFAULT(""),
	
	MM("mm"),

	IDENTICON("identicon"),

	MONSTERID("monsterid"),

	WAVATAR("wavatar"),

	RETRO("retro"),

	NOT_FOUND("404");

	private final String code;

	private LibravatarDefaultImage(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}