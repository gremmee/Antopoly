package nl.gremmee.antopoly.gui.tiles;

import java.awt.Color;
import java.awt.Graphics;

import nl.gremmee.antopoly.gui.AntopolyGUI;
import nl.gremmee.antopoly.gui.ID;
import nl.gremmee.antopoly.gui.abs.AntopolyObject;
import nl.gremmee.antopoly.gui.core.Coord;

public class TileView extends AntopolyObject {

    public TileView(Coord aPos, ID aId) {
        super(aPos, aId);
        this.getVel().setXY(getRandom().nextInt(9) - 5, (getRandom().nextInt(AntopolyGUI.WIDTH / 100) + 10) * -1);
        setColor(new Color(getRandom().nextInt(255), getRandom().nextInt(255), getRandom().nextInt(255)));
    }

    @Override
    public void doRender(Graphics aGraphics) {
        aGraphics.setColor(getColor());
        aGraphics.drawRect((int) this.getPos().getX(), (int) this.getPos().getY(), 50, 70);
    }

    @Override
    public void doUpdate() {
        if (getRandom().nextInt(10) < 1) {
            this.getPos().setX(this.getPos().getX() + getRandom().nextInt(3) - 1);
        }
    }
}
