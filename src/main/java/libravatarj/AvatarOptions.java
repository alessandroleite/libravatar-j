package libravatarj;

import com.google.common.base.Preconditions;

public class AvatarOptions {

	/**
	 * Specifies a custom base URI for HTTP use. The default is to use the
	 * official libravatar HTTP server. If you *really* wanted to use a non-free
	 * server, you could set this to "http://gravatar.com/avatar/", but why
	 * would you do such a thing?
	 */
	protected final String baseUri = "http://cdn.libravatar.org/avatar/";

	/**
	 * Specifies a custom base URI for HTTPS use. The default is to use the
	 * official libravatar HTTPS server.
	 */
	protected final String secureBaseUri = "https://seccdn.libravatar.org/avatar/";

	/**
	 * Produce https:// URIs where possible. This avoids mixed-content warnings
	 * in browsers when using libravatar-sharp from within a page served via
	 * HTTPS.
	 **/
	private boolean useHttps;

	/**
	 * Use the SHA256 hash algorithm, rather than MD5. SHA256 is significantly
	 * stronger, but is not supported by Gravatar, so libravatar's fallback to
	 * Gravatar for missing images will not work. Note that using
	 * AvatarUri.FromOpenID implicitly uses SHA256.
	 */
	private boolean useSHA256;

	/**
	 * URI for a default image, if no image is found for the user. This also
	 * accepts any of the "special" values in AvatarDefaultImages
	 */
	private LibravatarDefaultImage defaultImage = LibravatarDefaultImage.DEFAULT;

	/**
	 * Size of the image requested. Valid values are between 1 and 512 pixels.
	 * The default size is 80 pixels.
	 */
	private Integer imageSize;

	public AvatarOptions withHttps() {
		this.useHttps = true;
		return this;
	}

	public AvatarOptions useSHA256() {
		this.useSHA256 = true;
		return this;
	}

	public AvatarOptions withImageSize(final Integer imageSize) {
		Preconditions.checkArgument(imageSize >= 1 && imageSize <= 512);
		this.imageSize = imageSize;
		return this;
	}

	public AvatarOptions withoutHttps() {
		this.useHttps = false;
		return this;
	}

	public boolean isUseHttps() {
		return useHttps;
	}

	public boolean isUseSHA256() {
		return useSHA256;
	}

	public LibravatarDefaultImage getDefaultImage() {
		return defaultImage;
	}

	public Integer getImageSize() {
		return imageSize;
	}
}