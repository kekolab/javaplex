package kekolab.javaplex.model;

public interface WithCollections<CollectionsType extends PlexCollections<S>, S extends PlexSection<?, ?>> {
    CollectionsType collections();
}
