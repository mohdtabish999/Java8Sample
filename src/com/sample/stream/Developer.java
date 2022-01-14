package com.sample.stream;

import java.util.HashSet;
import java.util.Set;

public class Developer {

    private Integer price;
    private String name;
    private Set<String> book;

    //getters, setters, toString

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }

    @Override
    public String toString() {
	return "Developer [price=" + price + ", name=" + name + ", book=" + book + "]";
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}