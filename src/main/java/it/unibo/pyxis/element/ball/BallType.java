package it.unibo.pyxis.element.ball;

import java.util.Optional;

public enum BallType {

    NORMAL_BALL(Optional.of(1), 1, true),
    ATOMIC_BALL(Optional.empty(), 1, false),
    STEEL_BALL(Optional.empty(), 1, true);

    private final Optional<Integer> damage;
    private final double paceMultiplier;
    private final boolean bounce;

    private BallType(final Optional<Integer> typeDamage,
                     final double typePaceMultiplier, final boolean typeBounce) {
        this.damage = typeDamage;
        this.paceMultiplier = typePaceMultiplier;
        this.bounce = typeBounce;
    }

    /**
     * Returns the ball's damage as Optional<Integer>.
     * @return  Optional empty if damage is infinite,
     *          Optional of an integer representing damage.
     */
    public Optional<Integer> getDamage() {
        return this.damage;
    }

    /**
     * Returns the ball's pace multiplier.
     * @return
     */
    public double getPaceMultiplier() {
        return this.paceMultiplier;
    }

    /**
     * Returns the ball's property of bouncing if collided with a destructible brick.
     * @return  true if the ball bounces,
     *          false if the ball doesn't bounce.
     */
    public boolean isBounce() {
        return this.bounce;
    }
}