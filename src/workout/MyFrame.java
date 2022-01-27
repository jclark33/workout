package workout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;


class MyFrame 
extends JFrame
implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container c;
	private JLabel title;
	private JLabel location;
	private JTextField tlocation;
	private JLabel miles;
	private JTextField tmiles;
	private JLabel minutes;
	private JTextField tminutes;
	private JLabel type;
	private JRadioButton run;
	private JRadioButton bike;
	private JRadioButton walk;
	private ButtonGroup typegp;
	private JLabel date;
	@SuppressWarnings("rawtypes")
	private JComboBox day;
	@SuppressWarnings("rawtypes")
	private JComboBox month;
	@SuppressWarnings("rawtypes")
	private JComboBox time;
	@SuppressWarnings("rawtypes")
	private JComboBox year;
	private JButton sub;
	private JButton reset;
	private JButton print;
	private JLabel res;
	private log myLog;
	private String dates[] = { "01", "02", "03", "04", "05",
            "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
	private String months[] = { "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sep", "Oct", "Nov", "Dec" };
	private String years[] = {"2010", "2011", "2012", "2013",
			"2014", "2015", "2016", "2017", "2018", "2019",
			"2020", "2021", "2022"};
	private String times[] = {"Morning", "Midday", "Afternoon", "Evening", "Night"};
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MyFrame() {
		setTitle("Enter a New Workout");
		setBounds(300, 90, 580, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		c = getContentPane();
		c.setLayout(null);
		Font label = new Font("Arial", Font.PLAIN, 18);
		Font entry = new Font("Arial", Font.PLAIN, 14);
		
		myLog = new log();
		
		title = new JLabel("Enter a New Workout");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(300,30);
		title.setLocation(195,30);
		c.add(title);
		
		type = new JLabel("Activity");
		type.setFont(label);
		type.setSize(100,20);
		type.setLocation(100,100);
		c.add(type);
		
		run = new JRadioButton("Run");
		run.setFont(entry);
		run.setSelected(false);
		run.setSize(80,20);
		run.setLocation(200,100);
		c.add(run);
		
		bike =  new JRadioButton("Bike");
		bike.setFont(entry);
		bike.setSelected(false);
		bike.setSize(80,20);
		bike.setLocation(280,100);
		c.add(bike);
		
		walk = new JRadioButton("Walk");
		walk.setFont(entry);
		walk.setSelected(false);
		walk.setSize(80,20);
		walk.setLocation(360,100);
		c.add(walk);
		
		typegp = new ButtonGroup();
		typegp.add(bike);
		typegp.add(walk);
		typegp.add(run);
		
		location = new JLabel("Location");
		location.setFont(label);
		location.setSize(100,20);
		location.setLocation(100,150);
		c.add(location);
		
		tlocation = new JTextField();
		tlocation.setFont(entry);
		tlocation.setSize(220,20);
		tlocation.setLocation(200,150);
		c.add(tlocation);
		
		miles = new JLabel("Distance (miles)");
		miles.setFont(label);
		miles.setSize(200,20);
		miles.setLocation(100,200);
		c.add(miles);
		
		tmiles = new JTextField();
		tmiles.setFont(entry);
		tmiles.setSize(120,20);
		tmiles.setLocation(300,200);
		c.add(tmiles);
		
		minutes = new JLabel("Duration (minutes)");
		minutes.setFont(label);
		minutes.setSize(200,20);
		minutes.setLocation(100,250);
		c.add(minutes);
		
		tminutes = new JTextField();
		tminutes.setFont(entry);
		tminutes.setSize(120,20);
		tminutes.setLocation(300,250);
		c.add(tminutes);
		
		date = new JLabel("Date");
		date.setFont(label);
		date.setSize(100,20);
		date.setLocation(100,300);
		c.add(date);
		
		day = new JComboBox(dates);
		day.setFont(entry);
		day.setSize(50,20);
		day.setLocation(200,300);
		c.add(day);
		
		month = new JComboBox(months);
		month.setFont(entry);
		month.setSize(60,20);
		month.setLocation(250,300);
		c.add(month);
		
		year = new JComboBox(years);
		year.setFont(entry);
		year.setSize(60,20);
		year.setLocation(310,300);
		c.add(year);
		
		time = new JComboBox(times);
		time.setFont(entry);
		time.setSize(80,20);
		time.setLocation(390,300);
		c.add(time);
		
		sub = new JButton("Submit");
		sub.setFont(entry);
		sub.setSize(100,20);
		sub.setLocation(90,370);
		sub.addActionListener(this);
		c.add(sub);
		
		reset = new JButton("Reset");
		reset.setFont(entry);
		reset.setSize(100,20);
		reset.setLocation(210,370);
		reset.addActionListener(this);
		c.add(reset);
		
		print = new JButton("Print Log");
		print.setFont(entry);
		print.setSize(150,20);
		print.setLocation(330,370);
		print.addActionListener(this);
		c.add(print);
		
		res = new JLabel("");
		res.setFont(label);
		res.setSize(500,25);
		res.setLocation(170,420);
		c.add(res);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sub) {
				String data1;
				if(run.isSelected())
					data1 = "Run";
				else if(bike.isSelected())
					data1 = "Bike";
				else
					data1 = "Walk";
				String data2 = tlocation.getText();
				String temp = tmiles.getText();
				double data3 = Double.parseDouble(temp);
				temp = tminutes.getText();
				double data4 = Double.parseDouble(temp);
				temp = (String)day.getSelectedItem() + " "
						+ (String)month.getSelectedItem() + " "
						+ (String)year.getSelectedItem();
				Date data5 = new Date();
				try {
				data5 = new SimpleDateFormat("dd MMM yyyy").parse(temp);
				} catch (Exception f) {
					System.out.println("Something went wrong with the date.");
				}
				String data6 = (String)time.getSelectedItem();
				
				myLog.addCardio(data1,data2,data3,data4,data5,data6);
				res.setText("Workout added successfully.");
				}
		else if (e.getSource() == reset){
			String emp = "";
			tlocation.setText(emp);
			tmiles.setText(emp);
			tminutes.setText(emp);
			day.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			time.setSelectedIndex(0);
			res.setText(emp);
		}
		else if (e.getSource() == print) {
			myLog.printLog();
		}
	}
}
