package com.kodilla.vaadin.books.view;

import com.kodilla.vaadin.books.domain.Book;
import com.kodilla.vaadin.books.service.BookService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private BookService bookService = BookService.getInstance();
    private Grid<Book> grid = new Grid<>(Book.class);
    private TextField filter = new TextField();
    private BookForm form = new BookForm(this);

    public MainView() {
        filter.setPlaceholder("Filter by title");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(event -> update());
//        grid.setColumns("type", "author", "publicationYear"); // not required, but we can set only specific columns and wanted sequence.
//        grid.getColumnByKey("publicationYear").setHeader("publicationYear"); // we can modify the header name. Vaadin automatically does Publication Year
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(filter, mainContent);
        setSizeFull();
        refresh();
    }

    private void update() {
        grid.setItems(bookService.findByTitle(filter.getValue()));
    }

    public void refresh() {
        grid.setItems(bookService.getBooks());
    }
}
