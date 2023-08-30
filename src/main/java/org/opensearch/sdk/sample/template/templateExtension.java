package org.opensearch.sdk.sample.template;

import java.io.IOException;
import java.util.List;

import org.opensearch.sdk.api.ActionExtension;
import org.opensearch.sdk.BaseExtension;
import org.opensearch.sdk.rest.ExtensionRestHandler;
import org.opensearch.sdk.ExtensionSettings;
import org.opensearch.sdk.ExtensionsRunner;

public class templateExtension extends BaseExtension implements ActionExtension {

	public templateExtension() {
		// Optionally pass a String path to a YAML file with these settings
		super(new ExtensionSettings("template", "127.0.0.1", "4532", "127.0.0.1", "9200"));
	}

	@Override
	public List<ExtensionRestHandler> getExtensionRestHandlers() {
		return List.of(new templateAction(extensionsRunner()));
	}

	public static void main(String[] args) throws IOException {
		ExtensionsRunner.run(new templateExtension());
	}
}
