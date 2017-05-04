package d;
import java.applet.Applet;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AddititionQuiz extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {

		// Execute a job on the event-dispatching thread:
		// creating this applet's GUI.
		try {
			javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
					addAction();
				}

			});
		} catch (Exception e) {
			System.err.println("createGUI didn't successfully complete");
		}

	}

	// radio button add two values
	private JRadioButton rdAdd = new JRadioButton("Add");
	// radio button subtraction two values
	private JRadioButton rdSub = new JRadioButton("Subtract");
	// radio button multiply two values
	private JRadioButton rdMul = new JRadioButton("Multiply");
	// radio button divide two values
	private JRadioButton rdDiv = new JRadioButton("Divide");

	// group all radio button type (add, sub...)
	private ButtonGroup radioGroupType = new ButtonGroup();

	// radio button random between two values from 0 and 5
	private JRadioButton rdFrom0To5 = new JRadioButton("Numbers from 0 to 5");
	// radio button random between two values from 3 and 9
	private JRadioButton rdFrom3To9 = new JRadioButton("Number from 3 to 9");
	// radio button random between two values from 0 and 20
	private JRadioButton rdFrom0To20 = new JRadioButton("Number from 0 to 20");
	// radio button random between two values from any integer values
	private JRadioButton rdAnyTwoDigital = new JRadioButton("Any two digitals");

	// group all radio button random values
	private ButtonGroup radioGroupLevel = new ButtonGroup();

	private JButton btnStart = new JButton("Start");
	private JButton btnStop = new JButton("Stop");
	private JLabel lbQuestionShow = new JLabel("Question will be shown");

	private JLabel lbCorrectCount = new JLabel("Correct count will be shown");
	private JLabel lbTimeSpent = new JLabel("Time spent will be shown");

	private JTextField txtAnswer = new JTextField();

	private long startTime = 0;
	private Random random = new Random();
	private int correctAnwerCount = 0;
	private double answer = 0;

	// create grahic user interface
	private void createGUI() {

		radioGroupType.add(rdAdd);
		rdAdd.setSelected(true);
		radioGroupType.add(rdSub);
		radioGroupType.add(rdMul);
		radioGroupType.add(rdDiv);

		radioGroupLevel.add(rdFrom0To5);
		rdFrom0To5.setSelected(true);
		radioGroupLevel.add(rdFrom3To9);
		radioGroupLevel.add(rdFrom0To20);
		radioGroupLevel.add(rdAnyTwoDigital);

		JPanel panelType = new JPanel();
		panelType.setLayout(new BoxLayout(panelType, BoxLayout.Y_AXIS));
		panelType.setBorder(BorderFactory.createTitledBorder("Choose a type"));
		panelType.add(rdAdd);
		panelType.add(rdSub);
		panelType.add(rdMul);
		panelType.add(rdDiv);

		JPanel panelLevel = new JPanel();
		panelLevel.setLayout(new BoxLayout(panelLevel, BoxLayout.Y_AXIS));
		panelLevel.setBorder(BorderFactory.createTitledBorder("Choose a level"));
		panelLevel.add(rdFrom0To5);
		panelLevel.add(rdFrom3To9);
		panelLevel.add(rdFrom0To20);
		panelLevel.add(rdAnyTwoDigital);

		// panelQuestion
		JPanel panelQuestion = new JPanel();
		panelLevel.setLayout(new BoxLayout(panelLevel, BoxLayout.Y_AXIS));
		TitledBorder tb = new TitledBorder(BorderFactory.createEmptyBorder(), "Question");

		panelQuestion.setBorder(tb);
		lbQuestionShow.setAlignmentY(RIGHT_ALIGNMENT);
		panelQuestion.add(lbQuestionShow);

		// panel answer
		JPanel panelAnswer = new JPanel();
		panelAnswer.setLayout(new BoxLayout(panelAnswer, BoxLayout.Y_AXIS));
		TitledBorder tbAnswer = new TitledBorder(BorderFactory.createEmptyBorder(), "Answer");

		panelAnswer.setBorder(tbAnswer);

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnStop.setEnabled(false);
		panelButton.add(btnStart);
		panelButton.add(btnStop);
		panelAnswer.add(txtAnswer);
		panelAnswer.add(panelButton);

		// panel correct count
		JPanel panelCorrectCount = new JPanel();
		panelCorrectCount.setLayout(new BoxLayout(panelCorrectCount, BoxLayout.Y_AXIS));
		panelCorrectCount.setBorder(BorderFactory.createTitledBorder("Correct Count"));
		panelCorrectCount.add(lbCorrectCount);

		// panel time spent
		JPanel panelTimeSpent = new JPanel();
		panelTimeSpent.setLayout(new BoxLayout(panelTimeSpent, BoxLayout.Y_AXIS));
		panelTimeSpent.setBorder(BorderFactory.createTitledBorder("Time Spent"));
		panelTimeSpent.add(lbTimeSpent);

		// main layout
		setLayout(new GridBagLayout());
		setSize(400, 250);
		Frame title = (Frame) this.getParent().getParent();
		title.setTitle("Excercise18_26");

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;

		add(panelType, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		add(panelLevel, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		add(panelQuestion, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		add(panelAnswer, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		add(panelCorrectCount, c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 2;
		add(panelTimeSpent, c);

	}

	/**
	 * add action for components
	 */
	public void addAction() {
		txtAnswer.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// enter event
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						double yourAnswer = Double.parseDouble(txtAnswer.getText());
						// matching answer correct
						if (yourAnswer == answer) {
							correctAnwerCount++;
							lbCorrectCount.setText(correctAnwerCount + "");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					txtAnswer.setText("");
					showQuestion();
				}

			}
		});

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startTime = System.currentTimeMillis();
				btnStart.setEnabled(false);
				btnStop.setEnabled(true);
				correctAnwerCount = 0;
				lbCorrectCount.setText(correctAnwerCount + "");
				showQuestion();
			}
		});

		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long timeSpent = (System.currentTimeMillis() - startTime) / 1000;
				btnStop.setEnabled(false);
				btnStart.setEnabled(true);
				lbTimeSpent.setText(timeSpent + " seconds");
				startTime = 0;
			}
		});
	}

	/**
	 * get random value between two values
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public int randInt(int min, int max) {
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = random.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	/**
	 * show question
	 */
	public void showQuestion() {
		int value1 = 0;
		int value2 = 0;

		// get level quiz selected
		if (rdFrom0To5.isSelected()) {
			value1 = randInt(0, 5);
			value2 = randInt(0, 5);
		} else if (rdFrom3To9.isSelected()) {
			value1 = randInt(3, 9);
			value2 = randInt(3, 9);
		} else if (rdFrom0To20.isSelected()) {
			value1 = randInt(0, 20);
			value2 = randInt(0, 20);
		} else if (rdAnyTwoDigital.isSelected()) {
			value1 = random.nextInt();
			value2 = random.nextInt();
		}
		// get operation selected
		if (rdAdd.isSelected()) {
			answer = value1 + value2;
			lbQuestionShow.setText(value1 + "+" + value2);
		} else if (rdSub.isSelected()) {
			answer = value1 - value2;
			lbQuestionShow.setText(value1 + "-" + value2);
		} else if (rdMul.isSelected()) {
			answer = value1 * value2;
			lbQuestionShow.setText(value1 + "*" + value2);
		} else if (rdDiv.isSelected()) {
			answer = (double) value1 / (double) value2;
			lbQuestionShow.setText(value1 + "/" + value2);
		}
	}

}
