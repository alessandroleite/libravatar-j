package libravatarj;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import com.google.common.base.Preconditions;

public class AvatarUri implements FromBuilder {

	private String email;
	private AvatarOptions options = new AvatarOptions().withoutHttps();

	/**
	 * 
	 * @param email
	 * @return
	 */
	public AvatarUri from(final String email) {
		this.email = Preconditions.checkNotNull(email).toLowerCase();
		return this;
	}
	
	/**
	 * 
	 * @param options
	 * @return
	 */
	public AvatarUri withOptions(AvatarOptions options){
		this.options = options;
		return this;
	}

	/**
	 * 
	 * @param options
	 * @return
	 */
	public byte[] download(AvatarOptions options) {
		this.options = options;
		return this.download();
	}

	/***
	 * 
	 * @return
	 */
	public byte[] download() {		
		InputStream is = null;
		try {
			URL url = new URL(this.buildUrl());
			return IOUtils.toByteArray(is = url.openStream());
		} catch (IOException exception) {
			throw new AvatarException(exception);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	private String buildUrl() {
		StringBuilder sb = new StringBuilder(
				!this.options.isUseHttps() ? this.options.baseUri
						: this.options.secureBaseUri);
		
		sb.append(!this.options.isUseSHA256() ? DigestUtils.md5Hex(this.email
				.getBytes()) : DigestUtils.sha256Hex(this.email.getBytes()));
		sb.append(this.options.getImageSize());

		return sb.toString();
	}
}