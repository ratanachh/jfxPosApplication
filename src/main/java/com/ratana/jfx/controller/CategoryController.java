package com.ratana.jfx.controller;

import com.ratana.jfx.model.Category;
import com.ratana.jfx.service.Impl.CategoryServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.SVGPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController extends AbstractController {

    @FXML
    private TilePane container;
    @Autowired
    CategoryServiceImpl categoryService;

    @FXML
    private void initialize() {
        container.getChildren().clear();
        categoryService.findAll()
                .forEach( category -> container.getChildren().add(new CategoryItem(category)));
    }

    private class CategoryItem extends HBox {
        private SVGPath icon;
        private Label name;
        public CategoryItem(Category category) {
            icon = new SVGPath();
            icon.setContent("M5 5c-1.104 0-2 0.887-2 2v8l13.381 13.381c0.716 0.716 1.838 0.78 2.62 0.191l-14.001-14.072v-9.493c0-0.002 0-0.005 0-0.007h-0zM16 4l13.381 13.381c0.783 0.783 0.787 2.051 0.008 2.831l-7.177 7.177c-0.778 0.778-2.047 0.776-2.831-0.008l-13.381-13.381v-8c0-1.112 0.895-2 2-2h8zM11.5 11c0.828 0 1.5-0.672 1.5-1.5s-0.672-1.5-1.5-1.5c-0.828 0-1.5 0.672-1.5 1.5s0.672 1.5 1.5 1.5v0z");
            name = new Label();
            name.setText(category.getName());

            getChildren().addAll(icon, name);

            getStyleClass().add("category-item");
        }
    }
}
