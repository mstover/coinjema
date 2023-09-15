package org.coinjema.config;

import java.io.File;
import java.io.Reader;

public class TestInput {
	public final String gibberish;
	public final int year;
	public final EmailPropertiesClass emailProperties;

	public class EmailPropertiesClass {
		public final double ip;
		public final File emailText;
		public final String body;
		public final HeaderClass header;

		public class HeaderClass {
			public final ToClass to;

			public class ToClass {
				public final int port;
				public final File serverProps;

				public ToClass() {
					port = 44;

					serverProps = new File("/");

				}
			}

			public final String subject;

			public HeaderClass() {
				to = new ToClass();

				subject = null;

			}
		}

		public final String from;

		public EmailPropertiesClass() {
			ip = 5.444;

			emailText = new File("/");

			body = null;

			header = new HeaderClass();

			from = null;

		}
	}

	public final String name;

	private TestInput(Reader r) {
		gibberish = null;
		year = 65;
		emailProperties = new EmailPropertiesClass();
		name = null;
	}

}