package play.level1.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level1Controller extends Thread implements Initializable {
	@FXML
	private Button start;
	@FXML
	private Button throwDice;
	@FXML
	private Label random;
	@FXML
	private Label ergebnis;

	@FXML
	private ImageView dice;
	@FXML
	private ImageView dahm;
	@FXML
	private ImageView questionImg;
	@FXML
	private ImageView student;
	@FXML
	public Label score;
	@FXML
	public Button next;
	@FXML
	public Button back;

	@FXML
	public Label frage;

	@FXML
	private Button answerABtn;
	@FXML
	private Button answerBBtn;
	@FXML
	private Button answerCBtn;
	@FXML
	private Button answerDBtn;
	@FXML
	private Button goOnBtn;

	@FXML
	public Pane fragesFenster;
	@FXML
	public Pane ergebnisFenster;

	public int punkte;
	public String rightResult;

	// public Circle player;
	public static final int Tile_Size_width = 160;
	public static final int Tile_Size_height = 150;
	// insgesamt spielfelder
	public static final int width = 5;
	public static final int height = 5;
	public int rand;
	public int randQuestion;
	public int playerPosition = 1;
	public boolean playerTurn = true;
	public int cirPos[][] = new int[5][5];
	public int leadderPos[][] = new int[6][3];

	// Position von Spieler
	public static int playerXPosition = 50;
	public static int playerYPosition = 600;

	public static double prefWidth = (width * Tile_Size_width) + 200;
	public static double prefHeight = height * Tile_Size_height;
	public int posCir = 1;
	public int position;
	// Position von Spieler

	public boolean gameStart = false;

	public void switschScene(String path, ActionEvent event) throws IOException {
		Parent pa = FXMLLoader.load(getClass().getResource(path));
		Scene scene2 = new Scene(pa);
		Stage stage2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage2.setScene(scene2);
		stage2.show();
	}

	@FXML
	public void toStartBtnClick(ActionEvent event) throws IOException {
		System.out.println("back to start");
		switschScene("/start/start.fxml", event);
	}

	public void playStartBtnClick(ActionEvent event) throws IOException {
		playerXPosition = 50;
		playerYPosition = 600;
		punkte=0;
		student.setTranslateX(50);
		student.setTranslateY(600);
		rand = 0;
		gameStart = true;
		student.setVisible(true);
		start.setText("Neustarten");
		throwDice.setDisable(false);
		score.setText(String.valueOf(punkte));
		next.setDisable(false);
	}

	public void throwDiceBtnClick(ActionEvent event) throws IOException, InterruptedException {

		if (gameStart) {
			if (playerTurn) {
				Image image = new Image("img/wuerfel_0013.gif");
				dice.setImage(image);
				getDiceValue();
				getQuestionNummer();

				random.setText(String.valueOf(rand));
				Thread myThread = new Thread() {

					@Override
					public void run() {
						try {

							sleep(1000);
							Image image1 = null;
							switch (rand) {
							case 1:
								image1 = new Image("img/1.png");
								break;
							case 2:
								image1 = new Image("img/2.png");
								break;
							case 3:
								image1 = new Image("img/3.png");
								break;
							case 4:
								image1 = new Image("img/4.png");
								break;
							case 5:
								image1 = new Image("img/5.png");
								break;
							case 6:
								image1 = new Image("img/6.png");
								break;
							}
							dice.setImage(image1);

							movePlayer();

							translatePlayerTo(playerXPosition, playerYPosition, student);
							if (playerXPosition == 370 && playerYPosition == 600) {

								translatePlayer(370, 600, 530, 300, student);
								playerXPosition = 530;
								playerYPosition = 300;
							}
							if (playerXPosition == 210 && playerYPosition == 300) {

								translatePlayer(210, 300, 50, 0, student);
								playerXPosition = 50;
								playerYPosition = 0;
							}
							if (playerXPosition == 370 && playerYPosition == 150) {

								translatePlayer(370, 150, 210, 450, student);
								playerXPosition = 210;
								playerYPosition = 450;
							}
							if (playerXPosition == 530 && playerYPosition == 0) {

								translatePlayer(530, 0, 690, 300, student);
								playerXPosition = 690;
								playerYPosition = 300;
							}
							if (playerXPosition > 690 || playerYPosition < 0) {
								// fragesFenster.setVisible(false);
							}
							if (playerXPosition == 690 && playerYPosition == 0) {
								// fragesFenster.setVisible(false);
							}
							playerTurn = true;

						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				};
				// rufen erstellter thread auf
				myThread.start();
				// System.out.println(rand);
			}

			// Fenster von Frage pop-up
			setTimeout(() -> {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						try {

							if (randQuestion >= 16 && randQuestion <= 18) {
								questionImg.setVisible(true);

								Image img = null;
								if (randQuestion == 16) {
									questionImg.setFitHeight(130.0);
									questionImg.setFitWidth(185.0);
									img = new Image("img/diagramm.jpg");
									questionImg.setImage(img);
								}
								if (randQuestion == 17) {
									questionImg.setFitHeight(120.0);
									questionImg.setFitWidth(240.0);
									img = new Image("img/bild2frage.png");
									questionImg.setImage(img);
								}

								if (randQuestion == 18) {
									questionImg.setFitHeight(120.0);
									questionImg.setFitWidth(120.0);
									img = new Image("img/hermann.jpg");
									questionImg.setImage(img);
								}
								answerABtn.setVisible(true);
								answerBBtn.setVisible(true);
								answerCBtn.setVisible(true);
								answerDBtn.setVisible(true);
								goOnBtn.setDisable(true);
							} else {
								questionImg.setFitWidth(10.0);
								questionImg.setFitHeight(10.0);
								Image img1 = new Image("img/leer.png");
								questionImg.setImage(img1);
								if (randQuestion == 19 || randQuestion == 20) {

									frage.setPrefHeight(200.0);
									answerABtn.setVisible(false);
									answerBBtn.setVisible(false);
									answerCBtn.setVisible(false);
									answerDBtn.setVisible(false);
									goOnBtn.setDisable(false);
									punkte += 2;
								} else {
									frage.setPrefHeight(125.0);
									answerABtn.setVisible(true);
									answerBBtn.setVisible(true);
									answerCBtn.setVisible(true);
									answerDBtn.setVisible(true);
									goOnBtn.setDisable(true);
								}

							}
							setFragen(randQuestion);

						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (playerXPosition > 690 || playerYPosition < 0) {
							fragesFenster.setVisible(false);
							ergebnisFenster.setVisible(true);
							buttonsOff();
							if (punkte >= 15) {
								ergebnis.setText("Ausgezeichnet! Jetzt kannst du weiter mit dem Thema Kommunikation spielen!");
							} else {

								ergebnis.setText("Leider musst den Level wiederholen!");

							}

						}
						if (playerXPosition == 690 && playerYPosition == 0) {
							fragesFenster.setVisible(false);
							ergebnisFenster.setVisible(true);
							buttonsOff();
							if (punkte >= 15) {

								ergebnis.setText("Ausgezeichnet! Jetzt kannst du weiter mit dem Thema Kommunikation spielen!");

							}else {

								ergebnis.setText("Leider musst den Level wiederholen!");

							}
						} else {
							buttonsOff();
							fragesFenster.setVisible(true);
							// System.out.println("popup");
						}
					}

				});
			}, 2000);

		}

	}

	private void getDiceValue() {
		rand = (int) (Math.random() * 6 + 1);

	}

	private void getQuestionNummer() {
		randQuestion = (int) (Math.random() * 20 + 1);
	}

	private void movePlayer() {
		for (int i = 0; i < rand; i++) {
			if (posCir % 2 == 1) {
				playerXPosition += 160;
			}
			if (posCir % 2 == 0) {
				playerXPosition -= 160;
			}
			if (playerXPosition > 690) {
				playerYPosition -= 150;
				playerXPosition -= 160;
				posCir++;
			}
			if (playerXPosition < 50) {
				playerYPosition -= 150;
				playerXPosition += 160;
				posCir++;
			}
			if (playerXPosition > 690 || playerYPosition < 0)
			// || (playerXPosition==30 && playerYPosition==30))
			{
				playerXPosition = 690;
				playerYPosition = 0;
				gameStart = false;
				playerTurn = false;
				rand = 0;
			}
			if (playerXPosition == 690 && playerYPosition == 0) {
				playerXPosition = 690;
				playerYPosition = 0;
				gameStart = false;
				playerTurn = false;
				rand = 0;

			}

		}

	}

	// translation von Spieler von einer Position zu anderer
	void translatePlayer(int x1, int y1, int x2, int y2, ImageView b) {
		TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);

		animate.setFromX(x1);
		animate.setFromY(y1);
		animate.setToX(x2);
		animate.setToY(y2);
		animate.setAutoReverse(false);
		animate.play();
	}

	// Hilfsmethode f�r die Translation mit Ladder
	private void translatePlayerTo(int x, int y, ImageView b) {
		// TODO Auto-generated method stub
		TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);

		animate.setToX(x);
		animate.setToY(y);
		animate.setAutoReverse(false);
		animate.play();

	}

	// Timer fuer Pop-up Frage Fenster
	public static void setTimeout(Runnable runnable, int delay) {
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			} catch (Exception e) {
				System.err.println(e);
			}
		}).start();
	}

	public void nextLevelBtnClick(ActionEvent event) throws IOException {
		switschScene("/learn/level2learn.fxml", event);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ergebnis.setWrapText(true);
		frage.setWrapText(true);
		Image image = new Image("img/dahm.gif");
		dahm.setImage(image);

	}

	public void buttonsOff() {
		throwDice.setDisable(true);
		start.setDisable(true);
		back.setDisable(true);
	}

	public void buttonsOn() {
		throwDice.setDisable(false);
		start.setDisable(false);
		back.setDisable(false);
	}

	public void setFragen(int nummer) throws IOException {

		String CORRECT_ANSWER_INDICATOR = nummer + "+";
		String CHOICE1_INDICATOR = nummer + "*";
		String CHOICE2_INDICATOR = nummer + "$";
		String CHOICE3_INDICATOR = nummer + "@";
		String CHOICE4_INDICATOR = nummer + "&";
		String QUESTION_SEPARATOR = nummer + ".";
		FileInputStream questionFile = new FileInputStream("src/play/level1/controller/questions.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(questionFile, "UTF-8"));

		String line;
		while ((line = br.readLine()) != null) {
			if (line.startsWith(QUESTION_SEPARATOR)) {
				frage.setText(line.substring(QUESTION_SEPARATOR.length()));
				while ((line = br.readLine()) != null && !line.startsWith(QUESTION_SEPARATOR)) {

					if (line.startsWith(CORRECT_ANSWER_INDICATOR)) {
						rightResult = (line.substring(CORRECT_ANSWER_INDICATOR.length()));
					}
					if (line.startsWith(CHOICE1_INDICATOR)) {
						answerABtn.setText(line.substring(CHOICE1_INDICATOR.length()));

					}
					if (line.startsWith(CHOICE2_INDICATOR)) {
						answerBBtn.setText(line.substring(CHOICE2_INDICATOR.length()));

					}
					if (line.startsWith(CHOICE3_INDICATOR)) {
						answerCBtn.setText(line.substring(CHOICE3_INDICATOR.length()));

					}
					if (line.startsWith(CHOICE4_INDICATOR)) {
						answerDBtn.setText(line.substring(CHOICE4_INDICATOR.length()));

					}

				}

			}
		}
	}

	@FXML
	public void selectActionHandle(ActionEvent event) throws IOException {

		goOnBtn.setDisable(false);
		String selectedAnswer = ((Button) event.getSource()).getText();
		if (isResultRight(selectedAnswer, this.rightResult)) {
			((Button) event.getSource()).setStyle("-fx-background-color:#7fff00");
			punkte += 5;

		} else {
			if (answerABtn.getText().equals(this.rightResult)) {
				answerABtn.setStyle("-fx-background-color:#7fff00");
			} else if (answerBBtn.getText().equals(this.rightResult)) {
				answerBBtn.setStyle("-fx-background-color:#7fff00");
			} else if (answerCBtn.getText().equals(this.rightResult)) {
				answerCBtn.setStyle("-fx-background-color:#7fff00");
			} else {
				answerDBtn.setStyle("-fx-background-color:#7fff00");
			}

			((Button) event.getSource()).setStyle("-fx-background-color:#dc143c");
			punkte -= 5;

		}

	}

	public boolean isResultRight(String result, String rightResult) {
		return (result == rightResult || result.equals(rightResult));
	}

	@FXML
	public void goOnClickHandle(ActionEvent event) throws IOException {
		fragesFenster.setVisible(false);
		frage.setDisable(false);
		answerABtn.setDisable(false);
		answerABtn.setStyle(null);

		answerBBtn.setDisable(false);
		answerBBtn.setStyle(null);

		answerCBtn.setDisable(false);
		answerCBtn.setStyle(null);

		answerDBtn.setDisable(false);
		answerDBtn.setStyle(null);

		score.setText(String.valueOf(punkte));
		start.setDisable(false);
		throwDice.setDisable(false);
		back.setDisable(false);
	}

	@FXML
	public void okClickHandle(ActionEvent event) throws IOException {
		ergebnisFenster.setVisible(false);
		
		if (punkte >= 15) {
			buttonsOn();
			next.setDisable(false);
		} else {
			punkte=0;
			playerXPosition = 50;
			playerYPosition = 600;

			student.setTranslateX(50);
			student.setTranslateY(600);
			
			gameStart = true;
			start.setText("Neustarten");
			buttonsOn();
			score.setText(String.valueOf(punkte));
		}
	}
}
