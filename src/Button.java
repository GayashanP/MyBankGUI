import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Button extends JButton implements MouseListener {

    private boolean rounded;
    private boolean backgroundPainted;
    private boolean linePainted;
    private boolean entered;
    private boolean pressed;

    private Color enteredColor;
    private Color pressedColor;
    private Color gradientLineColor;
    private Color gradientBackgroundColor;
    private Color lineColor;

    public Button() {
        super();
        rounded = false;
        backgroundPainted = true;
        linePainted = true;
        pressed = false;
        entered = false;

        enteredColor = getBackground().brighter();
        pressedColor = getBackground().darker();
        lineColor = Color.BLACK;

        setContentAreaFilled(false);
        setFocusPainted(false);
        addMouseListener(this);
    }

    @Override
    public void setBackground(Color color) {
        super.setBackground(color);
        enteredColor = color.brighter();
        pressedColor = color.darker();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape s = (rounded) ? new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, getHeight() - 2, getHeight() - 2)
                : new Rectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2);

        if (backgroundPainted || (pressed && !backgroundPainted)) {
            if (gradientBackgroundColor == null) {
                g2.setColor(color());
            } else {
                GradientPaint paint = new GradientPaint(0, 0, getBackground(), getWidth(), getHeight(), gradientBackgroundColor);
                g2.setPaint(paint);
            }
            g2.fill(s);
        }
        if (linePainted) {
            if (gradientLineColor == null) {
                g2.setColor(isEnabled() ? lineColor : new Color(204, 204, 204));
            } else {
                GradientPaint paint = new GradientPaint(0, 0, lineColor, getWidth(), getHeight(), gradientLineColor);
            }
            g2.draw(s);
            super.paintComponent(g2);
        }
    }

        private Color color () {
            if (!isEnabled()) {
                return new Color(204, 204, 204);
            }
            Color temp = getBackground();
            if (pressed) {
                return pressedColor;
            }
            if (entered) {
                return enteredColor;
            }
            return temp;
        }

        public void setRounded ( boolean rounded){
            this.rounded = rounded;
        }

        public void setBackgroundPainted ( boolean backgroundPainted){
            this.backgroundPainted = backgroundPainted;
        }

        public void setLinePainted ( boolean linePainted){
            this.linePainted = linePainted;
        }

        public void setPressed ( boolean pressed){
            this.pressed = pressed;
        }

        public void setEnteredColor (Color enteredColor){
            this.enteredColor = enteredColor;
        }

        public void setGradientColor (Color gradientLineColor){
            this.gradientLineColor = gradientLineColor;
        }

        public void setGradientBackgroundColor (Color gradientBackgroundColor){
            this.gradientBackgroundColor = gradientBackgroundColor;
        }

        public void setLineColor (Color lineColor){
            this.lineColor = lineColor;
        }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        entered = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        entered = false;
    }
}
