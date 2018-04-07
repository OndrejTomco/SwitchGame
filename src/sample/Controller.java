package sample;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;


public class Controller {

    public ImageView img_1;
    public ImageView img_2;
    public ImageView img_3;
    public ImageView img_4;
    public ImageView img_5;
    public ImageView img_6;
    public ImageView img_7;
    public ImageView img_8;
    public ImageView img_9;
    public ImageView img_10;
    public ImageView img_11;
    public ImageView img_12;
    public ImageView img_13;
    public ImageView img_14;
    public ImageView img_15;
    public ImageView img_16;


    private State state = State.NEW;
    private boolean[][] field = new boolean[4][4];

    public void imgClick(MouseEvent event) throws IOException {

        ImageView sourceID = (ImageView) event.getSource();
        String[] imgID = sourceID.getId().toString().split("_");
        int imgNum = Integer.parseInt(imgID[1]);

        if (state == state.PLAYING) {
            System.out.println(imgNum + " was clicked");
            toggle(imgNum);
        }
    }


    public void startNewGame() throws IOException {
        state = state.PLAYING;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field[i][j] = false;
            }
        }
        
        randomize();
    }

    private void randomize() throws IOException {
        int i;
        state=State.GENERATE;

            Random random = new Random();
            for (i = 0; i < 10; i++) {
                toggle(random.nextInt(16) + 1);
            }
            state=State.PLAYING;
        }



    public void toggle(int n) throws IOException {
        int col = (n - 1) % 4;
        int row = (n - 1) / 4;
        int imgNumToChange;

        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {

                if (i >= 0 && i < 4 && j >= 0 && j < 4) {
                    if(i == row && j==col){
                        continue;
                    }

                    field[i][j] = !field[i][j];
                    System.out.println("row " + i + ", col " + j + field[i][j]);
                    imgNumToChange = (i*4) + j+1;
                    changeImage(i,j,imgNumToChange);

                }
            }
        }

        if(isGameOver() && state == state.PLAYING){
            state = state.END;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Congratulations, you won the game!");
            alert.showAndWait();
        }

    }

    private boolean isGameOver() {
        int i, j, count = 0;
        for (i = 0; i < 4; i++)
            for (j = 0; j < 4; j++)
                if (field[i][j])
                    count++;

            return count == 16 || count == 0;

    }


    private void changeImage(int i, int j, int imgNum) throws IOException {
        Image img;
        String current = new java.io.File( "." ).getCanonicalPath();

        if(field[i][j] == false){
            img = new Image(new FileInputStream(current+"\\src\\Img\\circle.png"));

        }
        else{
            img = new Image(new FileInputStream(current+"\\src\\Img\\cross.png"));
        }

        System.out.println(imgNum);

        switch(imgNum) {
            case 1:   img_1.setImage(img); break;
            case 2:   img_2.setImage(img); break;
            case 3:   img_3.setImage(img); break;
            case 4:   img_4.setImage(img); break;
            case 5:   img_5.setImage(img); break;
            case 6:   img_6.setImage(img); break;
            case 7:   img_7.setImage(img); break;
            case 8:   img_8.setImage(img); break;
            case 9:   img_9.setImage(img); break;
            case 10:   img_10.setImage(img); break;
            case 11:   img_11.setImage(img); break;
            case 12:   img_12.setImage(img); break;
            case 13:   img_13.setImage(img); break;
            case 14:   img_14.setImage(img); break;
            case 15:   img_15.setImage(img); break;
            case 16:   img_16.setImage(img); break;
        }

    }

    public void endGame(){
        Platform.exit();
        System.exit(1);
    }

}

