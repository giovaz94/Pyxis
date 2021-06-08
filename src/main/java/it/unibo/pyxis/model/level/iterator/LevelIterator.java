package it.unibo.pyxis.model.level.iterator;

import it.unibo.pyxis.model.level.Level;
import it.unibo.pyxis.model.level.loader.LevelLoader;
import it.unibo.pyxis.model.level.loader.LevelLoaderImpl;

import java.net.URL;
import java.util.Iterator;

public final class LevelIterator implements Iterator<Level> {

    private final LevelLoader loader;
    private int currentLevel;

    public  LevelIterator(final URL confDirUrl, final int startingLevel) {
        this.loader = new LevelLoaderImpl(confDirUrl);
        this.currentLevel = startingLevel;
    }

    public LevelIterator(final String levelDirectory, final int startingLevel) {
        this.loader = new LevelLoaderImpl(ClassLoader.getSystemResource(levelDirectory));
        this.currentLevel = startingLevel;
    }

    public LevelIterator() {
        this(Config.LEVEL_RESOURCE_FOLDER.getValue(), 1);
    }

    @Override
    public boolean hasNext() {
        return this.currentLevel <= loader.getFilesCount();
    }

    @Override
    public Level next() {
        final Level loadedLevel = this.loader.fromFile(this.buildFilename());
        this.currentLevel++;
        return loadedLevel;
    }

    /**
     * Build the name of the level file to load.
     * @return
     *          A String containing the name of the level configuration file that should be loaded
     */
    private String buildFilename() {
        return Config.LEVEL_FILE_PREFIX.getValue() + this.currentLevel + Config.LEVEL_FILE_EXTENSION.getValue();
    }
}