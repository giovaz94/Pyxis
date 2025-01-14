package it.unibo.pyxis.model.level.loader.skeleton.level;

import it.unibo.pyxis.model.level.loader.skeleton.ball.BallSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.brick.BrickSkeleton;
import it.unibo.pyxis.model.level.loader.skeleton.pad.PadSkeletonImpl;

import java.util.Set;

public final class LevelSkeletonImpl implements LevelSkeleton {

    private int levelNumber;
    private int lives;
    private double width;
    private double height;
    private PadSkeletonImpl pad;
    private Set<BrickSkeleton> bricks;
    private Set<BallSkeleton> balls;

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BallSkeleton> getBalls() {
        return this.balls;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<BrickSkeleton> getBricks() {
        return this.bricks;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getHeight() {
        return this.height;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevelNumber() {
        return this.levelNumber;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getLives() {
        return this.lives;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public PadSkeletonImpl getPad() {
        return this.pad;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public double getWidth() {
        return this.width;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBalls(final Set<BallSkeleton> ballSkeletonSet) {
        this.balls = ballSkeletonSet;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setBricks(final Set<BrickSkeleton> inputBrickSkeletonSet) {
        this.bricks = inputBrickSkeletonSet;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setHeight(final double inputHeight) {
        this.height = inputHeight;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setLevelNumber(final int number) {
        this.levelNumber = number;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setLives(final int inputLives) {
        this.lives = inputLives;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPad(final PadSkeletonImpl padSkeleton) {
        this.pad = padSkeleton;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setWidth(final double inputWidth) {
        this.width = inputWidth;
    }
}
