package yatzy;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// The Yatzy game object
	private Yatzy yatzy = new Yatzy();
	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	private TextField[] txfResults;
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	private Label lblRolled;
	private Button btnRoll;
	private Controller controller = new Controller();
	private int sumSame, sumOther, bonus, total;
	private boolean[] isTaken = new boolean[yatzy.getPossibleResults().length];

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(5);
		dicePane.setStyle("-fx-border-color: black");

		txfValues = new TextField[5];
		chbHolds = new CheckBox[5];
		
		for(int i = 0; i < chbHolds.length; i++) {
			TextField tf = new TextField();
			tf.setEditable(false);
			tf.setFont(Font.font(STYLESHEET_CASPIAN, 30));
			tf.setMaxWidth(70);
			CheckBox cb = new CheckBox("Hold");
			cb.setDisable(true);
			dicePane.add(tf, 0 + i, 0);
			dicePane.add(cb, 0 + i, 2);
			txfValues[i] = tf;
			chbHolds[i] = cb;
		}
		btnRoll = new Button("Roll");
		btnRoll.setFont(Font.font(20));
		lblRolled = new Label("Rolled: " + yatzy.getThrowCount());
		dicePane.add(btnRoll, 3, 3);
		dicePane.add(lblRolled, 4, 3);
		btnRoll.setOnAction(event -> controller.rollDices());
		// ---------------------------------------------------------------------
		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		txfResults = new TextField[yatzy.getPossibleResults().length];
		String[] labels = {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "One pair", "Two pairs", "Three of a kind", "Four of a kind", "Full house", "Small Straight", "Large Straight", "Chance", "Yatzy"};
		
		for(int i = 0; i < yatzy.getPossibleResults().length; i++){
			TextField tf = new TextField();
			int count = i;
			Label lb = new Label(labels[i]);
			tf.setEditable(false);
			tf.setFont(Font.font(STYLESHEET_CASPIAN, 14));
			tf.setMaxWidth(35);
			tf.setMaxHeight(50);
			scorePane.add(tf, 1, 0+i);
			scorePane.add(lb, 0, 0+i);
			txfResults[i] = tf;
			tf.setDisable(true);
			tf.setOnMouseClicked(event->controller.saveResult(count));
		}
		Label sum = new Label("Sum:"); Label bonus = new Label("Bonus:"); 	Label sum2 = new Label("Sum:");	Label total = new Label("Total:");
		txfBonus = new TextField(); txfSumSame = new TextField(); txfSumOther = new TextField(); txfTotal = new TextField();
		scorePane.add(sum, 2, 5);
		scorePane.add(sum2, 2, 14);
		scorePane.add(bonus, 4, 5);
		scorePane.add(total, 4, 14);
		scorePane.add(txfBonus, 5, 5);
		scorePane.add(txfSumSame, 3, 5);
		scorePane.add(txfSumOther, 3, 14);
		scorePane.add(txfTotal, 5, 14);
		txfSumSame.setText("0");
		txfBonus.setText("0");
		txfSumOther.setText("0");
		txfTotal.setText("0");
		txfBonus.setMaxWidth(40);
		txfSumSame.setMaxWidth(40);
		txfSumOther.setMaxWidth(40);
		txfTotal.setMaxWidth(40);
		txfBonus.setEditable(false);
		txfSumSame.setEditable(false);
		txfSumOther.setEditable(false);
		txfTotal.setEditable(false);
		txfTotal.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		txfTotal.setStyle("-fx-text-fill: blue");
		txfSumSame.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		txfSumSame.setStyle("-fx-text-fill: blue");
		txfSumOther.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		txfSumOther.setStyle("-fx-text-fill: blue");
		txfBonus.setFont(Font.font(STYLESHEET_CASPIAN, FontWeight.BOLD, 14));
		txfBonus.setStyle("-fx-text-fill: blue");
		
	}
	// -------------------------------------------------------------------------
	/**
	 * This class controls access to the model in this application.
	 */
	private class Controller {

		private void rollDices() {
			unlockRest();
			
			if(yatzy.getThrowCount() == 2){
				btnRoll.setDisable(true);
			}
			else{
				btnRoll.setDisable(false);
			}
			
			yatzy.throwDice(setRollToThrow());
			int[] newValues = yatzy.getValues();
			
			for(int i = 0; i < newValues.length; i++) {
					txfValues[i].setText(newValues[i] + "");
			}
			
			lblRolled.setText("Rolled: " + yatzy.getThrowCount());
			
			for(int i = 0; i < txfResults.length; i++) {
				if(!txfResults[i].isDisabled()){
					txfResults[i].setText(yatzy.getPossibleResults()[i] + "");
				}
			}
		}
		/**
		 * Decides which dice are held and shouldn't be thrown in the rollDices() method.
		 * @return toThrow - returns which dice aren't held.
		 */
		private boolean[] setRollToThrow() {
			boolean[] toThrow = new boolean[5];
			for(int i = 0; i < chbHolds.length; i++) {
				chbHolds[i].setDisable(false);
				if (chbHolds[i].isSelected()) {
					toThrow[i] = true;
				} else {
					toThrow[i] = false;
				}
			}
			return toThrow;
		}
		
		private void saveResult(int saveNumber){
		
				if(txfResults[saveNumber].isFocused()){
					yatzy.resetThrowCount();
					txfResults[saveNumber].setDisable(true);
					txfResults[saveNumber].cancelEdit();
					isTaken[saveNumber] = true;
					resetUI();
					sumNumbers();
					lockAll();
					gameComplete();
				}
			}
		
		private void resetUI(){
			String[] tempValuez = {"", "", "", "", ""};
			for(int i = 0; i < yatzy.getValues().length; i++) {
				txfValues[i].setText(tempValuez[i] + "");
				chbHolds[i].setSelected(false);
			}
			btnRoll.setDisable(false);
			lblRolled.setText("Rolled: " + yatzy.getThrowCount());
			btnRoll.requestFocus();
		}
		private void sumSame(){
			sumSame = 0; 
			for(int i = 0; i <6; i++){
				if(isTaken[i]){
					sumSame += Integer.parseInt(txfResults[i].getText());
				}
				txfSumSame.setText(sumSame+"");
			}
		}
		private void sumOther(){
			sumOther = 0;
			for(int i = 6; i<isTaken.length; i++){
				if(isTaken[i]){
					sumOther += Integer.parseInt(txfResults[i].getText());
				}
				txfSumOther.setText(sumOther+"");
			}
		}
		private void sumBonus(){
			bonus = 0;
			if(sumSame >= 63){
				txfBonus.setText("50");
			}
			
		}
		private void sumTotal(){
			total = sumSame+sumOther+bonus;
			txfTotal.setText(total+"");
		}
		/**
		 * Calls upon the previous four methods to add the sums to their corresponding TextFields in the scorePane.
		 */
		private void sumNumbers(){
			sumSame();
			sumOther();
			sumBonus();
			sumTotal();
		}
		
		/**
		 * Disables all of the non-selected sums, so the player cannot save several results on one throw
		 * this method is called upon in the saveResult(saveNumber) method.
		 */
		private void lockAll(){
			for(int i = 0; i < isTaken.length; i++){
				if (!isTaken[i]){
					txfResults[i].setDisable(true);
				}
			}
		}
		/**
		 * re-enables the non-selected sums, so the player can resume the game as normal.
		 * this method is called upon in the rollDices() method.
		 */
		private void unlockRest(){
			for(int i = 0; i < isTaken.length; i++){
				if(!isTaken[i]){
					txfResults[i].setDisable(false);
				}
			}
		}
		/**
		 * checks if the game is complete, if so, gives users an alert
		 */
		private void gameComplete(){
			int count = 0;
			for(int i = 0; i < isTaken.length; i++){
				if(isTaken[i]){
					count++;
				}
			}
			if(count == isTaken.length){
				gameCompleteAlert();
			}
		}
		/**
		 * Creates an alert shown to the player, informing the user of his points, with an option to play a new game if the player wishes.
		 */
		private void gameCompleteAlert(){
			Alert gameCompleted = new Alert(AlertType.INFORMATION);
			gameCompleted.setTitle("Game Complete");
			gameCompleted.setHeaderText("Your points: " + txfTotal.getText());
			Button yesBtn = new Button("Yes");
			Button noBtn = new Button("No");
			gameCompleted.getButtonTypes();
			gameCompleted.showAndWait();
	
			if(yesBtn.isPressed()){
				resetUI();
			}
			
			
			
		}
	}
}
