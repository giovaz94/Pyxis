package it.unibo.pyxis.model.element.brick;

import it.unibo.pyxis.model.element.AbstractElement;
import it.unibo.pyxis.model.element.ball.Ball;
import it.unibo.pyxis.model.event.Events;
import it.unibo.pyxis.model.event.movement.BallMovementEvent;
import it.unibo.pyxis.model.hitbox.HitEdge;
import it.unibo.pyxis.model.hitbox.RectHitbox;
import it.unibo.pyxis.model.util.Coord;
import it.unibo.pyxis.model.util.Dimension;
import it.unibo.pyxis.model.util.DimensionImpl;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;
import java.util.Optional;

public final class BrickImpl extends AbstractElement implements Brick {

    private static final Dimension DIMENSION = new DimensionImpl(60, 25);
    private final BrickType brickType;
    private int durability;

    public BrickImpl(final BrickType type, final Coord inputPosition) {
        super(DIMENSION, inputPosition);
        this.setHitbox(new RectHitbox(this));
        this.brickType = type;
        this.durability = type.getDurability();
        EventBus.getDefault().register(this);
    }

    @Override
    public void update(final double delta) {
        throw new UnsupportedOperationException("You can't call update on a brick");
    }

    @Override
    @Subscribe
    public void handleBallMovement(final BallMovementEvent movementEvent) {
        final Optional<HitEdge> hitEdge = movementEvent.getElement().getHitbox().collidingEdgeWithHB(this.getHitbox());
        hitEdge.ifPresent(edge -> {
            final Ball ball = movementEvent.getElement();
            EventBus.getDefault().post(Events.newBallCollisionEvent(ball.getId(), edge));
            this.handleIncomingDamage(movementEvent.getElement().getType().getDamage());
        });
    }

    /**
     * Handle the damage received by a {@link it.unibo.pyxis.model.element.ball.Ball}.
     * If the durability of the {@link Brick} reaches the value 0 then the brick is destroyed.
     *
     * @param incomingDamage
     *                         The {@link Optional} indicating the damage taken.
     */
    private void handleIncomingDamage(final Optional<Integer> incomingDamage) {
        this.durability = incomingDamage.isEmpty() ? 0 : Math.max(this.durability - incomingDamage.get(), 0);
        if (this.durability == 0 && !this.getBrickType().isIndestructible()) {
            EventBus.getDefault().post(Events.newBrickDestructionEvent(this.getPosition()));
            if (EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().unregister(this);
            }
        }
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public BrickType getBrickType() {
        return this.brickType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BrickImpl)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BrickImpl brick = (BrickImpl) o;
        return this.getDurability() == brick.getDurability() && this.getBrickType() == brick.getBrickType();
    }

    @Override
    public String toString() {
        return "BrickImpl{"
                + "Position X :" + this.getPosition().getX()
                + ", Position Y :" + this.getPosition().getY()
                + ", Type :" + this.getBrickType()
                + ", Durability : " + this.getDurability()
                + '}';
    }
}
