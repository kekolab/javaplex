package kekolab.javaplex;

import java.io.IOException;

import com.fasterxml.jackson.databind.node.ObjectNode;

import kekolab.javaplex.mappers.ObjectNodeDeserializer;
import kekolab.javaplex.model.PlexMovieSection;
import kekolab.javaplex.model.PlexMusicSection;
import kekolab.javaplex.model.PlexPhotoSection;
import kekolab.javaplex.model.PlexShowSection;

public class DirectoryDeserializer extends ObjectNodeDeserializer<Directory> {
	private static final long serialVersionUID = 7550593827443213344L;

	public DirectoryDeserializer() {
		super(Directory.class);
	}

	protected Class<? extends Directory> chooseDeserializingClass(ObjectNode node) throws IOException {
		if (node.has("composite")) {
			String composite = extractTextFieldValueFromObjectNode(node, "composite");
			if (composite.contains("sections")) {
				String type = extractTextFieldValueFromObjectNode(node, "type");
				if (type.equalsIgnoreCase(PlexShowSection.TYPE_DESCRIPTION))
					return ShowSection.class;
				if (type.equalsIgnoreCase(PlexMovieSection.TYPE_DESCRIPTION))
					return MovieSection.class;
				if (type.equalsIgnoreCase(PlexMusicSection.TYPE_DESCRIPTION))
					return MusicSection.class;
				if (type.equalsIgnoreCase(PlexPhotoSection.TYPE_DESCRIPTION))
					return PhotoSection.class;
					// TODO Log that it was impossible to deserialize this type of section
				throw new IOException("Cannot determine the right class to deserialize directory with type " + type);
			} else {
				// TODO Log that it was impossible to deserialize a node with composite set to something different from "composite"
			}
		}

		if (node.has("fastKey")) 			
			return SectionSecondaryDirectory.class;		

		// TODO Log that we're deserializing to the default implementation of PlexDirectory
		return Directory.class;
	}
}
