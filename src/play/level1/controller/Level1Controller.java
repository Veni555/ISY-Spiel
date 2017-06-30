package play.level1.controller;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class Level1Controller extends Thread implements Initializable {
	SingleChoiceLv1Controller singleChoiceLv1Controller= new SingleChoiceLv1Controller();//;
	@FXML
	public void toStartBtnClick(ActionEvent event) throws IOException {
		System.out.println("back to start");
		switschScene("/start/start.fxml", event);
	}
	
	public void switschScene(String path, ActionEvent event) throws IOException {
		Parent pa = FXMLLoader.load(getClass().getResource(path));
		Scene scene2 = new Scene(pa);
		Stage stage2 = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage2.setScene(scene2);
		stage2.show();
	}

	/**
	 * ============================== level1play.fxml ==============================
     */

	@FXML
	private Button start;
	@FXML
	private Button throwDice;
	@FXML
	private Label random;
	@FXML
	private ImageView dice;
	@FXML
	private ImageView student;
	@FXML
	public Label score;
	@FXML
	private Button getPunkteBtn;

	public int punkt;


//	public Circle player;
	public static final int Tile_Size_width = 160;
	public static final int Tile_Size_height = 150;
	//insgesamt spielfelder
	public static final int width = 5;
	public static final int height = 5;
	public int rand;
	public int playerPosition = 1;
	public boolean playerTurn = true;
	public int cirPos[][] = new int[5][5];
	public int leadderPos[][] = new int[6][3];
	//wie Spieler aussieht
	
	//Hilfsvariable für den Spieler

	
	//Position von Spieler
	public static int playerXPosition = 50;
	public static int playerYPosition = 600;
	
	public static double prefWidth = (width * Tile_Size_width)+200;
	public static double prefHeight = height * Tile_Size_height;
	public int posCir = 1;
	public int position;
	// Position von Spieler


	public boolean gameStart = false;

	public void setTextToLabel (int punkte){
		System.out.println("score in spielbrett before: " + punkte);
		score.setText(String.valueOf(punkte));
		System.out.println("score in spielbrett before: " + score.getText());
//		setPunkt(punkte);
	}

	public void setPunkt(int p) {
		System.out.println("setP: " + p);
		score.setText(String.valueOf(p));
		this.punkt = p;
	}

	public int getScore() {
		return Integer.parseInt(score.getText());
	}


//	public Level1Controller() {
//
//	}

	@FXML
	public void getPunkteBtnClick(ActionEvent event) throws IOException {
//		score.setText(main.loadPunktFromAufgabe());
//		System.out.println("from level1: "+main.loadPunktFromAufgabe());
//		score.setText(main.loadPunktFromAufgabe());
	}

	public void playStartBtnClick(ActionEvent event) throws IOException {
		playerXPosition = 50;
		playerYPosition = 600;

		student.setTranslateX(50);
		student.setTranslateY(600);

		gameStart = true;
		student.setVisible(true);

	}

	public void throwDiceBtnClick(ActionEvent event) throws IOException, InterruptedException {
		if (gameStart) {
			if (playerTurn) {
				Image image = new Image("img/wuerfel_0013.gif");
				dice.setImage(image);
				getDiceValue();

				random.setText(String.valueOf(rand));
				Thread myThread = new Thread() {

					@Override
					public void run() {
						try {

							sleep(1000);

							if (rand == 1) {

								Image image1 = new Image("img/1.png");
								dice.setImage(image1);
							}
							if (rand == 2) {
								Image image1 = new Image("img/2.png");
								dice.setImage(image1);
							}
							if (rand == 3) {

								Image image1 = new Image("img/3.png");
								dice.setImage(image1);
							}
							if (rand == 4) {

								Image image1 = new Image("img/4.png");
								dice.setImage(image1);
							}
							if (rand == 5) {

								Image image1 = new Image("img/5.png");
								dice.setImage(image1);
							}
							if (rand == 6) {

								Image image1 = new Image("img/6.png");
								dice.setImage(image1);
							}
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
							playerTurn = true;

						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				};
				// rufen erstellter thread auf
				myThread.start();
//				System.out.println(rand);
			}

			// Fenster von Frage pop-up
			setTimeout(() -> {
				Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                        	
                        	singleChoiceLv1Controller.setPosition(position);
                        	punkt=singleChoiceLv1Controller.getScore();
                        	score.setText(String.valueOf(punkt));
                        	windowPopUp(event);
							
                            
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
						System.out.println("popup");
                    }

                });
			}, 2000);

		}
				 
	}
	

	private void getDiceValue() {
		rand = (int) (Math.random() * 6 + 1);

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
				playerTurn=false;
				rand=0;
			}
			if (playerXPosition == 690 && playerYPosition == 0)
			{
				playerXPosition = 690;
				playerYPosition = 0;
				gameStart = false;
				playerTurn=false;
				rand=0;
			}

		}

	}
//translation von Spieler von einer Position zu anderer
	void translatePlayer(int x1, int y1, int x2, int y2, ImageView b) {
		TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);
	
		animate.setFromX(x1);
		animate.setFromY(y1);
		animate.setToX(x2);
		animate.setToY(y2);
		animate.setAutoReverse(false);
		animate.play();
	}



//Hilfsmethode f�r die Translation mit Ladder
	private void translatePlayerTo(int x, int y, ImageView b) {
		// TODO Auto-generated method stub
		TranslateTransition animate = new TranslateTransition(Duration.millis(1000), b);

		animate.setToX(x);
		animate.setToY(y);
		animate.setAutoReverse(false);
		animate.play();
		this.position = getPositionNummer(x, y);
	}

//	Positionsnummer zurueckgeben.
	int getPositionNummer(int x, int y) {
		switch (x) {
			case 50:
				switch (y) {
					case 0:
						position = 20;
						break;

					case 150:
						position = 19;
						break;

					case 300:
						position = 10;
						break;

					case 450:
						position = 9;
						break;
				}
				break;

			case 210:
				switch (y) {
					case 0:
						position = 21;
						break;

					case 150:
						position = 18;
						break;

					case 300:
						position = 11;
						break;

					case 450:
						position = 8;
						break;

					case 600:
						position = 1;
						break;
				}
				break;

			case 370:
				switch (y) {
					case 0:
						position = 22;
						break;

					case 150:
						position = 17;
						break;

					case 300:
						position = 12;
						break;

					case 450:
						position = 7;
						break;
					case 600:
						position = 2;
						break;
				}
				break;

			case 530:
				switch (y) {
					case 0:
						position = 23;
						break;

					case 150:
						position = 16;
						break;

					case 300:
						position = 13;
						break;

					case 450:
						position = 6;
						break;
					case 600:
						position = 3;
						break;
				}
				break;

			case 690:
				switch (y) {
//					case 0:
//						position = 20;
//						break;

					case 150:
						position = 15;
						break;

					case 300:
						position = 14;
						break;

					case 450:
						position = 5;
						break;

					case 600:
						position = 4;
						break;
				}
				break;
		}

		setPosition(position);

//		SingleChoiceLv1Controller singleChoiceLv1Controller = new SingleChoiceLv1Controller(position);
//
//		singleChoiceLv1Controller.setPosition(position);

		return position;
	}

	public void setPosition(int position){
		this.position = position;
	}

//	public int getPosition() {
//		System.out.println("test" + this.position);
//		return this.position;
//	}

	// Timer fuer Pop-up Frage Fenster
	public static void setTimeout(Runnable runnable, int delay){
		new Thread(() -> {
			try {
				Thread.sleep(delay);
				runnable.run();
			}
			catch (Exception e){
				System.err.println(e);
			}
		}).start();
	}

	public void nextLevelBtnClick(ActionEvent event) throws IOException {

	}

	private void windowPopUp(ActionEvent event)	throws IOException {

		Stage stage;
		Parent root;
		
		URL url = new File("src/play/level1/view/singleChoice.fxml").toURL();
		stage = new Stage();
		root = FXMLLoader.load(url);

		stage.setTitle("MCI lernen, Spaß machen");
		stage.setScene(new Scene(root, 800, 600));
		stage.show();

//		System.out.println("score: " + score.getText());

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		int punkt=singleChoiceLv1Controller.getScore();
		score.setText(String.valueOf(punkt));
	}

}
