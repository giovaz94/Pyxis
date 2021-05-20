package it.unibo.pyxis.event;

import it.unibo.pyxis.element.powerup.Powerup;
import it.unibo.pyxis.event.collision.BrickCollisionEvent;
import it.unibo.pyxis.event.collision.PadCollisionEvent;
import it.unibo.pyxis.event.movement.BallMovementEvent;
import it.unibo.pyxis.event.movement.PowerupMovementEvent;
import it.unibo.pyxis.event.notify.DecreaseLifeEvent;
import it.unibo.pyxis.event.notify.BrickDestructionEvent;
import it.unibo.pyxis.event.notify.PowerupActivationEvent;
import it.unibo.pyxis.hitbox.HitEdge;
import it.unibo.pyxis.util.Coord;

import java.util.Optional;

public final class Events {

    private Events() {
        throw new AssertionError("This class can't be instantiated , why are you here?");
    };

    /**
     * Create a new {@link BrickDestructionEvent} instance passing the coords of the destroyed brick.
     * @param coords
     *                  The coords of destroyed brick.
     * @return
     *                  The {@link BrickDestructionEvent} instance.
     */
    public static BrickDestructionEvent newBrickDestructionEvent(final Coord coords) {
        return () -> coords;
    }

    /**
     * Create a new {@link BrickCollisionEvent} instance passing a {@link HitEdge}.
     * @param hitEdge
     *                  The edge of the {@link it.unibo.pyxis.element.brick.Brick} that has been hit.
     * @return
     *         The {@link BrickCollisionEvent} instance.
     */
    public static BrickCollisionEvent newBrickCollisionEvent(final HitEdge hitEdge) {
        return () -> hitEdge;
    }

    /**
     * Create a new {@link PadCollisionEvent} instance passing a {@link HitEdge}.
     * @param hitEdge
     *                  The edge of the {@link it.unibo.pyxis.element.pad.Pad} that has been hit.
     * @param padWidth
     *                  The current width of the {@link it.unibo.pyxis.element.pad.Pad}
     * @return
     *           The {@link PadCollisionEvent} instance.
     */
    public static PadCollisionEvent newPadCollisionEvent(final HitEdge hitEdge, final double padWidth) {
        return new PadCollisionEvent() {
            @Override
            public double getPadWidth() {
                return padWidth;
            }

            @Override
            public HitEdge getCollidedEdge() {
                return hitEdge;
            }
        };
    }

    /**
     * Create a new {@link PowerupActivationEvent} instance passing a {@link Powerup}.
     * @param powerup
     *                  Powerup that called the event
     * @return
     *                  The {@link PowerupActivationEvent} instance.
     */
    public static PowerupActivationEvent newPowerupActivationEvent(final Powerup powerup) {
        return () -> powerup;
    }

    /**
     * Create a new {@link BallMovementEvent} instance passing a {@link Coord} representing the current position
     * of the {@link it.unibo.pyxis.element.ball.Ball} inside the {@link it.unibo.pyxis.arena.Arena}.
     *
     * @param coord
     *                  The {@link it.unibo.pyxis.element.ball.Ball}'s {@link Coord} position.
     * @return
     *                  The {@link BallMovementEvent} instance.
     */
    public static BallMovementEvent newBallMovementEvent(final Coord coord) {
        return () -> coord;
    }

    /**
     * Create a new {@link PowerupMovementEvent} instance passing a {@link Coord} representing the current position
     * of the {@link it.unibo.pyxis.element.powerup.Powerup} inside the {@link it.unibo.pyxis.arena.Arena}.
     *
     * @param coord
     *               The {@link it.unibo.pyxis.element.powerup.Powerup}'s {@link Coord} position.
     * @return
     *               The {@link PowerupMovementEvent} instance.
     */
    public static PowerupMovementEvent newPowerupMovementEvent(final Coord coord) {
        return () -> coord;
    }

    /**
     * Create a new {@link DecreaseLifeEvent} instance passing an {@link Optional} indicating the score gained.
     *
     * @param score
     *              An {@link Optional} with the score gained
     * @return
     *              The {@link DecreaseLifeEvent} instance.
     */
    public static DecreaseLifeEvent newDecreaseLifeEvent(final Optional<Integer> score) {
        return () -> score;
    }
}
