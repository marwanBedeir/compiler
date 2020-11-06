/*
 * The MIT License
 *
 * Copyright 2019 CASP3R.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Controllers;

/**
 *
 * @author CASP3R & MMB
 */
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class confirmBox {

    //Create variable
    static int answer;

    public static int display(String title, String message,String btn1,String btn2,String btn3) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(100);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button Button1 = new Button(btn1);
        Button Button2 = new Button(btn2);
        Button Button3 = new Button(btn3);

        //Clicking will set answer and close window
        Button1.setOnAction(e -> {
            answer = 1;
            window.close();
        });
        Button2.setOnAction(e -> {
            answer = 2;
            window.close();
        });
        Button3.setOnAction(e -> {
            answer = 3;
            window.close();
        });

        HBox layout = new HBox(10);

        //Add buttons
        layout.getChildren().addAll(label, Button1, Button2, Button3);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}
