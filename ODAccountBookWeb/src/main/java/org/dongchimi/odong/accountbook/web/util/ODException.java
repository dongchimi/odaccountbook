package org.dongchimi.odong.accountbook.web.util;

public class ODException extends RuntimeException {

	/** UID */
	private static final long serialVersionUID = -6293405867231961062L;

	public ODException() {
		super();
	}
	
    public ODException(String message) {
        super(message);
    }
}
