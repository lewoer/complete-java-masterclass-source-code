package com.example.awtSample;

import java.awt.*; // awt abstract window toolkit
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: ShiLe
 * @Description:
 * @Date: Created in 23:26 2018/12/29
 */
public class MyWindow extends Frame {
    public MyWindow(String title) {
        super(title);
        setSize(500,140);
        // 添加一个内联类对象
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("sansSerif",Font.BOLD,18);
        Font sansSerifSmall = new Font("sansSerif",Font.BOLD,12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course",60,60);
        g.setFont(sansSerifSmall);
        g.drawString("By lewoer",60 ,100);
    }
}
