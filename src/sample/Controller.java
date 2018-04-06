package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;

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


    public void btnNewClick() {
        state = state.PLAYING;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field[i][j] = false;
            }
        }
    }

    public void toggle(int n) throws IOException {
        int col = (n - 1) % 4;
        int row = (n - 1) / 4;
        Image img;

//        System.out.println(img_10.getImage().getUrl());
//        System.out.println(field[row][col]);
//        field[row][col] = !field[row][col];

        String current = new java.io.File( "." ).getCanonicalPath();
        System.out.println(current);
        System.out.println(row);
        System.out.println(col);

        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {

                if (i >= 0 && i < 4 && j >= 0 && j < 4) {
                    if(i == row && j==col){
                        continue;
                    }

                    field[i][j] = !field[i][j];
                    System.out.println("row " + i + ", col " + j + field[i][j]);

                }
            }
        }

        for(int i = 0;i<4;i++){

            for(int j = 0;j<4;j++){

                if(field[i][j] == false){
                    img = new Image(new FileInputStream(current+"\\src\\Img\\circle.png"));

                }
                else{
                    img = new Image(new FileInputStream(current+"\\src\\Img\\cross.png"));
                }

                img_1.setImage(img);


            }

        }



    }
}

