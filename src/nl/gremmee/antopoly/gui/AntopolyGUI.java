package nl.gremmee.antopoly.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.Random;

import nl.gremmee.antopoly.gui.core.Coord;
import nl.gremmee.antopoly.gui.tiles.TileView;

public class AntopolyGUI extends Canvas implements Runnable {

    private static final long serialVersionUID = 607334712862188104L;
    public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private boolean running = false;
    private Handler handler;
    private int frames = 0;
    private Random random = new Random();

    private Thread thread;

    public AntopolyGUI() {
        handler = new Handler();

        new Window(WIDTH, HEIGHT, "AntopolyGUI", this);
    }

    public static void main(String[] aArgs) {
        new AntopolyGUI();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            if (running) {
                render();
            }
            frames++;

            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                int tiles = handler.getTiles();
                System.out.println("FPS: " + frames + " : Tiles " + tiles);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        // g.setColor(new Color(0, 0, 0, 15));
        g.setColor(new Color(25, 77, 30));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (random.nextInt(AntopolyGUI.HEIGHT / 5) < 1) {
            Coord coord = new Coord(WIDTH / 2, HEIGHT);
            handler.addObject(new TileView(coord, ID.Tile));
        }

        handler.render(g);

        g.setColor(Color.WHITE);
        g.drawString("FPS " + frames, 12, 12);

        g.dispose();
        bs.show();
    }

    private void update() {
        handler.update();
    }
}
