package bsu.rfe.java.group8.lab2.YasonovR.var1a;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainFrame extends JFrame {

    private static final int WIDTH = 720;
    private static final int HEIGHT = 480;
    private JTextField textFieldX;
    private JTextField textFieldY;

    private JTextField textFieldZ;
    private JTextField textFieldResult;
    private JTextField textFieldSum;

    private ButtonGroup radioButtons = new ButtonGroup();

    private Box hboxFormulaType = Box.createHorizontalBox();
    private int formulaId = 1;
    private Double sum = 0.0;

    public Double calculate1(Double x, Double y, Double z) {
        if (x == 0)
        {
            JOptionPane.showMessageDialog(MainFrame.this, "X не может равняться нулю", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if (x < 0)
        {
            JOptionPane.showMessageDialog(MainFrame.this, "X должен быть больше нуля!", "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
        }
        if (y == -1)
        {
            JOptionPane.showMessageDialog(MainFrame.this, "Y не может равняться минус единице", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        return Math.pow(Math.cos(Math.exp(x)) + Math.log(Math.pow(1+y, 2)) + Math.pow(Math.exp(Math.cos(x)) + Math.sin(Math.PI * z), 1/2) + Math.pow(1/x, 1/2) + Math.cos(y * y), Math.sin(z));
    }


    public Double calculate2(Double x, Double y, Double z)
    {
        if (z * x < 0)
        {
            JOptionPane.showMessageDialog(MainFrame.this, "Произведение Z * X должно быть больше нуля!", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if (y % 2 == 0 && x <= -1)
        {
            JOptionPane.showMessageDialog(MainFrame.this, "X должен быть больше минус единицы!", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if (y  == 0 && x == 0)
        {
            JOptionPane.showMessageDialog(MainFrame.this, "Деление на ноль", "" + "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        return (1 + Math.pow(z * x, 1/2)) / Math.pow(1 + x * x * x, 1/y);
    }

    private void addRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId = formulaId;
                //imagePane.updateUI();
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }

    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        radioButtons.setSelected(
                radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        JLabel labelForSum = new JLabel("Сумма:");
        textFieldSum= new JTextField("0", 10);
        textFieldSum.setMaximumSize(textFieldSum.getPreferredSize());
        Box hboxMem = Box.createHorizontalBox();
        hboxMem.add(Box.createHorizontalGlue());
        hboxMem.add(labelForSum);
        hboxMem.add(Box.createHorizontalStrut(10));
        hboxMem.add(textFieldSum);
        hboxMem.add(Box.createHorizontalStrut(70));
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForSum);
        hboxVariables.add(textFieldSum);
        hboxVariables.add(Box.createHorizontalStrut(15));

        hboxVariables.add(Box.createHorizontalGlue());
        JLabel labelForResult = new JLabel("Результат:");
//labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1)
                        result = calculate1(x, y, z);
                    else
                        result = calculate2(x, y, z);
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "NumberFormatException", "Error 450",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
                //textFieldM.setText("0");
            }
        });
       JButton MC = new JButton("MC");
        MC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sum = 0.0;
                textFieldSum.setText(sum.toString());
            }
        });
        JButton MP = new JButton("M+");
        MP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                sum += Double.parseDouble(textFieldResult.getText());
                textFieldSum.setText(sum.toString());
            }
        });
        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        Box hboxButtonsM = Box.createHorizontalBox();
        hboxButtonsM.add(Box.createHorizontalGlue());
        hboxButtonsM.add(MP);
        hboxButtonsM.add(Box.createHorizontalStrut(30));
        hboxButtonsM.add(MC);
        hboxButtonsM.add(Box.createHorizontalGlue());
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(hboxButtonsM);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}