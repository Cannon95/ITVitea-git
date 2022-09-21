package com.markvdviert.main.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Plot {

    public JFrame window;
    public String xAs;
    public String yAs;


    public Plot(String title, String xAs,String yAs, double[] x, double[] y) {
        this.xAs = xAs;
        this.yAs = yAs;
        this.window = new JFrame(title);


        window.setVisible(true);
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new PlotPanel(x, y));
    }

    public Plot(String title, double[] x, double[] y) {
        this(title, "x", "y", x, y);
    }

}
class PlotPanel extends JPanel{

    public double[] x,y;
    public PlotPanel(double[] x, double[] y){
     this.x = x;
     this.y = y;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawThickLineX(100,400, 400, 400,g,8);

        drawThickLineY(100,100, 100, 400,g, 8);

        drawPlot(g,Color.red);



    }
    public void drawThickLineX(int x1,int y1,int x2,int y2,Graphics g, int thinkness){
        for (int i = -thinkness/2; i < thinkness/2; i++) {
            g.drawLine(x1 ,y1 + i, x2, y2 + i);
        }
    }
    public void drawThickLineY(int x1,int y1,int x2,int y2,Graphics g, int thinkness){
        for (int i = -thinkness/2; i < thinkness/2; i++) {
            g.drawLine(x1 + i,y1, x2 + i, y2);
        }
    }
    public void drawPoint(int x,int y,Graphics g, int thinkness){
        int t = thinkness/2;
        for (int i = -t; i < t; i++) {
            g.drawLine(x - t, y + i, x + t, y + i);
        }
    }

    public void drawPlot(Graphics g, Color color){
        // (0,0) = (100,400) dit kan ik ooit nog gaan shiften maar das voor later
        g.setColor(color);
        double maxX = Arrays.stream(this.x).max().getAsDouble();
        double maxY = Arrays.stream(this.y).max().getAsDouble();
        Integer[] prev = null;
        for (int i = 0; i < this.y.length; i++) {
            Integer[] xyPoint = getLocation(x[i],y[i],maxX,maxY);
            drawPoint(xyPoint[0],xyPoint[1],g, 4);
            if(prev != null){
                g.drawLine(prev[0],prev[1],xyPoint[0],xyPoint[1]);

            }
            prev = xyPoint;
        }

        System.out.println("maxX: " + maxX + " , maxY: " + maxY);
        g.setColor(Color.BLACK);
    }

    public Integer[] getLocation(double x,double y, double maxX,double maxY ){
        int locX = (int)((x*300)/maxX);
        int locY = (int)((y*300)/maxY);

         Integer[] result = {locX + 100, 400 - locY};
        return result;
    }



}
