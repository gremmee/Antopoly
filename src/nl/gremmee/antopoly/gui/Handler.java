package nl.gremmee.antopoly.gui;

import java.awt.Graphics;
import java.util.LinkedList;

import nl.gremmee.antopoly.gui.abs.AntopolyObject;
import nl.gremmee.antopoly.gui.tiles.TileView;

public class Handler {

    LinkedList<AntopolyObject> object = new LinkedList<>();

    public void addObject(AntopolyObject aObject) {
        this.object.add(aObject);
    }

    public AntopolyObject getGameObject(AntopolyObject aObject) {
        int index = this.object.indexOf(aObject);
        if (index != -1) {
            return this.object.get(index);
        }
        return null;
    }

    public int getTiles() {
        int result = 0;
        for (AntopolyObject antopolyObject : object) {
            if (antopolyObject instanceof TileView) {
                result++;
            }
        }
        return result;
    }

    public void removeObject(AntopolyObject aObject) {
        this.object.remove(aObject);
    }

    public void render(Graphics aGraphics) {
        for (int i = 0; i < object.size(); i++) {
            AntopolyObject tempObject = object.get(i);
            tempObject.render(aGraphics);
        }
    }

    public void update() {
        for (int i = 0; i < object.size(); i++) {
            AntopolyObject tempObject = (AntopolyObject) object.get(i);
            tempObject.update();

            if (tempObject instanceof TileView) {
                if (tempObject.getVel().getY() >= 0) {
                    removeObject(tempObject);

                }
            }
        }
    }

}
